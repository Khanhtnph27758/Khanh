
package Validate;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validation1 {
    
    public static boolean iEmpty (JTextField txtField, String mess){
        String txt = txtField.getText().trim();
        boolean dieuKien = (txt.length() == 0);
        
        return showMessage(txtField, mess, dieuKien);
    }
    public static boolean isNotId (JTextField txtField, String mess) {
        String txt = txtField.getText().trim();
        String pattern = "^[A-Z ]{2}[0-9]{4,6}$";
        boolean dk = (!txt.matches(pattern));
        return showMessage(txtField, mess, dk);
    }
    
    public static boolean isNotName (JTextField txtField, String mess) {
        String txt = txtField.getText().trim();
        boolean dk = false;
        String pattern = "^\\D{2,50}$";
        if (!txt.matches(pattern)) {
            dk = true;
        }
        
        return showMessage(txtField, mess, dk);
    }
    
    public static boolean isNotEmail (JTextField txtField, String mess){
        String txt = txtField.getText().trim();
        String pattern = "^[a-zA-Z]\\w{2,}@\\w{2,}(\\.\\w{2,3}){1,2}$";
        boolean dk = (!txt.matches(pattern));
        
        return showMessage(txtField, mess, dk);
    }
    
    public static boolean isNotDouble(JTextField txtField, String mess) {
        String txt = txtField.getText().trim();
        
        boolean dk = false;
        try {
            double salary = Double.parseDouble(txt);
            if(salary < 0){
                dk = true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            dk = true;
        }
        
        return showMessage(txtField, mess, dk);
    }
     public static boolean isNotFloat(JTextField txtField, String mess) {
        String txt = txtField.getText().trim();
        
        boolean dk = false;
        try {
            float salary =Float.parseFloat(txt);
            if(salary < 0){
                dk = true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            dk = true;
        }
        
        return showMessage(txtField, mess, dk);
    }
    public static boolean isNotInt(JTextField txtField, String mess) {
        String txt = txtField.getText().trim();
        
        boolean dk = false;
        try {
            int salary = Integer.parseInt(txt);
            if(salary < 0){
                dk = true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            dk = true;
        }
        
        return showMessage(txtField, mess, dk);
    }
    
    public static boolean isNotDOB(JTextField txtField, String mess){
        String txt = txtField.getText().trim();
        boolean dk = false;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            Date now = new Date();
            Date dd = sdf.parse(txt);
            if (now.getYear() - dd.getYear() < 16 || now.getYear() - dd.getYear() > 55){
                dk = true;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
            
            dk = true;            
        }
        
        return showMessage(txtField, mess, dk);
    }
    
    public static boolean showMessage (JTextField txtField, String mess, boolean dieuKien){
        if(dieuKien == true){
            JOptionPane.showMessageDialog(null, mess, "Error", JOptionPane.ERROR_MESSAGE);
            txtField.setBackground(Color.red);
            txtField.requestFocus();
            return true;
        }else{
            txtField.setBackground(Color.white);
            return false;
        }   
    }
}
