
import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


public class FileF extends File{
    private String name;
    private LocalDateTime changeDate;
    private long size;
    private String attributes;
    private boolean hidden;
    
    public FileF(String pathname) {
        super(pathname);
        this.name = this.getName();
        this.changeDate = LocalDateTime.ofEpochSecond(this.lastModified() / 1000, 0, ZoneOffset.UTC);
        this.size = this.length();
        this.attributes = attributes;
        this.hidden = this.isHidden();
        this.attributes = "";
    }
    
    public String setAttributes(){
        if(this.canRead()){
            attributes += "R";
        }if(this.canWrite()){
            attributes += "W";
        }if(this.canExecute()){
            attributes += "X";
        }
        return attributes;
    }
    
    @Override
    public String toString(){
        if (this.isDirectory() && this.hidden){
            return String.format("%-41s hidden", name);
        }
        if(this.isDirectory()){
            return String.format("%s", name);
        }
        else if(this.isFile() && this.hidden){
            return String.format("%-15s %-22s %5s KB %s hidden", name, changeDate, size, attributes);
        }if(this.isFile()){
            return String.format("%-15s %-22s %5s KB %s", name, changeDate, size, attributes);
        }
        return "";
    }
}