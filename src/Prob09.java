import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class Prob09 {
    public static String interpret(int number) {

        // return Zero if 0
        if(number == 0) {
            return "Zero";
        }

        String[] numberStrings = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] tenStrings = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] teensStrings = {"","","","","","","","","","","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};

        String output = "";

        // deal with hundreds
        if(number >= 100) {
            int hundredsPlace = (int) Math.floor(number / 100);
            output += numberStrings[hundredsPlace] + " Hundred ";
        }
        if(number >= 20) {
            int tensPlace = (int) Math.floor(number / 10) % 10;
            output += tenStrings[tensPlace];
            if(number % 10 != 0) {
                output += " " + numberStrings[number % 10];
            }
        } else if(number >= 10) {
            output += teensStrings[number];
        } else if(number >= 1) {
            output += numberStrings[number];
        }
        return output.trim();
    }
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new FileReader(new File("downloads/ExampleIO/Prob09.in.txt")))) { //change problem #
            String line = null;
            while ((line = br.readLine()) != null){

                // split into dollars and cents
                String[] parts = line.split("\\.");

                // deal with cents
                int cents;
                if(parts.length == 1) {
                    cents = 0;
                } else {
                    cents = Integer.parseInt(parts[1]);
                }
                String centPlural = cents != 1 ? "s" : "";

                // deal with dollars
                // split into thousands and ones
                int dollars = Integer.parseInt(parts[0]);
                int thousands = (int) Math.floor(dollars / 1000);
                int ones = dollars % 1000;
                String dollarString = "";
                if(thousands > 0) {
                    dollarString = String.format("%s Thousand ", interpret(thousands));
                }
                dollarString += interpret(ones);
                dollarString.trim();
                String dollarPlural = dollars != 1 ? "s" : "";

                // print out total
                System.out.printf("%s Dollar%s and %d Cent%s%n",
                        dollarString,
                        dollarPlural,
                        cents,
                        centPlural
                );

            }
        } catch (IOException e){e.printStackTrace();}
    }
}
