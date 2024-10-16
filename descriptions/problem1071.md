## 1071. Greatest Common Divisor of Strings

For two strings `s` and `t`, we say "`t` divides `s`" if and only if `s = t + t + t + ... + t + t` (i.e., `t` is concatenated with itself one or more times).

Given two strings `str1` and `str2`, return the largest string `x` such that `x` divides both `str1` and `str2`.

### **Example 1:**
> Input: `str1 = "ABCABC"`, `str2 = "ABC"`  
> Output: `"ABC"`

### **Example 2:**
> Input: `str1 = "ABABAB"`, `str2 = "ABAB"`  
> Output: `"AB"`

### **Example 3:**
> Input: `str1 = "LEET"`, `str2 = "CODE"`  
> Output: `""`

### **Constraints:**
* `1 <= str1.length, str2.length <= 1000`
* `str1` and `str2` consist of English uppercase letters.

### **[Solution](../src/main/java/ru/druzhininyy/leetcode/exercises/algorithms/problem1071/Solution.java)**

### Notes to solution:

(gcd - greates common divisor, lcm - less common multiple)

Strings `p` and `q` have common divider iff `p + q = q + p`. Necessity is obvious. Let's prove sufficiency. We can assume `len p >= len q`. Let `d = gcd(len p, len q)`, than `p = xx...x` (`x` repeats `M` times) and `q = yy...y` (`y` repeats `L` times), where `x` is string of length `d` and different `x` means different substrings.

Due to `p + q = q + p`:
```
                       ↓    ↓     ↓
s := p + q + p + ... = xxxxxyyy xxxxxyyyxxxxxxyyy
r := q + p + q + ... = yyyxxxxx yyyxxxxxyyyxxxxxx
                       ↑    ↑     ↑
```
we have `s[0] = r[0] = s[M] = r[M] = s[2M] = r[2M] = ...`. As `1 = gcd(M, L) = gcd(M, M + L)`, then `lcm(M, M + L) = M * (M + L)`, so `x` will return to itself after `M + L` jumps, which means `s[0], s[M], s[2M], ..., s[(M + L)M]` are equal numbers on different positions. We obtained that `x = x = ... = x = y = .. = y`. End of proof.

**Complexity:** `n` - length of `str1`, `m` - length of `str2`

* Time complexity: `O(n + m)`: `O(n + m)` for main algorithm and `O(log min{n, m})` for Euclid algorithm.
* Additional memory complexity: `O(1)`.
* Input memory complexity: `O(n + m)`.
* Output memory complexity: `O(min{n, m})`.