package exceptions;
import javax.swing.*;

public class noEmployeeAvailable extends Exception{
    public void displayError(JFrame frame){
        JOptionPane.showMessageDialog(frame, "No Employees Currently Free", "Info", JOptionPane.PLAIN_MESSAGE);
    }
}