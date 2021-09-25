package automatedtellermachine;

public class User {
    private String idCard;
    private String pinCode;
    private int balance;

    public User(String idCard, String pinCode, int balance) {
        this.idCard = idCard;
        this.pinCode = pinCode;
        this.balance = balance;
    }

    public User() {
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return idCard +
                " " + pinCode +
                " " + balance;
    }

}

