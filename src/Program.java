import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static String calc(String input) throws IOException{
        String[] tmp = input.split(" ");
        if (tmp.length != 3) {
            throw new IOException();
        }
        String [] arab = {"1","2","3","4","5","6","7","8","9","10"};
        String [] rome = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        boolean flag_arab = false;
        boolean flag_rome = false;
        int a = 0, b = 0, res;
        for (int i = 0; i < arab.length; i++) {
            if (tmp[0].equals(arab[i])) {
                a = i + 1;
                for (int j = 0; j < arab.length; j++) {
                    if (tmp[2].equals(arab[j])) {
                        b = j + 1;
                        flag_arab = true;
                        break;
                    }
                }
                if (!flag_arab) {
                    throw new IOException();
                } else {
                    break;
                }
            }
            if (tmp[0].equals(rome[i])) {
                a = i + 1;
                for (int j = 0; j < arab.length; j++) {
                    if (tmp[2].equals(rome[j])) {
                        b = j + 1;
                        flag_rome = true;
                        break;
                    }
                }
                if (!flag_rome) {
                    throw new IOException();
                } else {
                    break;
                }
            }
        }
        if (flag_arab || flag_rome) {
            switch (tmp[1]) {
                case "+":
                    res = a + b;
                    break;
                case "-":
                    if (flag_rome && a <= b) {
                        throw new IOException();
                    } else {
                        res = a - b;
                    }
                    break;
                case "*":
                    res = a * b;
                    break;
                case "/":
                    res = a / b;
                    break;
                default:
                    throw new IOException();
            }
        } else {
            throw new IOException();
        }
        if (flag_arab) {
            return String.valueOf(res);
        } else {
            if (res > 10) {
                String[] roman_str = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                        "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                        "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                        "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                        "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                        "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                        "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
                return roman_str[res - 1];
            } else {
                return rome[res- 1];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        try {
            System.out.println(calc(str));
        } catch (IOException e) {
            System.out.println("throws Exception");
        }
    }
}
