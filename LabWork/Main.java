import java.io.*;
import java.util.Scanner;

abstract class Account {

    private final String name;
    protected long balance, maxCredit, credit;

    public Account(String x1, String x2, String x3, String x4){
        this.name = x1;
        this.balance = (long)Integer.parseInt(x2);
        this.maxCredit = (long)Integer.parseInt(x3);
        this.credit = (long)Integer.parseInt(x4);
    }

    public String getName() {
        return this.name;
    }

    public long getBalance() {
        return this.balance;
    }

    public long getMaxCredit() {
        return this.maxCredit;
    }

    public long getCredit() {
        return this.credit;
    }

    public void addMoney(long amount) {
        this.balance += amount;
    }

    public void getMoney(long x) {}

    public void doCredit(long x) {}

    public void lowerCredit(long x) {}
}

class CheckingAccount extends Account {
    public CheckingAccount(String x1, String x2, String x3, String x4) {
        super(x1, x2, x3, x4);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public long getBalance() {
        return super.getBalance();
    }

    @Override
    public long getMaxCredit() {
        return super.getMaxCredit();
    }

    @Override
    public long getCredit() {
        return super.getCredit();
    }

    @Override
    public void addMoney(long amount) {
        super.addMoney(amount);
    }

    @Override
    public void getMoney(long amount){
        if(this.balance > amount){
            this.balance += -amount;
            System.out.println("Підтверджено.");
        }
        else {
            System.out.println("Недостатньо коштів на рахунку.");
        }
    }
    @Override
    public void doCredit(long amount) {
        if( this.maxCredit > this.credit + amount){
            this.balance = this.balance + amount;
            this.credit = this.credit + amount;
            System.out.println("Ваш запит підтверджено, кредит поступить на рахунок.");
        }
        else {
            System.out.println("Ваш кредит.");
        }

    }
    @Override
    public void lowerCredit(long amount) {
        if( this.balance > this.credit){
            this.balance = this.balance - amount;
            this.credit = this.credit - amount;
            if (amount == this.credit){
                System.out.println("Кредит анульвано.");
            }
            else {
                System.out.println("Ваш кредит зменшено.");
            }
        }
        else {
            System.out.println("Запит відхилено, недостатньо коштів на балансі.");
        }

    }

}


class SavingsAccount extends Account {
    public SavingsAccount(String x1, String x2, String x3, String x4) {
        super(x1, x2, x3, x4);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public long getBalance() {
        return super.getBalance();
    }

    @Override
    public long getMaxCredit() {
        return super.getMaxCredit();
    }

    @Override
    public long getCredit() {
        return super.getCredit();
    }

    @Override
    public void addMoney(long amount) {
        super.addMoney(amount);
    }

    @Override
    public void getMoney(long amount){
        if(this.balance > amount){
            this.balance += -(amount * 1.005);
            System.out.println("Підтверджено.");
        }
        else {
            System.out.println("Недостатньо коштів на рахунку.");
        }
    }
    @Override
    public void doCredit(long amount) {
        if( this.maxCredit > this.credit + amount){
            this.balance = this.balance + amount;
            this.credit = (long) (this.credit + (amount * 1.005));
            System.out.println("Ваш запит підтверджено, кредит поступить на рахунок.");
        }
        else {
            System.out.println("Ваш кредит.");
        }

    }
    @Override
    public void lowerCredit(long amount) {
        if( this.balance > this.credit){
            this.balance = this.balance - amount;
            this.credit = this.credit - amount;
            if (amount == this.credit){
                System.out.println("Кредит анульвано.");
            }
            else {
                System.out.println("Ваш кредит зменшено.");
            }
        }
        else {
            System.out.println("Запит відхилено, недостатньо коштів на балансі.");
        }

    }

}


class BusinessAccount extends Account{
    public BusinessAccount(String x1, String x2, String x3, String x4) {
        super(x1, x2, x3, x4);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public long getBalance() {
        return super.getBalance();
    }

    @Override
    public long getMaxCredit() {
        return super.getMaxCredit();
    }

    @Override
    public long getCredit() {
        return super.getCredit();
    }

    @Override
    public void addMoney(long amount) {
        super.addMoney(amount);
    }

    @Override
    public void getMoney(long amount){
        if(this.balance > amount){
            this.balance += -amount;
            System.out.println("Підтверджено.");
        }
        else {
            System.out.println("Недостатньо коштів на рахунку.");
        }
    }
    @Override
    public void doCredit(long amount) {
        if( this.maxCredit * 10 > this.credit + amount){
            this.balance = this.balance + amount;
            this.credit = (long) (this.credit + amount * 1.001);
            System.out.println("Ваш запит підтверджено, кредит поступить на рахунок.");
        }
        else {
            System.out.println("Ваш кредит.");
        }

    }
    @Override
    public void lowerCredit(long amount) {
        if( this.balance > this.credit){
            this.balance = (long) (this.balance - amount / 1.0001);
            this.credit = this.credit - amount;
            if (amount == this.credit){
                System.out.println("Кредит анульвано.");
            }
            else {
                System.out.println("Ваш кредит зменшено.");
            }
        }
        else {
            System.out.println("Запит відхилено, недостатньо коштів на балансі.");
        }

    }


}



public class Main {
    static Scanner in = new Scanner(System.in);


