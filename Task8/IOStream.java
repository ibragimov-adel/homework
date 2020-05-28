import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOStream {

    public static void write(int i, char c, File file) {
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(i >> 24);
            outputStream.write(i >> 16);
            outputStream.write(i >> 8);
            outputStream.write(i);

            outputStream.write(c >> 8);
            outputStream.write(c);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void read(File file) {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            int n = (inputStream.read() << 24) + (inputStream.read() << 16) + (inputStream.read() << 8) + inputStream.read();
            char c = (char) ((inputStream.read() << 8) + inputStream.read());
            System.out.println(n + " " + c);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        File file = new File("file.txt");
        write(64351, 'ъ', file);
        read(file);
    }

}
