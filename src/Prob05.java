import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Prob05 {

    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new FileReader(new File("downloads/ExampleIO/Prob05.in.txt")))) { //change problem #

            String line = null;

            while ((line = br.readLine()) != null) {

                AtomicInteger index = new AtomicInteger(0);
                int sum = Arrays.stream(line.replaceAll("\\-", "").split("")).mapToInt(Integer::parseInt).reduce(0, (accum, num) -> accum + num * (index.incrementAndGet() % 2 == 0 ? 3 : 1));
                System.out.println(sum % 10 == 0 ? "VALID" : Integer.parseInt(line.substring(line.length()-1, line.length())) + 10 - (sum % 10));

            }

        } catch (IOException e){e.printStackTrace();}
    }
}
