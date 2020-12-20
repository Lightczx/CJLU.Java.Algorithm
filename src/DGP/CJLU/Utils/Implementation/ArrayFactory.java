package DGP.CJLU.Utils.Implementation;

import java.util.Arrays;

/**
 * @author 16861
 */
public class ArrayFactory {
    public static Integer[] randomArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        for (int j = 0; j < n; j++) {
            Sorting.swapReferences(arr, arr[j], arr[new Rand().randomInt(0, j - 1)]);
        }
        return arr;
    }

    public static Integer[] incrementArray(int n) {
        Integer[] arr = new Integer[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static <T> T[] copy(T[] array) {
        return Arrays.copyOf(array, array.length);
    }
}
