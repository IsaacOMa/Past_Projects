
public class AddPascal {

	public void values (int numLines)
	{
		for (int index = 0; index <= numLines; index ++) {
			System.out.print( " " + pascals (numLines, index));
		}
	}
	
	public int pascals (int numLines, int index)
	{
		if (numLines == 1 || index == 0 || numLines == index)
		{
			return 1;
		}
		else 
		{
			return pascals (numLines - 1, index) + pascals (numLines - 1, index - 1);
		}
	}
}
