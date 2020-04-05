import java.util.Map;

public class MapKeysConcat {

    public static <K, V> String concat(Map<K, V> map) {
        return map.keySet().stream().map(a -> a.toString()).reduce((a,b) -> {return a+b;}).get();
    }

}
