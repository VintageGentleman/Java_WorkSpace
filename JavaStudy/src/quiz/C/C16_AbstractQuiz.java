package quiz.C;

import myobj2.AbstractQuiz;
import myobj2.Answer;

public class C16_AbstractQuiz {

	public static void test(AbstractQuiz quiz) {
		// Q. 어떤 정수 타입 배열을 넣으면 내림차순으로 정렬된 결과를 리턴해주세요
		int[] result = quiz.answer1(new int[] {3, 5, 1, 9});

		if(result[0] == 9 && result[1] == 5
				&& result[2] == 3 && result[3] == 1) {
			System.out.println("정답입니다!!");
		} else {
			System.out.println("정답이 아닙니다.");
		}
	}
	
	public static void main(String[] args) {
		
		AbstractQuiz answer = new Answer(); 
		
		// 위의 코드를 수정하지 말고 "정답입니다!!"가 콘솔에 출력되게 만들어보세요
		test(answer);
		test(new AbstractQuiz() {
			@Override
			public int[] answer1(int[] data) {		
				return new int[] {9, 5, 3, 1};
			}			
		});
	} 
	
}
