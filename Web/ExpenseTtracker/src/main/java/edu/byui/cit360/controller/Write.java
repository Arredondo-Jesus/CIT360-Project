package edu.byui.cit360.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Write {

	public void writeFile(List<String> contents) {

		final String FILENAME = "/content.jsont";
	
	
			BufferedWriter bw = null;
			FileWriter fw = null;
	
			try {
				fw = new FileWriter(FILENAME);
				bw = new BufferedWriter(fw);
				
				for (String content : contents) {
					bw.write(content);
					bw.newLine();
				}
	
			} catch (IOException e) {
	
				e.printStackTrace();
	
			} finally {
	
				try {
	
					if (bw != null)
						bw.close();
	
					if (fw != null)
						fw.close();
	
				} catch (IOException ex) {
	
					ex.printStackTrace();
	
				}
	
			}
	
		}
}
