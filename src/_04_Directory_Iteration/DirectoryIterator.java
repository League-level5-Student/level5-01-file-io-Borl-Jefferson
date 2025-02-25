package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	public static void main(String[] args) {
		/* 
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
		//JFileChooser jfc = new JFileChooser();
		//jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		//int returnVal = jfc.showOpenDialog(null);
		//if (returnVal == JFileChooser.APPROVE_OPTION) {
		
			File directory = new File("/Users/league/git/level5-01-file-io-Borl-Jefferson/src");
		
			
			copywrite(directory);
		
		//   /Users/league/git/level5-01-file-io-Borl-Jefferson/src
		
		/*
		 * Your task is to write a program that iterates through the src folder of this current Java Project. 
		 * For every .java file it finds, the program will add a (non-legally binding) copyright statement at the bottom.
		 * Be aware of possible directories inside of directories.
		 * e.g "\n//Copyright © 2019 Drake Haehnichen"
		 */
	}

	private static void watermark(String path) {
		try {
			FileWriter fw = new FileWriter(path, true);
			fw.append("\n//Copyright © 2025 Drake Haehnichen");
			fw.close();
			System.out.println("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
	private static void copywrite(File directory) {
		File[] files = directory.listFiles();
		if(files != null) {
			for(File f : files) {
				if(f.getAbsolutePath().substring(f.getAbsolutePath().length()-5).equals(".java")) {
					watermark(f.getAbsolutePath());
			  System.out.println(f.getAbsolutePath());
				}
			  copywrite(f);
			}
		}
	}
}
//Copyright © 2025 Drake Haehnichen