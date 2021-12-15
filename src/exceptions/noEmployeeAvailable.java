package exceptions;
import javax.swing.*;

public class noEmployeeAvailable extends Exception{
    public void displayError(JFrame frame){
        JOptionPane.showMessageDialog(frame, "Sufficient Employees are not Available", "Info", JOptionPane.PLAIN_MESSAGE);
    }
}