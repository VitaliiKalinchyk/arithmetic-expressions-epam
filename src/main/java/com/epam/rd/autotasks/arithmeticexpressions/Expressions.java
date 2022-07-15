package com.epam.rd.autotasks.arithmeticexpressions;

import java.util.StringJoiner;

public class Expressions{

    public static Variable var(String name, int value) {
        return new Variable(name,value);
    }


    public static Expression val(int value) {
        return new Expression() {
            @Override
            public int evaluate() {
                return value;
            }

            @Override
            public String toExpressionString() {
                return value>=0?String.valueOf(value):"("+value+")";
            }
        };
    }

    public static Expression sum(Expression... members){
        return new Expression() {

            @Override
            public int evaluate() {
                int sum=0;
                for (Expression i:members) {
                    sum+= i.evaluate();
                }
                return sum;
            }

            @Override
            public String toExpressionString() {
                final StringBuilder expression = new StringBuilder("(");
                for (Expression i:members) {
                    expression.append(i.toExpressionString()).append(" + ");
                }
                return expression.substring(0,expression.length()-3)+")";
            }
        };
    }

    public static Expression product(Expression... members){
        return new Expression() {

            @Override
            public int evaluate() {
                int product=1;

                for (Expression i:members) {
                    product*= i.evaluate();
                }
                return product;
            }

            @Override
            public String toExpressionString() {
                final StringBuilder expression = new StringBuilder("(");

                for (Expression i:members) {
                    expression.append(i.toExpressionString()).append(" * ");
                }
                return expression.substring(0,expression.length()-3)+")";
            }
        };
    }

    public static Expression difference(Expression minuend, Expression subtrahend){
        return new Expression() {
            @Override
            public int evaluate() {
                return minuend.evaluate()-subtrahend.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "("+minuend.toExpressionString()+" - "+subtrahend.toExpressionString()+")";
            }
        };
    }

    public static Expression fraction(Expression dividend, Expression divisor){
        return new Expression() {
            @Override
            public int evaluate() {
                return dividend.evaluate()/divisor.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "("+dividend.toExpressionString()+" / "+divisor.toExpressionString()+")";
            }
        };
    }
}
