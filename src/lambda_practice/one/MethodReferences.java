package lambda_practice.one;

import lambda_practice.one.Calculator;

import java.util.function.IntBinaryOperator;

public class MethodReferences {
    public static void main(String[] args) throws Exception{
        IntBinaryOperator operator;
        operator = Calculator::staticMethod;
        System.out.println(operator.applyAsInt(3,5));

        Calculator calculator = new Calculator();
        operator = calculator::instanceMethod;
        System.out.println(operator.applyAsInt(3,5));
    }
}
