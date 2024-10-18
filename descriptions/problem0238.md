## 238. Product of Array Except Self

Given an integer array `nums`, _return an array `answer` such that `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`_.

The product of any prefix or suffix of `nums` is **guaranteed** to fit in a **32-bit** integer.

You must write an algorithm that runs in `O(n)` time and without using the division operation.

### **Example 1:**
> Input: `nums = [1, 2, 3, 4]`  
> Output: `[24, 12, 8, 6]`

### **Example 2:**
> Input: `nums = [-1, 1, 0, -3, 3]`  
> Output: `[0, 0, 9, 0, 0]`

### **Constraints:**
* `2 <= nums.length <= 105`
* `-30 <= nums[i] <= 30`
* The product of any prefix or suffix of `nums` is **guaranteed** to fit in a **32-bit** integer.

### **[Solution](../src/main/java/ru/druzhininyy/leetcode/exercises/algorithms/problem0238/Solution.java)**

**Complexity:** `n` - length of `nums`

* Time complexity: `O(n)`.
* Additional memory complexity: `O(1)`.
* Input memory complexity: `O(n)`.
* Output memory complexity: `O(n)`.