행렬의 곱셈
===
### 문제 설명

2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.

### 제한 조건
+ 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
+ 행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
+ 곱할 수 있는 배열만 주어집니다.

### 입출력 예
|arr1|	arr2|	return|
|---|---|---|
|[[1, 4], [3, 2], [4, 1]]|	[[3, 3], [3, 3]]|	[[15, 15], [15, 15], [15, 15]]|
|[[2, 3, 2], [4, 2, 4], [3, 1, 4]]|	[[5, 4, 3], [2, 4, 1], [3, 1, 1]]|	[[22, 22, 11], [36, 28, 18], [29, 20, 14]]|

<br/><br/><br/><br/>


N으로 표현
===
### 문제 설명

아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.
```
12 = 5 + 5 + (5 / 5) + (5 / 5)
12 = 55 / 5 + 5 / 5
12 = (55 + 5) / 5
```
5를 사용한 횟수는 각각 6,5,4 입니다. 그리고 이중 가장 작은 경우는 4입니다.

이처럼 숫자 N과 number가 주어질 때, N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 return 하도록 solution 함수를 작성하세요.

### 제한사항
+ N은 1 이상 9 이하입니다.
+ number는 1 이상 32,000 이하입니다.
+ 수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시합니다.
+ 최솟값이 8보다 크면 -1을 return 합니다.

### 입출력 예
|N	|number|	return|
|---|---|---|
|5	|12	|4|
|2	|11| 3|

### 입출력 예 설명
#### 예제 #1
+ 문제에 나온 예와 같습니다.

#### 예제 #2
+ 11 = 22 / 2와 같이 2를 3번만 사용하여 표현할 수 있습니다.