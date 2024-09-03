package Day34of45;
class Solution {
    public boolean canCross(int[] stones) {
        int k = 0;
        Map<Integer, Integer> positions = new HashMap<>();
        int[][] memo = new int[stones.length][stones.length];
		
        for(int i = 0 ; i < stones.length; i++){
            Arrays.fill(memo[i], -1);
        }
        
        for(int i = 0 ; i < stones.length; i++){
            positions.put(stones[i], i);
        }
        
        return checkPossibles(stones, positions, memo, 0, k);
    }
    
    public boolean checkPossibles(int[] stones, Map<Integer, Integer> positions, int[][] memo, int i, int k){
        
        if(i == stones.length - 1){ 
            return true;
        }
		
        if(memo[i][k] != -1){ 
            return memo[i][k] == 0 ? false : true;
        }
        int indexForKMinusOneJump = positions.containsKey(stones[i] + k -1)? positions.get(stones[i] + k - 1):-1;
        int indexForKJump = positions.containsKey(stones[i] + k)? positions.get(stones[i] + k):-1; 
        int indexForKPlusOneJump = positions.containsKey(stones[i] + k + 1)? positions.get(stones[i] + k + 1):-1; 
		
        if(
			indexForKMinusOneJump == -1 && 
			indexForKJump == -1 && 
			indexForKPlusOneJump == -1
		){
            return false;
        } 
		else {
            boolean jumpPossibleKMinusOne = (
				indexForKMinusOneJump > i && checkPossibles(stones, positions, memo, indexForKMinusOneJump, k-1)
			);
            boolean jumpPossibleK = (
				indexForKJump > i && checkPossibles(stones, positions, memo, indexForKJump, k)
			);
            boolean jumpPossiblekPlusOne = (
				indexForKPlusOneJump > i && checkPossibles(stones, positions, memo, indexForKPlusOneJump, k+1)
			);
			if(jumpPossibleKMinusOne || jumpPossibleK ||  jumpPossiblekPlusOne){
                memo[i][k] = 1;
                return true;
            } else {
                memo[i][k] = 0;
                return false;
            }
        }
    }
}