package StackAndQueues.MonotonicStackQueue;
import java.util.Stack;

    // Time complexity : O(N)
    // space complexity : O(N)
public class AestroidCollision {
    public int [] asteroidCollision( int [] asteroids){
        Stack<Integer> stack = new Stack<Integer>();
        for ( int asteroid : asteroids){
            boolean flag = true;
            while ( !stack.isEmpty() && ( stack.peek() > 0 && asteroid < 0 )){
                if ( Math.abs(stack.peek()) < Math.abs(asteroid)){
                    stack.pop();
                    continue;
                }else if ( Math.abs(stack.peek()) == Math.abs(asteroid)){
                    stack.pop();
                }
                flag = false;
                break;

            }
            if ( flag){
                stack.push(asteroid);
            }
        }

        int [] remainingAsteroids = new int [stack.size()];
        for ( int i = stack.size() -1; i >= 0; i-- ){
            remainingAsteroids[i] = stack.pop();
        }

        return remainingAsteroids;
    }

    // time complexity : O(N^2)
    // space complexity : O(N)
    public int[] asteroidCollisionBF(int[] asteroids) {
        int len = asteroids.length;
        boolean [] isDestroyed = new boolean [len];
        for ( int i = 0; i < len; i++ ){
            int j = i -1;
            if  ( asteroids[i] > 0 ) continue;
            while ( j >= 0 && ( isDestroyed[j] || asteroids[i] + asteroids[j] <= 0 )){
                if(isDestroyed[j] || asteroids[j] < 0){
                    j--;
                    continue;
                };
                isDestroyed[j] = true;
                if ( asteroids[i] + asteroids[j] == 0 ){
                    isDestroyed[i] = true;
                    break;
                }
                j--;
            }
            if ( j != -1 ){
                isDestroyed[i] = true;
            }
        }
        int count = 0;
        for ( boolean aestroidAlive : isDestroyed ){
            if( !aestroidAlive ) count++;
        }
        int [] result = new int [count];
        int idx = 0;
        for ( int i = 0; i < len; i++ ){
            if ( !isDestroyed[i]){
                result[idx++] = asteroids[i];
            }
        }
        return result;
    }
}