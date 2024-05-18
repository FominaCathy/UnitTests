package FominaKat.second.vehicle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

public class VehicleTest {

    @Test
    @DisplayName("проверка, что экземпляр объекта Car также является экземпляром транспортного средства")
    void checkClassCar() {
        Car car = new Car("BMV", "x5", 1995);
        assertTrue(car instanceof Vehicle);
    }

    @Test
    @DisplayName("проверка, что объект Car создается с 4-мя колесами")
    void checkNumWheelsCar() {
        Car car = new Car("BMV", "x5", 1995);
        assertEquals(4, car.getNumWheels());
    }

    @Test
    @DisplayName("проверка что объект Motorcycle создается с 2-мя колесами")
    void checkNumWheelsMotorcycle() {
        Motorcycle motorcycle = new Motorcycle("Yamaha", "FJR1300", 2015);
        assertEquals(2, motorcycle.getNumWheels());

    }

    @Test
    @DisplayName("проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())")
    void checkSpeedCar() {
        Car car = new Car("BMV", "x5", 1995);
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }

    @Test
    @DisplayName("проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())")
    void checkSpeedMotorcycle() {
        Motorcycle motorcycle = new Motorcycle("Yamaha", "FJR1300", 2015);
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
    }

    //проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
    @Test
    @DisplayName("Проверка, что в режиме парковки машина останавливается")
    void checkParkCar() {
        Car car = new Car("BMV", "x5", 1995);
        car.testDrive();
        car.park();
        assertEquals(0, car.getSpeed());
    }

    @Test
    @DisplayName("Проверка, что в режиме парковки мотоцикл останавливается")
    void checkParkMotorcycle() {
        Motorcycle motorcycle = new Motorcycle("Yamaha", "FJR1300", 2015);
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed());
    }

}
