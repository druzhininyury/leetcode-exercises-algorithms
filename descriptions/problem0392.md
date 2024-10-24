## 392. Is Subsequence

Given two strings `s` and `t`, return true if `s` is a **subsequence** of `t`, or `false` _otherwise_.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., `"ace"` is a subsequence of `"abcde"` while `"aec"` is not).

### **Example 1:**
> Input: `s = "abc"`, `t = "ahbgdc"`  
> Output: `true`

### **Example 2:**
> Input: `s = "axc"`, `t = "ahbgdc"`  
> Output: `false`

### **Constraints:**
* `0 <= s.length <= 100`
* `0 <= t.length <= 10^4`
* `s` and `t` consist only of lowercase English letters.

### **[Solution](../src/main/java/ru/druzhininyy/leetcode/exercises/algorithms/problem0392/Solution.java)**

**Complexity:** `n` - length of `sub`, `m` - length of `str`

* Time complexity: `O(n)`.
* Additional memory complexity: `O(1)`.
* Input memory complexity: `O(n + m)`.
* Output memory complexity: `O(1)`.