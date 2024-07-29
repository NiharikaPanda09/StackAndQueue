import java.util.*;
public class Asteroid_Collision {
    public static void main(String[] args) {
         int[] ast = {10,2,-5};
        System.out.println(Arrays.toString(asteroidCollision(ast)));
    }
    public static int[] asteroidCollision(int[] asteroids) {
          List<Integer> st =  new ArrayList<>();
          for (int i=0;i<asteroids.length-1;i++){
              if (asteroids[i] > 0) {

                  st.add(asteroids[i]);
              } else{
                  while(!st.isEmpty() && st.get(st.size()-1) >0  && st.get(st.size()-1) < Math.abs(asteroids[i])){
                      st.remove(st.size()-1);
                  }if( !st.isEmpty() && (st.get(st.size()-1) == Math.abs(asteroids[i]))){
                      st.remove(st.size()-1);
                  } else if (st.isEmpty() || st.get(st.size()-1) < 0) {
                      st.add(asteroids[i]);
                  }
              }
          }
          return asteroids;
    }
}
