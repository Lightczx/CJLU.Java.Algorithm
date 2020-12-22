package DGP.CJLU.Utils.Implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * A class that contains several sorting routines,
 * implemented as static methods.
 * Arrays are rearranged with smallest item first,
 * using compareTo.
 *
 * @author Mark Allen Weiss
 */
public final class Sorting {
    private static final int CUTOFF = 3;

    /**
     * Simple insertion sort.
     *
     * @param a an array of Comparable items.
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] a) {
        int j;

        for (int p = 1; p < a.length; p++) {
            T tmp = a[p];
            for (j = p; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

    /**
     * ShellSort, using Shell's (poor) increments.
     *
     * @param arr an array of Comparable items.
     */
    public static <T extends Comparable<? super T>> void shellSort(T[] arr) {
        //step:步长
        for (int step = arr.length / 2; step > 0; step /= 2) {
            //对一个步长区间进行比较 [step,arr.length)
            for (int i = step; i < arr.length; i++) {
                T value = arr[i];
                int j;

                //对步长区间中具体的元素进行比较
                for (j = i - step; j >= 0 && value.compareTo(arr[j]) > 0; j -= step) {
                    //j为左区间的取值，j+step为右区间与左区间的对应值。
                    arr[j + step] = arr[j];
                }
                //此时step为一个负数，[j + step]为左区间上的初始交换值
                arr[j + step] = value;
            }
        }
    }

