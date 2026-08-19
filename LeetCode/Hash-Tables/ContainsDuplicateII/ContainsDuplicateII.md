# Contains Duplicate II

## Platform
LeetCode

## Difficulty
Easy

## Pattern
Hash Table / Value to Index Mapping

## Problem
Given an integer array `nums` and an integer `k`, return `true` if there are two distinct indices `i` and `j` such that:

```text
nums[i] == nums[j]
```

and:

```text
abs(i - j) <= k
```

## Key Idea
Use a `HashMap` to store:

```text
number -> latest index
```

When the same number appears again, compare the current index with its previous index.

```text
currentIndex - previousIndex <= k
```

If true, return `true`.

## Approach
1. Create a `HashMap<Integer, Integer>`.
2. Traverse the array.
3. If the current number already exists in the map, get its previous index.
4. Check whether the distance between the two indices is less than or equal to `k`.
5. If yes, return `true`.
6. Update the number with its latest index.
7. If no valid pair is found, return `false`.

## Java Logic
```java
HashMap<Integer, Integer> map = new HashMap<>();

for (int i = 0; i < nums.length; i++) {
    if (map.containsKey(nums[i])) {
        int previousIndex = map.get(nums[i]);

        if (i - previousIndex <= k) {
            return true;
        }
    }

    map.put(nums[i], i);
}
```

## Why Store the Latest Index?
Updating the index keeps the closest previous occurrence available for future comparisons.

## Complexity
- Time: `O(n)`
- Space: `O(n)`

## What to Remember
For problems involving duplicates and index distance:

```text
HashMap
value -> index
```

Then check:

```text
currentIndex - previousIndex <= k
```
