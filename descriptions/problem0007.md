## 7. Reverse Integer

Given a signed 32-bit integer `num`, return `num` with its digits reversed. If reversing `num` causes the value to go outside the signed 32-bit integer range `[-2^31, 2^31 - 1]`, then return `0`.

**Assume the environment does not allow you to store 64-bit integers (signed or unsigned).**


### **Example 1:**
> Input: `num = 123`  
> Output: `321`

### **Example 2:**
> Input: `num = -123"`  
> Output: `-321`  

### **Example 3:**
> Input: `num = 120`  
> Output: `21`

### **Constraints:**
* `-2^31 <= num <= 2^31 - 1`

### **[Solution](../src/main/java/ru/druzhininyy/leetcode/exercises/algorithms/problem0007/Solution.java)**

**Complexity:**

* Time complexity: `O(1)`.
* Additional memory complexity: `O(1)`.
* Input memory complexity: `O(1)`.
* Output memory complexity: `O(1)`.