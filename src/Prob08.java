import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Prob08 {

    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new FileReader(new File("downloads/ExampleIO/Prob08.in.txt")))) { //change problem #

            // get size of canvas
            String[] canvasSizeInput = br.readLine().split(",");
            int width = Integer.parseInt(canvasSizeInput[0]);
            int height = Integer.parseInt(canvasSizeInput[1]);

            List<List<Boolean>> map = new ArrayList<>();
            for(int i = 0; i < width; i++) {
                List<Boolean> row = new ArrayList<>();
                for(int j = 0; j < height; j++) {
                    row.add(false);
                }
                map.add(row);
            }

            String line;
            while ((line = br.readLine()) != null){

                String[] coordinatePairs = line.split(" ");
                String[] coordinate1 = coordinatePairs[0].split(",");
                // x's are actually y's
                int x1 = height - Integer.parseInt(coordinate1[1]);
                int y1 = Integer.parseInt(coordinate1[0]);
                String[] coordinate2 = coordinatePairs[1].split(",");
                int x2 = height - Integer.parseInt(coordinate2[1]);
                int y2 = Integer.parseInt(coordinate2[0]);

                for(int i = Math.min(x1, x2); i < Math.max(x1, x2); i++) {
                    for(int j = Math.min(y1, y2); j < Math.max(y1, y2); j++) {
                        map.get(i).set(j, !map.get(i).get(j));
                    }
                }

            }

            map.forEach(formattedRow -> System.out.println(String.join("", formattedRow.stream().map(e -> e ? "*" : " ").toArray(String[]::new))));

        } catch (IOException e){e.printStackTrace();}
    }
}
