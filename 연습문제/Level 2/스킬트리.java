class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        int firstIdx = 0;
        int currentIdx = 0;
        
        for(int i = 0; i < skill_trees.length; i++) {
        	firstIdx = skill_trees[i].indexOf(skill.charAt(0));	// C / firstIdx=2
        	
        	for(int j = 0; j < skill.length(); j++) {
        		currentIdx = skill_trees[i].indexOf(skill.charAt(j));
        		
        		if((firstIdx > currentIdx && currentIdx != -1) || (firstIdx == -1 && currentIdx != -1)) {
        			answer--;
        			break;
        		}
        		
        		firstIdx = currentIdx;
        	}
        }
        
        return answer;
    }
}