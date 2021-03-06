가장 큰 정사각형 찾기
===
### 문제 설명

1와 0로 채워진 표(board)가 있습니다. 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다. 표에서 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요. (단, 정사각형이란 축에 평행한 정사각형을 말합니다.)

예를 들어
```
1	2	3	4
0	1	1	1
1	1	1	1
1	1	1	1
0	0	1	0
```
가 있다면 가장 큰 정사각형은
```
1	2	3	4
0	1	1	1
0	1	1	1
0	1	1	1
0	0	0	0
```

가 되며 넓이는 9가 되므로 9를 반환해 주면 됩니다.

### 제한사항
+ 표(board)는 2차원 배열로 주어집니다.
+ 표(board)의 행(row)의 크기 : 1,000 이하의 자연수
+ 표(board)의 열(column)의 크기 : 1,000 이하의 자연수
+ 표(board)의 값은 1또는 0으로만 이루어져 있습니다.

### 입출력 예
|board	|answer|
|---|---|
|[[0,1,1,1],[1,1,1,1],[1,1,1,1],[0,0,1,0]]|	9|
|[[0,0,1,1],[1,1,1,1]]|	4|

### 입출력 예 설명
#### 입출력 예 #1
+ 위의 예시와 같습니다.

#### 입출력 예 #2
| 0 | 0 | 1 | 1 |
| 0 | 0 | 1 | 1 |

로 가장 큰 정사각형의 넓이는 4가 되므로 4를 return합니다.

<br/><br/><br/><br/>

짝지어 제거하기
===
### 문제 설명

짝지어 제거하기는, 알파벳 소문자로 이루어진 문자열을 가지고 시작합니다. 먼저 문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾습니다. 그다음, 그 둘을 제거한 뒤, 앞뒤로 문자열을 이어 붙입니다. 이 과정을 반복해서 문자열을 모두 제거한다면 짝지어 제거하기가 종료됩니다. 문자열 S가 주어졌을 때, 짝지어 제거하기를 성공적으로 수행할 수 있는지 반환하는 함수를 완성해 주세요. 성공적으로 수행할 수 있으면 1을, 아닐 경우 0을 리턴해주면 됩니다.

예를 들어, 문자열 S = `baabaa` 라면

b aa baa → bb aa → aa →

의 순서로 문자열을 모두 제거할 수 있으므로 1을 반환합니다.

### 제한사항
+ 문자열의 길이 : 1,000,000이하의 자연수
+ 문자열은 모두 소문자로 이루어져 있습니다.

### 입출력 예
|s	|result|
|---|---|
|baabaa	|1|
|cdcd	|0|

### 입출력 예 설명
#### 입출력 예 #1
+ 위의 예시와 같습니다.

#### 입출력 예 #2
+ 문자열이 남아있지만 짝지어 제거할 수 있는 문자열이 더 이상 존재하지 않기 때문에 0을 반환합니다.

<br/><br/><br/><br/>

멀쩡한 사각형
===
### 문제 설명

가로 길이가 Wcm, 세로 길이가 Hcm인 직사각형 종이가 있습니다. 종이에는 가로, 세로 방향과 평행하게 격자 형태로 선이 그어져 있으며, 모든 격자칸은 1cm x 1cm 크기입니다. 이 종이를 격자 선을 따라 1cm × 1cm의 정사각형으로 잘라 사용할 예정이었는데, 누군가가 이 종이를 대각선 꼭지점 2개를 잇는 방향으로 잘라 놓았습니다. 그러므로 현재 직사각형 종이는 크기가 같은 직각삼각형 2개로 나누어진 상태입니다. 새로운 종이를 구할 수 없는 상태이기 때문에, 이 종이에서 원래 종이의 가로, 세로 방향과 평행하게 1cm × 1cm로 잘라 사용할 수 있는 만큼만 사용하기로 하였습니다.

가로의 길이 W와 세로의 길이 H가 주어질 때, 사용할 수 있는 정사각형의 개수를 구하는 solution 함수를 완성해 주세요.

### 제한사항
+ W, H : 1억 이하의 자연수

### 입출력 예
|W	|H|	result|
|---|---|---|
|8	|12	|80|

<br/><br/><br/><br/>

N개의 최소공배수
===
### 문제 설명

두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다. 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.

### 제한 사항
+ arr은 길이 1이상, 15이하인 배열입니다.
+ arr의 원소는 100 이하인 자연수입니다.

### 입출력 예
|arr	|result|
|---|---|
|[2,6,8,14]	|168|
|[1,2,3]	|6|