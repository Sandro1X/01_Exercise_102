
import java.util.ArrayList;
import javax.swing.AbstractListModel;


public class FileModel extends AbstractListModel<FileF>{
    ArrayList<FileF> files = new ArrayList<>();
    
    public void add(FileF f){
        files.add(f);
        fireIntervalAdded(this, files.size() - 1, files.size() - 1);
    }
    
    @Override
    public int getSize() {
        return files.size();
    }

    @Override
    public FileF getElementAt(int index) {
        return files.get(index);
    }
    
}
