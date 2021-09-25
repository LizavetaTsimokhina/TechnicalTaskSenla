package automatedtellermachine;

public class Menu {
    public static int getMenu() {
        System.out.println("To select one of the proposed operations, enter the number:");
        System.out.println("1 - Check card balance");
        System.out.println("2 - Withdraw cash");
        System.out.println("3 - Replenish card balance");
        System.out.println("0 - Finish work and return card");
        System.out.println("Enter the number of the selected operation:");
        return InputData.InputNumber();
    }

}
