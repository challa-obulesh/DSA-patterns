# Isomorphic Strings

## Pattern
Hash Table / One-to-One Mapping

## Key Idea
Two strings are isomorphic when every character in `s` maps to exactly one character in `t`, while two different characters cannot map to the same character.

## Approach
1. Create two HashMaps.
2. `mapST` stores the mapping from `s` to `t`.
3. `mapTS` stores the reverse mapping from `t` to `s`.
4. Traverse both strings together.
5. If an existing mapping conflicts, return `false`.
6. Otherwise, store the mapping and continue.

## Example
`s = "egg"`, `t = "add"`

- `e -> a`
- `g -> d`
- `g -> d`

Result: `true`

Invalid example: `s = "ab"`, `t = "aa"`

- `a -> a`
- `b -> a`

Two different characters map to the same character, so the result is `false`.

## Java Code
```java
import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (mapST.containsKey(a) && mapST.get(a) != b) {
                return false;
            }

            if (mapTS.containsKey(b) && mapTS.get(b) != a) {
                return false;
            }

            mapST.put(a, b);
            mapTS.put(b, a);
        }

        return true;
    }
}
```

## Complexity
- Time: `O(n)`
- Space: `O(n)`

## What to Remember
For a one-to-one character mapping problem, check both directions:

`source -> target`

`target -> source`
