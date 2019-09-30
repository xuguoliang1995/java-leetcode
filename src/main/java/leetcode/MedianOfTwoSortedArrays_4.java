package leetcode;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 * <p>
 * <p>
 * 参考博客https://blog.csdn.net/chen_xinjia/article/details/69258706
 * index 0 1 2 3 4 5 6
 * L1  R1
 * num1  3 5 | 8 9           4 cut1: 左边有多少个元素
 * num2  1 2 7 | 10 11 12    6 cut2: 左边有多少个元素
 * L2 R2
 * num3-> 1 2 3 5 7 | 8 9 10 11 12
 * 取l2和l2 的最大值 R1和R2的最小值
 * 则必须成立的条件
 * L1 < R2  L2 < R1
 * if L1 > LR   cut1 << (cutL, cut1 - 1)
 * L2 > R1 cut2 >> (cut1+1, cutR)
 */
//public class MedianOfTwoSortedArrays_4 {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        /**
//         *
//         * time: O(log(min(m,n)))
//         * space: O(1)
//         * */
//        int N1 = nums1.length;
//        int N2 = nums2.length;
//        //使用短的数组进行切分
//        if (N1 > N2) {
//            return findMedianSortedArrays(nums2, nums1);
//        }
//        int size = N1 + N2;
//        //数组1左边有多少个元素
//        int cut1 = N1 / 2;
//        //数组2边有多少个元素
//        int cut2 = size / 2 - cut1;
//        // 切口移动的范围位置
//        int cutL = 0, cutR = N1;
//        while (cut1 <= N1){
//            //3  | 5 8 9   cut1 = (4 - 0) / 2 + 0;
//            cut1 = (cutR - cutL) / 2 + cutL;
//            cut2 = size /2 -cut1;
//        }
//
//
//    }
//
//}
