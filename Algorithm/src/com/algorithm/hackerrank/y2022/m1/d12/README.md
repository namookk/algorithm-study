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


<br/><br/><br/><br/>

Interquartile Range
===

### Task

The interquartile range of an array is the difference between its first (**Q1**) and third (**Q3**) quartiles (i.e., **Q3 - Q1** ).
Given an array,**values**, of **n** integers and an array,**freqs** , representing the respective frequencies of **values**'s elements, construct a data set,**S** , where each **values[i]** occurs at frequency **freqs[i]**. Then calculate and print **S**'s interquartile range, rounded to a scale of **1** decimal place (i.e., format).

### Example
**values = [1,2,3]**  
**freqs = [3,2,1]**  
Apply the frequencies to the values to get the expanded array  
**S =[1,1,1,2,2,3]**. Here **left=[1,1,1], right = [2,2,3]**. The median of the left half,**Q1 = 1.0** , the middle element. For the right half, **Q3 = 2.0** . Print the difference to one decimal place: **Q3 - Q1 = 2.0 - 1.0 = 1** , so print **1.0**.

### Constraints
+ 5 <= n <= 50
+ 0 < values[i] <= 100

### Sample Input
```
STDIN           Function
-----           --------
6               arrays size n = 6
6 12 8 10 20 16 values = [6, 12, 8, 10, 20, 16]
5 4 3 2 1 5     freqs = [5, 4, 3, 2, 1, 5]
```

### Sample Output
```
9.0
```