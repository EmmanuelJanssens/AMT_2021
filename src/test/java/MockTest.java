import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MockTest {

    int testingNumber;

    @BeforeEach
    void setup(){
        testingNumber = 1;
    }

    @Test
    @DisplayName("mock test")
    void test(){
        //testingNumber++;
        Assertions.assertEquals(2 ,testingNumber);
    }

}
