package com.haobin.datastructure.sort;

/**
 *
 * 堆的结构特性:
 * 1. 满足是一个满二叉树(除了叶子节点不能有空节点)
 * 2. 满足所有父节点大于等于或小于等于子节点
 *
 * 堆排序
 * 大顶堆： 每个节点都大于孩子节点，即:arr[i] > arr[2i+1] && arr[i] > arr[2i+2]
 *
 * 堆排序的基本思想是：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。
 * 将其与末尾元素进行交换，此时末尾就为最大值。
 * 然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。
 * 如此反复执行，便能得到一个有序序列了
 *
 * @Author: HaoBin
 * @Date 2017/12/26 9:02
 */
public class HeapSort {



    /**
     * 最大堆调整
     */
    public static void maxHeapfiy(int[] array, int index, int heapSize) {
        int iMax = index;
        int iLeft = 2 * index + 1;
        int iRight = 2 * (index + 1);
        // 找出最大的子节点
        if (iLeft < heapSize && array[index] < array[iLeft]) {
            iMax = iLeft;
        }
        if (iRight < heapSize && array[iMax] < array[iRight]) {
            iMax = iRight;
        }
        // 将最大节点放到根
        if (iMax != index) {
            Util.swap(array, iMax, index);
            // 递归调整
            maxHeapfiy(array, iMax, heapSize);
        }
    }

    /**
     * 创建最大堆
     */
    public static void buildMaxHeadp(int[] array, int heapSize) {
        int i;
        // (heapSize -1)/2以后的节点都是叶子节点，没必要调整
        int iParent = (int) Math.floor((heapSize - 1) / 2);
        for (i = iParent; i >= 0; i--) {
            maxHeapfiy(array, i, heapSize);
        }
    }

    /**
     * 堆排序
     */
    public static void heapSort1(int[] array, int heapSize) {
        buildMaxHeadp(array, heapSize);
        for (int i = heapSize - 1; i > 0; i--) {
            Util.swap(array, 0, i);
            maxHeapfiy(array, 0, i);
        }
    }


    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = new String("hello");
        String s3 = "hel" + "lo";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
    }
}
