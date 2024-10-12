## 22. Generate Parentheses

Given `n` pairs of parentheses, write a function to _generate all combinations of well-formed parentheses_.

### **Example 1:**
> Input: `n = 3`  
> Output: `["((()))", "(()())", "(())()", "()(())", "()()()"]`

### **Example 2:**
> Input: `n = 1`  
> Output: `["()"]`

### **Constraints:**
* `1 <= n <= 8`

### **[Solution](../src/main/java/ru/druzhininyy/leetcode/exercises/algorithms/problem0022/Solution.java)**

**Complexity:**

* Time complexity: `O(2^n)`.
* Additional memory complexity: `O(n)`.
* Input memory complexity: `O(1)`.
* Output memory complexity: `O(2^n)`.