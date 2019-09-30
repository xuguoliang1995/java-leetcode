package java数据结构.demo4;

import java.util.Arrays;

/**
 * @Author: 许国亮
 * @Date: 2019/9/19 11:39 AM
 * @Version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 2, 9, 4, 1, 0, 5, 7};
        // 0, 7, 2, 9, 4, 7, 0, 5, 7   1
        //    |              |

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int shard = arr[start];
            int low = start;
            int high = end;
            while (low < high) {
                while (low < high && shard <= arr[high]) {
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && shard >= arr[low]) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = shard;
            quickSort(arr, start, low);
            quickSort(arr, low + 1, end);
        }
    }
}
