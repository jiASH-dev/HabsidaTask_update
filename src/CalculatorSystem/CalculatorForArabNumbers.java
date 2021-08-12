package CalculatorSystem;

import MyExceptions.InvalidOperatorException;
import MyExceptions.OutOfNumbersException;


public class CalculatorForArabNumbers extends Calculator{
    public void calculate(String computation) {
        String[] computationSplit = computation.split(" ");

        char[] firstNumber = computationSplit[0].toCharArray();
        char[] secondNumber = computationSplit[2].toCharArray();

        try {
            for (int i = 0; i < firstNumber.length; i++){
                if ((firstNumber[i] == '.' || firstNumber[i] == ',') && (i != 0 && i != firstNumber.length-1)){
                    throw new NumberFormatException("Были использованы не целые числа");
                }
            }
            for (int i = 0; i < secondNumber.length; i++){
                if ((secondNumber[i] == '.' || secondNumber[i] == ',') && (i != 0 && i != secondNumber.length-1)){
                    throw new NumberFormatException("Были использованы не целые числа");
                }
            }
        } catch (NumberFormatException e){
            result = e.getMessage();
            return;
        }

        //

        try {
            if ((Integer.parseInt(computationSplit[0]) <= 10 && Integer.parseInt(computationSplit[0]) != 0)
                    && (Integer.parseInt(computationSplit[2]) <= 10 && Integer.parseInt(computationSplit[2]) != 0)) {
                switch (computationSplit[1]){
                    case "+":
                        result = Integer.parseInt(computationSplit[0]) + Integer.parseInt(computationSplit[2]) + "";
                        break;
                    case "-":
                        result = Integer.parseInt(computationSplit[0]) - Integer.parseInt(computationSplit[2]) + "";
                        break;
                    case "/":
                        result = Integer.parseInt(computationSplit[0]) / Integer.parseInt(computationSplit[2]) + "";
                        break;
                    case "*":
                        result = Integer.parseInt(computationSplit[0]) * Integer.parseInt(computationSplit[2]) + "";
                        break;
                    default:
                        throw new InvalidOperatorException("Использован некорректный оператор");
                }
            }
            else {
                throw new OutOfNumbersException("Были использованы числа вне допустимого диапазона");
            }
        } catch (OutOfNumbersException | InvalidOperatorException e) {
            result = e.getMessage();
        }
    }

    public String getResult(){
        return result;
    }
}