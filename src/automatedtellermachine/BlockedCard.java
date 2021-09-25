package automatedtellermachine;

public class BlockedCard extends Thread {
    private String idCard;

    public BlockedCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(86400000);
            throw new BlockedCardException("Card is blocked. The card will be unlocked automatically after 1 day.");
        } catch (BlockedCardException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            MainMenu.getMainMenu();
        }
    }
}
