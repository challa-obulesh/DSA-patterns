# Container With Most Water

## Platform
LeetCode

## Difficulty
Medium

## Pattern
Two Pointers

## Key Formula

```text
area = (right - left) × min(height[left], height[right])
```

- Width = `right - left`
- Water height is limited by the shorter line.

## Approach

1. Start with `left = 0` and `right = height.length - 1`.
2. Calculate the current area.
3. Update the maximum area.
4. Move the pointer with the smaller height inward.
5. Continue until `left >= right`.

## Why Move the Shorter Pointer?

The shorter line limits the amount of water. Moving the taller line cannot increase the limiting height while the shorter line remains. Move the shorter pointer and hope to find a taller line.

```text
height[left] < height[right] → left++
otherwise                    → right--
```

## Dry Run

```text
height = [1,8,6,2,5,4,8,3,7]
```

| left | right | heights | area | max |
|---|---|---|---|---|
| 0 | 8 | 1, 7 | 8 | 8 |
| 1 | 8 | 8, 7 | 49 | 49 |
| 1 | 7 | 8, 3 | 18 | 49 |
| 1 | 6 | 8, 8 | 40 | 49 |

Maximum area:

```text
width = 8 - 1 = 7
height = min(8, 7) = 7
area = 7 × 7 = 49
```

## Complexity

- Time: `O(n)`
- Extra Space: `O(1)`

## What to Remember

```text
Two boundaries
    ↓
width × minimum height
    ↓
Move the shorter pointer
    ↓
Track maximum area
```
