
import java.util.*;

public class StringFormatter
{
	public static int totalLetters(List<String> wordList)
	{
		int n = 0;
		for (int i = 0; i < wordList.size(); i++) {
			n += wordList.get(i).length();
		}
		return n;
	}
	public static int basicGapWidth(List<String> wordList, int formattedLen)
	{
		int letters = StringFormatter.totalLetters(wordList);
		int words = wordList.size();
		int spacesLeft = formattedLen - letters;
		int basicSpaces = spacesLeft / (words - 1); 
		return basicSpaces; //should be basic Spaces
	}
	public static int leftOverSpaces(List<String> wordList, int formattedLen)
	{
		int letters = StringFormatter.totalLetters(wordList);
		int initialSpaces = formattedLen - letters;
		int extraSpaces = initialSpaces - (basicGapWidth(wordList, formattedLen) * (wordList.size() - 1));
		return extraSpaces; // should Be extraSpaces
	}
	public static String format(List<String> wordList, int formattedLen)
	{
		int num = basicGapWidth(wordList, formattedLen);
		String sentence = "";
		int spaces = leftOverSpaces(wordList, formattedLen);

		for (int i = 0; i < wordList.size(); i++)
		{
			sentence += wordList.get(i);
			if (i < (wordList.size() - 1))
			{
				for (int n = 0; n < num; n++)
				{
					sentence += " ";
				}
				if (spaces > 0)
				{
					sentence += " ";
					spaces--;
				}
			}
		}
		return sentence;
	}


	public static void main(String[] args)
	{
		//testing 123
		List<String> wordList1 = new ArrayList<String>();
		wordList1.add("AP");
		wordList1.add("COMP");
		wordList1.add("SCI");
		wordList1.add("ROCKS");
		List<String> wordList2 = new ArrayList<String>();
		wordList2.add("GREEN");
		wordList2.add("EGGS");
		wordList2.add("AND");
		wordList2.add("HAM");
		List<String> wordList3 = new ArrayList<String>();
		wordList3.add("BEACH");
		wordList3.add("BALL");

		System.out.println(format(wordList1, 20));
		System.out.println(format(wordList2, 20));
		System.out.println(format(wordList3, 20));
	} 

}



