package userinterface;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.table.*;


public class CalendarView extends JPanel implements ActionListener {
	
	public CalendarView() {
		String months[] = {"January", "February","March", "April","May","June","July","August","September","October","November","December"};

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		  //Declare Frame
		  Container pane = this;
		  
		  //Declare Panels
		  JPanel panelLblCurrentDate = new JPanel();
		  JPanel panelLblMonth = new JPanel();
		  JPanel panelTable = new JPanel();
		  
		  //Declare Labels
		  JLabel labelCurrentDate = new JLabel(String.valueOf(Calendar.DATE-1) + ", " + months[Calendar.MONTH-1] + ", " + String.valueOf(Calendar.YEAR));
		  JLabel labelMonth = new JLabel(months[Calendar.MONTH]); //should not use current month, should be changeable
		  
		  //Current date label and panel
		  panelLblCurrentDate.setBorder(BorderFactory.createLineBorder(Color.black));
		  panelLblCurrentDate.add(labelCurrentDate);
		  pane.add(panelLblCurrentDate);
		   
		  //Backwards icon/button
		  java.net.URL backArrowURL = getClass().getResource("/resources/backArrow.gif");
		    if (backArrowURL != null) {
		    	 JButton buttonBackArrow = new JButton(new ImageIcon(backArrowURL));
				  panelLblMonth.add(buttonBackArrow);
				  buttonBackArrow.setBorder(BorderFactory.createEmptyBorder());
				  buttonBackArrow.setContentAreaFilled(false);
		    }
		 
		  
		  //Month label and panel
		  panelLblMonth.setBorder(BorderFactory.createLineBorder(Color.black));
		  panelLblMonth.add(labelMonth);
		  pane.add(panelLblMonth);
		  
		  //Forwards icon/button
		  java.net.URL forwardArrowURL = getClass().getResource("/resources/forwardArrow.gif");
		    if (forwardArrowURL != null) {
		    	 JButton buttonForwardArrow = new JButton(new ImageIcon(forwardArrowURL));
				  panelLblMonth.add(buttonForwardArrow);
				  buttonForwardArrow.setBorder(BorderFactory.createEmptyBorder());
				  buttonForwardArrow.setContentAreaFilled(false);
		    }
		  
		  
		  //Table set up
		  DefaultTableModel tableModel = new DefaultTableModel();
		  JTable calTable = new JTable(tableModel);
		  String[] columnNames = {"SUN", "MON", "TUE", "WED", "THU", "FRI","SAT"};
		  
		  
		  for(int i = 0; i < 7; i++){
		   tableModel.addColumn(columnNames[i]);
		  }
		  tableModel.setRowCount(5);
		  calTable.setRowHeight(450/tableModel.getRowCount());
		  JTableHeader tableHeader = calTable.getTableHeader(); //display days of the week
		  tableHeader.setReorderingAllowed(false);
		  tableHeader.setResizingAllowed(false);
		  
		  
		  Calendar calDate = GregorianCalendar.getInstance();
		  calDate.set(Calendar.YEAR, Calendar.MONTH, 0); //sets calDate to the first day of the current month
		              //should use month at the top of the calendar in the future
		  int firstDay = calDate.DAY_OF_WEEK;    
		  
		  int dateSet = 1;
		  int j =firstDay - 1; //puts the first day of the month on the proper day of the week
		  for(int i = 0; i < 5; i++){
		   for(; j < 7; j++){
		    if(dateSet <= calDate.getActualMaximum(calDate.DAY_OF_MONTH)){
		     tableModel.setValueAt(dateSet, i, j);
		     dateSet++;
		    }
		   }
		   j=0;
		  }
		  calTable.setEnabled(false);
		  panelTable.setBorder(BorderFactory.createLineBorder(Color.black));
		  panelTable.add(tableHeader);
		  panelTable.add(calTable);
		  pane.add(panelTable);

	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
