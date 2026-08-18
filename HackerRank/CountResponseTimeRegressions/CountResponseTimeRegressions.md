# Count Elements Greater Than Previous Average

## Platform
HackerRank

## Problem
Given an array of positive integers, return the number of elements that are strictly greater than the average of all previous elements. The first element is skipped because it has no previous elements.

### Example
Input:
```
[100, 200, 150, 300]
```

Output:
```
2
```

## Pattern
Running Sum / Prefix Sum

## Key Idea
Maintain the sum of all previous elements.

For index `i`, there are `i` previous elements, so:

```
previousAverage = sum / i
```

We need to check:

```
current > sum / i
```

To avoid division and floating-point precision issues, multiply both sides by `i`:

```
current * i > sum
```

## Approach
1. If the array contains zero or one element, return `0`.
2. Initialize `sum` with the first element.
3. Start from index `1`.
4. Check whether `responseTimes[i] * i > sum`.
5. If true, increment the count.
6. Add the current element to `sum`.
7. Return the count.

## Java Logic
```java
long sum = responseTimes.get(0);

for (int i = 1; i < responseTimes.size(); i++) {
    if ((long) responseTimes.get(i) * i > sum) {
        count++;
    }
    sum += responseTimes.get(i);
}
```

## Complexity
- Time: `O(n)`
- Extra Space: `O(1)`

## What to Remember
When a problem compares the current element with the average of previous elements:

```
current > sum / count
```

Avoid division by rewriting it as:

```
current * count > sum
```

Also use `long` for the running sum because the sum can exceed the range of `int`.
