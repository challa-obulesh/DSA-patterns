# Longest Consecutive Sequence

## Platform
LeetCode

## Difficulty
Medium

## Pattern
HashSet / Consecutive Sequence Detection

## Problem
Given an unsorted array of integers, find the length of the longest sequence of consecutive numbers.

Example:
```text
[100, 4, 200, 1, 3, 2]
```

Longest sequence:
```text
[1, 2, 3, 4]
```

Answer:
```text
4
```

## Key Idea
Use a `HashSet` for O(1) average lookup.

Only start counting when a number is the beginning of a sequence:

```text
num - 1 does not exist
```

Then continue checking:

```text
num + 1
num + 2
num + 3
...
```

## Approach
1. Add all numbers to a `HashSet`.
2. For every number, check whether `num - 1` exists.
3. If it exists, this number is not the start of a sequence, so skip it.
4. If it does not exist, start counting the consecutive sequence.
5. Keep checking for `currentNum + 1`.
6. Track the maximum sequence length.

## Core Logic
```java
if (!set.contains(num - 1)) {
    int currentNum = num;
    int currentLength = 1;

    while (set.contains(currentNum + 1)) {
        currentNum++;
        currentLength++;
    }

    longest = Math.max(longest, currentLength);
}
```

## Why Is It O(n)?
Each number is effectively processed as part of a sequence only when its sequence start is found. HashSet lookups take O(1) average time.

## Complexity
- Time: `O(n)` average
- Space: `O(n)`

## What to Remember
When you see:

```text
Unsorted array
+ consecutive numbers
+ O(n) requirement
```

Think:

```text
HashSet
    ↓
Find sequence start
(num - 1 does not exist)
    ↓
Keep checking num + 1
    ↓
Track maximum length
```
