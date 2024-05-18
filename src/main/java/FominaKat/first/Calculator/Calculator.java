package FominaKat.first.Calculator;

public class Calculator {
    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    /**
     * Метод принимает сумму покупки и процент скидки и возвращает сумму с учетом скидки.
     * @param summ сумма покупки
     * @param discount скидка от 0 до 100, не включая граицы
     * @return сумма со скидкой
     */
    public static int calculateDiscount(int summ, int discount) {

        if (summ <= 0) {
            throw new ArithmeticException("сумма покпки меньше либо равна нулю");
        }

        if (discount <= 0 || discount >= 100) {
            throw new ArithmeticException("недопустимое значение скидки (скидка должна быть больше нуля и меньше 100");
        }
        return summ / 100 * (100 - discount);
    }

    ;


}