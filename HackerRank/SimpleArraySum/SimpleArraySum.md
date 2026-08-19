# Simple Array Sum

## Platform
HackerRank

## Problem
Given an array of integers, find and return the sum of all its elements.

### Example
Input:
```text
[1, 2, 3, 4, 10, 11]
```

Output:
```text
31
```

## Pattern
Array Traversal + Running Sum

## Key Idea
Traverse the list one element at a time and keep adding each element to a running sum.

## Approach
1. Initialize `sum = 0`.
2. Loop through every element in the list.
3. Add the current element to `sum`.
4. Return `sum` after the loop.

## Java Code Logic
```java
int sum = 0;

for (int i = 0; i < ar.size(); i++) {
    sum += ar.get(i);
}

return sum;
```

## Important: Array vs List in Java
For an array:
```java
arr.length
arr[i]
```

For `List<Integer>`:
```java
ar.size()
ar.get(i)
```

## Complexity
- Time: `O(n)`
- Extra Space: `O(1)`

## What to Remember
This is the basic running sum pattern:

```text
sum = sum + currentElement
```

or:

```java
sum += currentElement;
```
