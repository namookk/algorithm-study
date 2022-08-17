# sk

1번 

### **문제 설명**

6종류(1원, 5원, 10원, 50원, 100원, 500원)의 동전을 생산하는 공장이 있습니다. 특정 금액만큼 동전을 생산해달라는 의뢰가 들어왔을 때, 최소 비용으로 그 금액만큼 동전을 생산하고자 합니다.

[Untitled](https://www.notion.so/a16644f32aa64618b9b2d3ad90de7e25)

만약 각 동전의 생산 단가가 위의 표와 같고, 의뢰받은 금액이 4578원이라면, 최소의 비용으로 4578원어치의 동전을 생산하는 방법은 다음과 같습니다.

[Untitled](https://www.notion.so/e6b9805ab2474344a12a88201324890f)

즉, 1원짜리 동전을 3개, 5원짜리 동전을 5개, 50원짜리 동전을 1개, 100원짜리 동전을 45개 생산하면 2308원이라는 최소 비용으로 4578원어치의 동전을 생산할 수 있습니다. 2308원보다 적은 비용으로 4578원어치의 동전을 생산할 수 있는 방법은 없습니다.

공장이 생산해야 하는 금액을 나타내는 정수 `money`, 6종류 동전의 생산 단가를 나타내는 1차원 정수 배열 `costs`가 매개변수로 주어집니다. `money`원만큼의 동전을 최소 비용으로 생산했을 때, 그 최소 비용을 return 하도록 solution 함수를 완성해주세요.

---

### 제한사항

- 1 ≤ `money` ≤ 1,000,000
- `costs`의 길이 = 6
- 1 ≤ `costs`의 원소 ≤ 5,000
- `costs[0]` ~ `costs[5]`은 차례대로 1원, 5원, 10원, 50원, 100원, 500원짜리 동전의 생산 단가를 담고 있습니다.

---

### 입출력 예

[Untitled](https://www.notion.so/1c804566d2e0461d96ad5fefe5d23fb6)

---

### 입출력 예 설명

**입출력 예 #1**

문제 예시와 같습니다.

**입출력 예 #2**

[Untitled](https://www.notion.so/b3062683e5df4978bf8b856657c85b39)

- 2798원의 최소 비용으로 1999원어치의 동전을 생산할 수 있습니다.
- 500원짜리 동전을 4개 생산하면 2400원(600 x 4 = 2400)의 비용으로 2000원어치의 동전을 생산할 수 있습니다. 하지만, 공장이 생산해야 하는 금액은 정확히 1999원이어야 합니다. 즉, **주어진 금액을 초과하는 금액을 더 싼 비용으로 생산할 수 있다고 하여도, 그것은 정답으로 인정되지 않습니다.**

2번

### **문제 설명**

자연수 n과 시계/반시계 방향을 결정하는 boolean 값 clockwise가 주어집니다. *입출력 예 설명*의 그림과 같이 소용돌이 모양(clockwise가 참이면 시계방향, 거짓이면 반시계방향)으로 n x n 정수 배열을 채워 return 하도록 solution 함수를 완성해주세요.

---

### 제한사항

- n은 1 이상 1,000 이하입니다.

---

### 입출력 예(파이썬을 제외한 언어)

[Untitled](https://www.notion.so/543bdb623c5c44fa8a41c3dd42398cdc)

### 입출력 예(파이썬)

[Untitled](https://www.notion.so/7ef94272389944839877ef952bd189c4)

---

### 입출력 예 설명

입출력 예 #1

- clockwise가 참이므로, 소용돌이를 시계방향으로 돌려야 합니다.
- 다음 그림은 5x5 정사각형을 시계방향 소용돌이 모양으로 채운 모습입니다.
- 
    
    ![https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/3ea5d285-2e6a-494b-b342-cf239d3abe70/ex1.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/3ea5d285-2e6a-494b-b342-cf239d3abe70/ex1.png)
    

입출력 예 #2

- clockwise가 거짓이므로, 소용돌이를 반시계방향으로 돌려야 합니다.
- 다음 그림은 6x6 정사각형을 반시계방향 소용돌이 모양으로 채운 모습입니다.
- 
    
    ![https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/e9a682c1-a15c-4ab5-a6d4-d5127160e65c/ex2.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/e9a682c1-a15c-4ab5-a6d4-d5127160e65c/ex2.png)
    

입출력 예 #3

- clockwise가 거짓이므로, 소용돌이를 반시계방향으로 돌려야 합니다.
- 다음 그림은 9x9 정사각형을 반시계방향 소용돌이 모양으로 채운 모습입니다.
- 
    
    ![https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/974ed066-3192-4f73-bc9f-fe84c799ce2f/ex3.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/974ed066-3192-4f73-bc9f-fe84c799ce2f/ex3.png)
    

**Python3**

**31분 전 저장됨**

1

2

3

4

5

6

7

8

9

10

11

12

13

14

15

16

17

18

import math

def printArr(arr):

for i in arr:

print(i)

def solution(n, clockwise):

global j

global i

answer = [[]]

val = 1

copy_val = val

arr = [[0] * (n) for _ in range(n)]

depth = math.ceil(n / 2)

if clockwise:  # 시계방향

**실행 결과**

실행 결과가 여기에 표시됩니다.

**테스트 케이스 추가하기내 답안코드 초기화코드 실행코드 제출하기**

3번

### **문제 설명**

가로 1칸, 세로 1칸의 크기를 갖는 정사각형으로 이루어진 가로 `width`칸, 세로 `height`칸의 격자가 있습니다. 일부 정사각형에는 "왼쪽 위의 점과 오른쪽 아래점을 잇는" 대각선이 있습니다. 이 격자에서 다음 조건을 만족하는 경로의 개수를 구하고자 합니다.

1. 좌측 하단의 끝점에서 우측 상단의 끝점으로 가는 경로입니다.
2. 대각선을 정확히 1번 이용해야 합니다.
3. 1, 2번 조건을 만족하는 전제 하에서 최단거리 경로여야 합니다.

예를 들어, 다음 그림은 한 격자가 주어졌을 때, 해당 격자에서 1~3번 조건을 만족하는 경로를 모두 나타낸 것입니다.

![https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/7ddefbed-31ea-40f6-8a08-241bf8b63cf8/ex1.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/7ddefbed-31ea-40f6-8a08-241bf8b63cf8/ex1.png)

격자의 가로 길이 `width`, 세로 길이 `height`, 대각선이 위치한 정사각형의 정보 `diagonals`가 매개변수로 주어집니다. 주어진 조건을 모두 만족하는 경로의 개수를 10,000,019로 나눈 나머지를 return 하도록 solution 함수를 완성해주세요.

---

### 제한사항

- 1 ≤ `width` ≤ 250
- 1 ≤ `height` ≤ 250
- 1 ≤ `diagonals`의 길이 ≤ `width` × `height`
    - `diagonals`의 각 행은 두 정수 `[x, y]`로 이루어져 있으며, 왼쪽에서부터 `x`번째, 아래에서부터 `y`번째 사각형에 대각선이 있음을 의미합니다.
    - 1 ≤ `x` ≤ `width`
    - 1 ≤ `y` ≤ `height`
    - 똑같은 `(x, y)` 순서쌍은 2번 이상 등장하지 않습니다.

---

### 입출력 예

[Untitled](https://www.notion.so/0b2c208389a34d3f9f969352494db6eb)

---

### 입출력 예 설명

**입출력 예 #1**

- 문제 예시와 같습니다.

**입출력 예 #2**

- 실제 경우의 수는 776,469,491,667,984,972,858,000 가지이므로, 이를 10,000,019로 나눈 나머지인 3,225,685를 return 해야 합니다.

4번

### **문제 설명**

`n`개의 노드로 이루어진 트리가 있습니다. 각 노드에는 0번부터 `n-1`번까지 번호가 매겨져 있습니다. 이때, 당신은 다음 조건을 모두 만족하는 정수 순서쌍 `(i,j,k)`의 개수를 구하고자 합니다.

- 0 ≤ `i`, `j`, `k` < `n`
- `i`, `j`, `k`는 서로 다릅니다.
- `distance(a, b)`를 `a`번 노드와 `b`번 노드를 잇는 경로 상의 간선의 개수라고 할 때, `distance(i, j) + distance(j, k) = distance(i, k)`입니다.

트리의 노드 개수를 의미하는 `n`과 간선 정보가 담긴 2차원 정수 배열 `edges`가 매개변수로 주어집니다. 주어진 조건을 모두 만족하는 순서쌍 `(i,j,k)`의 개수를 return 하도록 solution 함수를 완성해주세요.

---

### 제한사항

- 3 ≤ `n` ≤ 300,000
- `edges`의 행의 개수 = `n` - 1
- `edges`의 각 행은 `[v1,v2]` 2개의 정수로 이루어져 있으며, 이는 `v1`번 노드와 `v2`번 노드 사이에 간선이 있음을 의미합니다.
    - `0 ≤ v1 < n`
    - `0 ≤ v2 < n`
    - `v1 ≠ v2`
    - `edges`가 의미하는 그래프가 항상 트리인 경우만 입력으로 주어집니다.

---

### 입출력 예

[Untitled](https://www.notion.so/99642baef30a4c6580e8345d0199d8a6)

---

### 입출력 예 설명

**입출력 예 #1**

- 다음 그림은 입력으로 주어진 트리를 나타낸 것입니다.

![https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/f16dc144-6770-4a69-8f1b-7a8ad1b0bb81/ex1.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/f16dc144-6770-4a69-8f1b-7a8ad1b0bb81/ex1.png)

- 다음 표는 입력으로 주어진 트리에서 문제의 조건을 모두 만족하는 순서쌍의 목록을 나타낸 것입니다.

[Untitled](https://www.notion.so/d65875d40a15489b8c77480d76c18f0c)

- 문제의 조건을 모두 만족하는 순서쌍이 16개이므로, 16을 return 해야 합니다.

**입출력 예 #2**

- 다음 그림은 입력으로 주어진 트리를 나타낸 것입니다.

![https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/05744c0c-ce4d-4ddd-824e-d5a167538d89/ex2.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/05744c0c-ce4d-4ddd-824e-d5a167538d89/ex2.png)

- 다음 표는 입력으로 주어진 트리에서 문제의 조건을 모두 만족하는 순서쌍의 목록을 나타낸 것입니다.

[Untitled](https://www.notion.so/7b61e1f70d304de7bfb5cf604274b520)

- 문제의 조건을 모두 만족하는 순서쌍이 8개이므로, 8을 return 해야 합니다.