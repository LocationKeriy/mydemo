import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение, разделяя каждый символ пробелом");
        String text = scanner.nextLine();
        String[] array = text.split(" ");
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] number1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        if (array.length > 4) {
            for (int i = 0; i < 10; i++) {
                if (roman[i].equals(array[4]) || number1[i].equals(array[4])) {
                    System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    return;
                }
            }
        }
        if (array.length != 3) {
            System.out.println("Строка не является математической операцией");
            return;
        }
        try {
            int a = 0, b = 0, c;
            for (int i = 0; i < 10; i++) {
                if (roman[i].equals(array[0])) {
                    a = number[i];
                        for (int d = 0; d < 10; d++) {
                            if (number1[d].equals(array[2])) {
                                System.out.println("Используются одновременно разные системы счисления");
                                return;
                            }
                        }
                }
            }
            for (int i = 0; i < 10; i++) {
                if (roman[i].equals(array[2])) {
                    b = number[i];
                        for (int d = 0; d < 10; d++) {
                            if (number1[d].equals(array[0])) {
                                System.out.println("Используются одновременно разные системы счисления");
                                return;
                            }
                        }
                }
            }
            if (array[1].contains("+")) {
                c = a + b;
                String[] result = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"};
                String numeral = result[--c];
                System.out.println("Ответ: " + numeral);
                return;
            }
            if (array[1].contains("/")) {
                c = a / b;
                String[] result = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"};
                String numeral = result[--c];
                System.out.println("Ответ: " + numeral);
                return;
            }
            for (int i = 0; i < 10; i++) {
                if (array[1].contains("-") && (array[0].equals(roman[i]) || array[2].equals(roman[i]))) {
                    System.out.println("В римской системе нет отрицательных чисел");
                    return;
                }
            }
        } catch (NumberFormatException | ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.print("");
        }
        try {
            int a = Integer.parseInt(array[0]), b = Integer.parseInt(array[2]), c;
            if ((a > 10 || a <= 0) || (b > 10 || b <= 0)) {
                System.out.println("Числа не должны быть больше 10 и быть равными (меньше) 0");
                return;
            }
            if (array[1].contains("+")) {
                c = a + b;
                System.out.println("Ответ: " + c);
            } else if (array[1].contains("-")) {
                c = a - b;
                System.out.println("Ответ: " + c);
            } else if (array[1].contains("/")) {
                c = a / b;
                System.out.println("Ответ: " + c);
            } else if (array[1].contains("*")) {
                c = a * b;
                System.out.println("Ответ: " + c);
            }
        } catch (NumberFormatException e) {
            System.out.println("Некорректное выражение");
        }
    }
}