import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob12 {
// The caesar function lambda, un-minified
//      char c = e.charAt(0);
//      if(e.equals(e.toLowerCase())) {
//        c = (char) (((int)  - 97 + shift) % 26 + 97);
//      } else {
//        c = (char) (((int) c - 65 + shift) % 26 + 65);
//      }
//      return String.valueOf(c);
  public static String caesar(String input, int shift) {
    return String.join("", Arrays.stream(input.split("")).map(e -> String.valueOf((char) (((int) e.charAt(0) - (e.charAt(0) > 96 ? 97 : 65) + shift) % 26 + (e.charAt(0) > 96 ? 97 : 65))) ).toArray(String[]::new));
  }

  public static void main(String[] args){
    String total = "";
    List<Integer> lineLengths = new ArrayList<>();

    try(BufferedReader br = new BufferedReader(new FileReader(new File("downloads/ExampleIO/Prob12.in.txt")))) { //change problem #

      // reading in the lines
      String line;
      while ((line = br.readLine()) != null){
        total += line;
        lineLengths.add(line.length());
      }

    } catch (IOException e){e.printStackTrace();}

    // analyzing the line

    // find factors of thing
    List<Integer> factors = new ArrayList<>();
    int n = total.length();
    for(int i = 1; i <= Math.sqrt(n); i++) {
      if(n % i == 0) {
        factors.add(i);
        if(i * i != n) {
          factors.add(n / i);
        }
      }
    }

    for(int factor : factors) {
      List<String> rearranged = new ArrayList<>();
      for(int i = 0; i < total.length(); i++) {
        rearranged.add("");
      }
      for(int i = 0; i < factor; i++) {
        for(int j = 0; j < n / factor; j++) {

          rearranged.set(j * factor + i, total.substring(i*(n/factor)+j, i*(n/factor)+j+1));

          // uncomment the following line to see the algorithm in action
//          System.out.printf("Factor: %d i: %d j: %d Array: %s%n", factor, i, j, rearranged);
        }
      }

      String rearrangedString = String.join("", rearranged);

      // for each factor, split and go through each cypher cycle to try and find the word "Dear"
      for(int i = 0; i < 26; i++) {
        String decoded = caesar(rearrangedString, i);
        if(decoded.indexOf("Dear") >= 0) {

          // correctly found!
          // print correctly
          for(int x = 0, pointer = 0; x < lineLengths.size(); x++) {
            if(x == lineLengths.size()-1 && decoded.substring(pointer).equals(decoded.substring(pointer).toUpperCase())) {
              // if end of string, remove padding
              // a heuristic, but should work
              return;
            }
            for(int y = 0; y < lineLengths.get(x); y++) {
              System.out.print(decoded.charAt(pointer++));
            }
            System.out.println();
          }

        }
      }
    }
  }
}
