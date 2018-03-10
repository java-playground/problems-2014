import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class Base {
  public static void main(String[] args){
    try(BufferedReader br = new BufferedReader(new FileReader(new File("downloads/ExampleIO/Prob00.in.txt")))) { //change problem #
      String line;
      while ((line = br.readLine()) != null){

        /* Do things here */


      }
    } catch (IOException e){e.printStackTrace();}
  }
}
