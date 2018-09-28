import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SystemLog {

	private List<LogMessage> messageList = new ArrayList<LogMessage>();
	List<LogMessage> removed = new ArrayList<LogMessage>();
	
	public List<LogMessage> removeMessages(String keyword)
	{
		
		for (int i = 0; i < messageList.size(); i++)
		{
			if (messageList.get(i).containsWord(keyword))
			{
				removed.add(messageList.get(i));
				messageList.remove(i);
				i--;
			}
	}
		return removed;
}
 
	public static void main (String[] args)
	{
		SystemLog s = new SystemLog();
		s.messageList.add(new LogMessage ("CLIENT3:security alert - repeated login failures"));
		s.messageList.add(new LogMessage ("Webserver:disk offline"));
		s.messageList.add(new LogMessage ("SERVER1:file not found"));
		s.messageList.add(new LogMessage ("SERVER2:read error on disk DSK1"));
		s.messageList.add(new LogMessage ("SERVER1:write error on disk DSK2"));
		s.messageList.add(new LogMessage ("Webserver:error on /dev/disk"));
		
		System.out.println("Original list:");
		for (int i = 0; i < s.messageList.size(); i++)
		{
			System.out.println(" " + s.messageList.get(i).getDescription());
		}
		System.out.println();
		System.out.println();
		
		
		System.out.println("The removed declarations");
		s.removeMessages("disk");
		for (int i = 0; i < s.removed.size(); i++)
		{
			System.out.println(s.removed.get(i).getDescription());
		}
		System.out.println();
		System.out.println();
		
		
		System.out.println("The remaining declarations:");
		for (int i = 0; i < s.messageList.size(); i++)
		{
			System.out.println(s.messageList.get(i).getDescription());
		}
		
	}
}
