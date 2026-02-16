public class Song {
    private String title;
    private String artist;
    private String album;
    private int duration;
    private String genre;
    private int year;



    public Song(String title, String artist, String album, String genre, int year, int duration) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.year = year;
        this.duration=duration;
    }

    public int getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }


    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\t' +  //the t means it tabs space
                ", artist='" + artist + '\t' +
                ", album='" + album + '\t' +
                ", genre='" + genre + '\t' +
                ", year=" + year +
                '}';
    }
}
