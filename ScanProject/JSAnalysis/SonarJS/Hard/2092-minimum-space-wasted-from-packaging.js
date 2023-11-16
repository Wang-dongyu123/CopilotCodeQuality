/**https://leetcode.com/problems/minimum-space-wasted-from-packaging/ */
//You have n packages that you are trying to place in boxes, one package in each box. There are m suppliers that each produce boxes of different sizes (with infinite supply). A package can be placed in a box if the size of the package is less than or equal to the size of the box.
//The package sizes are given as an integer array packages, where packages[i] is the size of the ith package. The suppliers are given as a 2D integer array boxes, where boxes[j] is an array of box sizes that the jth supplier produces.
//You want to choose a single supplier and use boxes from them such that the total wasted space is minimized. For each package in a box, we define the space wasted to be size of the box - size of the package. The total wasted space is the sum of the space wasted in all the boxes.
//For example, if you have to fit packages with sizes [2,3,5] and the supplier offers boxes of sizes [4,8], you can fit the packages of size-2 and size-3 into two boxes of size-4 and the package with size-5 into a box of size-8. This would result in a waste of (4-2) + (4-3) + (8-5) = 6.
//Return the minimum total wasted space by choosing the box supplier optimally, or -1 if it is impossible to fit all the packages inside boxes. Since the answer may be large, return it modulo 109 + 7.


/**
 * @param {number[]} packages
 * @param {number[][]} boxes
 * @return {number}
 */
var minWastedSpace = function(packages, boxes) {
    let mod = 1000000007;
    let n = packages.length;
    let m = boxes.length;
    let result = Number.MAX_SAFE_INTEGER;
    packages.sort((a, b) => a - b);
    for (let i = 0; i < m; i++) {
        boxes[i].sort((a, b) => a - b);
        if (boxes[i][boxes[i].length - 1] < packages[packages.length - 1]) {
            continue;
        }
        let waste = 0;
        let j = 0;
        for (let k = 0; k < boxes[i].length; k++) {
            while (j < n && packages[j] <= boxes[i][k]) {
                waste += boxes[i][k] - packages[j];
                j++;
            }
        }
        result = Math.min(result, waste);
    }
    return result == Number.MAX_SAFE_INTEGER ? -1 : result % mod;
};

    