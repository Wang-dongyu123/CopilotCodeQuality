/**https://leetcode.com/problems/sum-of-k-mirror-numbers/ */
//A k-mirror number is a positive integer without leading zeros that reads the same both forward and backward in base-10 as well as in base-k.
//For example, 9 is a 2-mirror number. The representation of 9 in base-10 and base-2 are 9 and 1001 respectively, which read the same both forward and backward.
//On the contrary, 4 is not a 2-mirror number. The representation of 4 in base-2 is 100, which does not read the same both forward and backward.
//Given the base k and the number n, return the sum of the n smallest k-mirror numbers.


/**
 * @param {number} k
 * @param {number} n
 * @return {number}
 */
var kMirror = function(k, n) {
    let sum = 0;
    let count = 0;
    let i = 1;
    while(count < n){
        if(isMirror(i, k)){
            sum += i;
            count++;
        }
        i++;
    }
    return sum;
    
};

function isMirror(n, k){
    let nBaseK = convertToBaseK(n, k);
    let left = 0;
    let right = nBaseK.length - 1;
    while(left < right){
        if(nBaseK[left] !== nBaseK[right]){
            return false;
        }
        left++;
        right--;
    }
    return true;
}
function convertToBaseK(n, k){
    let result = "";
    while(n > 0){
        result = (n % k).toString() + result;
        n = Math.floor(n / k);
    }
    return result;
}