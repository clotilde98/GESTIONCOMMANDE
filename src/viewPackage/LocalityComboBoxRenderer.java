package viewPackage;

import modelPackage.Locality;

import javax.swing.*;
import java.awt.*;
public class LocalityComboBoxRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Locality) {
            Locality locality = (Locality) value;
            setText(locality.getCity()); // Affichez le nom de la ville dans le JComboBox
        }
        return this;
    }
}
