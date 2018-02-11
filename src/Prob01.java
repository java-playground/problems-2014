import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Prob01 {

    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new FileReader(new File("downloads/ExampleIO/Prob01.in.txt")))) { //change problem #

            String line = null;

            while ((line = br.readLine()) != null){

                /* Do things here */
                if (Integer.parseInt(line) % 3 == 0 && Integer.parseInt(line) % 7 == 0){
                    System.out.println("CODEQUEST");
                } else if (Integer.parseInt(line) % 3 == 0){
                    System.out.println("CODE");
                } else if (Integer.parseInt(line) % 7 == 0){
                    System.out.println("QUEST");
                } else {
                    System.out.println(line);
                }

            }

        } catch (IOException e){e.printStackTrace();}
    }
}
