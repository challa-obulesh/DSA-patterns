# Encode and Decode TinyURL

## Platform
LeetCode

## Difficulty
Medium

## Pattern
HashMap + Unique ID Generation

## Problem
Design a system that converts a long URL into a short URL and can later recover the original URL from the short URL.

## Key Idea
Generate a unique integer ID for each long URL and store the mapping:

```text
ID -> Original URL
```

For example:

```text
0 -> https://leetcode.com/problems/design-tinyurl
```

The encoded URL becomes:

```text
http://tinyurl.com/0
```

During decoding, extract the ID and use it to retrieve the original URL from the HashMap.

## Approach
1. Maintain a HashMap from integer ID to long URL.
2. Maintain an incrementing ID counter.
3. During `encode`, store the URL using the current ID.
4. Return the base TinyURL plus the ID.
5. Increment the ID for the next URL.
6. During `decode`, extract the ID from the short URL.
7. Return the corresponding long URL from the HashMap.

## Java Logic
```java
map.put(id, longUrl);
String shortUrl = "http://tinyurl.com/" + id;
id++;
```

Decode:

```java
int id = Integer.parseInt(
    shortUrl.replace("http://tinyurl.com/", "")
);

return map.get(id);
```

## Dry Run
Encode:

```text
Long URL
   ↓
id = 0
   ↓
HashMap: 0 -> Long URL
   ↓
Short URL: http://tinyurl.com/0
```

Decode:

```text
http://tinyurl.com/0
        ↓
Extract 0
        ↓
map.get(0)
        ↓
Original Long URL
```

## Complexity
- Encode: `O(1)` average time
- Decode: `O(1)` average time
- Space: `O(n)`

## What to Remember
A common design pattern is:

```text
Generate Unique ID
        ↓
Store ID -> Data
        ↓
Return Short Identifier
        ↓
Extract ID
        ↓
Retrieve Original Data
```
