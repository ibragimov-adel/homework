import java.util.Set;

public class SetStringCounter {

    private char[] VOWELS = {'a', 'e', 'i', 'o', 'u', 'y'};

    public static long count(Set<String> set) {
        return set.stream().filter(str -> {
            int vowelsCount = 0;
            for(char c : str.toCharArray()) {
                if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U' || c == 'y' || c == 'Y') {
                    vowelsCount++;
                }
            }
            return vowelsCount > 3;
        }).count();
    }

}
