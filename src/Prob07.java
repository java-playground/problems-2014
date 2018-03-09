import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Prob07 {

    public static void main(String[] args){

        boolean encode = true;

        Map<String, String> morseCode = new HashMap<>();
        morseCode.put("a", ".-");
        morseCode.put("b", "-...");
        morseCode.put("c", "-.-.");
        morseCode.put("d", "-..");
        morseCode.put("e", ".");
        morseCode.put("f", "..-.");
        morseCode.put("g", "--.");
        morseCode.put("h", "....");
        morseCode.put("i", "..");
        morseCode.put("j", ".---");
        morseCode.put("k", "-.-");
        morseCode.put("l", ".-..");
        morseCode.put("m", "--");
        morseCode.put("n", "-.");
        morseCode.put("o", "---");
        morseCode.put("p", ".--.");
        morseCode.put("q", "--.-");
        morseCode.put("r", ".-.");
        morseCode.put("s", "...");
        morseCode.put("t", "-");
        morseCode.put("u", "..-");
        morseCode.put("v", "...-");
        morseCode.put("w", ".--");
        morseCode.put("x", "-..-");
        morseCode.put("y", "-.--");
        morseCode.put("z", "--..");
        morseCode.put("1", ".----");
        morseCode.put("2", "..---");
        morseCode.put("3", "...--");
        morseCode.put("4", "....-");
        morseCode.put("5", ".....");
        morseCode.put("6", "-....");
        morseCode.put("7", "--...");
        morseCode.put("8", "---..");
        morseCode.put("9", "----.");
        morseCode.put("0", "-----");

        try(BufferedReader br = new BufferedReader(new FileReader(new File("downloads/ExampleIO/Prob07.in.txt")))) { //change problem #

            String line;

            while ((line = br.readLine()) != null){

                if(line.equals("END OF TRANSMISSION")) {
                    System.out.println(line);
                    encode = !encode;
                    continue;
                }

                if(encode) {
                    String[] words = line.split(" ");
                    for(int i = 0; i < words.length; i++) {
                        words[i] = String.join("___",
                                Arrays.stream(words[i].split(""))
                                        .map(e -> String.join("_", morseCode.get(e.toLowerCase()).split("")).replaceAll("-", "===").replaceAll("\\.", "="))
                                        .toArray(String[]::new)
                        );
                    }
                    System.out.println(String.join("_______", words));
                } else {
                    String[] words = line.split("_______");
                    for(int i = 0; i < words.length; i++) {
                       words[i] = String.join("",
                               Arrays.stream(words[i].split("___"))
                                       .map(e -> e.replaceAll("===", "-").replaceAll("=", ".").replaceAll("_", ""))
                                       .map(e -> {
                                           for (String s : morseCode.keySet()) {
                                               if(morseCode.get(s).equals(e)) {
                                                   return s;
                                               }
                                           }
                                           return "";
                                       })
                                       .toArray(String[]::new)
                       );
                    }
                    System.out.println(String.join(" ", words));
                }

            }

        } catch (IOException e){e.printStackTrace();}
    }
}
