import java.io.IOException;
import java.io.RandomAccessFile;

public class RanAccFileTest {
    public static void main(String[] args) throws IOException{
        RandomAccessFile file = new RandomAccessFile("D:\\Users\\renchuang\\PycharmProjects\\test.txt","rw");
        for (int i=0;i<file.length();i++){
            byte b=(byte)file.read();
            char c=(char)b;
            if (c=='a'){
                file.seek(i);
                file.write('c');
            }
        }
        file.close();
    }
}
