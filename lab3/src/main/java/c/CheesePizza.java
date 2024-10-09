package c;

public class CheesePizza implements PizzaInterface {
    @Override
    public void prepare() {
        System.out.println("Preparing cheese pizza");
    }
    
    @Override
    public void bake() {
        System.out.println("Baking cheese pizza");
    }
    
    @Override
    public void cut() {
        System.out.println("Cutting cheese pizza");
    }
    
    @Override
    public void box() {
        System.out.println("Boxing cheese pizza");
    }
}
