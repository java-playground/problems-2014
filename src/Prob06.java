import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Prob06 {

    public static void main(String[] args){

        List<List<Integer>> map = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(new File("downloads/ExampleIO/Prob06.in.txt")))) { //change problem #

            String line = null;

            while ((line = br.readLine()) != null){

                map.add(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));

            }

        } catch (IOException e){e.printStackTrace();}

        // look at horizontals
        int largestProduct = 0;
        for(int x = 0; x < map.size(); x++) {
            for(int y = 0; y < map.get(x).size() - 4; y++) {
                int product = map.get(x).get(y) * map.get(x).get(y+1) * map.get(x).get(y+2) * map.get(x).get(y+3);
                if(product > largestProduct) {
                    largestProduct = product;
                }
            }
        }

        // look at verticals
        for(int x = 0; x < map.size(); x++) {
            for(int y = 0; y < map.get(x).size() - 4; y++) {
                int product = map.get(y).get(x) * map.get(y+1).get(x) * map.get(y+2).get(x) * map.get(y+3).get(x);
                if(product > largestProduct) {
                    largestProduct = product;
                }
            }
        }

        // look at diagonals right-down
        for(int x = 0; x < map.size() - 4; x++) {
            for(int y = 0; y < map.get(x).size() - 4; y++) {
                int product = map.get(y).get(x) * map.get(y+1).get(x+1) * map.get(y+2).get(x+2) * map.get(y+3).get(x+3);
                if(product > largestProduct) {
                    largestProduct = product;
                }
            }
        }

        // look at diagonals left-down
        for(int x = map.size() - 1; x >= 4; x--) {
            for(int y = 0; y < map.get(x).size() - 4; y++) {
                int product = map.get(y).get(x) * map.get(y+1).get(x-1) * map.get(y+2).get(x-2) * map.get(y+3).get(x-3);
                if(product > largestProduct) {
                    largestProduct = product;
                }
            }
        }

        System.out.println(largestProduct);

    }
}
