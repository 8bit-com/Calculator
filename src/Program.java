import java.io.IOException;
import java.util.Scanner;

public class Prog {
    public static String calc(String input) throws IOException{
        String result = "ok";
        String[] tmp = input.split(" ");
        String [] arab = {"1","2","3","4","5","6","7","8","9","10"};
        String [] rome = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        return result;
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
