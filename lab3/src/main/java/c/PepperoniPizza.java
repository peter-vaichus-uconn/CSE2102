package c;

public class PepperoniPizza implements PizzaInterface {
    @Override
    public void prepare() {
        System.out.println("Preparing pepperoni pizza");
    }
    
    @Override
    public void bake() {
        System.out.println("Baking pepperoni pizza");
    }
    
    @Override
    public void cut() {
        System.out.println("Cutting pepperoni pizza");
    }
    
    @Override
    public void box() {
        System.out.println("Boxing pepperoni pizza");
    }
}
