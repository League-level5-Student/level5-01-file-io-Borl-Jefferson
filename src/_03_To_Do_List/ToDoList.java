package _03_To_Do_List;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

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
	JButton clear = new JButton();
	JButton delete = new JButton();
	JTextField jetf = new JTextField();
	Boolean lls = false;
	boolean blank = false;
	ArrayList<JButton> srblist = new ArrayList<JButton>();
	ArrayList<JButton> jbl = new ArrayList<JButton>();
	int state=0;
	String sv="";
	int count=0;
	ArrayList<String> mlist = new ArrayList<String>();
	JButton[] jbs = {add, view, remove, save, load, clear, delete};
	ArrayList<String> loglist = new ArrayList<String>();
	
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
		clear.setText("clear");
		delete.setText("delete save");
		aux.setVisible(false);
		
		cram.setText("cram");
		
		logload();
		if(!blank) {
			saveload(loglist.get(loglist.size()-1));
		}else {
			JOptionPane.showMessageDialog(jeff, "No save was loaded");
		}
		
		
		
		
		
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
			mlist.add("Add clear list");
			mlist.add("Make view into constant text");
			mlist.add("Add clear save");
			mlist.add("remove cram");
			cram.setVisible(false);
			e.setSource(view);
		}
		
		if(e.getSource().equals(load)) {
			Arrays.stream(jbs).forEach((x) -> x.setVisible(false));
				
				
				for (int i = 0; i < loglist.size(); i++) {
					jbl.add(i, new JButton());
					jbl.get(i).setText(loglist.get(i));
					jbl.get(i).setVisible(true);
					jbl.get(i).addActionListener(this);
					jepp.add(jbl.get(i));
				}
				
				
				}
				
				
		if(e.getSource().equals(clear)) {
			mlist.clear();
			jeff.setTitle("tasks cleared");
		}
		
		if(e.getSource().equals(save)) {
			if(mlist.size()>0) {
				try {
					
					
					/*8if(loglist.size()>0) {
						ArrayList<String> odl = new ArrayList<String>();
						BufferedReader broutdating = new BufferedReader(new FileReader("src/_03_To_Do_List/"+loglist.get(loglist.size()-1)+".txt"));
						String line = broutdating.readLine();
						while(line != null){
							odl.add(line);
							line = broutdating.readLine();
						}
						FileWriter outdate = new FileWriter("src/_03_To_Do_List/"+loglist.get(loglist.size()-1)+".txt");
						outdate.write(odl.get(0).substring(3));
						for (int i = 1; i < odl.size(); i++) {
							outdate.write("\n"+odl.get(i));
						}
						outdate.close();
					}*/
					
					
					String fname = JOptionPane.showInputDialog("Save name:");
					FileWriter fw = new FileWriter("src/_03_To_Do_List/"+fname+".txt");
					//fw.write("[l]");
					fw.write(mlist.get(0));
					for (int i = 1; i < mlist.size(); i++) {
						fw.write("\n"+mlist.get(i));
					}
					fw.close();
					loglist.add(fname);
					FileWriter log = new FileWriter("src/_03_To_Do_List/save_log.txt");
					log.write(loglist.get(0));
					for (int i = 1; i < loglist.size(); i++) {
						log.write("\n"+loglist.get(i));
					}
					log.close();
					jeff.setTitle(fname + " / saved");
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
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
		for (int i = 0; i < jbl.size(); i++) {
			if(e.getSource().equals(jbl.get(i))) {
				saveload(jbl.get(i).getText());
				Arrays.stream(jbs).forEach((x) -> x.setVisible(true));
				jbl.stream().forEach((x) -> x.setVisible(false));
				jbl.clear();
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
	
	public void saveload(String save) {
		jeff.setTitle(save +" / loaded");
		try {
			BufferedReader load = new BufferedReader(new FileReader("src/_03_To_Do_List/"+save+".txt"));
			mlist.clear();
			String line = load.readLine();
			while(line != null){
				mlist.add(line);
				line = load.readLine();
			}
			if(mlist.size()>0) {
				
				JOptionPane.showMessageDialog(jeff, svs());
				}else {
					JOptionPane.showMessageDialog(jeff, "No events were loaded");
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void logload() {
		blank=true;
		BufferedReader brsave;
		try {
			brsave = new BufferedReader(new FileReader("src/_03_To_Do_List/save_log.txt"));
			String line = brsave.readLine();
		while(line != null){
			blank=false;
			loglist.add(line);
			line = brsave.readLine();
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
