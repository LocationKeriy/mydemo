import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Калькулятор арифметических выражений между двумя числами");
        System.out.println("Пожалуйста, используйте пробел между символами");
        System.out.print("Введите выражение: ");
        System.out.println("Ответ: " + calc(scanner.nextLine()));
    }
    public static String calc(String input) {
        String[] result = input.split(" ", 3);
        try {
            if (Integer.parseInt(result[0]) <= 0 || Integer.parseInt(result[2]) > 10) {
                System.out.println("Числа должны быть в пределах (0...10)");
                System.exit(0);
            } else if (Integer.parseInt(result[2]) <= 0 || Integer.parseInt(result[0]) > 10) {
                System.out.println("Числа должны быть в пределах (0...10)");
                System.exit(0);
            }
            switch (result[1]) {
                case "+" -> {
                    return String.valueOf(Integer.parseInt(result[0]) + Integer.parseInt(result[2]));
                }
                case "-" -> {
                    return String.valueOf(Integer.parseInt(result[0]) - Integer.parseInt(result[2]));
                }
                case "/" -> {
                    return String.valueOf(Integer.parseInt(result[0]) / Integer.parseInt(result[2]));
                }
                case "*" -> {
                    return String.valueOf(Integer.parseInt(result[0]) * Integer.parseInt(result[2]));
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Некорректное выражение");
            System.exit(0);
        } catch (NumberFormatException e) {
            try {
                int a = ConvertToRoman.convert(result[0]), b = ConvertToRoman.convert(result[2]), c = 0;
                if (a > 0 && b > 0) {
                    if (a > 10 || b > 10) {
                        System.out.println("Числа должны быть в пределах (0...10)");
                        System.exit(0);
                    }
                    switch (result[1]) {
                        case "+" -> c = a + b;
                        case "-" -> {
                            c = a - b;
                            if (c < 0) {
                                System.out.println("В римской системе нет отрицательных чисел");
                                System.exit(0);
                            } else if (c == 0) {
                                System.out.println("В римской системе нет 0");
                                System.exit(0);
                            }
                        }
                        case "/" -> c = a / b;
                        case "*" -> c = a * b;
                    }
                    String convert = Integer.toString(c);
                    return ConvertToArab.convert(convert);
                } else if (a > 0 || b > 0) {
                    System.out.println("Некорректное выражение");
                    System.exit(0);
                }
            } catch (ArrayIndexOutOfBoundsException e1) {
                System.out.println("Некорректное выражение");
                System.exit(0);
            }
        }
        System.out.println("Некорректное выражение");
        System.exit(0);
        return input;
    }
}
class ConvertToRoman {
    public static int convert(String a) {
        if (a.equals("I")) return 1; if (a.equals("XXI")) return 21; if (a.equals("XLI")) return 41; if (a.equals("LXI")) return 61; if (a.equals("LXXXI")) return 81;
        if (a.equals("II")) return 2; if (a.equals("XXII")) return 22; if (a.equals("XLII")) return 42; if (a.equals("LXII")) return 62; if (a.equals("LXXXII")) return 82;
        if (a.equals("III")) return 3; if (a.equals("XXIII")) return 23; if (a.equals("XLIII")) return 43; if (a.equals("LXIII")) return 63; if (a.equals("LXXXIII")) return 83;
        if (a.equals("IV")) return 4; if (a.equals("XXIV")) return 24; if (a.equals("XLIV")) return 44; if (a.equals("LXIV")) return 64; if (a.equals("LXXXIV")) return 84;
        if (a.equals("V")) return 5; if (a.equals("XXV")) return 25; if (a.equals("XLV")) return 45; if (a.equals("LXV")) return 65; if (a.equals("LXXXV")) return 85;
        if (a.equals("VI")) return 6; if (a.equals("XXVI")) return 26; if (a.equals("XLVI")) return 46; if (a.equals("LXVI")) return 66; if (a.equals("LXXXVI")) return 86;
        if (a.equals("VII")) return 7; if (a.equals("XXVII")) return 27; if (a.equals("XLVII")) return 47; if (a.equals("LXVII")) return 67; if (a.equals("LXXXVII")) return 87;
        if (a.equals("VIII")) return 8; if (a.equals("XXVIII")) return 28; if (a.equals("XLVIII")) return 48; if (a.equals("LXVIII")) return 68; if (a.equals("LXXXVIII")) return 88;
        if (a.equals("IX")) return 9; if (a.equals("XXIX")) return 29; if (a.equals("IL")) return 49; if (a.equals("ILXX")) return 69; if (a.equals("IXC")) return 89;
        if (a.equals("X")) return 10; if (a.equals("XXX")) return 30; if (a.equals("L")) return 50; if (a.equals("LXX")) return 70; if (a.equals("XC")) return 90;
        if (a.equals("XI")) return 11; if (a.equals("XXXI")) return 31; if (a.equals("LI")) return 51; if (a.equals("LXXI")) return 71; if (a.equals("XCI")) return 91;
        if (a.equals("XII")) return 12; if (a.equals("XXXII")) return 32; if (a.equals("LII")) return 52; if (a.equals("LXXII")) return 72; if (a.equals("XCII")) return 92;
        if (a.equals("XIII")) return 13; if (a.equals("XXXIII")) return 33; if (a.equals("LIII")) return 53; if (a.equals("LXXIII")) return 73; if (a.equals("XCIII")) return 93;
        if (a.equals("XIV")) return 14; if (a.equals("XXXIV")) return 34; if (a.equals("LIV")) return 54; if (a.equals("LXXIV")) return 74; if (a.equals("XCIV")) return 94;
        if (a.equals("XV")) return 15; if (a.equals("XXXV")) return 35; if (a.equals("LV")) return 55; if (a.equals("LXXV")) return 75; if (a.equals("XCV")) return 95;
        if (a.equals("XVI")) return 16; if (a.equals("XXXVI")) return 36; if (a.equals("LVI")) return 56; if (a.equals("LXXVI")) return 76; if (a.equals("XCVI")) return 96;
        if (a.equals("XVII")) return 17; if (a.equals("XXXVII")) return 37; if (a.equals("LVII")) return 57; if (a.equals("LXXVII")) return 77; if (a.equals("XCVII")) return 97;
        if (a.equals("XVIII")) return 18; if (a.equals("XXXVIII")) return 38; if (a.equals("LVIII")) return 58; if (a.equals("LXXVIII")) return 78; if (a.equals("XCVIII")) return 98;
        if (a.equals("XIX")) return 19; if (a.equals("IXL")) return 39; if (a.equals("ILX")) return 59; if (a.equals("ILXXX")) return 79; if (a.equals("IC")) return 99;
        if (a.equals("XX")) return 20; if (a.equals("XL")) return 40; if (a.equals("LX")) return 60; if (a.equals("LXXX")) return 80; if (a.equals("C")) return 100;
        return 0;
    }
}
class ConvertToArab {
    public static String convert(String a) {
        if (a.equals("1")) return "I"; if (a.equals("21")) return "XXI"; if (a.equals("41")) return "XLI"; if (a.equals("61")) return "LXI"; if (a.equals("81")) return "LXXXI";
        if (a.equals("2")) return "II"; if (a.equals("22")) return "XXII"; if (a.equals("42")) return "XLII"; if (a.equals("62")) return "LXII"; if (a.equals("82")) return "LXXXII";
        if (a.equals("3")) return "III"; if (a.equals("23")) return "XXIII"; if (a.equals("43")) return "XLIII"; if (a.equals("63")) return "LXIII"; if (a.equals("83")) return "LXXXIII";
        if (a.equals("4")) return "IV"; if (a.equals("24")) return "XXIV"; if (a.equals("44")) return "XLIV"; if (a.equals("64")) return "LXIV"; if (a.equals("84")) return "LXXXIV";
        if (a.equals("5")) return "V"; if (a.equals("25")) return "XXV"; if (a.equals("45")) return "XLV"; if (a.equals("65")) return "LXV"; if (a.equals("85")) return "LXXXV";
        if (a.equals("6")) return "VI"; if (a.equals("26")) return "XXVI"; if (a.equals("46")) return "XLVI"; if (a.equals("66")) return "LXVI"; if (a.equals("86")) return "LXXXVI";
        if (a.equals("7")) return "VII"; if (a.equals("27")) return "XXVII"; if (a.equals("47")) return "XLVII"; if (a.equals("67")) return "LXVII"; if (a.equals("87")) return "LXXXVII";
        if (a.equals("8")) return "VIII"; if (a.equals("28")) return "XXVIII"; if (a.equals("48")) return "XLVIII"; if (a.equals("68")) return "LXVIII"; if (a.equals("88")) return "LXXXVIII";
        if (a.equals("9")) return "IX"; if (a.equals("29")) return "XXIX"; if (a.equals("49")) return "IL"; if (a.equals("69")) return "ILXX"; if (a.equals("89")) return "IXC";
        if (a.equals("10")) return "X"; if (a.equals("30")) return "XXX"; if (a.equals("50")) return "L"; if (a.equals("70")) return "LXX"; if (a.equals("90")) return "XC";
        if (a.equals("11")) return "XI"; if (a.equals("31")) return "XXXI"; if (a.equals("51")) return "LI"; if (a.equals("71")) return "LXXI"; if (a.equals("91")) return "XCI";
        if (a.equals("12")) return "XII"; if (a.equals("32")) return "XXXII"; if (a.equals("52")) return "LII"; if (a.equals("72")) return "LXXII"; if (a.equals("92")) return "XCII";
        if (a.equals("13")) return "XIII"; if (a.equals("33")) return "XXXIII"; if (a.equals("53")) return "LIII"; if (a.equals("73")) return "LXXIII"; if (a.equals("93")) return "XCIII";
        if (a.equals("14")) return "XIV"; if (a.equals("34")) return "XXXIV"; if (a.equals("54")) return "LIV"; if (a.equals("74")) return "LXXIV"; if (a.equals("94")) return "XCIV";
        if (a.equals("15")) return "XV"; if (a.equals("35")) return "XXXV"; if (a.equals("55")) return "LV"; if (a.equals("75")) return "LXXV"; if (a.equals("95")) return "XCV";
        if (a.equals("16")) return "XVI"; if (a.equals("36")) return "XXXVI"; if (a.equals("56")) return "LVI"; if (a.equals("76")) return "LXXVI"; if (a.equals("96")) return "XCVI";
        if (a.equals("17")) return "XVII"; if (a.equals("37")) return "XXXVII"; if (a.equals("57")) return "LVII"; if (a.equals("77")) return "LXXVII"; if (a.equals("97")) return "XCVII";
        if (a.equals("18")) return "XVIII"; if (a.equals("38")) return "XXXVIII"; if (a.equals("58")) return "LVIII"; if (a.equals("78")) return "LXXVIII"; if (a.equals("98")) return "XCVIII";
        if (a.equals("19")) return "XIX"; if (a.equals("39")) return "IXL"; if (a.equals("59")) return "ILX"; if (a.equals("79")) return "ILXXX"; if (a.equals("99")) return "IC";
        if (a.equals("20")) return "XX"; if (a.equals("40")) return "XL"; if (a.equals("60")) return "LX"; if (a.equals("80")) return "LXXX"; if (a.equals("100")) return "C";
        System.out.println("Некорректное выражение");
        System.exit(0);
        return "0";
    }
}