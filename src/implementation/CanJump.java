package implementation;

public class CanJump {
  /**
   * The greedy algorithm from the official solution
   *
   * @param nums
   * @return
   */
  public static boolean solution(int[] nums) {
    int right = nums.length - 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (i + nums[i] >= right) {
        right = i;
      }
    }
    return right == 0;
  }

  /**
   * This solution comes up by myself.
   * It is inspired by the greedy algorithm
   * but it is actually not that greedy.
   * The running time is O(n^2)
   * @param nums
   * @return
   */
  public static boolean self_greedy_solution(int[] nums) {
    int right = nums.length-1;
    if (right == 0 || right == -1) {
      return true;
    }
    while (right > 0) {
      int i = 0;
      while (i < right) {
        if (nums[i] + i >= right) {
          break;
        }
        i++;
      }
      if (i == right) {
        return false;
      } else {
        right = i;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(CanJump.solution(new int[] {0, 1}));

    System.out.println(CanJump.solution(new int[] {2, 0}));
    System.out.println(CanJump.solution(new int[] {2,3,1,1,4}));
    System.out.println(CanJump.solution(new int[] {3,2,1,0,4}));
  }
}
