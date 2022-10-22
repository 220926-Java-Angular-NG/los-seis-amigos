package org.project2.reteriver;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
//Normalty Comics Reader
public class NCReader
{
	// command to make docker db for this info "docker run --name magic -e POSTGRES_PASSWORD=123456 -p 5434:5432 -d postgres"
	BufferedReader inputFile;
	public ArrayList<ArrayList<String>> mainDir;

	public ArrayList<ArrayList<String>> getMainDir()
	{
		return mainDir;
	}

	public NCReader(String path)
	{
		System.out.println(path);
		this.mainDir = new ArrayList<ArrayList<String>>();
		try {
			this.inputFile = new BufferedReader(new InputStreamReader(new URL(path).openStream()));
			loadData(mainDir);
		}catch(IOException e){
			System.out.println(e);
		}
	}

	private void loadData(ArrayList<ArrayList<String>> mainDir) throws IOException{
		String lineFromFile;
		int count = 0;
		while ((lineFromFile = inputFile.readLine()) != null){
			//System.out.println(lineFromFile);
			String[] seporatedLine = lineFromFile.split("	");

			ArrayList<String> placeHolder = new ArrayList<String>();
			for (String word : seporatedLine){
				//load in to database
				placeHolder.add(word);
			}
			mainDir.add(placeHolder);
		}
		inputFile.close();
	}

	public void printMainDir(){
		for (ArrayList<String> l : mainDir){
			for (String s : l){
				System.out.print(s + "	");
			}
			System.out.println();
		}
	}
}
