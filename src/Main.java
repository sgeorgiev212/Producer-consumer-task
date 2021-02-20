public class Main {

    public static void main(String[] args) {
        Shop shop = new Shop();
        DeliveryGuy deliveryGuy = new DeliveryGuy("pepsi",shop);
        Client client = new Client("ivan",shop);

        deliveryGuy.start();
        client.start();
        long start = System.currentTimeMillis();
        try {
            deliveryGuy.join();
            client.join();
            long end = System.currentTimeMillis();
            System.out.println("the whole process took "+(end-start)+" seconds");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
