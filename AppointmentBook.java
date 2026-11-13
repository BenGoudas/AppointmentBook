import java.util.Scanner;


public class AppointmentBook
{
    private boolean[] period1;
    private boolean[] period2;
    private boolean[] period3;
    private boolean[] period4;
    private boolean[] period5;
    private boolean[] period6;
    private boolean[] period7;
    private boolean[] period8;

    
    public AppointmentBook(String scheduleData)
    {
        period1 = new boolean[60];
        period2 = new boolean[60];
        period3 = new boolean[60];
        period4 = new boolean[60];
        period5 = new boolean[60];
        period6 = new boolean[60];
        period7 = new boolean[60];
        period8 = new boolean[60];
        Scanner s = new Scanner(scheduleData);
        for (int i=0; i < 60; i++)
        {
            period1[i] = s.nextBoolean();
        }
        for (int i=0; i < 60; i++)
        {
            period2[i] = s.nextBoolean();
        }
        for (int i=0; i < 60; i++)
        {
            period3[i] = s.nextBoolean();
        }
        for (int i=0; i < 60; i++)
        {
            period4[i] = s.nextBoolean();
        }
        for (int i=0; i < 60; i++)
        {
            period5[i] = s.nextBoolean();
        }
        for (int i=0; i < 60; i++)
        {
            period6[i] = s.nextBoolean();
        }
        for (int i=0; i < 60; i++)
        {
            period7[i] = s.nextBoolean();
        }
        for (int i=0; i < 60; i++)
        {
            period8[i] = s.nextBoolean();
        }
        s.close();
    }
    
    public boolean isMinuteFree(int period, int minute)
    {
        boolean result;
        switch(period)
        {
            case 1:
                result = period1[minute];
                break;
            case 2:
                result = period2[minute];
                break;
            case 3:
                result = period3[minute];
                break;
            case 4:
                result = period4[minute];
                break;
            case 5:
                result = period5[minute];
                break;
            case 6:
                result = period6[minute];
                break;
            case 7:
                result = period7[minute];
                break;
            case 8:
                result = period8[minute];
                break;
            default:
                result = false;
        };
        return result;
    }

    private void reserveBlock(int period, int startMinute, int endMinute)
    {
        for(int i=startMinute; i<=endMinute; i++)
        {
            switch(period)
            {
                case 1:
                    period1[i] = false;
                    break;
                case 2:
                    period2[i] = false;
                    break;
                case 3:
                    period3[i] = false;
                    break;
                case 4:
                    period4[i] = false;
                    break;
                case 5:
                    period5[i] = false;
                    break;
                case 6:
                    period6[i] = false;
                    break;
                case 7:
                    period7[i] = false;
                    break;
                case 8:
                    period8[i] = false;
                    break;
            };
        }
    }

    public int findFreeBlock(int period, int duration)
    {
        for(int i=0; i<59;i++)
        {
            int minutesFree = 0;
            int firstFreeMinute = -1;
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
                return(firstFreeMinute);
            }
        }
        return(-1);
    }

    public boolean makeAppointment(int startPeriod, int endPeriod, int duration)
    {
        for(int i=startPeriod; i<=endPeriod; i++)
        {
            int freeBlock = findFreeBlock(i,duration);
            if(freeBlock != -1)
            {
                reserveBlock(i,freeBlock,freeBlock+duration-1);
                return(true);   
            }
        }
        return(false);
    }
}