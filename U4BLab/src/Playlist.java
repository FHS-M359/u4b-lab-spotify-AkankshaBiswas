

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
//Represents a playlist containing multiple Song objects.
 //Provides the functionality to load songs, search by genre,
        //as well as sort songs by artist or year.

public class Playlist {

    ArrayList<Song> songsList;


    public Playlist() throws FileNotFoundException{
        this.songsList=new ArrayList<Song>();
        this.loadSong();
    }
    // Read song data from the text file and loads THat it into the songsList ArrayList
    public void loadSong() throws FileNotFoundException {
        Scanner scan=new Scanner(new File("spotify_unique_years_artists.txt"));
        while(scan.hasNextLine()){
            String line=scan.nextLine();
            String[] parts=line.split(",");
            // split each line of the file into parts using commas to sepearte the song parts
            String title=parts[0];
            String artist=parts[1];
            String album=parts[2];
            String genre=parts[5];
            int year=Integer.parseInt(parts[4]);
            int duration=Integer.parseInt(parts[3]);


            Song newSong=new Song(title, artist, album, genre, year,duration);
            songsList.add(newSong);
        }

    }

    // Searches for songs that matches specific genre entered by the user
    public void searchByGenre(String genre){
        ArrayList<Song> filteredList=new ArrayList<Song>();
        for(Song i:songsList){
            if(i.getGenre().equals(genre)){
            filteredList.add(i);
            }

        }
        if(filteredList.size()==0){
            System.out.println("No song in these genre was found. Please select from the following options next time.");
        }
        else{
        songOutput(filteredList);}
    }
    // Sort songs by artist name from A to Z using selection sort
    public void sortByArtistAZ(){
        ArrayList<Song> sortedByArtistListAZ=new ArrayList<>(songsList);
        for(int i=0; i<sortedByArtistListAZ.size()-1; i++){
            int indexSmallest=i;


            for(int s=i+1; s< sortedByArtistListAZ.size(); s++){
                String currentArtist=sortedByArtistListAZ.get(s).getArtist();
                String smallestArtist=sortedByArtistListAZ.get(indexSmallest).getArtist();
                if(currentArtist.compareToIgnoreCase(smallestArtist)<0){
                    indexSmallest=s;
                }

            }
                if(indexSmallest!=i){
                    Song temp=sortedByArtistListAZ.get(i);
                    sortedByArtistListAZ.set(i,sortedByArtistListAZ.get(indexSmallest));

                    sortedByArtistListAZ.set(indexSmallest, temp);
                }


        }

        songOutput(sortedByArtistListAZ);
    }
    // Sort songs by artist name from Z to A using selection sort
    public void sortByArtistZA(){
        ArrayList<Song> sortedByArtistListZA=new ArrayList<>(songsList);
        for(int i=0; i<sortedByArtistListZA.size()-1; i++){
            int indexLargest=i;

// track the index of the largest artist name
            for(int s=i+1; s< sortedByArtistListZA.size(); s++){
                String currentArtist=sortedByArtistListZA.get(s).getArtist();
                String smallestArtist=sortedByArtistListZA.get(indexLargest).getArtist();
                if(currentArtist.compareToIgnoreCase(smallestArtist)>0){
                    indexLargest=s;
                }
                // compare artist names alphabetically in reverse order


            }
            if(indexLargest!=i){
                Song temp=sortedByArtistListZA.get(i);
                sortedByArtistListZA.set(i,sortedByArtistListZA.get(indexLargest));

                sortedByArtistListZA.set(indexLargest, temp);
            }
            // swap the songs if larger artist name is found


        }

        songOutput(sortedByArtistListZA);
        //returne

    }
    // Sort songs from most oldest year to newest year using insertion sort
    //how:store the current song to insert into the sorted portion
    //shift songs with larger years forward (insertion)
    public void sortByYearOldToNew(){
        ArrayList<Song> copiedList=new ArrayList<>(songsList);
        for(int i=1; i<copiedList.size(); i++){
            Song key=copiedList.get(i);

            int j=i-1;
            while(j>=0 && copiedList.get(j).getYear()>key.getYear()){
                copiedList.set(j+1,copiedList.get(j));
                j--;

            }
            copiedList.set(j+1,key);

        }
        songOutput(copiedList);

    }
    // Sort songs from newest year to oldest year using insertion sort

    public void sortByYearNewToOld(){
        ArrayList<Song> copiedList=new ArrayList<>(songsList);
        for(int i=1; i<copiedList.size(); i++){
            Song key=copiedList.get(i);

            // store the current song to insert into the sorted portion

            int j=i-1;
            while(j>=0 && copiedList.get(j).getYear()<key.getYear()){
                copiedList.set(j+1,copiedList.get(j));
                j--;

            }
            copiedList.set(j+1,key);
// shift songs with smaller years forward
        }
        songOutput(copiedList);

    }
    // Prints the formatted table displaying song information
    public void songOutput(ArrayList<Song> songs){
        String body="";
        String header=String.format("%-35s %-25s %-30s %-25s %-5s",
                "title","artist","album","genre","year"); //format method to make right spacing
        String dashed="-----------------------------------------------------------------------------------------------------------------------------------------";
        for(Song i:songs){
            body+="\n"+String.format("%-35s %-25s %-30s %-25s %-5d",
                    i.getTitle(), i.getArtist(), i.getAlbum(),i.getGenre(),i.getYear());
        }
        System.out.println(header+"\n"+dashed+"\n"+body);



    }
    // returns formatted string of all songs in the playlist
    @Override
    public String toString(){
        String body="";
        String header=String.format("%-35s %-25s %-30s %-25s %-5s",
                "title","artist","album","genre","year");
        String dashed="-----------------------------------------------------------------------------------------------------------------------------------------";
        for(Song i:songsList){
            body+=String.format("%-35s %-25s %-30s %-25s %-5d",
                    i.getTitle(), i.getArtist(), i.getAlbum(),i.getGenre(),i.getYear())+"\n";
        }
        return header+"\n"+dashed+"\n"+body;

    }

}
