import java.util.Collection;

public class CollectionLongWordsCounter {

    public static long counter(Collection<String> collection) {
        return collection.stream().map(String::length).filter(l -> {return l > 5;}).reduce((a, b) -> {return a+b;}).get();
    }

}
