# Plus Minus

## Platform
HackerRank

## Pattern
Array Traversal + Counting

## Approach

Count three categories while traversing the array:

- Positive numbers
- Negative numbers
- Zero values

Then divide each count by the total number of elements.

## Core Logic

```java
for (int num : arr) {
    if (num > 0) {
        positive++;
    } else if (num < 0) {
        negative++;
    } else {
        zero++;
    }
}
```

## Important Concept

Use `double` when calculating ratios:

```java
(double) positive / n
```

This avoids integer division.

## Output

```java
System.out.printf("%.6f%n", value);
```

This prints exactly six digits after the decimal point.

## Complexity

- Time: `O(n)`
- Extra Space: `O(1)`

## What to Remember

```text
Traverse array
    ↓
Count categories
    ↓
Divide count by total
    ↓
Use double
    ↓
Print with 6 decimal places
```
