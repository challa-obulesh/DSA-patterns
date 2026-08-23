# Two Sum II - Input Array Is Sorted

## Platform
LeetCode

## Difficulty
Medium

## Pattern
Two Pointers

## Problem
Given a sorted array, find two numbers whose sum equals the target and return their 1-indexed positions.

## Key Idea
Because the array is sorted, use two pointers:

```text
left  -> beginning
right -> end
```

Calculate:

```text
numbers[left] + numbers[right]
```

Then:

```text
sum == target -> answer found
sum < target  -> left++
sum > target  -> right--
```

## Why It Works
The array is sorted.

- Moving `left` to the right increases the sum.
- Moving `right` to the left decreases the sum.

## Example
```text
numbers = [2, 7, 11, 15]
target = 9
```

Start:

```text
2 + 15 = 17 -> too large -> right--
2 + 11 = 13 -> too large -> right--
2 + 7  = 9  -> found
```

The zero-based indices are `0` and `1`, but the problem requires 1-indexed positions, so return:

```java
new int[]{left + 1, right + 1}
```

## Core Logic
```java
int left = 0;
int right = numbers.length - 1;

while (left < right) {
    int sum = numbers[left] + numbers[right];

    if (sum == target) {
        return new int[]{left + 1, right + 1};
    } else if (sum < target) {
        left++;
    } else {
        right--;
    }
}
```

## Complexity
- Time: `O(n)`
- Extra Space: `O(1)`

## What to Remember
When you see:

```text
Sorted array
+ find two values
+ target sum
+ constant extra space
```

Think:

```text
Two Pointers
left = 0
right = last index

sum < target -> left++
sum > target -> right--
sum == target -> return answer
```
