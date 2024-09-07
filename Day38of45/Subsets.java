package Day38of45;

class Solution {
    public static List<List<Integer>> subsets(int[] nums) {

    List<List<Integer>> myList=new ArrayList<>();
    List<Integer> List=new ArrayList<>();

    f(0,nums.length,nums,myList,List);

    return myList;
}
public static void f(int i,int n,int nums[],List<List<Integer>> L1,List<Integer> l1){

    if(i>=n){
        L1.add(new ArrayList<>(l1));
        return ;
    }

    l1.add(nums[i]);
    f(i+1,n,nums,L1,l1);
    l1.remove(l1.size()-1);
    f(i+1,n,nums,L1,l1);

}
}