
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int l = str.length();
        char[] arr = str.toCharArray();

// Количество символов
        int k_open = 0;// количество открывающихся скобок (
        int m_open = 0; //количество открывающихся скобок [
        int k_close = 0; //количество закрывающихся скобок (
        int m_close = 0; // количество закрывающихся скобок ]
        for (int i = 0; i < l; i++) {
            if (arr[i] == '(') {
                k_open++;
            }
            if (arr[i] == ')') {
                k_close++;
            }
            if (arr[i] == '[') {
                m_open++;
            }
            if (arr[i] == ']') {
                m_close++;
            }

        }
        if (k_open > k_close) {
            System.out.println("Ошибка: отсутствие )");
        } else if (k_open < k_close) {
            System.out.println("Ошибка: отсутствие (");
        } else if (m_open < m_close) {
            System.out.println("Ошибка: отсутствие [");
        } else if (m_open > m_close) {
            System.out.println("Ошибка: отсутствие ]");
        } else {
            Main main = new Main();
            Check_Сonsequense(str);
            System.out.println(Check_Сonsequense(str));
        }
    }
// Метод проверки правильности расстановок скобок
    private static String Check_Сonsequense(String checkStr) {

        int value_k_open = checkStr.indexOf('(');
        int value_m_open = checkStr.indexOf('[');
        int value_k_close = checkStr.lastIndexOf(')');
        int value_m_close = checkStr.lastIndexOf(']');
        int value_open = 0;
        int value_close = checkStr.length()-1;

        if (checkStr.indexOf('(')!=-1 && checkStr.lastIndexOf(')')!=-1
                && (checkStr.indexOf('(') < checkStr.indexOf('['))
                && (checkStr.lastIndexOf(')') < checkStr.lastIndexOf(']'))
        ||  (checkStr.indexOf('[')!=-1 && checkStr.lastIndexOf(']')!=-1 &&
                (checkStr.indexOf('(') > checkStr.indexOf('['))
                && (checkStr.lastIndexOf(')') > checkStr.lastIndexOf(']')))
        )
        {
            return "Ошибка: неправильная расстановка";
        }


        if ((checkStr.indexOf('(') == -1 && checkStr.lastIndexOf(')') == -1)
                && (checkStr.indexOf('[') == -1 && checkStr.lastIndexOf(']') == -1))
        {
            return "Правильная строка";
        }
        if ((checkStr.indexOf('[')!=-1 && checkStr.lastIndexOf(']')!=-1
                && (checkStr.indexOf('(') < checkStr.indexOf('['))
                && (checkStr.lastIndexOf(')') > checkStr.lastIndexOf(']')))
                || ((checkStr.indexOf('[')==-1 && checkStr.indexOf('(')!=-1)
                && (checkStr.indexOf(']')==-1 && checkStr.indexOf(')')!=-1))
        )
        {
            value_open = checkStr.indexOf('(');
            value_close = checkStr.lastIndexOf(')');

        } else  if ((checkStr.indexOf('(')!=-1 && checkStr.lastIndexOf(')')!=-1
                && (checkStr.indexOf('(') > checkStr.indexOf('['))
                && (checkStr.lastIndexOf(')') < checkStr.lastIndexOf(']')))
                || ((checkStr.indexOf('(')==-1 && checkStr.lastIndexOf('[')!=-1)
                && (checkStr.indexOf(')')==-1 && checkStr.lastIndexOf(']')!=-1)))
        {
                value_open = checkStr.indexOf('[');
                value_close = checkStr.lastIndexOf(']');
        }

                return  Check_Сonsequense(checkStr.substring(value_open + 1, value_close));

    }
}




