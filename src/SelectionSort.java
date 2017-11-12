/**
 * 选择排序：
 * 不断从剩余元素中选则最小的，与当前i位置的元素进行替换
 * 注：感觉就是冒泡排序的变体，只不过减少了交换的次数
 */
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] test = {45,56,7,5,90,68,3,34,54,10,123,26,70,30,21,215};
        System.out.println("排序之前：" + Arrays.toString(test));
        // selectionSort(test);
        selectionImprovedSort(test);
        System.out.println("排序之后： " + Arrays.toString(test));
    }

    /**
     * 选择排序
     * @param test [需要进行排序的数组]
     */
    private static void selectionSort(int[] test) {
        int len = test.length;
        int minIndex;
        int temp;
        int loopNum = 0;
        int changeNum = 0;
        // i表示最小元素应该放的位置
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            loopNum++;
            // 开始在未排序元素中寻找最小值
            for (int j = i + 1; j < len; j++) {
                if (test[j] < test[minIndex]) {
                    minIndex = j;
                }
            }
            // 将最小元素交换至i处
            temp = test[i];
            test[i] = test[minIndex];
            test[minIndex] = temp;
            changeNum++;
        }
        System.out.println("selectionSort排序中，循环次数为："
            + loopNum + ",交换次数为：" + changeNum);
    }

    /**
     * 选择排序，同样可以仿照冒泡排序那样，通过增加标志位，来减少交互次数，但不能减少循环次数
     * @param test [需要进行排序的数组]
     */
    private static void selectionImprovedSort(int[] test) {
        int len = test.length;
        int minIndex;
        int temp;
        int loopNum = 0;
        int changeNum = 0;
        boolean needChange;
        // i表示最小元素应该放的位置
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            loopNum++;
            needChange = false;
            // 开始在未排序元素中寻找最小值
            for (int j = i + 1; j < len; j++) {
                if (test[j] < test[minIndex]) {
                    minIndex = j;
                    needChange = true;
                }
            }
            // 根据标志值来确定是否需要进行交换
            if (needChange) {
                // 将最小元素交换至i处
                temp = test[i];
                test[i] = test[minIndex];
                test[minIndex] = temp;
                changeNum++;
            }
        }
        System.out.println("selectionSort排序中，循环次数为："
            + loopNum + ",交换次数为：" + changeNum);
    }
}
