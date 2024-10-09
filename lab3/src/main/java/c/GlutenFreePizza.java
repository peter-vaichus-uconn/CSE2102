package c;

public class GlutenFreePizza implements PizzaInterface {
    @Override
    public void prepare() {
        System.out.println("Preparing GF pizza");
    }
    
    @Override
    public void bake() {
        System.out.println("Baking GF pizza");
    }
    
    @Override
    public void cut() {
        System.out.println("Cutting GF pizza");
    }
    
    @Override
    public void box() {
        System.out.println("Boxing GF pizza");
    }
}
