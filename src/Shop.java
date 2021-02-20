import java.util.ArrayList;
import java.util.Random;

public class Shop {

    private static final int MAX_PRODUCTS = 14;
    private ArrayList<Product> products;

    public Shop() {
        this.products = new ArrayList<>();
    }

    public synchronized void  addProduct(Product product){
        while(this.products.size()>=MAX_PRODUCTS){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.products.add(product);
        notifyAll();
    }

    public synchronized void buyProduct(){
        while (this.products.size()<=0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Product pr = this.products.get(new Random().nextInt(this.products.size()));
        this.products.remove(pr);
        notifyAll();
    }

}
