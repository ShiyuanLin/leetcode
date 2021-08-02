package implementation;

public class FindCelebrity {
  public boolean knows(int a, int b) {
    return false; // placeholder to pass IDE check
  }

  public int findCelebrity(int n) {
    int[] candidates = new int[n];
    // 0 not investigated
    // 1 normal people for sure
    // 2 so far celebrity

    for (int i = 0; i < n; i++) {
      if (candidates[i] == 1) {
        continue;
      }
      // ===== check if all after i_th element know i
      int a = i + 1;
      while (a < n && knows(a, i)) {
        candidates[a] = 1;
        a++;
      }
      // ====================
      if (a == n) {
        // ======= check if all before i_th element know i
        candidates[i] = 2;
        for (int j = 0; j < i; j++) {
          if (!knows(j, i)) {
            candidates[i] = 1;
            break;
          }
        }
        // ========================
      } else {
        // some element after i doesn't know i
        candidates[i] = 1;
      }
      if (candidates[i] == 2) {
        // Check if i knows anyone
        for (int j = 0; j < n; j++) {
          if (j == i) continue;
          if (knows(i, j)) {
            candidates[i] = 1;
          }
        }
        if (candidates[i] == 2) return i;
      }
    }
    return -1;
  }
}
