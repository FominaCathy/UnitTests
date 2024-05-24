package FominaKat.second.vehicle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * c). Написать следующие тесты:
 * - проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
 * - проверка того, объект Car создается с 4-мя колесами
 * - проверка того, объект Motorcycle создается с 2-мя колесами
 * - проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
 * - проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
 * - проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
 * - проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
 */

/**
 * Класс содержит  тесты для Мотоциклов из задания
 */
public class MotorcycleTest {
    Motorcycle motorcycle;

    @BeforeEach
    void initMoto() {
        motorcycle = new Motorcycle("Yamaha", "FJR1300", 2015);
    }

    @Test
    @DisplayName("проверка что объект Motorcycle создается с 2-мя колесами")
    void checkNumWheelsMotorcycle() {
        assertEquals(2, motorcycle.getNumWheels());
    }


    @Test
    @DisplayName("проверка того, что Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())")
    void checkSpeedMotorcycle() {
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
    }

    @Test
    @DisplayName("Проверка, что в режиме парковки мотоцикл останавливается")
    void checkParkMotorcycle() {
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed());
    }
}
