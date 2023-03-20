package amazonOA;

public class MinimumTotalContainerSize {
//  public int minDifficulty(int[] jobDifficulty, int d) {
//    int n = jobDifficulty.length;
//    if (d > n) {
//      return -1;
//    }
//    int[][] dp = new int[d][n];
//
//  }
//    if (d > jobDifficulty.length) {
//      return -1;
//    }
//
//    List<Integer> jobs = new ArrayList<>();
//    for (int job: jobDifficulty) {
//      jobs.add(job);
//    }
//    return minDiff(jobs, d);
//  }
//
//  public int minDiff(List<Integer> jobs, int d) {
//    if (d==1) {
//      return Collections.max(jobs);
//    }
//    int minD = Integer.MAX_VALUE;
//    for (int i = 1; i <= jobs.size() + 1 - d; i++) {
//      minD = Math.min(minDiff(jobs.subList(i, jobs.size()), d-1)
//                      + Collections.max(jobs.subList(0, i))
//              , minD);
//    }
//    return minD;
//  }
}
