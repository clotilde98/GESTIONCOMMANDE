package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class YearComboBoxRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof LocalDate) {
            LocalDate date = (LocalDate) value;
            setText(String.valueOf(date.getYear()));
        }
        return this;
    }
}
