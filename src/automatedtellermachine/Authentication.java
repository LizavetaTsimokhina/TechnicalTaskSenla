package automatedtellermachine;

import java.util.HashMap;
import java.util.Map;

public class Authentication extends Database {
    protected static User user;

    public Authentication(HashMap<String, String> listOfClients, User user) {
        super(listOfClients);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static void authenticateUser() {
        Database.addList();
        verifyIdCard();
    }

    public static void verifyIdCard() {
        for (int i = 0; ; i++) {
            System.out.println("To enter your idCard:");
            String idCard = InputData.InputString();
            if (!idCard.matches("^\\d{4}-\\d{4}-\\d{4}-\\d{4}$")) {
                try (MyAutoCloseable m = new MyAutoCloseable()) {
                    throw new IdCardExceptionContent("Your idCard should contain 16 numbers" +
                            "and look like 1111-1111-1111-1111");
                } catch (IdCardExceptionContent e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (idCard.matches("^\\d{4}-\\d{4}-\\d{4}-\\d{4}$")) {
                System.out.println("To enter your pinCode:");
                String pinCode = InputData.InputString();
                Map<String, String> intry = new HashMap<>();
                intry.put(idCard, pinCode);
                for (Map.Entry entry : getListOfClients().entrySet()) {
                    user = new User(idCard, pinCode, 1000);
                    String dataUser = user.toString();
                    FileData.writeFile(dataUser);
                    if (true == idCard.equals(entry.getKey())) {
                        if (true == pinCode.equals(entry.getValue())) {
                            System.out.println("You are authenticated.");
                            AutomatedTellerMachine.getOperation();
                        } else {
                            System.out.println("This pinCode don't valid.");
                            for (int j = 0; j < 3; j++) {
                                if (j == 2) {
                                    System.out.println("Your card with number " + idCard + " is blocked.");
                                    new BlockedCard(idCard).start();
                                    MainMenu.getMainMenu();
                                    break;
                                } else {
                                    System.out.println("To enter your pinCode:");
                                    String pinCodeNew = InputData.InputString();
                                    intry.put(idCard, pinCodeNew);
                                    if (pinCodeNew == entry.getValue()) {
                                        System.out.println("You are authenticated.");
                                        AutomatedTellerMachine.getOperation();
                                    } else {
                                        System.out.println("Your pinCode don't valid.");
                                    }
                                }
                            }
                            break;
                        }
                    } else {
                        System.out.println("User with this idCard don't have.");
                    }
                }
            }
        }
    }
}