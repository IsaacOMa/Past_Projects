
public class LogMessage {
private String machineId;
private String description;

public LogMessage (String message)
{
//	for (int i = 0; i < message.length(); i++)
//	{
//		String shorty = message.substring(i, i+1);
//		if (shorty.equals(":"))
//		{
//			machineId = message.substring(0, i);
//			description = message.substring(i, message.length() - 1);
//		}
//	}
	//The indexOf() allows for easier processing of the sentence. The method shown above works, however, it is inefficient
	
	int colon = message.indexOf(":");
	machineId = message.substring(0, colon);
	description = message.substring(colon + 1, message.length());
	
}


public boolean containsWord (String keyword)
{

	boolean inSentence = false;
	if ((description.indexOf(" " + keyword + " ") > -1) && (description.indexOf(" " + keyword + " ") < description.length())){
		inSentence = true; 
	}
	if (description.equals(keyword))
	{
		inSentence = true;
	}
	if ((description.indexOf(keyword.toLowerCase() + " ") > -1) && description.indexOf(keyword) < keyword.length())
	{
	inSentence = true;
	}
	if ((description.indexOf(" " + keyword)) == (description.length() - keyword.length() - 1))
			{
		inSentence = true;
			}
		return inSentence;
}



public String getMachineId()
{
	return machineId;
}


public String getDescription()
{
	return description;
}

public static void main (String args[])
{
	LogMessage[] messager = new LogMessage[6];
	messager[0] = new LogMessage("CLIENT3:security alert - repeated login failures");
	messager[1] = new LogMessage("Webserver:disk offline");
	messager[2] = new LogMessage("SERVER1:file not found");
	messager[3] = new LogMessage("SERVER2:read error on disk DSK1");
	messager[4] = new LogMessage("SERVER1:write error on disk DSK2");
	messager[5] = new LogMessage("Webserver:error on /dev/disk");
	//LogMessage messager = new LogMessage("SERVER2:read error on DSK1 disk");
	for (int num = 0; num < messager.length; num ++)
	{
		System.out.println(messager[num].containsWord("disk"));
	}
	

}
}
