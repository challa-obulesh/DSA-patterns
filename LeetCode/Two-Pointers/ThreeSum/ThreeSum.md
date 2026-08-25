# 3Sum

## Platform
LeetCode

## Difficulty
Medium

## Pattern
Sorting + Two Pointers + Duplicate Handling

## Key Idea

```text
Sort the array
    ↓
Fix one number nums[i]
    ↓
Use left and right pointers
    ↓
Find nums[i] + nums[left] + nums[right] == 0
    ↓
Skip duplicates
```

## Pointer Rules

```text
sum == 0 → save triplet and move both pointers
sum < 0  → left++ to get a bigger sum
sum > 0  → right-- to get a smaller sum
```

## Avoiding Duplicates
Skip duplicate fixed values:

```java
if (i > 0 && nums[i] == nums[i - 1]) {
    continue;
}
```

After finding a triplet, move both pointers and skip duplicate left and right values.

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

- Time: `O(n²)`
- Extra Space: `O(1)` excluding output

## What to Remember

```text
3Sum
 ↓
SORT
 ↓
Fix one element
 ↓
Two Pointers on remaining elements
 ↓
Skip duplicates
```
