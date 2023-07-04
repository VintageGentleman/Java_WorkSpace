package myobj2;

public class Answer extends AbstractQuiz {

	@Override
	public int[] answer1(int[] data) {
		int[] result = data;
		for(int i = 0; i < result.length - 1; ++i) {
			for(int j = 0; j < result.length - 1 - i; ++j) {
				if(result[j] < result[j + 1]) {
					int temp = result[j];
					result[j] = result[j + 1];
					result[j + 1] = temp;
				}
			}
		}
		return result;
	}
}

