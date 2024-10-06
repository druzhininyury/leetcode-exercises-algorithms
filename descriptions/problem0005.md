## 5. Longest Palindromic Substring

Given a string `str`, return the _longest palindromic substring_ in `str`.
### **Example 1:**
> Input: `str = "babad"`  
> Output: `bab`  
> Explanation: `"aba"` is also a valid answer.

### **Example 2:**
> Input: `str = "cbbd"`  
> Output: `bb`  

### **Constraints:**
* `1 <= s.length <= 1000`
* `str` consist of only digits and English letters.

### **[Solution](../src/main/java/ru/druzhininyy/leetcode/exercises/algorithms/problem0005/Solution.java)**

Natural solution:  
* Time complexity: `O(n^2)`, `n` - str length.  
* Memory complexity: `O(1)`. 


  Fast solution:
* Time complexity: `O(n)`, `n` - str length.
* Memory complexity: `O(n)`, `n` - str length.