package exceptions;

import javax.swing.*;

public class noData extends Exception {
    public void displaYError(JFrame frame){
        JOptionPane.showMessageDialog(frame, "No Data to Display", "Info", JOptionPane.PLAIN_MESSAGE);
    }
}