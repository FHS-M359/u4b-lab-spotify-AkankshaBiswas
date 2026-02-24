import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;
public class SpotifyTester {
    private static final int VIEWPLAYLIST=1;
    private static final int SORTBYARTISTZA=2;
    private static final int SORTBYARTISTAZ=3;
    private static final int SORTBYYEARNEWOLD=4;
    private static final int SORTBYYEAROLDNEW=5;
    private static final int SEARCHBYGENRE=6;
    private static final int QUIT=7;


    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Let's start the spotify tester");
        Scanner sc=new Scanner(System.in);

        Playlist songs=new Playlist();
        while(true) {
            System.out.println("Pick from the following options");

//menu of options
            System.out.println("******** MENU *********");
            System.out.println("1. view entire playlist"); //extra
            System.out.println("2. sort by artist by Z-A");
            System.out.println("3. Sort artist by A-Z");
            System.out.println("4. Sort by year: new-old");
            System.out.println("5. Sort by year: old-new");
            System.out.println("6. Search by genre");
            System.out.println("7. quit");
            System.out.println("******** MENU *********");


            try {
                System.out.println("Enter your choice from 1-7!");
                int answer = sc.nextInt();

                if (answer >= VIEWPLAYLIST && answer <= SEARCHBYGENRE) {
                    if(answer==VIEWPLAYLIST){

                        System.out.println(songs);
                    }
                    else if(answer==SORTBYARTISTZA){
                        songs.sortByArtistZA();
                    }
                    else if(answer==SORTBYARTISTAZ){
                        songs.sortByArtistAZ();
                    }
                    else if(answer==SORTBYYEARNEWOLD){
                        songs.sortByYearNewToOld();
                    }
                    else if(answer==SORTBYYEAROLDNEW){
                        songs.sortByYearOldToNew();
                    }
                    else{
                        sc.nextLine();
                        System.out.println("What genre would you like?");
                        System.out.println("The available genres are... Hip-hop, Pop, Synth Pop, Electronic, Rock, Country Rap, R&B, and Indie");
                        String gen=sc.nextLine();
                        songs.searchByGenre(gen);
                    }
                } else if (answer == QUIT) {
                    System.out.println("Thank you for participating");
                    break;
                }

                else{
                    System.out.println("Choose 1-7 only");
                    continue;

                }
            }catch (InputMismatchException e){
                System.out.println("Invalid input; input correctly next time");
                sc.next();
            }

        }

    sc.close();


   }

}
