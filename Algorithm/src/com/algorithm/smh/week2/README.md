Island Count
===

Given a string representation of a 2d map, return the number of islands in the map.

Land spaces are denoted by a zero.
Water is denoted by a dot.
Rows are denoted by newlines ('\n').
Two land spaces are considered connected if they are adjacent (horizontal or vertical, but not diagonal).
Too easy? Try solving it without recursion..

### Example:
You may be given the string ".0...\n.00..\n....0" as input.

This correlates to a grid, like this:

.0...
.00..
....0

This would be an example of a map that contains two islands; one with 3 pieces of land, one with 1 piece of land.

### More example:
This is 5 islands:

0...0
..0..
0...0

This is 3 islands:

..000.
..000.
..000.
.0....
..000.