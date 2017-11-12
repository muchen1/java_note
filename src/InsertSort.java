/**
 * 插入排序，将数据分为已拍好序列及未排好序列，每次从未排号序列中取值插入到排好序列的合适位置
 */
import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] test = {89,56,7,5,90,68,3,34,54,10,123,26,70,30,21,215};
        System.out.println("排序之前：" + Arrays.toString(test));
        // insertionSort(test);
        insertSort(test);
        // insertImprovedSort(test);
        System.out.println("排序之后： " + Arrays.toString(test));
    }

    /**
     * 插入排序
     */
    private static void insertSort(int[] test) {
        int len = test.length;
        int tmp;
        int loopNum = 0;
        int changeNum = 0;
        // i表示从未排序序列中取出的要进行排序的数字的下标
        // i下标前边的序列为已排序序列
        int i,j;
        int temp;
        for (i = 1; i < len; i++) {
            loopNum++;
            // j表示有序序列的下标值
            // 此次循环找到i的值在有序队列中的应该位置
            for (j = i; j > 0; j--) {
                // 从后向前找位置，当比前一个大时，则为自身位置，停止循环
                if (test[j] > test[j - 1]) {
                    break;
                }
                // 找到位置前，不挺进行交互
                temp = test[j];
                test[j] = test[j - 1];
                test[j - 1] = temp;
                changeNum++;
            }
        }
        System.out.println("insertSort排序中，循环次数为："
            + loopNum + ",交换次数为：" + changeNum);
    }

    /**
     * 插入排序提升版，不是进行排序，而是将元素向后移动
     */
    private static void insertImprovedSort(int[] test) {
        int len = test.length;
        int loopNum = 0;
        int changeNum = 0;
        // i表示从未排序序列中取出的要进行排序的数字的下标
        // i下标前边的序列为已排序序列
        int i,j;
        int temp;
        for (i = 1; i < len; i++) {
            loopNum++;
            // j表示有序序列的下标值
            // 此次循环找到i的值在有序队列中的应该位置
            temp = test[i];
            for (j = i; j >= 0; j--) {
                if (j == 0 || test[j - 1] < temp) {
                    test[j] = temp;
                    break;
                }
                test[j] = test[j - 1];
            }
        }
        System.out.println("insertSort排序中，循环次数为："
            + loopNum + ",交换次数为：" + changeNum);
    }

    /**
     * 插入排序
     */
    private static void insertionSort(int[] test) {
        int len = test.length;
        int loopNum = 0;
        int changeNum = 0;
        // i表示从未排序序列中取出的要进行排序的数字的下标
        // i下标前边的序列为已排序序列
        int i,j,temp;
        for (i = 1; i <= len - 1; i++) {
            loopNum++;
            temp = test[i];
            j = i;
            while (j >= 1 && test[j - 1] > temp) {
                test[j] = test[j - 1];
                j--;
            }
            test[j] = temp;
        }
        System.out.println("insertSort排序中，循环次数为："
            + loopNum + ",交换次数为：" + changeNum);
    }
}