    public static void startATM() {
        System.out.println("Вас вітає банкомат ...");
        System.out.println("Для вибору аккаунта натисніть (1), якщо хочете завершити роботу натисніть (2)");
        if (1 == in.nextInt()){
            Main.chooseAccount();
        }
        else if (2 == in.nextInt()) {
            System.out.println("До побачення!");
        }
    }

    public static void chooseAccount() {
        System.out.println("Будь ласка, введіть назву аккаунту.");
        String a = in.next();
        Account workInstance = null;
        int q = 0;
        try {

            FileReader fr = new FileReader("C:\\Java\\projects\\LabWork\\src\\Data.txt");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String[] arr = line.split(" ");
                if (a.equals(arr[0])) {
                    if (arr[4].equals("Checking")) {
                        workInstance = new CheckingAccount(arr[0], arr[1], arr[2], arr[3]);
                        q++;
                        break;
                    }
                }
                if (a.equals(arr[0])) {
                    if (arr[4].equals("Savings")) {
                        workInstance = new SavingsAccount(arr[0], arr[1], arr[2], arr[3]);
                        q++;
                        break;
                    }
                }
                if (a.equals(arr[0])) {
                    if (arr[4].equals("Business")) {
                        workInstance = new BusinessAccount(arr[0], arr[1], arr[2], arr[3]);
                        q++;
                        break;
                    }
                }
                line = reader.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();

        }
        if (q == 1) {
            System.out.println("Вхід виконано.");
            int clock = 1;
            while (clock != 0) {
                System.out.println("Для перегляду рахунку натисніть (1), для внесення коштів (2), зняття (3), кредитування (4), погашення кредиту(5), повтор(6), чек(7), до меню (0)");
                if (1 == in.nextInt()) {
                    System.out.format("Name: %s, баланс %d, кредит %d, кредитний ліміт %d \n", workInstance.getName(), workInstance.getBalance(), workInstance.getCredit(), workInstance.getMaxCredit());
                    System.out.println("Для перегляду рахунку натисніть (1), для внесення коштів (2), зняття (3), кредитування (4), погашення кредиту(5), повтор(6), чек(7), до меню (0)");
                }
                if (2 == in.nextInt()) {
                    System.out.println("Ввведіть суму коштів:");
                    workInstance.addMoney(in.nextInt());
                    System.out.println("Для перегляду рахунку натисніть (1), для внесення коштів (2), зняття (3), кредитування (4), погашення кредиту(5), повтор(6), чек(7), до меню (0)");
                }
                if (3 == in.nextInt()) {
                    System.out.println("Ввведіть суму коштів:");
                    workInstance.getMoney(in.nextInt());
                    System.out.println("Для перегляду рахунку натисніть (1), для внесення коштів (2), зняття (3), кредитування (4), погашення кредиту(5), повтор(6), чек(7), до меню (0)");
                }
                if (4 == in.nextInt()) {
                    System.out.println("Ввведіть суму коштів:");
                    workInstance.doCredit(in.nextInt());
                    System.out.println("Для перегляду рахунку натисніть (1), для внесення коштів (2), зняття (3), кредитування (4), погашення кредиту(5), повтор(6), чек(7), до меню (0)");
                }
                if (5 == in.nextInt()) {
                    System.out.println("Ввведіть суму коштів:");
                    workInstance.lowerCredit(in.nextInt());
                    System.out.println("Для перегляду рахунку натисніть (1), для внесення коштів (2), зняття (3), кредитування (4), погашення кредиту(5), повтор(6), чек(7), до меню (0)");
                }
                if (6 == in.nextInt()) {
                    System.out.println("Повтор.");
                    startATM();
                    System.out.println("Для перегляду рахунку натисніть (1), для внесення коштів (2), зняття (3), кредитування (4), погашення кредиту(5), повтор(6), чек(7), до меню (0)");
                }
                if (7 == in.nextInt()) {
                    try(FileWriter writer = new FileWriter("C:\\Java\\projects\\LabWork\\src\\Out.txt", false)) {
                        String text = "Operation finished";
                        writer.write(text);
                        writer.append('\n');
                        writer.flush();
                    }
                    catch(IOException ex){

                        System.out.println(ex.getMessage());
                    }
                }
                if (0 == in.nextInt()) {
                    clock = 0;
                    Main.startATM();
                }
            }
        }
    }





    public static void main(String[] args) {

        Main.startATM();


    }
}
