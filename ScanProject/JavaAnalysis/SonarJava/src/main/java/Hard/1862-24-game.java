package main.java.Hard;

import java.util.ArrayList;
import java.util.List;

/**https://leetcode.com/problems/24-game/ */
//You are given an integer array cards of length 4. You have four cards, each containing a number in the range [1, 9]. You should arrange the numbers on these cards in a mathematical expression using the operators ['+', '-', '*', '/'] and the parentheses '(' and ')' to get the value 24.
//You are restricted with the following rules:
//The division operator '/' represents real division, not integer division.
//For example, 4 / (1 - 2 / 3) = 4 / (1 / 3) = 12.
//Every operation done is between two numbers. In particular, we cannot use '-' as a unary operator.
//For example, if cards = [1, 1, 1, 1], the expression "-1 - 1 - 1 - 1" is not allowed.
//You cannot concatenate numbers together
//For example, if cards = [1, 2, 1, 2], the expression "12 + 12" is not valid.
//Return true if you can get such expression that evaluates to 24, and false otherwise.


class TwoFourGame {
    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<Double>();
        for (int card : cards) {
            list.add((double) card);
        }
        return dfs(list);

    }

    public boolean dfs(List<Double> list) {
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24) < 0.001;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {

                List<Double> next = new ArrayList<Double>();
                for (int k = 0; k < list.size(); k++) {
                    if (k != i && k != j) {
                        next.add(list.get(k));
                    }
                }

                double a = list.get(i);
                double b = list.get(j);

                next.add(a + b);
                if (dfs(next)) {
                    return true;
                }
                next.remove(next.size() - 1);

                next.add(a - b);
                if (dfs(next)) {
                    return true;
                }
                next.remove(next.size() - 1);

                next.add(b - a);
                if (dfs(next)) {
                    return true;
                }
                next.remove(next.size() - 1);

                next.add(a * b);
                if (dfs(next)) {
                    return true;
                }
                next.remove(next.size() - 1);

                if (b != 0) {
                    next.add(a / b);
                    if (dfs(next)) {
                        return true;
                    }
                    next.remove(next.size() - 1);
                }

                if (a != 0) {
                    next.add(b / a);
                    if (dfs(next)) {
                        return true;
                    }
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }
}
     
    