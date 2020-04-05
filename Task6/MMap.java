import java.util.*;

public class MMap<K, V> extends AbstractMap<K, V> {

    private ArrayList<Pair> data;

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public boolean containsKey(Object key) {
        for (Pair p : data) {
            if (p.getKey().equals(key))
                return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Pair p : data) {
            if (p.getValue().equals(value))
                return true;
        }
        return false;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        HashSet<Entry<K, V>> set = new HashSet<>();
        for (Pair p : data) {
            set.add(p);
        }
        return set;
    }

    @Override
    public V get(Object key) {
        for (Pair p : data) {
            if (p.getKey().equals(key)) {
                return p.getValue();
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public Set<K> keySet() {
        HashSet<K> set = new HashSet<>();
        for(Pair p : data) {
            set.add(p.getKey());
        }
        return set;
    }

    @Override
    public V put(K key, V value) {
        for (Pair p : data) {
            if (p.getKey().equals(key)) {
                V temp = p.getValue();
                p.setValue(value);
                return temp;
            }
        }
        data.add(new Pair(key, value));
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        for (K k : map.keySet()) {
            put(k, map.get(k));
        }
    }

    @Override
    public V remove(Object key) {
        for (Pair p : data) {
            if (p.getKey().equals(key)) {
                V temp = p.getValue();
                data.remove(p);
                return temp;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> values = new ArrayList<>();
        for (Pair p : data) {
            values.add(p.getValue());
        }
        return values;
    }

    private class Pair implements Entry {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public Object setValue(Object value) {
            this.value = (V) value;
            return value;
        }
    }

    @Override
    public String toString() {
        return "MMap{" +
                "data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MMap<?, ?> mMap = (MMap<?, ?>) o;

        return data != null ? data.equals(mMap.data) : mMap.data == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
