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
            teachers[i] = new AppointmentBook(s.nextLine() + " " + s.nextLine() + " " + s.nextLine() + " " + s.nextLine() + " " + s.nextLine() + " " + s.nextLine() + " " + s.nextLine() + " " + s.nextLine() + " " + s.nextLine());
        }

        f = new File("requests.txt");
        s = new Scanner(f);
        int sucessfulAppointments = 0;
        for (int i=0; i < 1000; i++)
        {
            int teacher = s.nextInt();
            int startpd = s.nextInt();
            int endpd = s.nextInt();
            int drtion = s.nextInt();
            for (int j = startpd; j < endpd; j++)
            {
                boolean appointmentMade = teachers[teacher].makeAppointment(startpd, endpd, drtion);
                if (appointmentMade == true)
                {
                    sucessfulAppointments++;
                }
            }
        }
        
        System.out.println(sucessfulAppointments);
    }
    

}