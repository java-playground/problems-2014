import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Prob11 {
  public static void main(String[] args){
    try(BufferedReader br = new BufferedReader(new FileReader(new File("downloads/ExampleIO/Prob11.in.txt")))) { //change problem #
      String thisLine;
      String line = "";
      while ((thisLine = br.readLine()) != null) {
        line += thisLine.trim() + " ";
      }
      line = line.trim();

      // find length of square side
      int squareSize = (int) Math.ceil(Math.sqrt(line.length()));

      // create empty spiral, pad with spaces
      List<List<String>> spiral = new ArrayList<>();
      for(int i = 0; i < squareSize; i++) {
        List<String> row = new ArrayList<>();
        for(int j = 0; j < squareSize; j++) {
          row.add(" ");
        }
        spiral.add(row);
      }

      // start spiraling!
      int dir = 0; // direction goes from 0 to 3; 0 is left, 1 is down, 2 is right, 3 is up
      int x = (int) Math.ceil(squareSize/2);
      int y = (int) Math.floor(squareSize/2);
      // update position (and direction if necessary)
      for(int counter = 0, i = 0; i < line.length(); counter++) {
        for(int j = 0; j < Math.floor(counter / 2) + 1; j++) {
          // set letter
          spiral.get(y).set(x, (i < line.length()) ? "" + line.charAt(i++) : " ");

          // move position
          switch(dir) {
            case 0:
              x--;
              break;
            case 1:
              y++;
              break;
            case 2:
              x++;
              break;
            case 3:
              y--;
              break;
          }
        }

        dir = (dir + 1) % 4;
      }

      // print
      for(int i = 0; i < spiral.size(); i++) {
        System.out.println(String.join("", spiral.get(i)));
      }
    } catch (IOException e){e.printStackTrace();}
  }
}
