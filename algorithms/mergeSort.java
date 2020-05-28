import java.util.Arrays;

public class MergeSort {

    private static int[] a;
    private static int[] b;

    public static void sort(int l, int r) {
        if (l >= r) return;
        int mid = (l + r) / 2;
        sort(l, mid);
        sort(mid + 1, r);
        merge(l, r, mid);
    }

    private static void merge(int l, int r, int mid) {
        int i = l, j = mid + 1, k = l;
        while (i <= mid && j <= r) {
            if (a[i] < a[j]) {
                b[k] = a[i];
                i++;
                k++;
            } else {
                b[k] = a[j];
                j++;
                k++;
            }
        }
        while (i <= mid) {
            b[k] = a[i];
            i++;
            k++;
        }
        while (j <= r) {
            b[k] = a[j];
            j++;
            k++;
        }
        for (int z = l; z <= r; z++)
            a[z] = b[z];
    }

    public static void main(String[] args) {
        a = new int[]{5, 8, 11, 2, 2, 4, 1, 9, 9, 4, 7};
        b = new int[a.length];
        sort(0, a.length - 1);

        System.out.println(Arrays.toString(a));
    }

}
