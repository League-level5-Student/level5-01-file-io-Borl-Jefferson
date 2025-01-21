package _03_To_Do_List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ToDoList {
	//* Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	JFrame  jeff = new JFrame();
	JPanel  jepp = new JPanel();
	JButton add  = new JButton();
	JButton view = new JButton();
	JButton remove = new JButton();
	JButton save = new JButton();
	JButton load = new JButton();
	public static void main(String[] args) {
		new ToDoList().setup();	
	}
	public void setup() {
		
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
	
}
