/**https://leetcode.com/problems/the-score-of-students-solving-math-expression/ */
//You are given a string s that contains digits 0-9, addition symbols '+', and multiplication symbols '*' only, representing a valid math expression of single digit numbers (e.g., 3+5*2). This expression was given to n elementary school students. The students were instructed to get the answer of the expression by following this order of operations:
//Compute multiplication, reading from left to right; Then,
//Compute addition, reading from left to right.
//You are given an integer array answers of length n, which are the submitted answers of the students in no particular order. You are asked to grade the answers, by following these rules:
//If an answer equals the correct answer of the expression, this student will be rewarded 5 points;
//Otherwise, if the answer could be interpreted as if the student applied the operators in the wrong order but had correct arithmetic, this student will be rewarded 2 points;
//Otherwise, this student will be rewarded 0 points.
//Return the sum of the points of the students.


/**
 * @param {string} s
 * @param {number[]} answers
 * @return {number}
 */
var scoreOfStudents = function(s, answers) {
    let result = 0;
    let map = new Map();
    let correct = calculate(s);
    for (let i = 0; i < answers.length; i++) {
        let answer = answers[i];
        if (answer == correct) {
            result += 5;
        } else if (calculate(answer) == correct) {
            result += 2;
        }
    }
    return result;
    
    
};

function calculate(s) {
    let stack = [];
    let num = 0;
    let sign = '+';
    for (let i = 0; i < s.length; i++) {
        let c = s[i];
        if (c == ' ') {
            continue;
        }
        if (!isNaN(c)) {
            num = num * 10 + parseInt(c);
        }
        if (isNaN(c) || i == s.length - 1) {
            if (sign == '+') {
                stack.push(num);
            }
            if (sign == '-') {
                stack.push(-num);
            }
            if (sign == '*') {
                stack.push(stack.pop() * num);
            }
            sign = c;
            num = 0;
        }
    }
    let result = 0;
    while (stack.length > 0) {
        result += stack.pop();
    }
    return result;
}
