package us.wa.newport.finalSolution;
import java.io.*;
import java.util.*;
//Song Class for implementation in SongCollection as Object
public class Song{
    private boolean truth;
    private int year;
    private int rank; 
    private String artist; 
    private String title;
    private String song;
    //Constructs Song object of two ints (year and rank) and two Strings (artist and title)
    public Song(int inYear, int inRank, String inArtist, String inTitle){
        this.year = inYear;
        this.rank = inRank;
        this.artist = inArtist;
        this.title = inTitle;
    }
    //Returns year of song
    public int getYear(){
        return this.year;
    }
    //Returns rank of song
    public int getRank(){
        return this.rank;
    }
    //Returns artist of song
    public String getArtist(){
        return this.artist;
    }
    //Returns title of song
    public String getTitle(){
        return this.title;
    }
    //Maintains input format of Song
    public String toString(){
        song = year + "\t" + rank + "\t" + artist + "\t" + title;
        return song;
    }
    //Int return to determine order
    public int compareTo(Song otherSong, String field){
        int comparison = 0;
        if (field.equals("year")){
            if (this.year == otherSong.getYear())
                comparison = 0;
            else if (this.year > otherSong.getYear())
                comparison = 1;
            else if (this.year < otherSong.getYear())
                comparison = -1;
        }
        else if (field.equals("rank")){
            if (this.rank == otherSong.getRank())
                comparison = 0;
            else if (this.rank > otherSong.getRank())
                comparison = 1;
            else if (this.rank < otherSong.getRank())
                comparison = -1;
        }
        else if (field.equals("artist")){
            comparison = this.artist.compareToIgnoreCase(otherSong.getArtist()); 
        }
        else if (field.equals("title")){
            comparison = this.title.compareToIgnoreCase(otherSong.getTitle());
        }
        return comparison;
    }
    //Boolean return to determine existence (stay or nay)
    public boolean isMatch(String field, String value){
        if (field.equals("year") && value.contains("-")){
            Range yearRange = new Range(value);
            if (this.year >= yearRange.getMin() && this.year <= yearRange.getMax())
                truth = true;
        }
        else if (field.equals("year")){
            int num = Integer.parseInt(value);
            if (this.year == num)
                truth = true;
        }
        if (field.equals("rank") && value.contains("-")){
            Range rankRange = new Range(value);
            if (this.rank >= rankRange.getMin() && this.rank <= rankRange.getMax())
                truth = true;
        }
        else if (field.equals("rank")){
            int num = Integer.parseInt(value);
            if (this.rank == num)
                truth = true;
        }
        else if (field.equals("artist")){
            //Case insensitive filter by changing both values to lowerCase in comparison for artist and title
            if (this.artist.toLowerCase().contains(value.toLowerCase()))
                truth = true;
        }
        else if (field.equals("title")){
            if (this.title.toLowerCase().contains(value.toLowerCase()))
                truth = true;
        }
        return truth;
    }
}
            