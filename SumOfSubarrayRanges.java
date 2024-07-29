import java.util.*;
public class SumOfSubarrayRanges {
    public static void main(String[] args) {
          int[] arr = {1,3,3};
        System.out.println(subArrayRanges(arr));
    }
    public static long subArrayRanges(int[] nums) {
     return sumOfMaxSubarrayRanges(nums) - sumOfMinSubarrayRanges(nums);

    }

    private static long sumOfMinSubarrayRanges(int[] nums) {
        long sum =0;
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        int [] pse = new int[n];

        Arrays.fill(nse, n);
        Arrays.fill(pse, -1);


        for(int i=0;i<n ;i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                nse[st.pop()] = i;
            }
            st.push(i);
        }
        st.clear();


        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                pse[st.pop()] = i;
            }
            st.push(i);
        }
        st.clear();
        for(int i=0;i<nums.length;i++){
            sum += (long) nums[i] * (i - pse[i]) * (nse[i] - i);

        }

        return sum;


    }

    private static long sumOfMaxSubarrayRanges(int[] nums) {
        long sum =0;
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        int [] pge = new int[n];

        Arrays.fill(nge,n);
        Arrays.fill(pge,-1);
        for(int i=0;i<n ;i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                nge[st.pop()] = i;
            }
            st.push(i);
        }

        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                pge[st.pop()] = i;
            }
            st.push(i);
        }
     st.clear();

        for(int i=0;i<nums.length;i++){
            sum += (long) nums[i] * (i - pge[i])* (nge[i] - i);

        }

           return sum;


    }

}
