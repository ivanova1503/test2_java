import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите уравнение из цифр 0-9, длиной 5 символов, с одним неизвестным x: ");
        String str = scanner.nextLine();
        char[] array = str.toCharArray();

        int kolichestvo_x=0; // количество найденных х в уравнении
        boolean proverka = true;

        /*
        проверить условие, что 1,3 и 5 элементы являются две цифры от 0-9 или буква х
        проверить условие, что 2 элемент является символом + или -
        проверить, что 4 элемент является символом =
        */

        for (int i=0; i < array.length; i++) {
            if(i==0 || i==2 || i==array.length-1) {
                proverka = ((array[i]=='x')||Character.isDigit(array[i]));
                if(array[i]=='x') {
                    kolichestvo_x+=1;
                }
            }
            else if (i==1) {
                proverka = ((array[i]=='+')||(array[i]=='-'));
            }
            else if (i==3) {
                proverka = (array[i]=='=');
            }
        }

        //проверка что х только 1 раз
        if (kolichestvo_x!=1) {
            proverka=false;
        }

        while((array.length!=5)||(proverka==false) ){
            System.out.println("Неверно введено уравнение!");
            System.out.println("Введите уравнение из цифр 0-9, длиной 5 символов, с одним неизвестным x: ");
            str = scanner.nextLine();
            array = str.toCharArray();
        }

        int result=0;

        // если х стоит на первом месте, индекс 0
        if(str.indexOf('x')==0) {
            if(array[1]=='-') {
                result=(Character.getNumericValue(array[4])) + (Character.getNumericValue(array[2]));
            }
            else if(array[1]=='+') {
                result=(Character.getNumericValue(array[4])) - (Character.getNumericValue(array[2]));
            }
        }

        //если х стоит на 3 месте, индекс 2
        if(str.indexOf('x')==2) {
            if(array[1]=='-') {
                result=(Character.getNumericValue(array[0])) - (Character.getNumericValue(array[4]));
            }
            else if(array[1]=='+') {
                result=(Character.getNumericValue(array[4])) + (Character.getNumericValue(array[0]));
            }
        }
        // если х стоит на последнем месте, индекс 4
        if(str.indexOf('x')==4) {
            if(array[1]=='-') {
                result=(Character.getNumericValue(array[0])) - (Character.getNumericValue(array[2]));
            }
            else if(array[1]=='+') {
                result=(Character.getNumericValue(array[0])) + (Character.getNumericValue(array[2]));
            }
        }
        //результат:
        System.out.println("Результат: х = " + result);
    }
}