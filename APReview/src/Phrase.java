public class Phrase
{
  private String currentPhrase;
  
  public Phrase(String p)
  {
    currentPhrase = p;
  }
  
  public int findNthOccurrence(String str, int n)
  { 
    int i = currentPhrase.indexOf(str);
    if(currentPhrase.indexOf(str) == -1)
      return -1;
    else
    {
      int count = 1;
      if(count == n)
      {
        return i;
      }
      while(i + str.length() < currentPhrase.length())
      {
        i = currentPhrase.indexOf(str, i + 1);
        if (i == -1)
        {
          return -1;
        }
        else 
        {
          count++;
          if(count == n)
          {
            return i;
          }
        }
      }
    }
    return -1;
  }
  
  public void replaceNthOccurence(String str, int n, String repl)
  {
	  String newPhrase = "";
	  int num = 0;
	  for (int i = 0; i < currentPhrase.length(); i++) {
		  if (i + str.length() < currentPhrase.length()) {
			  if (currentPhrase.substring(i, i + str.length()).equals(str)) {
				  num++;
			  }
			  if (currentPhrase.substring(i, i + str.length()).equals(str) && num == n) {
				  newPhrase = currentPhrase.substring(0, i) + repl + currentPhrase.substring(i + str.length());
			  }
		  }
	  }
	  if (num >=n) {
		  currentPhrase = newPhrase;
	  }

  }
  
  public int findLastOccurence(String str)
  {
	  for (int i = currentPhrase.length() - 1; i >=0; i--) {
		  if (i + str.length() - 1 < currentPhrase.length()) {
			  if (currentPhrase.substring(i, i + str.length()).equals(str)) {
				  return i;
			  }
		  }
	  }
	  return -1;
  }
  
  public String toString()
  {
    return currentPhrase;
  }
  
  public static void main(String[] args)
  {
    Phrase phrase1 = new Phrase("A cat ate late.");
    phrase1.replaceNthOccurence("at", 1, "rane");
    System.out.println(phrase1);
    
    Phrase phrase2 = new Phrase("A cat ate late.");
    phrase2.replaceNthOccurence("at", 6, "xx");
    System.out.println(phrase2);
    
    Phrase phrase3 = new Phrase("A cat ate late.");
    phrase3.replaceNthOccurence("bat", 2, "xx");
    System.out.println(phrase3);
    
    Phrase phrase4 = new Phrase("aaaa");
    phrase4.replaceNthOccurence("aa", 1, "xx");
    System.out.println(phrase4);
    
    Phrase phrase5 = new Phrase("aaaa");
    phrase5.replaceNthOccurence("aa", 2, "bbb");
    System.out.println(phrase5);
    
    phrase1 = new Phrase("A cat ate late.");
    
    System.out.print("The last occurrence is actually at index 11 and the return is ");
    System.out.println(phrase1.findLastOccurence("at"));
    
    System.out.print("The last occurrence is actually at index 2 and the return is ");
    System.out.println(phrase1.findLastOccurence("cat"));
    
    System.out.print("The last occurrence should return -1 and returns ");
    System.out.println(phrase1.findLastOccurence("bat"));
  }
}