import java.util.Scanner;
class Account{
    private String accountholder;
    private String accountnumber;
    private double balance;
    int trans;
    public   Account(String accountholder, String accountnumber){
        this.accountholder=accountholder;
        this.accountnumber=accountnumber;
        this.balance=0;
        this.trans=1000;
    }
    public void CheckBalance(){
        System.out.println("Available balance: LE."+balance);
    }
    public void Deposit(double now){
        balance+=now;
        System.out.println("current balance is: "+balance);
    }
    public void AccountDetail(){
        System.out.println("----------ACCOUNT DETAIL----------");
        System.out.println("Account Holder:"+accountholder);
        System.out.println("Account Number:"+accountnumber);
        System.out.println("Available balance: LE."+balance);
    }
    public void TransExit(){
        System.out.println("printing receipt..............");
        System.out.println("******************************************");
        System.out.println("Transaction is now complete.");
        System.out.println("Transaction number:"+(trans++));
        System.out.println("Account Holder:"+accountholder);
        System.out.println("Account Number:"+accountnumber);
        System.out.println("Available balance: LE."+balance);
        System.out.println("Thanks for choosing us as your bank");
        System.out.println("****************************************");
    }
    public void Withdraw(double now){
        if(now>balance){
            System.out.println("sorry your balance dont support this operation");
        }
        else{
            balance-=now;
            System.out.println("LE. " + now );
            System.out.println("current account balance:  " + balance);
        }
    }
}
class TaskSh {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.println("*******WELCOME TO BANK OF HSBC*******");
        System.out.println("__________________________________________________________");
        System.out.println("----------ACCOUNT CREATION----------");
        System.out.println("Enter Account Name: ");
        String Name=input.nextLine();
        System.out.println("Enter Account Number: ");
        String Number=input.nextLine();
        Account account=new Account(Name,Number);
        System.out.println("Congratulations! Account created successfully......");
        System.out.println("Do you want to do any transactions?(y/n):");
        String choice =input.nextLine();
        while (choice.equalsIgnoreCase("y")) {
            System.out.println("TRANSACTION \n"+
            "*********************\n"+
            "Menu:\n"+
            "1. Account Detail\n"+
            "2. Check Balance\n"+
            "3. Deposit\n"+
            "4. Withdraw\n"+
            "5. Exit\n"+
            "*********************\n");
            System.out.println("Enter 1, 2, 3, 4 or 5: ");
            double currentDeposit,currentWithdraw;
            int c=input.nextInt();
            switch(c){
                case 1:
                    account.AccountDetail();
                    break;
                case 2:
                    account.CheckBalance();
                    break;
                case 3:
                    System.out.print("How much you want to Deposit : ");
                    currentDeposit=input.nextDouble();
                    account.Deposit(currentDeposit);
                    break;
                case 4:
                    System.out.print("How much you want to Withdraw: ");
                    currentWithdraw=input.nextDouble();
                    account.Withdraw(currentWithdraw);
                    break;
                case 5:
                    account.TransExit();
                    System.exit(0);
                    break;
            }
        }
        input.close();
        }
    }
