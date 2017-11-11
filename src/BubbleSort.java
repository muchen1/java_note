import java.util.Arrays;
/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] test = {45,56,7,5,90,68,3,34,54,10,123,26,70,30,21,215};
        System.out.println("排序之前：" + Arrays.toString(test));
        bubbleSort(test);
        // bubbleSortImproved(test);
        System.out.println("排序之后： " + Arrays.toString(test));
    }

    /**
     * 冒泡排序算法
     * @param test [表示需要进行排序的数组]
     */
    private static void bubbleSort(int[] test) {
        int len = test.length;
        int loopNum = 0;
        int changeNum = 0;
        // i的数量表示已经排好序的数量
        for (int i = 0; i < len - 1; i++) {
            loopNum++;
            // j表示未排好序的数字数量，从这个数量中对数字进行冒泡
            for (int j = len - 2; j >= i; j--) {
                // 如果前一个值比后一个值大，则进行交换
                if (test[j] > test[j + 1]) {
                    int temp = test[j];
                    test[j] = test[j + 1];
                    test[j + 1] = temp;
                    changeNum++;
                }
            }
        }
        System.out.println("bubbleSort 排序中,loop次数为=="
            + loopNum + ",交换次数为=" + changeNum);
    }

    /**
     * 改进之后的冒泡排序算法 -- 通过增加是否交换顺序的标志，来达到减少循环的次数
     * @param test [表示需要进行排序的数组]
     */
    private static void bubbleSortImproved(int[] test) {
        int len = test.length;
        boolean flag = true;
        int loopNum = 0;
        int changeNum = 0;
        // i的数量表示已经排好序的数量
        for (int i = 0; i < len - 1 && flag; i++) {
            loopNum++;
            flag = false;
            // j表示未排好序的数字数量，从这个数量中对数字进行冒泡
            for (int j = len - 2; j >= i; j--) {
                // 如果前一个值比后一个值大，则进行交换
                if (test[j] > test[j + 1]) {
                    int temp = test[j];
                    test[j] = test[j + 1];
                    test[j + 1] = temp;
                    // 交换过，将该值置为true,可以继续遍历
                    flag = true;
                    changeNum++;
                }
            }
        }
        System.out.println("bubbleSortImproved 排序中,loop次数为=="
            + loopNum + ",交换次数为=" + changeNum);
    }
}