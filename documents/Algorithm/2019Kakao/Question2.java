package problem2;

public class Main {
	public static void main(String[] args) {
//		1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
//		2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
//		3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
//		  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
//		4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
//		  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
//		  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
//		  4-3. ')'를 다시 붙입니다. 
//		  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
//		  4-5. 생성된 문자열을 반환합니다.
//		solution("()))((()");
//		String a = "()";
//		System.out.println(a.charAt(1) == '(');
		System.out.println(solution(")(()"));
	}
	
	public static String checker(String test) {
		if (test.length() > 1) {
			String temp = test.replace("()", "");
			if (test.equals(temp)) {
				return test;
			} else {
				return checker(temp);
			}
		} else {
			return test;
		}
	}
	// 1. 
	public static String solution(String p) {
		String answer = "";
		String u = "";
		String v = "";
		if (p.length() > 1) {
			
			if(checker(p).equals("")) {
				return p;
			} else {
				int index = 0;
				int left = 0;
				int right = 0;
				for (int i = 0; i < p.length(); i++) {
					if (p.charAt(i) == '(') left++;
					if (p.charAt(i) == ')') right++;
					if (left == right) {
						index = i + 1;
						break;
					}
				}
				u = p.substring(0, index);
				v = p.substring(index, p.length());
				if (checker(u).equals("")) {
					u += solution(v);
					return u;
				} else {
					answer = "(";
					answer += solution(v);
					answer += ")";
					String leave = u.substring(1, u.length() - 1);
					String reverse = "";
					for(int i = 0; i < leave.length(); i++) {
						if (leave.charAt(i) == '(') {
							reverse += ")";
						} else {
							reverse += "(";
						}
					}
					return answer += reverse;
				}
			}
//			return answer;
		} else {
			return "";
		}
	}
}
