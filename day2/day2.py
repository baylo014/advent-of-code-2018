from collections import Counter
from difflib import SequenceMatcher

def part1():
    with open("day2.txt") as f:
        lines = f.readlines()
    two = 0
    three = 0
    for l in lines:
        c = dict(Counter(l))
        if 2 in c.values():
            two+=1
        if 3 in c.values():
            three += 1
    print(two * three)
    return lines
def part2():
    lines = part1()
    r = 0.0
    l = ['','']
    for i in range(len(lines)):
        for j in range(i+1,len(lines)):
            s = SequenceMatcher(None, lines[i], lines[j])
            if (s.ratio() > r):
                r = s.ratio()
                l[0] = lines[i]
                l[1] = lines[j]
    for i in range(len(l[0])):
        if l[0][i] == l[1][i]:
            print(l[0][i],end="")
    print(l[0][:-1])
    print(l[1][:-1])
def main():
    part2()

if __name__ == '__main__':
    main()
