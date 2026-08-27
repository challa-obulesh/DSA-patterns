# Trapping Rain Water

## Platform
LeetCode

## Difficulty
Hard

## Pattern
Two Pointers + Left Maximum + Right Maximum

## Main Idea

Water trapped at a position is:

```text
min(leftMax, rightMax) - currentHeight
```

The optimal solution uses two pointers and processes the side with the smaller current height.

## Optimal Java Solution

```java
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }
}
```

## Variables

- `left` → starts from index `0`
- `right` → starts from the last index
- `leftMax` → tallest wall seen from the left
- `rightMax` → tallest wall seen from the right
- `water` → total trapped water

## Dry Run

```text
height = [4,2,0,3,2,5]
```

### Step 1

```text
left = 0, right = 5
heights = 4 and 5
4 < 5 → process left
leftMax = 4
water = 0
left++
```

### Step 2

```text
left = 1, right = 5
height[left] = 2
leftMax = 4

water += 4 - 2 = 2
water = 2
left++
```

### Step 3

```text
left = 2, right = 5
height[left] = 0

water += 4 - 0 = 4
water = 6
left++
```

### Step 4

```text
left = 3, right = 5
height[left] = 3

water += 4 - 3 = 1
water = 7
left++
```

### Step 5

```text
left = 4, right = 5
height[left] = 2

water += 4 - 2 = 2
water = 9
```

## Final Answer

```text
9
```

## Why Process the Smaller Side?

If `height[left] < height[right]`, the right side is guaranteed to have a boundary at least as high as the current left height. Therefore, the trapped water on the left can be determined using `leftMax`.

If the right height is smaller or equal, process the right side using `rightMax`.

## Complexity

- Time: `O(n)`
- Extra Space: `O(1)`

## Memory Trick

```text
Two Pointers
      +
leftMax and rightMax
      ↓
Process the smaller side
      ↓
Add trapped water
```
