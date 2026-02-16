

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Playlist {

    ArrayList<Song> songsList;

    public Playlist() throws FileNotFoundException{
        this.songsList=new ArrayList<Song>();
        this.loadSong();
    }

    public void loadSong() throws FileNotFoundException {
        Scanner scan=new Scanner(new File("spotify_unique_years_artists.txt"));
        while(scan.hasNextLine()){
            String line=scan.nextLine();
            String[] parts=line.split(",");

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
    @Override
    public String toString(){
        String body="";
        String header=String.format("%-25s %-25s %-30s %-25s %-5s",
                "title","artist","album","genre","year");
        String dashed="-----------------------------------------------------------------------------------------------------------------------------------------";
        for(Song i:songsList){
            body+="\n"+String.format("%-25s %-25s %-30s %-25s %-5d",
                    i.getTitle(), i.getArtist(), i.getAlbum(),i.getGenre(),i.getYear());
        }
        return header+"\n"+dashed+"\n"+body;

    }

}
