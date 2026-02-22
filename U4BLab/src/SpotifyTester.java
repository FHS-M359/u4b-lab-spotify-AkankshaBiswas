import java.io.FileNotFoundException;
import java.util.Scanner;
public class SpotifyTester {

    public static void main(String[] args) throws FileNotFoundException {
//        System.out.println("Let's start the spotify tester");
//        Scanner sc=new Scanner(System.in);
//
//        System.out.println("Pick from the following options");
//
//
//        System.out.println("1. view entire playlist"); //extra
//        System.out.println("2. sort by artist by Z-A");
//        System.out.println("3.Sort artist by A-Z");
//        System.out.println("4.Sort by year: new-old");
//        System.out.println("5. Sort by year: old-new");
//        System.out.println("6. Search by genre");
//        System.out.println("7. quit");
//
//

        Playlist obj=new Playlist();
//        System.out.println(obj);
//
        obj.sortByYear();

        System.out.println("Artist sorted ");
        obj.sortByArtistAZ();

        obj.searchByGenre("Hip-Hop");
    }
}
