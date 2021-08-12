package CalculatorSystem;

import MyExceptions.InvalidOperatorException;
import MyExceptions.OutOfNumbersException;

public class CalculateForRomanNumbers extends Calculator{
    private final static String[] RomanNumbers = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};

    public void calculate(String computation) {
        String[] RomanSplit = computation.split(" ");

        int firstNumber = 0;
        int secondNumber = 0;

        for (int i = 1; i < 11; i++) {
            if (RomanNumbers[i].equals(RomanSplit[0])) {
                firstNumber = i;
            }
            if (RomanNumbers[i].equals(RomanSplit[2])) {
                secondNumber = i;
            }
        }

        try {
            if (firstNumber != 0 && secondNumber != 0) {
                switch (RomanSplit[1]) {
                    case "+":
                        result = ArabToRoman(firstNumber + secondNumber);
                        break;
                    case "-":
                        result = ArabToRoman(firstNumber - secondNumber);
                        break;
                    case "/":
                        result = ArabToRoman(firstNumber / secondNumber);
                        break;
                    case "*":
                        result = ArabToRoman(firstNumber * secondNumber);
                        break;
                    default:
                        throw new InvalidOperatorException("Использован некорректный оператор");
                }
            } else {
                throw new OutOfNumbersException("Были использованы числа вне допустимого диапазона");
            }
        } catch (OutOfNumbersException | InvalidOperatorException e) {
            result = e.getMessage();
        }
    }

    private String ArabToRoman(int res) {
        String str = "";
        int tmp = res;
        if (res < 0){
            str = "-";
            tmp = res * -1;
        }
        if (tmp <= 10) {
            str += CalculateForRomanNumbers.RomanNumbers[tmp];
        } else if (tmp < 100) {
            int dozens = tmp / 10;
            str += CalculateForRomanNumbers.RomanNumbers[(dozens + 10) - 1] + CalculateForRomanNumbers.RomanNumbers[(tmp - (dozens * 10))];
        } else {
            str += CalculateForRomanNumbers.RomanNumbers[CalculateForRomanNumbers.RomanNumbers.length - 1];
        }
        return str;
    }

    public String getResult(){
        return result;
    }
}
