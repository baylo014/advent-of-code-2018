        identification division.
        program-id. 01a.
        environment division.
        input-output section.
        file-control.
            select inputfile assign to disk
            organization is line sequential.
        data division.
        file section.
        fd inputfile is external
            record is varying in size
            value of file-id is "input"
            data record is input-line.
            01 input-line pic A(99999).
        working-storage section.
            01 idx pic 99999 value 00001.
            01 len pic 9999.
            01 pm pic A.
            01 distance pic S99999.
            01 done pic 9 value 0.
            01 total_f pic S99999.
            01 direction pic 9 value 1.
        procedure division.
        main.
            open input inputfile.
            read inputfile.
            close inputfile.
            perform until done = 1
              perform read-command
              perform apply-command
            end-perform
            display total_f.
            stop run.
        read-command.
            move input-line(idx:1) to pm.
            if pm <> "+" and pm <> "-" then
              move 1 to done
            end-if.
            add 1 to idx.
            move 0 to len.
            perform until input-line(idx + len:1) = "," or
                          input-line(idx + len:1) = " "
              add 1 to len
            end-perform.
            move '    ' to distance.
            move input-line(idx:len) to distance.
            add len to idx.
            add 2 to idx.
        apply-command.
            if pm = "+" then
              move 1 to direction
            else
              move 0 to direction
            end-if.
            perform distance times
              if direction = 1 then
                add 1 to total_f
              end-if
              if direction = 0 then
                subtract 1 from total_f
              end-if
            end-perform.
