package automatedtellermachine;

import java.util.Scanner;

public class InputData {
    public static String InputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int InputNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();

    }
}
