package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/input.txt");
			fw.write(JOptionPane.showInputDialog("Input"));
			fw.close();
			String in2 = JOptionPane.showInputDialog("File name and message");
			FileWriter fc = new FileWriter("src/_01_File_Recorder/"+in2+".txt");
			fc.write(in2);
			fc.close();
		}catch(IOException e) {
			System.out.println(e.getStackTrace());
		}
	}
}
