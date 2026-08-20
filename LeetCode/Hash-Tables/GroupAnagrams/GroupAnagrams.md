# Group Anagrams

## Platform
LeetCode

## Difficulty
Medium

## Pattern
Hash Table + Sorting

## Problem
Given an array of strings, group together strings that are anagrams of each other.

## Key Idea
Anagrams contain the same characters with the same frequencies. After sorting, all anagrams produce the same string.

Example:

```text
eat -> aet
tea -> aet
ate -> aet
```

Use the sorted string as a key in a `HashMap`:

```text
aet -> [eat, tea, ate]
ant -> [tan, nat]
abt -> [bat]
```

## Approach
1. Create a `HashMap<String, List<String>>`.
2. Traverse each word.
3. Convert the word into a character array.
4. Sort the character array.
5. Convert it back into a string to create the key.
6. Add the original word to the list for that key.
7. Return all values from the map.

## Java Logic
```java
char[] chars = word.toCharArray();
Arrays.sort(chars);

String key = new String(chars);

map.putIfAbsent(key, new ArrayList<>());
map.get(key).add(word);
```

## Important Line
```java
map.putIfAbsent(key, new ArrayList<>());
```

If the key does not exist, create an empty list.

Then:

```java
map.get(key).add(word);
```

adds the original word to its anagram group.

## Complexity
Let `n` be the number of strings and `k` be the maximum string length.

- Time: `O(n * k log k)`
- Space: `O(n * k)`

## What to Remember
For anagram grouping:

```text
Same characters
    ↓
Sort each word
    ↓
Same sorted key
    ↓
HashMap<key, List<String>>
    ↓
Group anagrams
```
