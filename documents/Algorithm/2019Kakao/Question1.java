package problem1;

// clear
public class Main {
	public static void main(String[] args) {
		System.out.println(solution("ababcdcdababcdcd"));
		
	}
	/**
	 * 1. 길이가 n인 문자열이 들어온다.
	 * 2. 단위문자길이수를 1개로 쪼개고, 쪼갠 문자열을 배열에 넣는다.
	 * 3. 배열을 순회하면서 현재 index와 다음 index가 값이 일치하는지 확인한다.
	 * 3.1 일치하는경우: 일치하지 않을 때 까지 count를 1증가시킨다. 
	 * 3.2 일치하지않는경우: 
	 * 3.2.1 count == 1: 결과문자열에 이어붙인다. 
	 * 3.2.2 1 < count : count + 단위문자를 결과문자열에 이어붙인다.
	 * 4. 결과문자열의 length가 현재 result 보다 크다면 현재 length를 result에 저장한다.   
	 * 5. 단위문자길이수를 1 증가시키고 2단계 부터 끝날때 까지 반복한다.
	 */
	public static int solution(String s) {
		int answer = 1000;
		for (int measure = 1; measure <= s.length(); measure++) {
			int left = (s.length()%measure > 0) ? 1 : 0;
			String[] devide = new String[(s.length()/measure) + left];
			int startPoint = 0;
			for (int i = 0; i < devide.length; i++) {
				if (startPoint < s.length() && startPoint + measure < s.length()) {
					devide[i] = s.substring(startPoint, startPoint + measure);
					startPoint = startPoint + measure;
				} else {
					devide[i] = s.substring(startPoint, s.length());
				}
				
			}
			
			int count = 1;
			String result = "";
			for (int i = 0; i < devide.length; i++) {
				if(i + 1 < devide.length && devide[i].equals(devide[i + 1])) {
					count++;
				} else {
					if (count > 1) {
						result = result + String.format("%d%s", count, devide[i]);	
					} else {
						result = result + devide[i];
					}
					count = 1;
				}
			}
			
			answer = answer > result.length() ? result.length() : answer;
		}
		
		return answer;
	}
}
