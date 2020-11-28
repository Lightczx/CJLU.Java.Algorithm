package DGP.CJLU.Utils.Implementation;

public class Searching {
    public static final int NOT_FOUND = -1;

    /**
     * Performs the standard binary search.
     *
     * @return index where item is found, or -1 if not found
     */
    public static <AnyType extends Comparable<? super AnyType>> int binarySearch(AnyType[] a, AnyType x) {
        int low = 0, high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid].compareTo(x) < 0) {
                low = mid + 1;
            } else if (a[mid].compareTo(x) > 0) {
                high = mid - 1;
            } else {
                // Found
                return mid;
            }
        }
        // NOT_FOUND is defined as -1
        return NOT_FOUND;
    }

    /**
     * @param arr asdsd
     * @param x   asdasd
     * @return
     */
    public static <AnyType extends Comparable<? super AnyType>> int sequentialSearch(AnyType[] arr, AnyType x) {
        for (int i = 0; i < arr.length; i++) {
            if (x.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }

}
