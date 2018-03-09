import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prob04 {

    public static String translate(String word) {

        Matcher consonant = Pattern.compile("[(qu)wrtypsdfghjklzxcvbnm]").matcher(word);
        Matcher beginCosonants = Pattern.compile("^[(qu)wrtypsdfghjklzxcvbnm]+").matcher(word);

        // deal with no vowels
        if(consonant.find() == false) {
            return word;
        }

        // deal with two consonants at the beginning
        if(beginCosonants.find()) {
            return word.replaceFirst(beginCosonants.group(), "") + beginCosonants.group() + "ay";
        }

        // deal with vowel at the beginning
        return word + "yay";

    }

    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new FileReader(new File("downloads/ExampleIO/Prob04.in.txt")))) { //change problem #

            String line = null;

            while ((line = br.readLine()) != null){

                System.out.println(String.join(
                        " ",
                        Arrays.stream(line.split(" ")).map(word -> translate(word)).toArray(String[]::new))
                );

            }

        } catch (IOException e){e.printStackTrace();}
    }
}
