
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.AbstractListModel;

public class FileModel extends AbstractListModel<FileF> {

    ArrayList<FileF> files = new ArrayList<>();

    public void add(FileF f) {
        files.add(f);
        fireIntervalAdded(this, files.size() - 1, files.size() - 1);
    }

    public void sort() {
        Collections.sort(files, new FileComparer());
        fireContentsChanged(this, 0, files.size() - 1);
    }

    public void selectDir(File dir) {
        this.add(new FileF(dir.getAbsolutePath() + "."));
        for (File f : dir.listFiles()) {
            FileF file = new FileF(f.getAbsolutePath());
            this.add(file);
            file.setAttributes();
        }
    }

    public void directoryChanged(int idx) {
        File dir = files.get(idx);
        files.clear();
        
        this.add(new FileF(dir.getAbsolutePath()+"/.."));
            for (File f : dir.listFiles()) {
                FileF file = new FileF(f.getAbsolutePath());
                this.add(file);
                file.setAttributes();
            }
        fireContentsChanged(this, 0, files.size() - 1);
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
