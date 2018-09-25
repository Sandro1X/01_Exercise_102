
import java.io.File;
import java.time.LocalDateTime;


public class FileF extends File{
    private String name;
    private LocalDateTime changeDate;
    private int size;
    private String attributes;
    private boolean hidden;
    
    public FileF(String pathname, String name, LocalDateTime changeDate, int size, 
            String attributes, boolean hidden) {
        super(pathname);
        this.name = name;
        this.changeDate = changeDate;
        this.size = size;
        this.attributes = attributes;
        this.hidden = hidden;
    }
    
    public FileF(String pathname, String name){
        super(pathname);
        this.name = name;
    }
}