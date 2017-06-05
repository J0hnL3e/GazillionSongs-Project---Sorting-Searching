		package us.wa.newport.finalSolution;
import java.io.*;
import java.util.*;
//Grouping of Songs --> SongCollection Class
public class SongCollection{
    private ArrayList<Song> songCollection;
    //Constructs SongCollection from ArrayList
    public SongCollection(){
        songCollection = new ArrayList<Song>();
    }
    //Adds Song to SongCollection
    public void addSong(String line){
        String[] songParts = line.split("\t");
        int year = Integer.parseInt(songParts[0]);
        int rank = Integer.parseInt(songParts[1]);
        String artist = songParts[2];
        String title = songParts[3];
        Song inputSong = new Song(year, rank, artist, title);
        songCollection.add(inputSong);
    }
    //Filters Songs
    public void filter(String field, String data){
        for (int i = songCollection.size()-1; i >= 0; i--){
            Song tempSong = songCollection.get(i);
            if (!tempSong.isMatch(field, data))
                songCollection.remove(i);
            }
    }
    //Sorts Songs through insertion
    public void insertionSort(String field){
        for (int j = 1; j < songCollection.size(); j++){
            Song value = songCollection.get(j); // value is first element in unsorted arraylist
            int possibleIndex = j;
            while (possibleIndex > 0 && value.compareTo(songCollection.get(possibleIndex - 1), field) < 0){
                songCollection.set(possibleIndex, songCollection.get(possibleIndex - 1));
                possibleIndex--;
            }
            songCollection.set(possibleIndex, value); // put value in its place!
        }
    }
    //Sorts Songs through selection
    public void selectionSort(String field){
        // Sort by swapping smallest with first element of unsorted part
        // i is the index of the first element of the unsorted part…
        for (int i = 0; i < songCollection.size() - 1; i++){
            // Finding index of smallest value of the unsorted part…
            Song min = songCollection.get(i);
            int minIndex = i;
            for (int j = i+1; j < songCollection.size(); j++) 
            {
                if (min.compareTo(songCollection.get(j), field) > 0){ 
                    min = songCollection.get(j);
                    minIndex = j;
                }
            }
            // swap smallest value its proper place
            Song temp = songCollection.get(i);
            songCollection.set(i, min);
            songCollection.set(minIndex, temp);
        }
        
    }
    //Sorts songs through MergeSort
    public void mergeSort(String field){
        int n = songCollection.size();
        ArrayList<Song> temp = new ArrayList<Song>(0);
        mergeSort(songCollection, 0, n - 1, temp, field);
        }  
    public static void mergeSort(ArrayList<Song> input, int from, int to, ArrayList<Song> temp, String field){
        if (from < to){
            int middle = (from + to)/ 2;
            mergeSort(input, from, middle, temp, field);
            mergeSort(input, middle + 1, to, temp, field);
            merge(input, from, middle, to, temp, field);
        }
    }
    private static void merge(ArrayList<Song> input, int from, int mid, int to, ArrayList<Song> temp, String field) {
        int i = from;
        int j = mid + 1;
        int k = from;
        while (i <= mid && j <= to){
            if (input.get(i).compareTo(input.get(j), field) < 0){
                temp.add(k, input.get(i));
                i++;
            }
            else{
                temp.add(k, input.get(j));
                j++;
            }
            k++;
        }
        while (i <= mid){
            temp.add(k, input.get(i));
            i++;
            k++;
        }
        while (j <= to)
        {
            temp.add(k, input.get(j));
            j++;
            k++;
        }

        for (k = from; k <= to; k++)
        {
            input.set(k, temp.get(k));
        }
    }
    //Prints songs through PrintStream
    public void printSongs(PrintStream output){
        for (int i = 0; i < songCollection.size(); i++){
            output.println(songCollection.get(i));
        }
    }
}