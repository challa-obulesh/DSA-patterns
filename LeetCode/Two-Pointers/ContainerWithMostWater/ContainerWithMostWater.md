# Container With Most Water

## Platform
LeetCode

## Difficulty
Medium

## Pattern
Two Pointers

## Java Code

```java
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int area = width * currentHeight;

            maxWater = Math.max(maxWater, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
```

## Key Formula

```text
area = (right - left) × min(height[left], height[right])
```

- Width = `right - left`
- The shorter line determines the water height.

## Code Explanation

### Start Two Pointers

```java
int left = 0;
int right = height.length - 1;
```

Start from both ends of the array.

### Calculate Width

```java
int width = right - left;
```

The width is the distance between the two selected lines.

### Find Limiting Height

```java
int currentHeight = Math.min(height[left], height[right]);
```

Water cannot be higher than the shorter line.

### Calculate Area

```java
int area = width * currentHeight;
```

### Store Maximum Area

```java
maxWater = Math.max(maxWater, area);
```

### Move the Shorter Pointer

```java
if (height[left] < height[right]) {
    left++;
} else {
    right--;
}
```

The shorter line limits the water. Move the shorter pointer hoping to find a taller line. Moving the taller pointer only reduces the width while the shorter line remains the bottleneck.

## Full Dry Run

```text
height = [1,8,6,2,5,4,8,3,7]
index    0 1 2 3 4 5 6 7 8
```

### Step 1

```text
left = 0, right = 8
heights = 1 and 7
width = 8 - 0 = 8
minHeight = 1
area = 8 × 1 = 8
maxWater = 8
```

Since `1 < 7`, move `left++`.

### Step 2

```text
left = 1, right = 8
heights = 8 and 7
width = 8 - 1 = 7
minHeight = 7
area = 7 × 7 = 49
maxWater = 49
```

Since `8 > 7`, move `right--`.

### Step 3

```text
left = 1, right = 7
heights = 8 and 3
width = 7 - 1 = 6
minHeight = 3
area = 6 × 3 = 18
maxWater = 49
```

Move `right--`.

### Step 4

```text
left = 1, right = 6
heights = 8 and 8
width = 6 - 1 = 5
minHeight = 8
area = 5 × 8 = 40
maxWater = 49
```

The code moves `right--` when heights are equal.

### Remaining Steps

| left | right | heights | width | min height | area | max |
|---|---|---|---:|---:|---:|---:|
| 1 | 5 | 8, 4 | 4 | 4 | 16 | 49 |
| 1 | 4 | 8, 5 | 3 | 5 | 15 | 49 |
| 1 | 3 | 8, 2 | 2 | 2 | 4 | 49 |
| 1 | 2 | 8, 6 | 1 | 6 | 6 | 49 |

When `left == right`, the loop stops.

## Final Answer

```text
49
```

The maximum container uses:

```text
height[1] = 8
height[8] = 7

width = 8 - 1 = 7
water height = min(8, 7) = 7
area = 7 × 7 = 49
```

## Complexity

- Time: `O(n)`
- Extra Space: `O(1)`

## What to Remember

```text
Start from both ends
        ↓
width = right - left
        ↓
height = min(left height, right height)
        ↓
area = width × height
        ↓
Track maximum
        ↓
Move the shorter pointer
```
