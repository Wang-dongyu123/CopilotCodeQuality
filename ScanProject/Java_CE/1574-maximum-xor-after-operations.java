package main.java.Medium;

/**https://leetcode.com/problems/maximum-xor-after-operations/ */
//You are given a 0-indexed integer array nums. In one operation, select any non-negative integer x and an index i, then update nums[i] to be equal to nums[i] AND (nums[i] XOR x).
//Note that AND is the bitwise AND operation and XOR is the bitwise XOR operation.
//Return the maximum possible bitwise XOR of all elements of nums after applying the operation any number of times.
// 
//Example 1:
//Input: nums = [3,2,4,6]
//Output: 7
//Explanation: Apply the operation with x = 4 and i = 3, num[3] = 6 AND (6 XOR 4) = 6 AND 2 = 2.
//Now, nums = [3, 2, 4, 2] and the bitwise XOR of all the elements = 3 XOR 2 XOR 4 XOR 2 = 7.
//It can be shown that 7 is the maximum possible bitwise XOR.
//Note that other operations may be used to achieve a bitwise XOR of 7.
//Example 2:
//Input: nums = [1,2,3,9,2]
//Output: 11
//Explanation: Apply the operation zero times.
//The bitwise XOR of all the elements = 1 XOR 2 XOR 3 XOR 9 XOR 2 = 11.
//It can be shown that 11 is the maximum possible bitwise XOR.
// 
//Constraints:
//	1 <= nums.length <= 105
//	0 <= nums[i] <= 108
class Solution319 {
    public int maximumXOR(int[] nums) {
        Trie1 trie = new Trie1();
        for (int num : nums) {
            trie.insert(num);
        }
        int res = 0;
        for (int num : nums) {
            res = Math.max(res, trie.query(num));
        }
        return res;
    }
}
class Trie1 {
    private Trie1[] children;
    public Trie1() {
        children = new Trie1[2];
    }
    public void insert(int num) {
        Trie1 node = this;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >>> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new Trie1();
            }
            node = node.children[bit];
        }
    }
    public int query(int num) {
        Trie1 node = this;
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >>> i) & 1;
            if (node.children[bit ^ 1] != null) {
                res |= (1 << i);
                node = node.children[bit ^ 1];
            } else {
                node = node.children[bit];
            }
        }
        return res;
    }
}