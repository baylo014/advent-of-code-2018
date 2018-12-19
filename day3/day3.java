import java.util.*;
import java.io.*;
public class day3{
    private int numRows, numCols;
    private int[][] grid;
    public day3(int numRows, int numCols, String inputFile) {
        this.numRows=numRows;
        this.numCols=numCols;
        this.grid = new int[this.numRows][this.numCols];

        try {
            BufferedReader lineReader = new BufferedReader(new FileReader(inputFile));
            String lineText = null;

            while ((lineText = lineReader.readLine()) != null) {
                String[] parts = lineText.split(" ");
                String temp;
                int row, col, width, height, data;
                col = Integer.parseInt(parts[2].split(",")[0]);
                temp = parts[2].split(",")[1];
                row = Integer.parseInt(temp.substring(0, temp.length() - 1));
                width = Integer.parseInt(parts[3].split("x")[0]);
                height = Integer.parseInt(parts[3].split("x")[1]);
                //setElement(row,col,1);
                //System.out.println(row+" "+col+" "+" "+width+" "+" "+height);
                for (int y = row; y < (row + height); y++) {
                  for (int x = col; x < (col + width); x++) {
                    try{
                      this.grid[y][x] += 1;
                    }
                    catch (Exception e){
                      System.err.println("Err");
                    }
                  }
                }
            }
            while ((lineText = lineReader.readLine()) != null) {
                String[] parts = lineText.split(" ");
                String temp;
                int row, col, width, height, data;
                col = Integer.parseInt(parts[2].split(",")[0]);
                temp = parts[2].split(",")[1];
                row = Integer.parseInt(temp.substring(0, temp.length() - 1));
                width = Integer.parseInt(parts[3].split("x")[0]);
                height = Integer.parseInt(parts[3].split("x")[1]);
                boolean found = true;
                for (int y = row; y < (row + height); y++) {
                  for (int x = col; x < (col + width); x++) {
                    if (this.grid[y][x] > 1){
                      found = false;
                    }
                  }
                }
                if (found) {
                  System.out.println(parts[0]);
                }
            }

            lineReader.close();
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
        printGrid();
    }
    public void printGrid(){
      int count = 0;
      for (int y = 0; y < 1000; y++) {
        for (int x = 0; x < 1000; x++) {
          //System.out.printf("%d ",this.grid[y][x]);
          if (this.grid[y][x] > 1){
            count += 1;
          }
        }
        //System.out.printf("|\n");
      }
      System.out.println(count);
    }
    public static void main(String[] args){
        day3 m = new day3(1000,1000,"day3.txt");
    }
}
