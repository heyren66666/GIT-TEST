import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        FileInputStream fin=new FileInputStream("D:\\Users\\renchuang\\PycharmProjects\\test.txt");
        FileOutputStream fout=new FileOutputStream("D:\\Users\\renchuang\\PycharmProjects\\b.txt");
        byte[] buff=new byte[256];
        int len=0;
        while ((len=fin.read(buff))>0){
            fout.write(buff,0,len);
        }
        fin.close();
        fout.close();
    }
}
