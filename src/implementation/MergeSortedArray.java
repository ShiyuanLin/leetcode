package implementation;

public class MergeSortedArray {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] nums1_copy = new int[m];

    if (m >= 0) System.arraycopy(nums1, 0, nums1_copy, 0, m);

    int mIdx = 0;
    int nIdx = 0;

    while (mIdx < m || nIdx < n) {
      if (mIdx < m && nIdx < n) {
        if (nums1_copy[mIdx] <= nums2[nIdx]) {
          nums1[mIdx + nIdx] = nums1_copy[mIdx];
          mIdx++;
        } else {
          nums1[mIdx + nIdx] = nums2[nIdx];
          nIdx++;
        }
      } else if (mIdx < m) {
        nums1[mIdx + nIdx] = nums1_copy[mIdx];
        mIdx++;
      } else {
        nums1[mIdx + nIdx] = nums2[nIdx];
        nIdx++;
      }
    }
  }
}
