package automatedtellermachine;

public class AutomatedTellerMachine extends User implements Balance, Replenishment, WithdrawalCash {

    public AutomatedTellerMachine(String idCard, String pinCode, int balance) {
        super(idCard, pinCode, balance);
    }

    public AutomatedTellerMachine() {
    }

    @Override
    public void getBalanceConsole() {
        System.out.println("Your card cash is " + Authentication.user.getBalance());
    }

    @Override
    public void replenish() {
        System.out.println("Enter the amount of replenishment of the card account:");
        int replenishment = InputData.InputNumber();
        if (replenishment < 1000000) {
            int balance = Authentication.user.getBalance();
            balance += replenishment;
            Authentication.user.setBalance(balance);
        } else {
            System.out.println("The amount of replenishment of the card account should not exceed 1000000.");
        }
    }

    @Override
    public void withdraw() {
        System.out.println("Enter the amount of cash to withdraw:");
        int cash = InputData.InputNumber();
        int balance = Authentication.user.getBalance();
        int limit = 9000000;
        if (cash <= balance && cash < limit) {
            balance -= cash;
            Authentication.user.setBalance(balance);
        } else {
            System.out.println("The amount of cash to withdraw should not exceed 9000000 " +
                    "or insufficient funds in the account. ");
        }
    }

    public static void getOperation() {
        for (int i = 0; ; i++) {
            int choice = Menu.getMenu();
            switch (choice) {
                case 1:
                    AutomatedTellerMachine choice1 = new AutomatedTellerMachine();
                    choice1.getBalanceConsole();
                    break;
                case 2:
                    AutomatedTellerMachine choice2 = new AutomatedTellerMachine();
                    choice2.withdraw();
                    break;
                case 3:
                    AutomatedTellerMachine choice3 = new AutomatedTellerMachine();
                    choice3.replenish();
                    break;
                case 0:
                    String changeUser = Authentication.user.toString();
                    FileData.writeFile(changeUser);
                    System.out.println("Your card is returned.");
                    System.exit(0);
                    break;
                default:
                    try (MyAutoCloseable myAutoCloseable = new MyAutoCloseable()) {
                        throw new IllegalStateException("Unexpected value: " + choice);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }
    }
}


