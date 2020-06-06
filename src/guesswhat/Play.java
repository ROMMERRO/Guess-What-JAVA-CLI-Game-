package guesswhat;

import static guesswhat.GuessWhat.*;
import java.util.ArrayList;

/**
 *
 * @author ROMERRO
 */

public abstract class Play     
{
// this var present the msg we'll show to the player if he won or lost the game or a chance
    static String dead = null;	
/*-----------------Functions--------------------*/
	
    public static void disp(Words m,String[] cases,int chance)
    {
        
    /* the next part is for opening the Game Frame *********************************/    
	
        System.out.println("*******************| "+m.category+" |*******************");
        System.out.print("**");
	for(int i=0;i<m.category.length()+38;i++)System.out.print(" ");
        System.out.println("**");	
    
    /*******************************************************************************/
    //    
    /* the next part is for display the available cases for the word *****/   
        
        // make the cases in the center of the frame  :  
        int w = (m.category.length()+39 - (cases.length + 2*(cases.length-1)) ) / 2;
        for(int i=0;i<w;i++) System.out.print(" ");
        
        //show the cases
        for (String i : cases) System.out.print("  "+i);
    /********************************************************************/
    //    
        System.out.print(" \n \n ");
    //
    /* the next part is for display the available caracters for the word */
	for (char i : m.caracters) System.out.print("   "+i);
 
    /* the next part is for closing the Game Frame **********************/
	
        System.out.print("\n**");
        for(int i=0;i<m.category.length()+38;i++)System.out.print(" ");
        System.out.println("**");
        for(int i=0;i<m.category.length()+42;i++)System.out.print("*");
    
    /*******************************************************************/
        
        if(chance!=0)
        {
            dead = "";
            for(int i=0;i<chance;i++) dead += "\t#";
            System.out.println("\n\t     You still have "+chance+" choices");
        }
	System.out.println("\n\t"+dead);
        
    }



    public static ArrayList<Words> creatListWords()            
    {
		
	ArrayList<Words> listWords = new ArrayList<>();
		
		
		String[] words  = 
                {
                    "cat",          //
                    "cow",          //
                    "bear",         //  Animals
                    "lion",         //
                    "elephant",     //
                    
                    "leg",          //
                    "hair",         //
                    "head",         // Body
                    "arm",          //
                    "nose",         //
                    
                    "carrot",       //
                    "tomatos",      //
                    "potatos",      // Vegitables
                    "onion",        //
                    "garlic",       //
                    
                    "bowling",      //
                    "baseball",     //
                    "tennis",       // Sport
                    "golf",         //
                    "chess",        //
                    
                    "desktop",      //
                    "office",       //
                    "software",     // Computer
                    "hardware",     //
                    "disk",         //
                    
                    "apple",        //
                    "watermelon",   //
                    "grape",        // Fruits
                    "orange",       //
                    "lemon"         //
                };
		String[] carac = 
                {
                    "qcsdftlmat",   // cat
                    "zoewriyupc",   // cow
                    "hekragmblj",   // bear  
                    "lwixcnvbpo",   // lion
                    "enrkqpatlh",   // elephant
                    
                    "kehjglmlnb",   // leg
                    "aprtiyuoqh",   // hair
                    "dflhegjkam",   // head
                    "xwrmbanvcp",   // arm
                    "nipsroteyu",   // nose
                    
                    "otyharncbg",   // carrot
                    "fgasdomthj",   // tomatos
                    "oasxctderp",   // potatos
                    "nikjuoyhbv",   // onion
                    "rcgaxslziq",   // garlic
                    
                    "bongltywih",   // bowling
                    "aeloxskbqt",   // baseball
                    "isqmtnldbe",   // tennis
                    "ortlgyuiwf",   // golf
                    "thebalcnsm",   // chess
                    
                    "teodapqwsk",   // desktop
                    "dicevofght",   // office
                    "sartehwmof",   // software
                    "hlrdekwmaf",   // hardware
                    "iktedocqls",   // disk
                    
                    "alrztypqew",   // apple
                    "lwnreomeat",   // watermelon
                    "bpenrgvcax",   // grape
                    "oemgalsnbr",   // orange
                    "lwrgmneohd"    // lemon
                };
		String[] categ = 
                { 
                    "ANIMALS" , 
                    "BODY" , 
                    "VIGETABLES",
                    "SPORT",
                    "COMPUTER",
                    "FRUITS"
                };
		
		int j = 0,t = 0;
		for(int i=0;i<words.length;i++) {
		
			if(i-t == 5) {
				t = i;
				j++;
			}
			Words m = new Words();
			
			m.setWord(words[i]);
			m.setCaracters(carac[i].toCharArray());
			m.setCategory(categ[j]);
			listWords.add(m);
				
		}
		return listWords;
	}    
    
      
        
    public static boolean casesEmpty(String[] cases)
    {
        /*
        * this function verify if the play complet entering the correct word
        */
        
        for (String cs : cases) 
        {    
            if (cs.equals("_")) // if one of the text field "_" is empty then he's not complet the word yet 
                return true;    // at least one of the cases "_" is empty
        }
        
        return false;           // the whole cases are full, the player complet correctly the word
		
    }
	
        
    
    public static void play()
    {
        
	int r = rand.nextInt(30);   // we'll use this var as a index to reach word in a random way

	Words currentWord = creatListWords().get(r); // here it is 

	String[] cases = new String[currentWord.word.length()]; // the available cases for the word
		
	for(int i=0;i<currentWord.word.length();i++) cases[i] = "_"; // initialize the available cases ( Empty => '_' )
		

        int chance=3;   // this var present the posible number of the wrong choices

	while(chance>0 && casesEmpty(cases))
        {
            disp(currentWord,cases,chance);
		
            String c =  scan.next().toLowerCase() ; 
		
            if(currentWord.word.contains(c) && String.valueOf(currentWord.caracters).contains(c))
            {	
                
                cases[currentWord.word.indexOf(c)] = c;
                cases[currentWord.word.lastIndexOf(c)] = c;
                
                currentWord.caracters[ String.valueOf(currentWord.caracters).indexOf(c) ] = '◌';
                	
            }
		
		
            else if( String.valueOf(currentWord.caracters).contains(c) )
            { 
		currentWord.caracters[String.valueOf(currentWord.caracters).indexOf(c)] = '◌';
		chance--;
                System.out.println("Sorry!wrong choice!you lost one chance");
            }
		
		
            else System.out.println("Seriously man!Are you blind or fool!what is that!!?");
					
	}	 
        
        if(chance==0) dead = "\n   You Lost!!!! Good luck with the next turn!";
        else
        {
            dead = "\n\t\tBravo!!! You Win"  ;
            chance = 0;
        }
        disp(currentWord,cases,chance);                 
           
    }
	
        
        
}
