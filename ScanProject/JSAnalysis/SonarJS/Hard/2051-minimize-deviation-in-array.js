/**https://leetcode.com/problems/minimize-deviation-in-array/ */
//You are given an array nums of n positive integers.
//You can perform two types of operations on any element of the array any number of times:
//If the element is even, divide it by 2.
//For example, if the array is [1,2,3,4], then you can do this operation on the last element, and the array will be [1,2,3,2].
//If the element is odd, multiply it by 2.
//For example, if the array is [1,2,3,4], then you can do this operation on the first element, and the array will be [2,2,3,4].
//The deviation of the array is the maximum difference between any two elements in the array.
//Return the minimum deviation the array can have after performing some number of operations.


/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumDeviation = function(nums) {
    let n = nums.length;
    let pq = new PriorityQueue((a, b) => a - b);
    let max = 0;
    for(let i = 0; i < n; i++){
        if(nums[i] % 2 == 1){
            nums[i] *= 2;
        }
        pq.add(nums[i]);
        max = Math.max(max, nums[i]);
    }
    let res = Infinity;
    while(pq.size() > 0){
        let cur = pq.poll();
        res = Math.min(res, max - cur);
        if(cur % 2 == 0){
            cur /= 2;
            max = Math.max(max, cur);
            pq.add(cur);
        }else{
            break;
        }
    }
    return res;
    
    
};

class PriorityQueue{
    constructor(compare){
        this.compare = compare;
        this.arr = [];
    }
    add(val){
        this.arr.push(val);
        let cur = this.arr.length - 1;
        while(cur > 0){
            let parent = Math.floor((cur - 1) / 2);
            if(this.compare(this.arr[parent], this.arr[cur]) <= 0){
                break;
            }
            this.swap(cur, parent);
            cur = parent;
        }
    }
    poll(){
        if(this.arr.length == 0){
            return null;
        }
        let res = this.arr[0];
        this.swap(0, this.arr.length - 1);
        this.arr.pop();
        let cur = 0;
        while(cur < this.arr.length){
            let left = cur * 2 + 1;
            let right = cur * 2 + 2;
            if(left >= this.arr.length){
                break;
            }
            let next = left;
            if(right < this.arr.length && this.compare(this.arr[left], this.arr[right]) > 0){
                next = right;
            }
            if(this.compare(this.arr[cur], this.arr[next]) <= 0){
                break;
            }
            this.swap(cur, next);
            cur = next;
        }
        return res;
    }
    peek(){
        if(this.arr.length == 0){
            return null;
        }
        return this.arr[0];
    }
    size(){
        return this.arr.length;
    }
    swap(i, j){
        let temp = this.arr[i];
        this.arr[i] = this.arr[j];
        this.arr[j] = temp;
    }
}