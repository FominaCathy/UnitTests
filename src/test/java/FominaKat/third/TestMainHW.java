package FominaKat.third;


import FominaKat.third.hw.MainHW;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMainHW {

    static MainHW service;

    @BeforeAll
    static void init() {
        service = new MainHW();
    }

    @ParameterizedTest(name = "{index} - проверка четности числа {0}")
    @DisplayName("Проверка четности")
    @ValueSource(ints = {-2, 0, 6})
    void evenNumberTest(int number) {
        assertTrue(service.evenOddNumber(number));
    }

    @ParameterizedTest(name = "{index} - проверка нечетности числа {0}")
    @DisplayName("Проверка нечетности")
    @ValueSource(ints = {-1, 3})
    void oddNumberTest(int number) {
        assertFalse(service.evenOddNumber(number));
    }

    @ParameterizedTest(name = "{index} - проверка вхождения в интервал (25, 100) числа {0}")
    @DisplayName("Проверка вхождения числа в интервал (25, 100)")
    @ValueSource(ints = {26, 50, 99})
    void numberInIntervalTest(int number) {
        assertTrue(service.numberInInterval(number));
    }

    @ParameterizedTest(name = "{index} - проверка НЕ вхождения в интервал (25, 100) числа {0}")
    @DisplayName("Проверка НЕ вхождения числа в интервал (25, 100)")
    @ValueSource(ints = {24, 25, 100, 101})
    void numberNotIntervalTest(int number) {
        assertFalse(service.numberInInterval(number));
    }

}
