## 20. Valid Parentheses

Given a string `str` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

### **Example 1:**
> Input: `str = "()"`  
> Output: `true`

### **Example 2:**
> Input: `str = "()[]{}"`  
> Output: `true`

### **Example 3:**
> Input: `str = "(]"`  
> Output: `false`

### **Example 4:**
> Input: `str = "([])"`  
> Output: `true`

### **Constraints:**
* `1 <= str.length <= 10^4`
* `str` consists of parentheses only `'()[]{}'`.

### **[Solution](../src/main/java/ru/druzhininyy/leetcode/exercises/algorithms/problem0020/Solution.java)**

**Complexity:** `n` - `str` length

* Time complexity: `O(n)`.
* Additional memory complexity: `O(n)`.
* Input memory complexity: `O(n)`.
* Output memory complexity: `O(1)`.