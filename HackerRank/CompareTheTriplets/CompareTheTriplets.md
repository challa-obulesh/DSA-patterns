# Compare the Triplets

## Platform
HackerRank

## Pattern
Array/List Traversal + Comparison

## Problem
Alice and Bob each have three ratings. Compare the values at the same index:

- If `a[i] > b[i]`, Alice gets 1 point.
- If `a[i] < b[i]`, Bob gets 1 point.
- If `a[i] == b[i]`, nobody gets a point.

Return the result as:

```text
[AliceScore, BobScore]
```

## Approach
1. Initialize `aliceScore` and `bobScore` to `0`.
2. Loop through the three positions.
3. Compare `a.get(i)` and `b.get(i)`.
4. Increment the appropriate score.
5. Add both scores to a result list.
6. Return the result.

## Core Logic
```java
for (int i = 0; i < 3; i++) {
    if (a.get(i) > b.get(i)) {
        aliceScore++;
    } else if (a.get(i) < b.get(i)) {
        bobScore++;
    }
}
```

## Complexity
- Time: `O(1)` because there are always 3 comparisons.
- Extra Space: `O(1)`.

## What to Remember
For two arrays/lists with values compared at the same index:

```text
Loop through index
    ↓
Compare a[i] and b[i]
    ↓
Update counters
    ↓
Return result
```
