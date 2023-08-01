import java.util.Scanner;

public class Calculator {

    /**
     * класс калькулятор, поля мы не задаем, прописываем методы: сложение,
     * умножение,
     * вычитание, деление, для возведения в степень вызываем метод из
     * PowerCalculator
     */
    public Calculator() {
    }

    /**
     * @param a первое число
     * @param b второе число
     * @return результат
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * @param a первое число
     * @param b второе число
     * @return результат
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * @param a первое число
     * @param b второе число
     * @return результат
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * если делитель равен 0, то выбрасываем и обрабатываем исключение
     * ArithmeticException
     * 
     * @param a первое число
     * @param b второе число
     * @return результат
     */
    public double division(double a, double b) {
        if (b == 0)
            throw new ArithmeticException("ДЕление на ноль!");
        else {
            return a / b;
        }
    }

    /**используем switc case для выбора case, самый сложным было настроить проверки на ввод 
     * и на завершение кейсов, помогал chatGPT, процентов на 80 я разобрался тоже
     * 
     */
    public static void run() {
        //ввод данных и создание объектов где необходимо
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();
        PowerCalculator powCalc = new PowerCalculator();
        //для завершения работы создаем булеву переменную и заворачиваем в цикл
        boolean continueProgram = true;
        while (continueProgram) {
            double A = 0;
            double B = 0;
            char opper = ' ';
            //создаем еще булеву переменнуб для проверки коректности ввода
            boolean validInput = false;
            while (!validInput) {//пока фолс, в трай при неправильном вводе обрабатываем искл
                //что бы программа не легла
                try {
                    System.out.println("Введите первое число:  ");
                    A = Double.parseDouble(sc.nextLine());
                    System.out.println("Введите второе число: ");
                    B = Double.parseDouble(sc.nextLine());
                    validInput = true;//если все удовлетворяет меняем на тру и выходим из цикла
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод. Попробуйте еще раз.");
                }
            }
            validInput = false;//то же самое для оператора
            while (!validInput) {
                System.out.println("Введите +,-,*,/ для вычисления или символ ^ для возведения в степень: ");
                opper = sc.next().charAt(0);
                if (opper == '+' || opper == '-' || opper == '*' || opper == '/' || opper == '^') {
                    validInput = true;
                } else {
                    System.out.println("Некорректный ввод. Попробуйте еще раз.");
                }
            }
            switch (opper) {//переходим в case
                case '+':
                    System.out.println("РЕзультат: " + calculator.add(A, B));
                    break;
                case '-':
                    System.out.println("РЕзультат: " + calculator.subtract(A, B));
                    break;
                case '*':
                    System.out.println("РЕзультат: " + calculator.multiply(A, B));
                    break;
                case '/':
                    try {
                        System.out.println("РЕзультат: " + calculator.division(A, B));//обрабатываем исключения
                        //не совсем уверен что нужно обрабытывать и в методе и при вызове
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case '^'://такая же ситуация с обработкой как в division
                    PowerCalculator powCal = new PowerCalculator();
                    try {
                        System.out.println("РЕзультат: " + powCal.calculatePower(A, B));
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("НЕ корректное значение");//по умолчанию
            }
            boolean validAnswer = false;//проверка на выход
            while (!validAnswer) {//пока фолс, мы находимся в цикле
                System.out.println("Хотите продолжить? (Y/N)");
                String answer = sc.next();
                if (answer.equalsIgnoreCase("N")) {
                    //если значение соответсвует, то меняем на фолс и выходим из программы, стр 67-68
                    continueProgram = false;
                    validAnswer = true;//если значение соответсвует, то меняем на тру и выходим из цикла
                } else if (answer.equalsIgnoreCase("Y")) {
                    validAnswer = true;
                } else {
                    System.out.println("Некорректный ввод. Попробуйте еще раз.");
                }
            }
        }
    }
}
