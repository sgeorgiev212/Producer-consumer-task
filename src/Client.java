public class Client extends Thread{

    private String name;
    private Shop shop;

    public Client(String name,Shop shop) {
        this.name = name;
        this.shop = shop;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                sleep(2000);
                this.shop.buyProduct();
                System.out.println(this.name+" bought something from the store");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
