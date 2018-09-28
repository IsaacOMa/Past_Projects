
public class HiddenWord
{
  String word ="";
  public HiddenWord(String hWord) {
	  word = hWord;
  }

  
  public String getHint(String guess)
  {
	  String statement = "";
    for (int i = 0; i < guess.length(); i++) {
    	boolean presence = false;
    	if (word.substring(i, i+1).equals(guess.substring(i, i+1))) {
    		statement += guess.substring(i, i+1);
    	}
    	else {
    		for (int k = 0; k < guess.length(); k++) {
    			if (guess.substring(i, i+1).equals(word.substring(k,k+1))){
    				presence = true;
    			}
    		}
    	if (presence == true) {
    	statement+= "+";
    	}
    	else 
    	statement+="*";
    	}
    }
    return statement;
  }

  public static void main(String[] args)
  {
    //Testing...testing...123
    HiddenWord puzzle = new HiddenWord("HARPS");
    System.out.println(puzzle.getHint("AAAAA"));
    System.out.println(puzzle.getHint("HELLO"));
    System.out.println(puzzle.getHint("HEART"));
    System.out.println(puzzle.getHint("HARMS"));
    System.out.println(puzzle.getHint("HARPS"));
  }
}