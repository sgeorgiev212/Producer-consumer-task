public class DeliveryGuy extends Thread{

    private String name;
    private Shop shop;

    public DeliveryGuy(String name,Shop shop) {
        this.name = name;
        this.shop = shop;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            Product product = new Product("product"+i);
            this.shop.addProduct(product);
            System.out.println(this.name+" added "+product+" to the store");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
