package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ToDoList implements ActionListener {
	//* Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	JFrame  jeff = new JFrame();
	JPanel  jepp = new JPanel();
	JButton add  = new JButton();
	JButton view = new JButton();
	JButton remove = new JButton();
	JButton save = new JButton();
	JButton load = new JButton();
	JButton aux = new JButton();
	JButton cram = new JButton();
	JTextField jetf = new JTextField();
	ArrayList<JButton> srblist = new ArrayList<JButton>();
	int state=0;
	String sv="";
	int count=0;
	ArrayList<String> mlist = new ArrayList<String>();
	JButton[] jbs = {add, view, remove, save, load};
	public static void main(String[] args) {
		new ToDoList().setup();	
	}
	void setup() {
		jepp.add(cram);
		jepp.add(jetf);
		jepp.add(aux);
		Arrays.stream(jbs).forEach((b) -> jepp.add(b));
		jeff.add(jepp);
		
		jeff.pack();
		
		
		jeff.setVisible(true);
		jeff.setSize(300, 100);
		jeff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Arrays.stream(jbs).forEach((b) -> b.addActionListener(this));
		aux.addActionListener(this);
		cram.addActionListener(this);
		
		jetf.setVisible(false);
		add.setText("add");
		view.setText("view");
		remove.setText("remove");
		save.setText("save");
		load.setText("load");
		aux.setVisible(false);
		
		cram.setText("cram");
		
		
	}
	//* When add task is clicked:
	//* 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	
	//* When the view tasks button is clicked:
	//*		show all the tasks in the list
	
	//* When the remove task button is clicked:
	//* 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	
	//* When the save list button is clicked:
	//* 		Save the list to a file
	
	//* When the load list button is clicked:
	//* 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	
	//* When the program starts, it should automatically load the last saved file into the list. 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(cram)) {
			mlist.add("Homework");
			mlist.add("Lunch");
			mlist.add("Class");
			mlist.add("Call");
			mlist.add("Break");
			cram.setVisible(false);
			e.setSource(view);
		}
		
		if(e.getSource().equals(add)) {
			Arrays.stream(jbs).forEach((b) -> b.setVisible(false));
			jetf.setText("event name");
			jetf.setVisible(true);
			aux.setText("enter");
			aux.setVisible(true);
			state=1;
		}
		if(e.getSource().equals(view)) {
			if(mlist.size()>0) {
			JOptionPane.showMessageDialog(jeff, svs());
			}else {
				JOptionPane.showMessageDialog(jeff, "No events were added");
			}
		}
		if(e.getSource().equals(remove)) {
			if(mlist.size()>0) {
				Arrays.stream(jbs).forEach((x) -> x.setVisible(false));
				srb();
			}else {
				JOptionPane.showMessageDialog(jeff, "No events to remove");
			}
		}
		if(e.getSource().equals(aux)) {
			System.out.println(state);
			if(state==1) {
				String addfield = jetf.getText();
				jeff.setTitle(addfield + " / added");
				Arrays.stream(jbs).forEach((b) -> b.setVisible(true));
				aux.setVisible(false);
				jetf.setVisible(false);
				mlist.add(addfield);
			}
			
		}
		else {for (int i = 0; i < srblist.size(); i++) {
			if(e.getSource().equals(srblist.get(i))) {
				rbclear(srblist.get(i));
			}
		}
			
		}
	}
	
	
	public String svs() {
		sv = "";
		for (int i = 0; i < mlist.size(); i++) {
			sv+=(i+1)+". "+mlist.get(i)+"\n";
		}
		return sv;
	}
	public void srb() {
		state=2;
		srblist.clear();
		for (int i = 0; i < mlist.size(); i++) {
			srblist.add(i, new JButton());
			srblist.get(i).setText(mlist.get(i));
			srblist.get(i).setVisible(true);
			srblist.get(i).addActionListener(this);
			jepp.add(srblist.get(i));
		}
	}
	public void rbclear(JButton jb) {
		jeff.setTitle(jb.getText() +" / removed");
		mlist.remove(jb.getText());
		srblist.stream().forEach((x) -> x.setVisible(false));
		Arrays.stream(jbs).forEach((x) -> x.setVisible(true));
	}
}