    /**
     * Internal method for heapsort.
     *
     * @param i the index of an item in the heap.
     * @return the index of the left child.
     */
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    /**
     * Internal method for heapsort that is used in deleteMax and buildHeap.
     *
     * @param a an array of Comparable items.
     * @index i the position from which to percolate down.
     * @int n the logical size of the binary heap.
     */
    private static <T extends Comparable<? super T>> void percDown(T[] a, int i, int n) {
        int child;
        T tmp;

        for (tmp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0) {
                child++;
            }
            if (tmp.compareTo(a[child]) < 0) {
                a[i] = a[child];
            } else {
                break;
            }
        }
        a[i] = tmp;
    }

    /**
     * Standard heapsort.
     *
     * @param a an array of Comparable items.
     */
    public static <T extends Comparable<? super T>> void heapsort(T[] a) {
        /* buildHeap */
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            percDown(a, i, a.length);
        }
        for (int i = a.length - 1; i > 0; i--) {
            /* deleteMax */
            swapReferences(a, 0, i);
            percDown(a, 0, i);
        }
    }

    /**
     * Mergesort algorithm.
     *
     * @param a an array of Comparable items.
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<? super T>> void mergeSort(T[] a) {
        T[] tmpArray = (T[]) new Comparable[a.length];
        mergeSort(a, tmpArray, 0, a.length - 1);
    }

    /**
     * Internal method that makes recursive calls.
     *
     * @param a        an array of Comparable items.
     * @param tmpArray an array to place the merged result.
     * @param left     the left-most index of the subarray.
     * @param right    the right-most index of the subarray.
     */
    private static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }
    }

    /**
     * Internal method that merges two sorted halves of a subarray.
     *
     * @param a        an array of Comparable items.
     * @param tmpArray an array to place the merged result.
     * @param leftPos  the left-most index of the subarray.
     * @param rightPos the index of the start of the second half.
     * @param rightEnd the right-most index of the subarray.
     */
    private static <T extends Comparable<? super T>> void merge(T[] a, T[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        // Main loop
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos].compareTo(a[rightPos]) <= 0) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }

        // Copy rest of first half
        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = a[leftPos++];
        }
        // Copy rest of right half
        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = a[rightPos++];
        }

        // Copy tmpArray back
        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }

    /**
     * Quicksort algorithm.
     *
     * @param a an array of Comparable items.
     */
    public static <T extends Comparable<? super T>> void quicksort(T[] a) {
        quicksort(a, 0, a.length - 1);
    }

    /**
     * Method to swap to elements in an array.
     *
     * @param a      an array of objects.
     * @param index1 the index of the first object.
     * @param index2 the index of the second object.
     */
    public static <T> void swapReferences(T[] a, int index1, int index2) {
        T tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    /**
     * Return median of left, center, and right.
     * Order these and hide the pivot.
     */
    private static <T extends Comparable<? super T>> T median3(T[] a, int left, int right) {
        int center = (left + right) / 2;
        if (a[center].compareTo(a[left]) < 0) {
            swapReferences(a, left, center);
        }
        if (a[right].compareTo(a[left]) < 0) {
            swapReferences(a, left, right);
        }
        if (a[right].compareTo(a[center]) < 0) {
            swapReferences(a, center, right);
        }

        // Place pivot at position right - 1
        swapReferences(a, center, right - 1);
        return a[right - 1];
    }

    /**
     * Internal quicksort method that makes recursive calls.
     * Uses median-of-three partitioning and a cutoff of 10.
     *
     * @param a     an array of Comparable items.
     * @param left  the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    private static <T extends Comparable<? super T>> void quicksort(T[] a, int left, int right) {
        if (left + CUTOFF <= right) {
            T pivot = median3(a, left, right);

            // Begin partitioning
            int i = left, j = right - 1;
            for (; ; ) {
                while (a[++i].compareTo(pivot) < 0) {
                }
                while (a[--j].compareTo(pivot) > 0) {
                }
                if (i < j) {
                    swapReferences(a, i, j);
                } else {
                    break;
                }
            }
            // Restore pivot
            swapReferences(a, i, right - 1);
            // Sort small elements
            quicksort(a, left, i - 1);
            // Sort large elements
            quicksort(a, i + 1, right);
        } else {// Do an insertion sort on the subarray
            insertionSort(a, left, right);
        }
    }

    /**
     * Internal insertion sort routine for subArrays
     * that is used by quicksort.
     *
     * @param a     an array of Comparable items.
     * @param left  the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    private static <T extends Comparable<? super T>> void insertionSort(T[] a, int left, int right) {
        for (int p = left + 1; p <= right; p++) {
            T tmp = a[p];
            int j;

            for (j = p; j > left && tmp.compareTo(a[j - 1]) < 0; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

    public static <T extends Comparable<? super T>> void selectionSort(T[] a) {
        for (int i = 0; i < a.length; i++) {
            // 将当前下标定义为最小值下标
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[minIndex].compareTo(a[j]) > 0) {
                    minIndex = j;
                }
            }
            //如果不是同一个，就交换
            if (i != minIndex) {
                T temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
    }

    public static <T extends Comparable<? super T>> void bubbleSort(T[] a) {
        T temp;
        int i, j;
        //外循环为排序趟数，a.length个数进行a.length-1趟
        for (i = 0; i < a.length - 1; i++) {
            //内循环为每趟比较的次数，第i趟比较a.length-i次
            for (j = 0; j < a.length - 1 - i; j++) {
                //相邻元素比较，若逆序则交换（升序为左大于右，降序反之）
                if (a[j].compareTo(a[j + 1]) > 0) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void bucketSort(Integer[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // 一次循环，将该数组的最大值，最小值求出来
        for (int value : arr) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        }

        // 求桶数
        int bucketNum = (max - min) / (arr.length) + 1;

        // 初始化每个桶
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<>());
        }

        // 遍历数组，将每个元素放入桶中
        for (int k : arr) {
            int bucketIndex = (k - min) / (arr.length);
            bucketArr.get(bucketIndex).add(k);
        }

        // 对每个桶元素，进行排序
        for (ArrayList<Integer> integers : bucketArr) {
            Collections.sort(integers);
        }

        // 将已经排序好的元素，重新赋值到arr数组里
        int j = 0;
        // 遍历每个桶，将每个桶的元素，赋值到arr数组里
        for (ArrayList<Integer> arrayList : bucketArr) {
            for (Integer key : arrayList) {
                arr[j++] = key;
            }
        }

    }

    public static Integer[] radixSort(Integer[] sourceArray) {
        //对 arr 进行拷贝，不改变参数内容
        Integer[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int maxDigit = getMaxDigit(arr);
        return radixSort(arr, maxDigit);
    }

    private static int getMaxDigit(Integer[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLength(maxValue);
    }

    private static int getMaxValue(Integer[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    private static int getNumLength(long num) {
        if (num == 0) {
            return 1;
        }
        int lenght = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }

    private static Integer[] radixSort(Integer[] arr, int maxDigit) {
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod * 2][0];

            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], arr[j]);
            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }

        return arr;
    }

    private static int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}

