import java.io.File;
import java.io.IOException;

public class FileDirTest {
    public static void main(String[] args){
        File file1 = new File("D:/Users/renchuang/PycharmProjects/a.txt");
        if (!file1.exists()){
            try{
                file1.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        File dir = new File("D:\\Users\\renchuang\\PycharmProjects");
        if (dir.isDirectory()){
            String[] files = dir.list();
            for (String fileName:files){
                File f = new File(dir.getPath()+File.separator+fileName);
                if (f.isFile()){
                    System.out.println("file:"+f.getName());

                }else if (f.isDirectory()){
                    System.out.println("dir:"+f.getName());
                }
            }
        }
    }
}
