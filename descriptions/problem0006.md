## 6. Zigzag Conversion

The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
```
P   A   H   N   
A P L S I I G  
Y   I   R
```
And then read line by line: `"PAHNAPLSIIGYIR"`.

Write the code that will take a string and make this conversion given a number of rows:
```
string convert(string str, int numRows);
```


### **Example 1:**
> Input: `str = "PAYPALISHIRING"`, `numRows = 3`  
> Output: `"PAHNAPLSIIGYIR"`

### **Example 2:**
> Input: `s = "PAYPALISHIRING"`, `numRows = 4`  
> Output: `"PINALSIGYAHRPI"`  
> Expanation:  
```
P     I    N
A   L S  I G
Y A   H R
P     I
```

### **Example 3:**
> Input: `str = "A"`, `numRows = 1`  
> Output: `"A"`

### **Constraints:**
* `1 <= s.length <= 1000`
* `str` consists of English letters (lower-case and upper-case), `','` and `'.'`.
* `1 <= numRows <= 1000`

### **[Solution](../src/main/java/ru/druzhininyy/leetcode/exercises/algorithms/problem0005/Solution.java)**

**Complexity:** `n` - str length

* Time complexity: `O(n)`.
* Additional memory complexity: `O(1)`.
* Input memory complexity: `O(n)`.
* Output memory complexity: `O(n)`.