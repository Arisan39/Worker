import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.text.DecimalFormat;

public class PayRollSystemDriverGui {

 private static JTextArea total;
 private static PayRollSystem syst;
 /**
  * Launch the application.
  * @param args
  */
 public static void main(String[] args) {
   //make window
   //*********************************************************
   syst = new PayRollSystem();
   
   JFrame f = new JFrame("Pay Roll System"); 
   f.setLayout(null);
   f.setSize( 1000, 800 );


  
   //list Workers in the system
  JLabel tt = new JLabel("Workers");
  tt.setBounds(200,200, 150, 20);
  f.add(tt);
  total = new JTextArea("");
  total.setBounds(200,220,350,200);
  total.setBorder(new LineBorder( Color.RED));
  f.add(total);
  
  
  //Buttons
  JButton btnAddSW = new JButton("Add Salary Worker");
  btnAddSW.setBounds(20, 20, 300, 30);
  f.add(btnAddSW);

  JButton btnAddCW = new JButton("Add Commissioned Worker");
  btnAddCW.setBounds(20, 50, 300, 30);
  f.add(btnAddCW);
  
  JButton btnAddHW = new JButton("Add Hourly Worker");
  btnAddHW.setBounds(20, 80, 300, 30);
  f.add(btnAddHW);
 
  JButton btnGetTotalPBC = new JButton("Total Pay By Company");
  btnGetTotalPBC.setBounds(20, 110, 300, 30);
  f.add(btnGetTotalPBC);  
  
  JButton btnGetAllWorkersThreshold = new JButton("All Workers Below Threshold");
  btnGetAllWorkersThreshold.setBounds(20, 140, 300, 30);
  f.add(btnGetAllWorkersThreshold);
  
  //**********************************************
  //add event listeners
  btnAddSW.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    //add a Salary Worker
     String n = JOptionPane.showInputDialog( null, "Enter Name");
     String c = JOptionPane.showInputDialog( null, "Enter Company");
     int s = Integer.parseInt(JOptionPane.showInputDialog( null, "Enter Yearly Salary"));
     SalaryWorker w = new SalaryWorker( n, c, s  ); 
     syst.addWorker( w );
     clearAndFill();
       
    }
   }
  ); 

  btnAddCW.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    //add a Salary Worker
     String n = JOptionPane.showInputDialog( null, "Enter Name");
     String c = JOptionPane.showInputDialog( null, "Enter Company");
     double r = Double.parseDouble(JOptionPane.showInputDialog( null, "Enter Commission Rate as decimal"));
     double s = Double.parseDouble(JOptionPane.showInputDialog( null, "Enter Yearly Sales"));
     CommissionedWorker w = new CommissionedWorker( n, c,r , s  ); 
     syst.addWorker( w );
     clearAndFill();
       
    }
   }
  ); 


  btnAddHW.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    //add a Salary Worker
     String n = JOptionPane.showInputDialog( null, "Enter Name");
     String c = JOptionPane.showInputDialog( null, "Enter Company");
     double h = Double.parseDouble(JOptionPane.showInputDialog( null, "Enter Hours Worked"));
     double r = Double.parseDouble(JOptionPane.showInputDialog( null, "Enter Pay per Hour"));
     HourlyWorker w = new HourlyWorker( n, c,h , r  ); 
     syst.addWorker( w );
     clearAndFill();
       
    }
   }
  ); 
  
  btnGetTotalPBC.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
     String company = JOptionPane.showInputDialog( null, "Enter Company Name--Be Careful");
     double totalPay = syst.getTotalPayByCompany( company);
     JOptionPane.showMessageDialog( null, "Total Pay for " + company + " is " + totalPay );
    }
   }
  );  
  
  btnGetAllWorkersThreshold.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    
     double threshold = Double.parseDouble( JOptionPane.showInputDialog( null, "Enter Threshold Dollar Amount"));
     String workers = syst.getAllWorkers( threshold);
     JOptionPane.showMessageDialog( null, "Workers with pay higher than " + threshold + ":\n********\n" + workers );
       
    }
   }
  );
                         

      
  //set screen
   f.setResizable(false);
   f.setVisible(true);

 }
 
  public static void clearAndFill(){
    //clear and fill the text field 
    total.setText("");;  
    total.setText( syst.toString() ); 
  }
  

}
