## 151. Reverse Words in a String

Given an input string `str`, reverse the order of the words.

A **word** is defined as a sequence of non-space characters. The **words** in `str` will be separated by at least one space.

Return _a string of the words in reverse order concatenated by a single space_.

**Note** that `str` may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

### **Example 1:**
> Input: `str= "the sky is blue"`  
> Output: `"blue is sky the"`

### **Example 2:**
> Input: `str= "  hello world  "`  
> Output: `"world hello"`  
> Explanation: Your reversed string should not contain leading or trailing spaces.

### **Example 3:**
> Input: `str= "a good   example"`  
> Output: `"example good a"`  
> Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

### **Constraints:**
* `1 <= str.length <= 10^4`
* `str` contains English letters (upper-case and lower-case), digits, and spaces `' '`.
* There is at least one word in `str`.

### **[Solution](../src/main/java/ru/druzhininyy/leetcode/exercises/algorithms/problem0151/Solution.java)**

**Complexity:** `n` - length of `str`

* Time complexity: `O(n)`.
* Additional memory complexity: `O(1)`.
* Input memory complexity: `O(n)`.
* Output memory complexity: `O(n)`.