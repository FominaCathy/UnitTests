package FominaKat.first.Calculator;


import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    public static void main(String[] args) {
        positiveTest();
        negativeTest();
    }

    /**
     * позитивные проверки
     */
    private static void positiveTest() {
        assertThat(Calculator.calculateDiscount(100, 10)).isEqualTo(90);
    }

    /**
     * негативные проверки (проверка на исключение ArithmeticException.)
     */
    private static void negativeTest() {
        assertThatThrownBy(() ->
                Calculator.calculateDiscount(0, 10)).isInstanceOf(ArithmeticException.class);

        assertThatThrownBy(() ->
                Calculator.calculateDiscount(-1, 10)).isInstanceOf(ArithmeticException.class);

        assertThatThrownBy(() ->
                Calculator.calculateDiscount(100, 0)).isInstanceOf(ArithmeticException.class);

        assertThatThrownBy(() ->
                Calculator.calculateDiscount(100, -1)).isInstanceOf(ArithmeticException.class);

        assertThatThrownBy(() ->
                Calculator.calculateDiscount(100, 100)).isInstanceOf(ArithmeticException.class);
    }
}