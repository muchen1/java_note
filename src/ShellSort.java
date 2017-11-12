/**
 * 希尔排序
 * 实际上是插入排序的改进版，其中交换的间隔不断缩小，直到1
 */
import java.util.Arrays;
public class ShellSort {
    public static void main(String[] args) {
        int[] test = {89,56,7,5,90,68,3,34,54,10,123,26,70,30,21,215};
        System.out.println("排序之前：" + Arrays.toString(test));
        shellSort(test);
        System.out.println("排序之后： " + Arrays.toString(test));
    }

    /**
     * 希尔排序
     */
    private static void shellSort(int[] test) {
        int len = test.length;
        // d表示希尔排序分组的间距
        int d = len;
        int i,j,temp;
        while(d >= 1) {
            // 初始值为长度的一般，并且以此速率缩小
            d = d / 2;
            // i表示在步幅为d时，test的分组情况，每个分组进行一次插入排序
            for (i = 0; i < d; i++) {
                // 进行一遍插入排序
                // 如果改组只有一个元素，则没必要进行插入排序
                if (i + d > len -1) {
                    continue;
                }
                for (j = i + d; j < len; j += d) {
                    temp = test[j];
                    while(j - d >= 0 && temp < test[j - d]) {
                        test[j] = test[j - d];
                        j -= d;
                    }
                    test[j] = temp;
                }
            }
        }
    }
}