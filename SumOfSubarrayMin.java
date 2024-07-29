import java.util.*;
public class SumOfSubarrayMin {
    public static void main(String[] args) {
        int [] arr = {3,1,2,4};
        System.out.println(sumSubarrayMins(arr));
    }
    public static int sumSubarrayMins(int[] arr) {
        List<Integer> nse = findNSE(arr);
        List<Integer> pse = findPSE(arr);
        int total =0;
        int mod = (int)1e9 +7;


        for (int i = 0; i < arr.length; i++) {
            int left = i - pse.get(i);
            int right = nse.get(i) - i;
            total = (int) ((total + (right * left * (long) arr[i]) % mod) % mod);
        }
        return total;
    }
    public static List<Integer> findNSE(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        List<Integer> nse = new ArrayList<>(Collections.nCopies(n,n));
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>= arr[i]){
                st.pop();
            }if( !st.isEmpty()){
               nse.set(i,st.peek());
            }
            st.push(i);
        }
        return nse;
    }
    public static List<Integer> findPSE(int[] arr){
       int n = arr.length;
       Stack<Integer> st = new Stack<>();
        List<Integer> pse = new ArrayList<>(Collections.nCopies(n,-1));
       for(int i=0;i<n;i++){
           while(!st.isEmpty() && arr[st.peek()]> arr[i]){
               st.pop();
           }if(!st.isEmpty()){
              pse.set(i,st.peek());
           }
           st.push(i);
       }
       return pse;
    }
}
