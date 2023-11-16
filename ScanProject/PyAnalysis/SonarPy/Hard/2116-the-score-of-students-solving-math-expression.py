#https://leetcode.com/problems/the-score-of-students-solving-math-expression/
#You are given a string s that contains digits 0-9, addition symbols '+', and multiplication symbols '*' only, representing a valid math expression of single digit numbers (e.g., 3+5*2). This expression was given to n elementary school students. The students were instructed to get the answer of the expression by following this order of operations:
#Compute multiplication, reading from left to right; Then,
#Compute addition, reading from left to right.
#You are given an integer array answers of length n, which are the submitted answers of the students in no particular order. You are asked to grade the answers, by following these rules:
#If an answer equals the correct answer of the expression, this student will be rewarded 5 points;
#Otherwise, if the answer could be interpreted as if the student applied the operators in the wrong order but had correct arithmetic, this student will be rewarded 2 points;
#Otherwise, this student will be rewarded 0 points.
#Return the sum of the points of the students.


class Solution(object):
    def scoreOfStudents(self, s, answers):
        """
        :type s: str
        :type answers: List[int]
        :rtype: int
        """
        n = len(s)
        nums = []
        ops = []
        for i in range(n):
            if i % 2 == 0:
                nums.append(int(s[i]))
            else:
                ops.append(s[i])
        def calc(x, y, op):
            if op == "+":
                return x + y
            else:
                return x * y
        @lru_cache(None)
        def dp(i, j):
            if i == j:
                return [nums[i]]
            res = set()
            for k in range(i, j):
                left = dp(i, k)
                right = dp(k + 1, j)
                for x in left:
                    for y in right:
                        res.add(calc(x, y, ops[k]))
            return list(res)
        ans = dp(0, n - 1)
        correct = eval(s)
        cnt = 0
        for x in answers:
            if x == correct:
                cnt += 5
            elif x in ans:
                cnt += 2
        return cnt
        
        
    