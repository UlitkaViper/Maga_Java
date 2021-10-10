public class Main{

    public static void main(String[] args){
    /* Типы данных */
        byte byteNum = 69;
        short shortNum = 69;
        int intNum = 69;
        long longNum = 69;
        float floatNum = 69.420f;
        double doubleNum = 69.420;
        boolean bool = true;
        char charSymbol = 'q';
        String stringWord = "Shalom";

    /* Методы */

        System.out.println(calcABCD(6, 9, 4, 2));       /* Расчет по формуле */
        System.out.println(checkBetween(6, 9));             /* Между 10 и 20 */
        checkSign(69);                                      /* Знак числа */
        System.out.println(checkNegative(-69));             /* Отрицательое ли число */
        printName("Макс");                                      /* Вывести имя */
        checkYear(420);                                         /* Проверка високосного года */

    }

    public static double calcABCD(double a, double b, double c, double d){
        return a * (b + (c/d));
    }

    public static boolean checkBetween(double a, double b){
        if (a + b >= 10 && a + b <= 20){
            return true;
        }
        else{
            return false;
        }
    }

    public static void checkSign(int num){
        if (num >= 0){
            System.out.println("Число положительное");
        }
        else{
            System.out.println("Число отрицательное");
        }
    }

    public static boolean checkNegative(int num){
        if (num >= 0){
            return false;
        }
        else{
            return true;
        }
    }

    public static void printName(String name){
        System.out.println("Привет, " + name);
    }

    public static void checkYear(int year){
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)){
            System.out.println("Год високосный");
        }
        else{
            System.out.println("Год не високосный");
        }
    }

}