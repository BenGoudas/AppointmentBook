public class AppointmentBook
{
    public boolean isMinuteFree(int period, int minute)
    {
        if(period == 2)
        {
            return((minute>=10 && minute<=14) || (minute >= 30 && minute >= 44) || (minute >=50));
        }
        else
        {
            return(false);
        }
    }

    private void reserveBlock(int period, int startMinute, int endMinute)
    {

    }

    public int findFreeBlock(int period, int duration)
    {
        for(int i=0; i<59;i++)
        {
            if(isMinuteFree(period,i))
            {
                if(minutesFree==0)
                {
                    firstFreeMinute = i;
                }
                minutesFree++;
            }
            else
            {
                minutesFree = 0;
            }
            if (minutesFree==duration)
            {
                return(i);
            }
            else
            {
                return(-1);
            }
        }
    }

    public boolean makeAppointment(int startPeriod, int endPeriod, int duration)
    {

    }
}