# Trapping Rain Water

## Platform
LeetCode

## Difficulty
Hard

## Pattern
Two Pointers

## Main Idea

Think of the array as walls. Water at an index depends on the tallest wall on the left and the tallest wall on the right.

```text
water = min(leftMax, rightMax) - currentHeight
```

Water can only rise up to the shorter boundary because both sides are needed to hold the water.

Example:

```text
height = [4,2,0,3,2,5]
```

At index `2`:

```text
leftMax  = 4
rightMax = 5
current  = 0

water = min(4,5) - 0
      = 4
```

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

- `left` → pointer starting at index `0`
- `right` → pointer starting at the last index
- `leftMax` → tallest wall found from the left
- `rightMax` → tallest wall found from the right
- `water` → total amount of trapped water

## How the Two Pointers Work

Start with both ends:

```text
height = [4,2,0,3,2,5]
          ↑         ↑
         left      right
```

Compare the two current heights.

```text
height[left] < height[right]
```

If the left height is smaller, process the left side. The right side already has a boundary at least as high as the current left height, so `leftMax` is enough to determine the water for that position.

Otherwise, process the right side using `rightMax`.

## Dry Run

Input:

```text
height = [4,2,0,3,2,5]
```

Initial:

```text
left = 0
right = 5
leftMax = 0
rightMax = 0
water = 0
```

### Step 1

```text
left height = 4
right height = 5
```

Since `4 < 5`, process left.

```text
4 >= leftMax(0)
```

So:

```text
leftMax = 4
water = 0
left++
```

### Step 2

```text
left height = 2
right height = 5
```

Since `2 < 5`, process left.

```text
leftMax = 4
current = 2
```

Water:

```text
4 - 2 = 2
```

```text
water = 2
left++
```

### Step 3

```text
left height = 0
right height = 5
```

Process left.

```text
water += 4 - 0
water = 6
left++
```

### Step 4

```text
left height = 3
right height = 5
```

Process left.

```text
water += 4 - 3
water = 7
left++
```

### Step 5

```text
left height = 2
right height = 5
```

Process left.

```text
water += 4 - 2
water = 9
```

Now the pointers meet, so the loop stops.

## Final Answer

```text
9
```

The trapped water at the individual positions is:

```text
index:  0 1 2 3 4 5
water: [0,2,4,1,2,0]
```

Total:

```text
2 + 4 + 1 + 2 = 9
```

## Why Move the Smaller Side?

This is the key Two Pointers idea.

If:

```text
height[left] < height[right]
```

the left side is the limiting boundary. The right side is already tall enough, so we can safely calculate water for the left position using `leftMax` and move `left`.

If:

```text
height[right] <= height[left]
```

do the same thing from the right using `rightMax` and move `right`.

## Compare With Container With Most Water

### Container With Most Water

```text
area = width × min(leftHeight, rightHeight)
```

Move the shorter pointer.

### Trapping Rain Water

```text
water = min(leftMax, rightMax) - currentHeight
```

Track the maximum wall from both sides and process the smaller current side.

## Complexity

- Time: `O(n)`
- Extra Space: `O(1)`

## Memory Trick

```text
Trapping Rain Water

Two Pointers
      ↓
leftMax + rightMax
      ↓
smaller side is processed
      ↓
maximum boundary - current height
      ↓
add water
```
