package problems;

public class MedianTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int maxLength = nums1.length + nums2.length;
        int[] nums3 = new int[maxLength];
        int mCount = 0, nCount = 0;
        double median;

        for (int i = 0; i < maxLength; i++) {
            if (nums1.length > mCount && nums2.length > nCount) {
                if (nums1[mCount] <= nums2[nCount]) {
                    nums3[i] = nums1[mCount];
                    mCount++;
                } else {
                    nums3[i] = nums2[nCount];
                    nCount++;
                }
            } else if (nums1.length > mCount) {
                nums3[i] = nums1[mCount];
                mCount++;
            } else if (nums2.length > nCount) {
                nums3[i] = nums2[nCount];
                nCount++;
            }

            if (i >= maxLength / 2d) {
                if (((maxLength / 2d) % 1d) > 0) {
                    median = nums3[(int) Math.floor(maxLength / 2d)];
                } else {
                    median = (nums3[(maxLength / 2) - 1] + nums3[(maxLength / 2)]) / 2d;
                }
                return median;
            }
        }

        return nums3[0];
    }
}