# Diagonal Difference

## Platform
HackerRank

## Pattern
Matrix Traversal

## Problem
Given a square matrix, calculate the absolute difference between the sums of its two diagonals.

## Diagonal Patterns
Primary diagonal:

```text
arr[i][i]
```

Secondary diagonal:

```text
arr[i][n - 1 - i]
```

## Example
```text
11   2   4
 4   5   6
10   8  -12
```

Primary diagonal:

```text
11 + 5 + (-12) = 4
```

Secondary diagonal:

```text
4 + 5 + 10 = 19
```

Absolute difference:

```text
|4 - 19| = 15
```

## Approach
1. Initialize `primarySum` and `secondarySum` to `0`.
2. Get the matrix size `n`.
3. Loop from `0` to `n - 1`.
4. Add `arr[i][i]` to the primary diagonal sum.
5. Add `arr[i][n - 1 - i]` to the secondary diagonal sum.
6. Return the absolute difference using `Math.abs()`.

## Core Logic
```java
for (int i = 0; i < n; i++) {
    primarySum += arr.get(i).get(i);
    secondarySum += arr.get(i).get(n - 1 - i);
}

return Math.abs(primarySum - secondarySum);
```

## Complexity
- Time: `O(n)`
- Extra Space: `O(1)`

## What to Remember
```text
Primary diagonal   -> arr[i][i]
Secondary diagonal -> arr[i][n - 1 - i]
```
