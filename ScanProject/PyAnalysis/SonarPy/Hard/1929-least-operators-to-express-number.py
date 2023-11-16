#https://leetcode.com/problems/least-operators-to-express-number/
#Given a single positive integer x, we will write an expression of the form x (op1) x (op2) x (op3) x ... where each operator op1, op2, etc. is either addition, subtraction, multiplication, or division (+, -, *, or /). For example, with x = 3, we might write 3 * 3 / 3 + 3 - 3 which is a value of 3.
#When writing such an expression, we adhere to the following conventions:
#The division operator (/) returns rational numbers.
#There are no parentheses placed anywhere.
#We use the usual order of operations: multiplication and division happen before addition and subtraction.
#It is not allowed to use the unary negation operator (-). For example, "x - x" is a valid expression as it only uses subtraction, but "-x + x" is not because it uses negation.
#We would like to write an expression with the least number of operators such that the expression equals the given target. Return the least number of operators used.


class Solution(object):
    def leastOpsExpressTarget(self, x, target):
        """
        :type x: int
        :type target: int
        :rtype: int
        """
        if x>target:
            return min(2*target-1,x-target)
        if x==target:
            return 0
        if target%x==0:
            return self.leastOpsExpressTarget(x,target//x)
        else:
            return min(target%x*x,self.leastOpsExpressTarget(x,target%x)+x)
        
        
    