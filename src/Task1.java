import java.util.Scanner;

public class Task1 {
    public static int digitSumInNumber(int n){
        int sum=0;
        while(n != 0){
            //Суммирование цифр числа
            sum += (n % 10);
            n/=10;
        }
        return sum;
    }
    // Функция для вычисления шифра кандидата
    public static String calculateCipher(String lastName, String firstName, String middleName, int day, int month, int year) {
        // Подсчитываем количество различных символов в ФИО
        String all = lastName + firstName + middleName;
        int uniqueChars = (int) all.chars().distinct().count();

        // Сумма цифр в дне и месяце.
        int dateSum = digitSumInNumber(day) + digitSumInNumber(month);
        //System.out.println(dateSum);

        // Шаг c: Определяем номер первой буквы фамилии.
        int firstLetterValue = Character.toUpperCase(lastName.charAt(0)) - 'A' + 1;
        //System.out.println(firstLetterValue);

        // Подсчет общего значения.
        int total = (uniqueChars + (dateSum * 64)) + (firstLetterValue * 256);
        //System.out.println(total);

        // Шаг e: Переводим в 16-ричную систему и оставляем только 3 младших разряда
        String cipher = Integer.toHexString(total).toUpperCase();
        System.out.println(cipher);
        String answer = "";
        for (int i = cipher.length()-1; i > cipher.length()-4; i--) {
             answer = cipher.charAt(i) + answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // Количество кандидатов
        String answer="";
        // Считываем информацию о кандидатах и выводим их шифры
        for (int i = 0; i < N; i++) {
            String[] data = scanner.next().split(",");
            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            int day = Integer.parseInt(data[3]);
            int month = Integer.parseInt(data[4]);
            int year = Integer.parseInt(data[5]);

            String cipher = calculateCipher(lastName, firstName, middleName, day, month, year);
            answer = answer + cipher + " ";
        }
        System.out.print(answer);
        scanner.close();
    }
}

