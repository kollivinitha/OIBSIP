import java.util.*;

public class Number_guessing
{
    public static void main(String[] args) throws Exception
    {
        int score=100;
        int x=1;
        Scanner sc=new Scanner(System.in);
        int max=100;
        int min=1;
        int rand_num=(int)(Math.random()*(max-min+1)+min);

        boolean status=false;
        while(!status || x > 10)
        {
        System.out.println("Guess a number between 1 to 100:");

        int num=sc.nextInt();

        if(num> rand_num)
        {
            System.out.println("The number you have guessed is too high....Try Again");
            score-=(2*x);
        }

        else if( num < rand_num)
        {
              System.out.println("The number you have guessed is too Low....Try Again");     
              score-=(2*x);     
        }

        else 
        {
            status=true;
            System.out.println("Congratulations!!! You have guessed the number accurately!");
            System.out.println("Your score is"+score);
        }
        x+=1;
    }
    if(x>10)
    {
        System.out.println("You lost the game");
    }

    }
}
