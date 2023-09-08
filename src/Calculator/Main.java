package Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static String calc(String input) throws Exception {
        String[] data = String.valueOf(input).split(" ");
        String operation = null;
        String firstValue = null;
        String secondValue = null;
        if (data.length != 3) {
            throw new Exception("Введено больше двух значений!/ или не корректный ввод: Операция должна содержать a (+,-,*,/) a");
        } else {
            try {
                for (int i = 0; i < data.length; i++) {
                    firstValue = data[0];
                    secondValue = data[2];
                    operation = data[1];
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new Exception("Не корректный ввод");
            }
        }
        String[] romanFullValue = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String[] romanMaxInput = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        List<String> listRomanValue = new ArrayList<>(List.of(romanFullValue));
        if (listRomanValue.contains(firstValue) || listRomanValue.contains(secondValue)) {
            int resultFirst = 0;
            int resultSecond = 0;
            for (int i = 0; i < 10; i++) {
                if (firstValue.equals(romanMaxInput[i])) {
                    resultFirst = i + 1;
                }
                if (secondValue.equals(romanMaxInput[i])) {
                    resultSecond = i + 1;
                }
            }
            if ((resultFirst < 11 && resultFirst > 0) && (resultSecond < 11 && resultSecond > 0)) {
                try {
                    if (operation.contains("+")) {
                        int result = resultFirst + resultSecond;
                        String megaResult = romanFullValue[result - 1];
                        System.out.println(megaResult);
                    } else if (operation.contains("-")) {
                        int result = resultFirst - resultSecond;
                        String megaResult = romanFullValue[result - 1];
                        System.out.println(megaResult);
                    } else if (operation.contains("*")) {
                        int result = resultFirst * resultSecond;
                        String megaResult = romanFullValue[result - 1];
                        System.out.println(megaResult);
                    } else if (operation.contains("/")) {
                        int result = resultFirst / resultSecond;
                        String megaResult = romanFullValue[result - 1];
                        System.out.println(megaResult);
                    } else {
                        throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new Exception("В римской системе счесления нет отрицательных чисел");
                }
            } else {
                throw new Exception("Введите два значения одного типа");
            }
        }
        try {
            if (!listRomanValue.contains(firstValue) && !listRomanValue.contains(secondValue)) {
                if (Integer.parseInt(firstValue) > 0 && Integer.parseInt(firstValue) < 11 && Integer.parseInt(secondValue) > 0 && Integer.parseInt(secondValue) < 11) {
                    if (operation.contains("+")) {
                        System.out.println(Integer.parseInt(firstValue) + Integer.parseInt(secondValue));
                    } else if (operation.contains("-")) {
                        System.out.println(Integer.parseInt(firstValue) - Integer.parseInt(secondValue));
                    } else if (operation.contains("*")) {
                        System.out.println(Integer.parseInt(firstValue) * Integer.parseInt(secondValue));
                    } else if (operation.contains("/")) {
                        System.out.println(Integer.parseInt(firstValue) / Integer.parseInt(secondValue));
                    } else {
                        throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    }
                } else {
                    throw new Exception("Введите значение от 1 до 10");
                }
            }
        } catch (NumberFormatException e) {
            throw new Exception("Введены некорректные значения");
        }
        return "Программа завершена!";
    }


    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String string = input.nextLine();
        System.out.println(calc(string));
    }
}