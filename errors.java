import java.util.Scanner;
import java.util.InputMismatchException;
public class errors
{
    static Scanner scanner = new Scanner(System.in);
    public static void main()
    {
        System.out.println("Pick a number between 1 and 10");

        try 
        {
            int number = getNumber();
            System.out.println("You picked " + number);
        }
        catch (InputMismatchException e)
        {
            System.out.println("Don't be dumb.");
        }
        catch (RuntimeException e)
        {
            System.out.println("Your number is bad.");
        }
        catch (Exception e)
        {
            System.out.println("Unknown Error: " + e);
        }
    }
    
    public static int getNumber() throws Exception
    {
        int number = scanner.nextInt();
        if(number > 10 || number < 1)
        {
            throw new RuntimeException();
        }
        return number;
    }
}
