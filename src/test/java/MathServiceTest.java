

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MathServiceTest {

    private final MathService mathService = new MathService();

    @ParameterizedTest
    @CsvSource({
            "1, -3, 2, 1.0, 2.0", // Пример где два реальных корня
            "1, -2, 1, 1.0, 1.0", // Пример где один корень (дискриминант равен 0)

    })
    void testGetAnswerWithValidInputs(int a, int b, int c, Double expectedFirst, Double expectedSecond) throws NotFoundAnswerException {
        Pair result = mathService.getAnswer(a, b, c);
        assertEquals(expectedFirst, result.first);
        assertEquals(expectedSecond, result.second);
    }

    @Test
    void testGetAnswerWithNegativeDiscriminant() {
        assertThrows(NotFoundAnswerException.class, () -> mathService.getAnswer(1, 2, 3));
    }
}
