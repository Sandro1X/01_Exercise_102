
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


public class FileListRenderer implements ListCellRenderer{

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = new JLabel (value.toString());
        label.setOpaque(true);
        
        if(value instanceof FileF){
            FileF file = (FileF) value;
            
            if(file.isDirectory()){
                label.setForeground(Color.red);
            }else if (file.isFile()){
                label.setForeground(Color.blue);
            }
        }
        label.setBackground(isSelected ? Color.lightGray : Color.white);
        return label;
    }
    
}
