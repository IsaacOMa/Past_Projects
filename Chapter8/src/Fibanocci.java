
public class Fibanocci {

	public static void main (String[] args)
	{
		System.out.println(sequence(7));
	}

	public static int sequence (int num)
	{
		if (num == 1)
		{
			return 1;
		}
		else if (num == 2)
		{
			return 1;
		}
		else 
			 return sequence (num-1) + sequence (num - 2);
	}
	
	}

