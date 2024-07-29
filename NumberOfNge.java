import java.util.*;
public class NumberOfNge {
    public static void main(String[] args) {
          int[] arr = {3,4,2,7,5,8,10,6};
          int N = arr.length;
          int queries = 2;
          int [] indices = {0,5};
          int [] res = count_NGEs(N,arr,queries,indices);
        System.out.println(Arrays.toString(res));
    }
    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        // code here
        Stack<Integer> st = new Stack<>();
        int[] ct = new int[queries];
        int[] gc = new int[N];
        for(int i= N-1; i>=0;i--){
            while((!st.isEmpty()) && arr[i] >= arr[st.peek()]){

                st.pop();
            }
            gc[i] = st.size();
            st.push(i);
        }
      for(int q =0;q< queries;q++ ){
          ct[q] = gc[indices[q]];
      }
          return ct;
    }
}
