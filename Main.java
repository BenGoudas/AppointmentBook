import java.util.Scanner;
import java.io.File;
import java.io.IOException;


public class Main
{
    public static void main(String[] args) throws IOException
    {
        File f = new File("schedules.txt");
        Scanner s = new Scanner(f);
        AppointmentBook[] teachers = new AppointmentBook[100];
        for (int i=0; i < 100; i++)
        {
            teachers[i] = new AppointmentBook(s.nextLine());
        }
    }

}