public class Karacuba {

    public static long multiply(long x, long y) {

        int sizeX = getSize(x);
        int sizeY = getSize(y);

        int N = Math.max(sizeX, sizeY);

        if (N < 10) return x * y;
        N = (N + 1) / 2;

        long m = (long) Math.pow(10, N);

        long b = x / m;
        long a = x - (b * m);
        long d = y/m;
        long c = y - (d * m);

        long p1 = multiply(a, c);
        long p2 = multiply(b, d);
        long p3 = multiply(a + b, c + d);

        return (long) (p1 * Math.pow(10, 2*N) + (p3 - p1 - p2) * Math.pow(10, N) + p2);

    }

    private static int getSize(long num) {
        int size = 0;
        while (num != 0) {
            num /= 10;
            size++;
        }
        return size;
    }


    public static void main(String[] args) {
        System.out.println(multiply(123456, 123456));
        System.out.println(123456 * 123456);
    }

}
