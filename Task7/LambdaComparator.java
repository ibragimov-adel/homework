import java.util.Arrays;

public class LambdaComparator {

    public static void sort(Integer[] arr) {
        Arrays.sort(arr, (a,b) -> {return a-b;});
    }

}
