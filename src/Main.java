import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите выражение (например, 2 + 3):");
        String input = br.readLine();

        calc(input);
    }

    public static void calc(String input) throws Exception {

        String[] inputs = input.split(" ");

        if (inputs.length != 3) {
            throw new Exception("Некорректное выражение. Введите выражение в формате '1(пробел)+(пробел)2'.");
        }


        int num1 = Integer.parseInt(inputs[0]);
        char operator = inputs[1].charAt(0);
        int num2 = Integer.parseInt(inputs[2]);


        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new Exception("Калькулятор принимает числа только в диапазоне от 1 до 10 включительно.");
        }

        int result;


        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new Exception("Деление на ноль запрещено.");
                }
                result = num1 / num2;
                break;
            default:
                throw new Exception("Недопустимый оператор. Используйте только '+', '-', '*', '/'.");
        }

        System.out.println("Результат: " + result);
    }
}
