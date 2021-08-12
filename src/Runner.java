import CalculatorSystem.CalculateForRomanNumbers;
import CalculatorSystem.Calculator;
import CalculatorSystem.CalculatorForArabNumbers;
import MyExceptions.NumbersOfDifferentTypesException;

import java.util.Scanner;


public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choose = 0;
        char[] toCharArray1;
        char[] toCharArray2;
        boolean FirstRomanIsTrue = true;
        boolean SecondRomanIsTrue = true;
        boolean FirstArabIsTrue = true;
        boolean SecondArabIsTrue = true;
        Calculator calculatorForArabNumbers = new CalculatorForArabNumbers();
        Calculator calculatorForRomanNumbers = new CalculateForRomanNumbers();
        System.out.println("Введите вычислительную операцию (Пример: 1 + 1 или I + I)");
        String operation = scanner.nextLine();
        String[] operationSplit = operation.split(" ");

        try {
            if (operationSplit.length != 3){
                throw new ArrayIndexOutOfBoundsException("Некорректый ввод");
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            return;
        }

        toCharArray1 = operationSplit[0].toCharArray();
        toCharArray2 = operationSplit[2].toCharArray();

        for (int i = 0; i < toCharArray1.length; i++) {
            if (toCharArray1[i] >= 48 && toCharArray1[i] < 57) {
                FirstRomanIsTrue = false;
                break;
            }
        }
        for (int i = 0; i < toCharArray2.length; i++) {
            if (toCharArray2[i] >= 48 && toCharArray2[i] < 57) {
                SecondRomanIsTrue = false;
                break;
            }
        }
        if (FirstRomanIsTrue && SecondRomanIsTrue) {
            choose = 2;
        }



        for (int i = 0; i < toCharArray1.length; i++) {
            if ((toCharArray1[i] < 48 || toCharArray1[i] > 57) && (toCharArray1[i] != '.' && toCharArray1[i] != ',')) {
                FirstArabIsTrue = false;
                break;
            }
        }
        for (int i = 0; i < toCharArray2.length; i++) {
            if ((toCharArray2[i] < 48 || toCharArray2[i] > 57) && (toCharArray2[i] != '.' && toCharArray1[i] != ',')) {
                SecondArabIsTrue = false;
                break;
            }
        }
        if (FirstArabIsTrue && SecondArabIsTrue) {
            choose = 1;
        }


        try {
            if (choose == 0) {
                throw new NumbersOfDifferentTypesException("Калькулятор может производитель вычисления только с римскими или арабскими цифрами одновременно");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        switch (choose) {
            case 1:
                calculatorForArabNumbers.calculate(operation);
                System.out.println("Ответ: " + calculatorForArabNumbers.getResult());
                break;
            case 2:
                calculatorForRomanNumbers.calculate(operation);
                System.out.println("Ответ: " + calculatorForRomanNumbers.getResult());
                break;
            default:
                System.out.println("Данного пункта в меню не существует");
        }
    }
}

