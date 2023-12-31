/**https://leetcode.com/problems/longest-turbulent-subarray/ */
//Given an integer array arr, return the length of a maximum size turbulent subarray of arr.
//A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
//More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:
//For i <= k < j:
//arr[k] > arr[k + 1] when k is odd, and
//arr[k] < arr[k + 1] when k is even.
//Or, for i <= k < j:
//arr[k] > arr[k + 1] when k is even, and
//arr[k] < arr[k + 1] when k is odd.


/**
 * @param {number[]} arr
 * @return {number}
 */
var maxTurbulenceSize = function(arr) {
    let n = arr.length;
    let ans = 1;
    let anchor = 0;
    for(let i = 1; i < n; i++){
        let c = compare(arr[i - 1], arr[i]);
        if(c == 0){
            anchor = i;
        }else if(i == n - 1 || c * compare(arr[i], arr[i + 1]) != -1){
            ans = Math.max(ans, i - anchor + 1);
            anchor = i;
        }
    }
    return ans;
    
    
};
function compare(a, b){
    if(a < b){
        return -1;
    }else if(a > b){
        return 1;
    }else{
        return 0;
    }
}

    