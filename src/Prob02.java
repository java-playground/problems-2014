import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Prob02 {

    static String s(String card) { return card.substring(card.length()-1); }

    static Map<String, String> map = new LinkedHashMap<>();
    static Map<String, String> numberMap = new LinkedHashMap<>();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader(new File("downloads/ExampleIO/Prob02.in.txt")))) { //change problem #

            String line = null;

            int hand = 0;
            while ((line = br.readLine()) != null) {

                System.out.printf("HAND %d%n", ++hand);

                String[] cards = line.split(" ");

                int redCount = (int) Arrays.stream(cards).filter(s -> s(s).equals("D") || s(s).equals("H")).count();
                System.out.printf("%d-%s%n", redCount, "RED");

                int blackCount = (int) Arrays.stream(cards).filter(s -> s(s).equals("C") || s(s).equals("S")).count();
                System.out.printf("%d-%s%n", blackCount, "BLACK");

                map.put("CLUB", "C");
                map.put("DIAMOND", "D");
                map.put("HEART", "H");
                map.put("SPADE", "S");

                map.keySet().forEach(e -> {
                    int count = (int) Arrays.stream(cards).filter(s -> s(s).equals(map.get(e))).count();
                    String plural = count != 1 ? "S" : "";
                    System.out.printf("%d-%s%s%n", count, e, plural);
                });

                numberMap.put("2", "2 card");
                numberMap.put("3", "3 card");
                numberMap.put("4", "4 card");
                numberMap.put("5", "5 card");
                numberMap.put("6", "6 card");
                numberMap.put("7", "7 card");
                numberMap.put("8", "8 card");
                numberMap.put("9", "9 card");
                numberMap.put("10", "10 card");
                numberMap.put("J", "Jack");
                numberMap.put("Q", "Queen");
                numberMap.put("A", "Ace");

                numberMap.keySet().forEach(e -> {
                    int count = (int) Arrays.stream(cards).filter(s -> s.substring(0, s.length()-1).equals(e)).count();
                    String plural = count != 1 ? "s" : "";
                    System.out.printf("%d-%s%s%n", count, numberMap.get(e), plural);
                });

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
