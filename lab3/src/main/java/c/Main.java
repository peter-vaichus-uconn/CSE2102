package c;

public class Main {
    public static void main(String[] args) {
        PizzaFactory factory = new PizzaFactory();
        PizzaStore store = new PizzaStore(factory);

        store.orderPizza("cheese");
        store.orderPizza("pepperoni");
        store.orderPizza("greek");
        store.orderPizza("gluten free");
    }
}