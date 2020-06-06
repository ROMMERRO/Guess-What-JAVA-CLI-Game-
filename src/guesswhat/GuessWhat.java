package guesswhat;


import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ROMERRO
 */
public class GuessWhat {

    public static Scanner scan = new Scanner(System.in);
    public static Random rand = new Random();	

            // main
    public static void main(String[] args) throws InterruptedException
    {   
    /*_the next part is for the intro of the game_*****************************/    
        for(int i=0;i<42;i++)System.out.print("*");
        Thread.sleep(200);
        System.out.print("\n**\t\t\t\t\t**");
        Thread.sleep(300);
        System.out.print("\n**\tHi, Welcome to \"GuessWhat\"   \t**");
        Thread.sleep(1500);
        System.out.print("\n**\t\t\t\t\t**");
        Thread.sleep(500);
        System.out.println("\n**    press any key to start the game\t**");
        Thread.sleep(300);
        for(int i=0;i<42;i++)System.out.print("*");
        System.out.println();
        scan.next();
        
        System.out.println("Your Game will start in");
        
        for(int i=3;i>0;i--)
        {
            Thread.sleep(1000);
            System.out.println("\n \t \t "+i);
        }
        Thread.sleep(1000);
        System.out.println("\t\tGo!have fun\n");
        Thread.sleep(1000);
    /**************************************************************************/
    /*_the game start from here_*/
        boolean replay = true;
        while(replay)
        {
            Play.play();
            System.out.println("\nIf you want to play again press ' y '.\nif you don't press any other key.Thanks!");
            replay = ("y".equals(scan.next()));
        }
        System.out.println("We wish you have enjoyed!!!good bye!!");
    }    
}
