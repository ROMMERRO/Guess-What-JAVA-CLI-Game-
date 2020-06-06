package guesswhat;

/**
 *
 * @author ROMERRO
 */
public class Words
{

/*--------Proprties-----------------*/
	
    String word,category;
    char[] caracters = new char[10];	
		
	
/*--------Getters and Setters-----------------*/	
		
    public String getWord()
    {
        return word;
    }
    public void setWord(String word)
    {
        this.word = word;
    }
	
    public String getCategory() 
    {
        return category;
    }
    public void setCategory(String category) 
    {
        this.category = category;
    }
		
    public char[] getCaracters()
    {
        return caracters;
    }
    public void setCaracters(char[] caracters) 
    {
        this.caracters = caracters;
    }
	
/*--------Constructors-----------------*/	
	
    public Words()
    {
         //Empty Constructor
    }
    public Words(String word,String category,String caracters)
    {
        this.word = word;
        this.category = category;
        this.caracters = caracters.toCharArray();
    }

}