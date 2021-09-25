package automatedtellermachine;

public class MainMenu {

    public static void getMainMenu() {
        System.out.println("To select one of the proposed operations, enter the number:");
        System.out.println("1 - Authenticate user");
        System.out.println("0 - Finish work");
        System.out.println("Test idCard is 1234-2345-3456-4567. Test pinCode is 123456789.");
        int choice = InputData.InputNumber();
        if (choice == 1) {
            Authentication.authenticateUser();
        } else if (choice == 0) {
            System.exit(0);
        }
    }
}
