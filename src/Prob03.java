import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Prob03 {

    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new FileReader(new File("downloads/ExampleIO/Prob03.in.txt")))) { //change problem #

            String line = null;

            while ((line = br.readLine()) != null){

                List<Integer> nums = Arrays.stream(line.split(" ")).mapToInt(e -> Integer.parseInt(e)).boxed().collect(Collectors.toList());
                nums.sort((a, b) -> b - a);

                String[] sortedArray = new String[nums.size()];

                for(int i = 0; i < nums.size(); i++) {
                    sortedArray[i % 2 == 0 ? i/2 : nums.size()-i/2-1] = nums.get(i) + "";
                }

                System.out.println(String.join(" ", sortedArray));

            }

        } catch (IOException e){e.printStackTrace();}
    }
}
