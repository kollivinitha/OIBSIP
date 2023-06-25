import java.util.*;

public class atm_interface
{
    static String id,name;
    static int pin,entered_pin;
    static float balance=100000f;
    static int count=0;
    static String transaction_history="";
    static boolean bool=true;

    static Scanner sc=new Scanner(System.in);
    
    public static void signin()
    {
        System.out.println("Please Enter your Name:");
        id=sc.next();
        System.out.println("Please Enter your 4-Digit UPI Pin:");
        pin=sc.nextInt();
        System.out.println("Please Don't share your UPI PIN");
        System.out.println("Congratulations!! You have successfully authorized to access the Atm Functionlities");
    }
    public static void login()
    {
        System.out.println("Please Enter your Name:");
        name=sc.next();
        if(name.equals(id))
        {
            System.out.println("Please Enter your 4-Digit UPI PIN:");
            entered_pin=sc.nextInt();
            if(pin==entered_pin)
            {
                System.out.println("Congratulations!!! You have successfully logged in and unlocked the ATM Functionalities");
            }
            else{
            System.out.println("Sorry!! You are supposed to be unauthorized");
            System.exit(0);
        }
        }
        else{
            System.out.println("Sorry!! You are supposed to be unauthorized");
            System.exit(0);
        }
        
    }

    public static void deposit(int amount){
        balance+=amount;
        System.out.println("Amount is successfully credited!!");
        System.out.println("Available balance:"+balance);
        count+=1;
        transaction_history+="RS."+amount+" credited to your account\n";

    }
    public static void withdraw(int amount){
        if(amount>balance){
            System.out.println("Negative Balance Transaction Cancelled");
        }
        else{
            balance-=amount;
            System.out.println("Amount is successfully debited!!");
            System.out.println("Available balance:"+balance+"/-");
            count+=1;
            transaction_history+="RS."+amount+" debited from your account\n";
        }

    }
    public static void transfer(float amount,int transfer_acc){
        if(amount>balance){
            System.out.println("Insufficient Balance Transaction Cancelled");
        }
        else{
            balance-=amount;
            System.out.println("Amount is successfully transferred!!");
            System.out.println("Available balance:"+balance+"Rupees");
            count+=1;
            transaction_history+="RS."+amount+" tranferred from your account\n";
        }

    }
    public static void transaction_History()
    {
        if(count>0)
        {
            System.out.println("You have perfomed "+count+" transactions...");
            System.out.println("Transaction History:");
            System.out.println(transaction_history);
        }
        else{
            System.out.println("You have not performed any ATM transaction");
        }
    }
    public static void main(String[] args) throws Exception
    {
        System.out.println("WELCOME TO ATM...PLEASE SIGNIN TO CONTINUE");
        System.out.println("\n1.SIGNIN \n2.Quit");
        int ch=sc.nextInt();
        if(ch==1)
        {
            signin();
        }
        else{
            System.exit(0);
        }
        System.out.println("Please login to unlock the ATM Functionalities");
        System.out.println("\n1.LOGIN \n2.Quit");
        int c=sc.nextInt();
        if(c==1)
        {
            login();
        }
        else{
            System.exit(0);
        }
        while(bool)
        {
            System.out.println("Choose your desired transaction:");
            System.out.println("\n1.Deposit\n2.Withdraw\n3.Transfer\n4.Transaction History\n5.Quit");
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                 System.out.println("Enter amount to be deposited");
                 int amount=sc.nextInt();
                 deposit(amount);
                 break;
                 case 2:
                 System.out.println("Enter amount to be credited");
                 int a=sc.nextInt();
                 withdraw(a);
                 break;
                 case 3:
                 System.out.println("Enter amount to be transferred");
                 int b=sc.nextInt();
                 System.out.println("Enter the account number of the receiver");
                 int account_num=sc.nextInt();
                 transfer(b,account_num);
                 break;
                 case 4: transaction_History();
                 break;
                 case 5:bool=false;
                 System.out.println("Please Collect Your Card....THANK YOU");
                 System.exit(0);
            }
        }
    }
}
