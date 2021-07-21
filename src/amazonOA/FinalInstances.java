package amazonOA;

public class FinalInstances {
  // https://aonecode.com/amazon-online-assessment-utilization-checks
  public static int finalInstances(int instances, int[] averageUtil) {
    int maxInstance = (int) (2 * Math.pow(10, 8));
    int idx = 0;
    while (idx < averageUtil.length) {
      if (averageUtil[idx] < 25) {
        int nextInstances = (int) Math.ceil(instances / 2.0);
        if (instances != nextInstances) {
          idx += 10;
          instances = nextInstances;
        }
      } else if (averageUtil[idx] > 60){
        int nextInstances = (int) Math.min(instances * 2, maxInstance);
        if (instances != nextInstances) {
          idx += 10;
          instances = nextInstances;
        }
      }
      idx++;
    }
    return instances;
  }

  public static void main(String[] args) {
    FinalInstances.finalInstances(1, new int[] {5, 10, 80});
  }
}
