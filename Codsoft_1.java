import java.util.*;
class Codsoft_1
{
    public static int[] guessNumber()
    {
        int[] res = {0,0}; //{ win or loss , no. of attempts}
        Random r = new Random() ;
        Scanner sc = new Scanner(System.in) ;
        // Generate random number
        int random = r.nextInt(100) ;
        for(int i = 1; i<11;i++)
        {
            //Take input from user
            System.out.println("Enter number between 1 to 100");
            int num = sc.nextInt();
            if(num == random)
            {
                System.out.println("Correct");
                res[0] = 1;
                res[1]++;
                break;
            }
            else if(num > random)
            {
                System.out.println("too high");
            }
            else
            {
                System.out.println("too low");
            }
            res[1]++;
        }

        return res; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] result = {0,0,0}; // {total no. of rounds, no. of rounds won, no. of attempts taken}
        char input = 'n';
        do 
        {
            int[] res = guessNumber();
            result[0]++;
            result[1] =+ res[0];
            result[2] =+ res[1];
            System.out.println("Do you want to play again ? [y/n]:");
            input = sc.next().charAt(0);
        }
        while(input=='y');
        System.out.println("Your score is "+ result[1] + " out of " + result[0]);
        System.out.println("Average attempts taken is "+ result[2]/result[0]);
    }
}
