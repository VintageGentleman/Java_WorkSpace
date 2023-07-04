package baekjoon;

class Solution {
    public int solution(String before, String after) {
    	char[] beforeSet = before.toCharArray();
    	char[] afterSet = after.toCharArray();
    	int len = beforeSet.length;

    	int[] beforeCount = new int[len];
    	int[] afterCount = new int[len];
    	
    	
    	for (int i = 0; i < len; ++i) {
    		int count = 0;
    		for (int j = 0; j < len; ++j) {
    			if (beforeSet[i] == beforeSet[j]) ++count;
    		}
    		beforeCount[i] = count;
    	}
    	
    	for (int i = 0; i < len; ++i) {
    		int count = 0;
    		for (int j = 0; j < len; ++j) {
    			if (beforeSet[i] == afterSet[j]) ++count;
    		}
    		afterCount[i] = count;
    	}
    	
    	boolean check = true;
    	for (int i = 0; i < len; ++i) {
    		check &= beforeCount[i] == afterCount[i];
    	}
    	
        int answer = check ? 1 : 0;
        return answer;
    }
}
 
class Solution2 {
    public static void main(String[] args) {
    	
    	Solution test = new Solution();
    	
    	int result = test.solution("allpe", "apple");
    	
    	System.out.println(result);
    }
}
