package u;

import static org.junit.Assert.*;

import org.junit.Test;
import c.PizzaFactory;
import c.CheesePizza;
import c.PizzaInterface;

public class PizzaFactoryTest {

    // verify the behavior of a PizzaFactory when creating a "cheese" pizza
    @Test
    public void testCreateCheesePizza() {
        PizzaFactory factory = new PizzaFactory();
        PizzaInterface pizza = factory.createPizza("cheese");

        assertNotNull("Pizza should not be null", pizza);
        assertTrue("Pizza should be an instance of CheesePizza", pizza instanceof CheesePizza);
    }

    // test invalid pizza input
    @Test
    public void testCreateInvalidPizza() {
        PizzaFactory factory = new PizzaFactory();

        PizzaInterface pizza = factory.createPizza("hawaiian");
        assertNull("Pizza should be null for invalid type", pizza);
    }

    // test case insensitivity
    @Test
    public void testCreatePizzaCaseInsensitive() {
        PizzaFactory factory = new PizzaFactory();
        PizzaInterface pizza = factory.createPizza("CheEsE");

        assertNotNull("Pizza should not be null for case-insensitive input", pizza);
        assertTrue("Pizza should be an instance of CheesePizza", pizza instanceof CheesePizza);
    }

    // test null input
    @Test
    public void testCreatePizzaWithNullInput() {
        PizzaFactory factory = new PizzaFactory();
        PizzaInterface pizza = factory.createPizza(null);

        assertNull("Pizza should be null for null input", pizza);
    }
}
