package c;

public class PizzaFactory {
    public PizzaInterface createPizza(String type) {
        // Check for null input first
        if (type == null) {
            return null; // Return null if input is null
        }

        if (type.equalsIgnoreCase("cheese")) {
            return new CheesePizza();
        } else if (type.equalsIgnoreCase("pepperoni")) {
            return new PepperoniPizza();
        } else if (type.equalsIgnoreCase("greek")) {
            return new GreekPizza();
        } else if (type.equalsIgnoreCase("gluten free")) {
            return new GlutenFreePizza();
        } else {
            return null; // Return null for any other invalid types
        }
    }
}
