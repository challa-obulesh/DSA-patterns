# 3Sum

## Platform
LeetCode

## Difficulty
Medium

## Pattern
Sorting + Two Pointers + Duplicate Handling

## Optimal Approach

The brute-force approach checks every triplet and takes `O(n^3)` time.

The optimal standard approach is:

```text
Sort
 ↓
Fix one element
 ↓
Use Two Pointers for the remaining elements
 ↓
Skip duplicates
```

This reduces the time complexity to `O(n^2)`.

## Pointer Rules

```text
sum == 0 → save triplet, move both pointers, skip duplicates
sum < 0  → left++ to get a bigger sum
sum > 0  → right-- to get a smaller sum
```

## Avoiding Duplicates

Skip duplicate fixed elements:

```java
if (i > 0 && nums[i] == nums[i - 1]) {
    continue;
}
```

After finding a valid triplet, move both pointers and skip duplicate values.

## Example

```text
nums = [-1, 0, 1, 2, -1, -4]
```

After sorting:

```text
[-4, -1, -1, 0, 1, 2]
```

Valid triplets:

```text
[-1, -1, 2]
[-1, 0, 1]
```

## Complexity

```text
Brute Force → O(n^3) ❌
Optimal     → O(n^2) ✅
```

- Time: `O(n²)`
- Extra Space: `O(1)` excluding output and sorting implementation details

## What to Remember

```text
3Sum
 ↓
SORT
 ↓
Fix nums[i]
 ↓
left = i + 1
right = last index
 ↓
sum < 0 → left++
sum > 0 → right--
sum == 0 → save + skip duplicates
```
