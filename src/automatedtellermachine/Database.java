package automatedtellermachine;

import java.util.HashMap;

public class Database {
    private static HashMap<String, String> listOfClients = new HashMap<>();

    public Database(HashMap<String, String> listOfClients) {
        this.listOfClients = listOfClients;
    }

    public static HashMap<String, String> getListOfClients() {
        return listOfClients;
    }

    public static void setListOfClients(HashMap<String, String> listOfClients) {
        Database.listOfClients = listOfClients;
    }

    public static void addList() {
        listOfClients.put("1234-2345-3456-4567", "123456789");
        listOfClients.put("1235-2345-3456-4567", "123456788");
        listOfClients.put("1236-2345-3456-4567", "123456787");
        listOfClients.put("1237-2345-3456-4567", "123456786");
        listOfClients.put("1238-2345-3456-4567", "123456785");
        listOfClients.put("1239-2345-3456-4567", "123456784");
        listOfClients.put("1231-2345-3456-4567", "123456783");
    }

    @Override
    public String toString() {
        return "Database{" +
                "listOfClients=" + listOfClients +
                '}';
    }
}
