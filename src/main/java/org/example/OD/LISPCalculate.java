package org.example.OD;

import java.util.Scanner;
import java.util.Stack;

public class LISPCalculate {
    static Stack<Integer> numStack = new Stack<>();   // 数字栈
    static Stack<String> operatorStack = new Stack<>();  // 操作符栈

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int index = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                operatorStack.push(input.substring(i + 1, i + 4));
                i += 4;
                index = i + 1;
            } else if (ch == ')') {
                if (index < i) {
                    pushNumber(input.substring(index, i));
                    i += 1;
                    index = i + 1;
                }
                calculate();
            } else {
                if (ch == ' ' && index < i) {
                    pushNumber(input.substring(index, i));
                    index = i + 1;
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            calculate();
        }

        System.out.println(numStack.get(0));
    }

    private static void pushNumber(String number) {
        try {
            numStack.push(Integer.parseInt(number));
        } catch (NumberFormatException e) {
            handleInvalidInput();
        }
    }

    private static void calculate() {
        int num2 = numStack.pop();
        int num1 = numStack.pop();
        String op = operatorStack.pop();

        switch (op) {
            case "add":
                numStack.push(num1 + num2);
                break;
            case "sub":
                numStack.push(num1 - num2);
                break;
            case "mul":
                numStack.push(num1 * num2);
                break;
            case "div":
                handleDivision(num1, num2);
                break;
            default:
                handleInvalidInput();
        }
    }

    private static void handleDivision(int num1, int num2) {
        if (num2 == 0) {
            System.out.println("error");
            System.exit(0);
        } else {
            int res = num1 / num2 + ((num1 % num2 != 0) ? (num1 > 0 ? 1 : -1) : 0);
            numStack.push(res);
        }
    }

    private static void handleInvalidInput() {
        System.exit(0);
    }

    public static void solution2(String str) {
        for (int i = 0; i < str.length(); i++){
            int index = 0;
            if (str.charAt(i) == '('){
                operatorStack.push(str.substring(i + 1, i + 4));
                i += 4;
                index = i+1;
           }
            if (str.charAt(i) == ')'){

            }
        }
    }
}
