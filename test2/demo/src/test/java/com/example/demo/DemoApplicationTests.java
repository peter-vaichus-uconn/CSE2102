import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class DemoApplicationTests {
	@Test
	void contextLoads() {
	}
	@Test /* ADDED */
	void notEqualTest() {
		int expected = 5;
		int actual = 3+2;
		Assertions.assertNotEquals(expected, actual+1); /* ADDED */
	}
}
