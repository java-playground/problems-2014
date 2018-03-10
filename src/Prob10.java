import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Prob10 {
    static class Track {
        String start;
        String end;
        int length;
        Track(String start, String end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }
    }
    public static void main(String[] args){
        List<Track> tracks = new ArrayList<>();
        List<List<Boolean>> dividers = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(new File("downloads/ExampleIO/Prob10.in.txt")))) { //change problem #
            String line;
            boolean isTrack = true;
            while ((line = br.readLine()) != null){

                // collecting data
                if(isTrack) {
                    String start = line.substring(0, 3);
                    String end = line.substring(line.length()-3, line.length());
                    int length = line.length() - 6;
                    tracks.add(new Track(start, end, length));
                } else {
                    dividers.add(Arrays.stream(line.trim().split("")).map(e -> e.equals("|")).collect(Collectors.toList()));
                }
                isTrack = !isTrack;

            }
        } catch (IOException e){e.printStackTrace();}

        // using the data
        for(int i = 0; i < tracks.size(); i++) {
            int trackNumber = i;    // this is used to keep track of current track
            int lastMove = 0;       // this is used to keep track of last move, in case multiple moves were to happen
            for(int x = 0; x < tracks.get(trackNumber).length; x++) {
                if(lastMove != 1 && trackNumber != 0 && dividers.get(trackNumber-1).get(x)) {
                    trackNumber--;
                    lastMove = -1;
                    x--;
                } else if(lastMove != -1 && trackNumber != tracks.size()-1 && dividers.get(trackNumber).get(x)) {
                    trackNumber++;
                    lastMove = 1;
                    x--;
                } else {
                    lastMove = 0;
                }
            }
            Track endTrack = tracks.get(trackNumber);
            System.out.format("Start: %s, End: %s%n", tracks.get(i).start, endTrack.end);
        }
    }
}
