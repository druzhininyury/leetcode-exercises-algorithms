## 345. Reverse Vowels of a String

Given a string `str`, reverse only all the vowels in the string and return it.

The vowels are `'a'`, `'e'`, `'i'`, `'o'`, and `'u'`, and they can appear in both lower and upper cases, more than once.

### **Example 1:**
> Input: `str = "IceCreAm"`  
> Output: `"AceCreIm"`  
> Explanation: The vowels in s are `['I', 'e', 'e', 'A']`. On reversing the vowels, `str` becomes `"AceCreIm"`.

### **Example 2:**
> Input: `str = "leetcode"`  
> Output: `"leotcede"`

### **Constraints:**
* `1 <= str.length <= 3 * 105`
* `str` consist of **printable ASCII** characters.
*
*

### **[Solution](../src/main/java/ru/druzhininyy/leetcode/exercises/algorithms/problem0345/Solution.java)**

**Complexity:** `n` - length of `str`

* Time complexity: `O(n)`.
* Additional memory complexity: `O(1)`.
* Input memory complexity: `O(n)`.
* Output memory complexity: `O(n)`.