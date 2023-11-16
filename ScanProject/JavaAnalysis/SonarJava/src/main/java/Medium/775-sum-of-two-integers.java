package main.java.Medium;

/**https://leetcode.com/problems/sum-of-two-integers/ */
//Given two integers a and b, return the sum of the two integers without using the operators + and -.


class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        while(b != 0){
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
        
        
    }
}

    