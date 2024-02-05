import java.util.Scanner;
class BankAccount
{
    String name;
    String userName;
    String password;
    String accountno;
    float balance =10000f;
    int transaction=0;
    String transactionHistory=" ";
    public  void register()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter your Name : ");
        this.name=sc.nextLine();
        System.out.println("\nEnter your Username : ");
        this.userName=sc.nextLine();
        System.out.println("\nEnter your Password : ");
        this.password=sc.nextLine();
        System.out.println("\nEnter your Account Number : ");
        this.accountno=sc.nextLine();
        System.out.println("\nRegistration Successful Please log in to your Bank Account : ");
    }
    public boolean login()
    {
        boolean islogin=false;
        Scanner sc=new Scanner(System.in);
        while(!islogin)  //false=true
        {
            System.out.println("\nEnter your Username : ");
            String Username=sc.nextLine();//g
            if(Username.equals(userName)) //g==g
            {
                while(!islogin) //false==true   true==false
                {
                    System.out.println("\nEnter Your Password: ");
                    String Password= sc.nextLine();
                    if (Password.equals(password))//123=123
                    {
                        System.out.println("\nLogin Successful....");
                        islogin=true;
                    }
                    else
                    {
                        System.out.println("\nPlease Try again Password not match.....");
                    }
                }
            }
            else
            {
                System.out.println("\nUser Name not match ");
            }
        }
        return islogin;
    }
    public void withdraw()
    {
        System.out.println("\nEnter Amount to Withdraw : ");
        Scanner sc=new Scanner(System.in);
        float amount=sc.nextFloat();
        try {

            if(balance>=amount)
            {
                transaction++;
                balance=balance-amount;
                System.out.println("\nWithdraw Successful .. ");
                String  str=amount+"Rs Withdraw\n";
                transactionHistory=transactionHistory.concat(str);
            }
            else
            {
                System.out.println("Insufficient Balance....");
            }
        }
        catch (Exception e)
        {

        }
    }

    public void deposite()
    {
        System.out.println("\nEnter Amount to deposit : ");
        Scanner sc=new Scanner(System.in);
        float amount=sc.nextFloat();
        try {

            if(amount<=10000f)
            {
                transaction++;
                balance=balance+amount;
                System.out.println("\nDeposit Successful .. ");
                String  str=amount+"Rs Deposit\n";
                transactionHistory=transactionHistory.concat(str);
            }
            else
            {
                System.out.println("\nSorry Deposit limit is only 10,000....");
            }
        }
        catch (Exception e)
        {

        }
    }


    public void transfer()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter Receipent Name : ");
        String receipent=sc.nextLine();
        System.out.println("\nEnter Amount to transfer : ");
        float amount=sc.nextFloat();
        try
        {
            if(balance>=amount)
            {
                if (amount <= 10000f)
                {
                    transaction++;
                    balance = balance - amount;
                    System.out.println("\nTransfer Successful .. "+receipent);
                    String str = amount + "Rs Transfer To "+ receipent+"\n";
                    transactionHistory = transactionHistory.concat(str);
                }
                else
                {
                    System.out.println("\nSorry Transfer  limit is only 10,000....");
                }
            }
            else
            {
                System.out.println("\nInsufficient Balance....");
            }
        }
        catch (Exception e)
        {

        }
    }

    public void transHistory()
    {
        if(transaction==0)
            System.out.println("No Transaction happened...");
        else
            System.out.println("\n"+transactionHistory);
    }

    public void checkBalance()
    {
        System.out.println("\n"+balance+"Rs");
    }
}
public class ATMInterface
{
    public static int takeninteger(int limit) //limit=2
    {
        int input=0;
        boolean flag=false;
        while (!flag) //false=true
        {
            try {
                Scanner sc=new Scanner(System.in);
                input=sc.nextInt();//1>2
                flag=true;

                if(flag && input>limit ||input<1) // true && 0>2 || 0<1
                {
                    System.out.println("Choose the number between 1 to "+limit);
                    flag=false;
                }
            }
            catch (Exception e)
            {
                System.out.println("Enter only integer value ");
                flag=false;
            }
        }
        return input;
    }
    public static void main(String[] args)
    {
        System.out.println("\n****Welcome to MyBank  Atm Interface *****");
        System.out.println("1.Register \n2.Exit");
        System.out.println("Choose one option : ");
        int choose=takeninteger(2);
        //Scanner sc=new Scanner(System.in);
        if(choose==1)
        {
           BankAccount b=new BankAccount();
           b.register();
           while (true)
           {
               System.out.println("1.Login \n2.Exit");
               System.out.println("Choose one option : ");
               int ch=takeninteger(2);
               if(ch==1)
               {
                   if (b.login())
                   {
                       System.out.println("\n*****   Welcome Back <<<----- " + b.name + " -------->");
                       boolean isfinised = false;
                       while (!isfinised)
                       {
                           System.out.println("1.Withdraw \n2.Deposite \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
                           System.out.println("Choose one option : ");
                           int c = takeninteger(6);
                           //Scanner sc=new Scanner(System.in);
                           //char chh =sc.next().charAt(0);
                            //do
                            //{
                                switch (c)
                                {
                                    case 1:
                                        b.withdraw();
                                        break;
                                    case 2:
                                        b.deposite();
                                        break;
                                    case 3:
                                        b.transfer();
                                        break;
                                    case 4:
                                        b.checkBalance();
                                        break;
                                    case 5:
                                        b.transHistory();
                                        break;
                                    case 6:
                                        isfinised = true;
                                        break;
                                }
                                //System.out.println("Do You Want to Continue");

                            //}
                            //while (chh=='Y'&& chh=='N');
                       }
                   }
               }
               else
               {
                    System.exit(0);
               }
           }
        }
        else
        {
            System.exit(0);
        }
    }
}