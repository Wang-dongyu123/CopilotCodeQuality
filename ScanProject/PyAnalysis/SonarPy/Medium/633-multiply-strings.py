#https://leetcode.com/problems/multiply-strings/
#Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
#Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.


class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """ 
              
        if num1=="0" or num2=="0":
            return "0"
        if num1=="1":
            return num2
        if num2=="1":
            return num1
        if len(num1)<len(num2):
            num1,num2=num2,num1
        num1=num1[::-1]
        num2=num2[::-1]
        res="0"
        for i in range(len(num2)):
            res=self.add(res,self.multiplyOne(num1,num2[i],i))
        return res
    def add(self,num1,num2):
            res=""
            i,j,carry=len(num1)-1,len(num2)-1,0
            while i>=0 or j>=0 or carry:
                if i>=0:
                    carry+=int(num1[i])
                    i-=1
                if j>=0:
                    carry+=int(num2[j])
                    j-=1
                res=str(carry%10)+res
                carry=carry//10
            return res
    def multiplyOne(self,num1,num2,i):
            res=""
            carry=0
            for j in range(len(num1)):
                carry+=int(num1[j])*int(num2)
                res=str(carry%10)+res
                carry=carry//10
            if carry>0:
                res=str(carry)+res
            res=res+"0"*i
            return res

        

    