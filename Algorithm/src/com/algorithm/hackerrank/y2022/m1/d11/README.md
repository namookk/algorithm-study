
## Mean, Median, and Mode

### Task

Given an array, **X**, of **N** integers, calculate and print the respective mean, median, and mode on separate lines. If your array contains more than one modal value, choose the numerically smallest one.

**Note**: Other than the modal value (which will always be an integer), your answers should be in decimal form, rounded to a scale of decimal place (i.e., ,  format).

### Example
**N = 6**  
**X = [1,2,3,4,5,5]**  
The mean is **20/6 = 3.3**  
The median is **(3+4)/2 = 3.5**  
The mode is **5** because **5** occurs most frequently.

### Input Format
The first line contains an integer, **N** , the number of elements in the array.
The second line contains **N** space-separated integers that describe the array's elements.

### Constraints
+ 10 <= N <= 2,500
+ 0 < x[i] <= 100,000 where x[i] is the  element of the array.

### Output Format
Print **3**  lines of output in the following order:
1. Print the mean on the first line to a scale of  decimal place (i.e., , ).
2. Print the median on a new line, to a scale of  decimal place (i.e., , ).
3. Print the mode on a new line. If more than one such value exists, print the numerically smallest one.

### Sample Input
```
10
64630 11735 14216 99233 14470 4978 73429 38120 51135 67060
```

### Sample Output
```
43900.6
44627.5
4978
```


