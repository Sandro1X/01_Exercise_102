
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
            
//            label.setBackground(Color.white);
            if(file.isDirectory()){
                label.setForeground(Color.red);
                label.setFont(new Font("Courier New", Font.PLAIN, 12));
                label.setBackground(Color.GRAY);
            }else if (file.isFile()){
                label.setForeground(Color.blue);
                label.setFont(new Font("Courier New", Font.ITALIC, 12));
                label.setBackground(Color.getColor("200"));
            }
        }
        if(isSelected){
//            label.setBackground(Color.DARK_GRAY);
        }
//        label.setBackground(isSelected ? Color.lightGray : Color.white);
        return label;
    }
    
}
