## 11. Container With Most Water

You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `i-th` line are `(i, 0)` and `(i, height[i])`.

Find two lines that together with the x-axis form a container, such that the container contains the most water.

_Return the maximum amount of water a container can store._

**Notice** that you may not slant the container.

### **Example 1:**
> Input: `heights = [1,8,6,2,5,4,8,3,7]`  
> Output: `49`  
> Explanation: The above vertical lines are represented by array `[1,8,6,2,5,4,8,3,7]`. In this case, the max area of water (blue section) the container can contain is `49`.

### **Example 2:**
> Input: `heights = [1,1]`  
> Output: `1`  

### **Constraints:**
* `2 <= heights.length <= 10^5`
* `0 <= heights[i] <= 10^4`

### **[Solution](../src/main/java/ru/druzhininyy/leetcode/exercises/algorithms/problem0011/Solution.java)**

**Complexity:** `n` - heights length

* Time complexity: `O(n)`.
* Additional memory complexity: `O(1)`.
* Input memory complexity: `O(n)`.
* Output memory complexity: `O(1)`.

**Notes:**

Let `leftIdx` and `rightIdx` points some elements in `heights`, and `leftIdx < rightIdx`. Let `maxArea` store some integer.

**Invariant:** `maxArea` stores maximum area between any positions `i` and `j` where `i <= leftIdx` and `j >= rightIdx`.

**Step:** move the pointer (`leftIdx` or `rightIdx`) with lower height toward another pointer.