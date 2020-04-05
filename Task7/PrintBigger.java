import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PrintBigger {

    public static <T> void printBigger(List<T> l1, List<T> l2, Comparator<T> comparator) {
        Optional<T> max = l2.stream().max(comparator);
        l1.forEach(el -> {
            if (comparator.compare(el, max.get()) > 0)
                System.out.println(el);
        });
    }

}
