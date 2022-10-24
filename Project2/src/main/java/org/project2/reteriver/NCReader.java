package org.project2.reteriver;

import org.project2.model.Card;
import org.project2.repo.CardRepo;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
//Normalty Comics Reader
public class NCReader
{
	// command to make docker db for this info "docker run --name magic -e POSTGRES_PASSWORD=123456 -p 5434:5432 -d postgres"
	BufferedReader inputFile;
	CardRepo cardRepo;
	public ArrayList<ArrayList<String>> mainDir;

	public ArrayList<ArrayList<String>> getMainDir()
	{
		return mainDir;
	}

	public NCReader(String path)
	{
		System.out.println(path);
		cardRepo = new CardRepo();
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
			System.out.println(lineFromFile);
			cardRepo.create(new Card(lineFromFile));
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

/*
create table cards(
cardid serial primary key,
name varchar(141) not null,
setname	varchar(3000),
imagefile	varchar(3000),
actualset	varchar(3000),
color	varchar(),
colorid	varchar(3000),
concost	varchar(3000),
manavalue	varchar(3000),
type	varchar(3000),
power	varchar(3000),
toughness	varchar(3000),
loyalty	varchar(3000),
rarity	varchar(3000),
text varchar(3000)
);
 */
