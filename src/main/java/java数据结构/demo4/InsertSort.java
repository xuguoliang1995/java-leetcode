package java数据结构.demo4;

/**
 * @Author: 许国亮
 * @Date: 2019/9/19 3:21 PM
 * @Version 1.0
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {5,    3, 2, 8, 5, 9, 1, 0};
        insertSort(arr);
        System.out.println(arr);
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                int j;
                for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = temp;
            }

        }


    }

}
