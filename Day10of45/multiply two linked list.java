package Day10of45;

class Solution {
    public long multiplyTwoLists(Node first, Node second) {
        // Code here
        
        Node temp1 = first;
        Node temp2 = second;
        long sum1 =0;
        long sum2 =0;
        long mod = 1000000007;
        while(temp1!=null){
            sum1= ((sum1 *10)%mod + temp1.data)%mod;
            temp1 = temp1.next;
        }
        
        while(temp2!=null){
            sum2=((sum2 *10)%mod + temp2.data)%mod;
            temp2 = temp2.next;
        }
        
        return (sum1*sum2)%mod;
    }
