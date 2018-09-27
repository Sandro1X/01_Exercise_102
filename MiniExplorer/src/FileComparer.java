
import java.util.Comparator;


public class FileComparer implements Comparator<FileF>{

    @Override
    public int compare(FileF o1, FileF o2) {
        if(o1.isDirectory() && !o2.isDirectory()){
            return -1;
        }else if (o1.isFile() && !o2.isFile()){
            return 1;
        }
        return 0;
    }
    
}
