package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	public static void main(String[] args) {
		int key =Integer.parseInt(JOptionPane.showInputDialog("Key (again):"));
		FileEncryptor fe = new FileEncryptor();
		try {
			String toread="";
			BufferedReader fr = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/encrypt.txt"));
			String msg = fr.readLine();
			
			for (int i = 0; i < msg.length(); i++) {
				char toprint = msg.charAt(i);
				toprint-=key;
				if(toprint-'a'<0) {
					toprint+=26;
				}
			toread+=toprint;
			
			}
			JOptionPane.showMessageDialog(null, toread);
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
