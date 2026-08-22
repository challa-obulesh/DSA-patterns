# A Very Big Sum

## Platform
HackerRank

## Pattern
Array/List Traversal + Running Sum

## Problem
Given an array of large integers, return the sum of all elements.

The important point is that the final sum may exceed the range of Java `int`.

## Key Idea
Use `long` instead of `int` for both the list values and the running sum.

```java
List<Long> ar
long sum = 0;
```

## Approach
1. Initialize `sum` to `0` using `long`.
2. Traverse every element in the list.
3. Add the current value to `sum`.
4. Return `sum`.

## Core Logic
```java
long sum = 0;

for (int i = 0; i < ar.size(); i++) {
    sum += ar.get(i);
}

return sum;
```

## Example
```text
1000000001 + 1000000002 + 1000000003 + 1000000004 + 1000000005
= 5000000015
```

This value is larger than the maximum value supported by a Java `int`, so `long` is required.

## Complexity
- Time: `O(n)`
- Extra Space: `O(1)`

## What to Remember
If a problem says that values or their sum can become very large, check whether `int` is sufficient.

```text
Normal values → int may be enough
Large sum     → use long
```
