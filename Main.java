import java.util.Scanner;
import java.io.File;
import java.io.IOException;


public class Main
{
    public static void main(String[] args) throws IOException
    {
        AppointmentBook[] schedules = new AppointmentBook[100];
        File f = new File("schedules.txt");
        Scanner s = new Scanner(f);
        int i = 0;
        while (s.hasNextLine())
        {
            boolean[][] schedule = new boolean[8][60];
            int j = 0;
            while (j < schedule.length)
            {
                String line = s.nextLine();
                if (line.length() > 0)
                {
                    schedule[j] = getRow(line);
                }
                j++;
            }
            schedules[i] = new AppointmentBook(schedule);
            i++;
        }

        
        f = new File("requests.txt");
        s = new Scanner(f);
        int meetings = 0;
        while (s.hasNextLine()) 
        {
            int schedule = s.nextInt();
            int start = s.nextInt();
            int end = s.nextInt();
            int duration = s.nextInt();
            if(schedules[schedule].makeAppointment(start, end, duration))
            {
                meetings++;
            }
        }
        System.out.println(meetings);
    }

    public static boolean[] getRow(String s)
    {
        Scanner scanner = new Scanner(s);
        int i = 0;
        boolean[] row = new boolean[60];
        while(scanner.hasNextBoolean())
        {
            row[i] = scanner.nextBoolean();
            i++;
        }
        return row;
    }
    

}