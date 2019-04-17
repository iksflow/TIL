# [1008] A / B

## Problem
두 정수 A와 B를 입력받은 다음, A/B를 출력하는 프로그램을 작성하시오.
## Input
첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)
## Output
첫째 줄에 A/B를 출력한다. 절대/상대 오차는 10-9 까지 허용한다.
## Input Example 1
```
1 3
```
## Output Example 1
```
0.33333333333333333333333333333333
```
## Input Example 2
```
4 5
```
## Output Example 2
```
0.8
```

## My Code
```Java
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double v1 = scan.nextInt();
		double v2 = scan.nextInt();
		
		System.out.println(v1/v2);
		scan.close();
	}
}

```

## Question
Q1. double 의 경우 연산이 되지만, long의 경우 연산이 안되는 이유는 무엇인가?<br/>
A1.<br/>
Q2. 절대/상대오차는 무엇인가?<br/>
A2.<br/>



## Reference
* https://www.acmicpc.net/problem/1008