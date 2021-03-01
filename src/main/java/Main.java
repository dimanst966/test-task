public class Main {

    public static void main(String[] args) {
        Bank.Banker banker = new Bank.Banker();
        Bank bank = banker.createBank();

        Bank.Account account = bank.new Account("1", "dima", 1500);

        account.open();

        account.close();
    }


}
