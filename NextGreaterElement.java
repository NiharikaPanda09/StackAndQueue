import java.util.*;
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums1 = {4,2,1};
        int [] nums2 = {1,3,4,2};
        int [] res = nextGreaterElement(nums1,nums2);
        System.out.println(Arrays.toString(res));
    }
    public static  int[] nextGreaterElement(int[] nums1, int[] nums2) {
      int n = nums2.length;
      int [] res = new int[n];
      Arrays.fill(res,-1);
      Stack<Integer> st = new Stack<>();
      for(int i=n-1;i>=0;i--){
          while((!st.isEmpty()) && nums2[i] >= st.peek()){
              st.pop();
          } if (st.isEmpty()){
              res[i] = -1;
          }else {
              res[i] = st.peek();
          }
          st.push(nums2[i]);
      }
      for(int i=0;i<nums1.length;i++){
          for(int j=0;j<n;j++){
              if(nums1[i] == nums2[j]){
                  nums1[i] = res[j];
                  break;
              }
          }
      }
      return nums1;
    }
}
