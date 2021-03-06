1번 자동완성
===
### 문제 설명

## 자동완성

포털 다음에서 검색어 자동완성 기능을 넣고 싶은 라이언은 한 번 입력된 문자열을 학습해서 다음 입력 때 활용하고 싶어 졌다. 예를 들어, go 가 한 번 입력되었다면, 다음 사용자는 g 만 입력해도 go를 추천해주므로 o를 입력할 필요가 없어진다! 단, 학습에 사용된 단어들 중 앞부분이 같은 경우에는 어쩔 수 없이 다른 문자가 나올 때까지 입력을 해야 한다.
효과가 얼마나 좋을지 알고 싶은 라이언은 학습된 단어들을 찾을 때 몇 글자를 입력해야 하는지 궁금해졌다.

예를 들어, 학습된 단어들이 아래와 같을 때
```
go
gone
guild
```
+ `go`를 찾을 때 `go`를 모두 입력해야 한다.
+ `gone`을 찾을 때 `gon` 까지 입력해야 한다. (`gon`이 입력되기 전까지는 `go` 인지 `gone`인지 확신할 수 없다.)
+ `guild`를 찾을 때는 `gu` 까지만 입력하면 `guild`가 완성된다.

이 경우 총 입력해야 할 문자의 수는 `7`이다.

라이언을 도와 위와 같이 문자열이 입력으로 주어지면 학습을 시킨 후, 학습된 단어들을 순서대로 찾을 때 몇 개의 문자를 입력하면 되는지 계산하는 프로그램을 만들어보자.

입력 형식
학습과 검색에 사용될 중복 없는 단어 N개가 주어진다.

모든 단어는 알파벳 소문자로 구성되며 단어의 수 N과 단어들의 길이의 총합 L의 범위는 다음과 같다.

+ 2 <= N <= 100,000
+ 2 <= L <= 1,000,000

### 출력 형식
+ 단어를 찾을 때 입력해야 할 총 문자수를 리턴한다.

### 입출력 예제
|words	|result|
|---|---|
|["go","gone","guild"]	|7|
|["abc","def","ghi","jklm"]	|4|
|["word","war","warrior","world"]	|15|

<br/><br/><br/><br/>

2번 이중우선순위큐
===
### 문제 설명

이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.
```
명령어	수신 탑(높이)

I 숫자	큐에 주어진 숫자를 삽입합니다.
D 1	큐에서 최댓값을 삭제합니다.
D -1	큐에서 최솟값을 삭제합니다.
```
이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.

### 제한사항
+ operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
+ operations의 원소는 큐가 수행할 연산을 나타냅니다.
  + 원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
+ 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.

### 입출력 예
|operations|	return|
|---|---|
|["I 16","D 1"]	|[0,0]|
|["I 7","I 5","I -5","D -1"]	|[7,5]|

<br/><br/><br/><br/>

3번 Merge Intervals
===    
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
```
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
```
Example 2:
```
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
```