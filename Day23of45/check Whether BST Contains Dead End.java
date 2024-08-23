package Day23of45;

class Solution
{
      private static void populatesets(Node node, HashSet<Integer> allnodes, HashSet<Integer> leafnodes) {
           if(node ==null){
               return ;
           }
           populatesets(node.left,allnodes,leafnodes);
           allnodes.add(node.data);
           if(node.left ==null && node.right == null){
               leafnodes.add(node.data);
           }
           populatesets(node.right,allnodes,leafnodes);
          
          
          
      }
    public static boolean isDeadEnd(Node root)
    {
        //Add your code here.
    
        HashSet<Integer>allnodes = new HashSet<>();
        HashSet<Integer>leafnodes  = new HashSet<>();
        populatesets(root,allnodes,leafnodes);
        for(int leaf:leafnodes){
            if(leaf ==1){
                if(allnodes.contains(2)){
                    return true;
                }
            }else if(allnodes.contains(leaf-1)&& allnodes.contains(leaf+1)){
                return true;
            }
        }
        
     return false;    
    }
}