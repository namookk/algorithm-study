Quartiles
===

### Task
Given an array, **arr** , of **n** integers, calculate the respective first quartile (**Q1**), second quartile (**Q2**), and third quartile (**Q3**). 

### Example
**arr = [9,5,7,1,3]**  
The sorted array is **[1,3,5,7,9]** which has an odd number of elements. The lower half consists of **[1,3]**, and its median is **1+3 / 2 = 2**. The middle element is **5** and represents the second quartile. The upper half is **[5,7]** and its median is **5+7 / 2 = 8**. Return **[2,5,8]**.

### Function Description
Complete the quartiles function in the editor below.  
quartiles has the following parameters:  
+ int arr[n]: the values to segregate

### Returns
+ int[3]: the medians of the left half of ,  in total, and the right half of .

### Constraints
+ 5 <= 5 <= 50
+ 0 < arr[i] < 100

### Sample Input
```
STDIN                   Function
-----                   --------    
9                       arr[] size n = 9
3 7 8 5 12 14 21 13 18  arr = [3, 7, 8, 5, 12, 14, 21, 13,18]
```

### Sample Output
```
6
12
16
```