package com.losAmigos.magiczon.repos.sets;

import com.losAmigos.magiczon.models.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.*;

@RequiredArgsConstructor
@Getter
public class SetLoader {
    private final SetRepository packRepository;


    public void getSetRepo() {
        if (!(this.packRepository.count() < 112)) return;
        this.loadTable();
    }

    private void loadTable() {
        BufferedReader inputFile;
        try {
            inputFile = new BufferedReader(new FileReader(
                    "magiczon/src/main/resources/PackInfo.txt"));
            String lineFromFile = inputFile.readLine();
            while (lineFromFile != null) {
                System.out.println(lineFromFile);
                // read next line

                Set pack = new Set(lineFromFile);
                this.packRepository.save(pack);
                lineFromFile = inputFile.readLine();
            }
            inputFile.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}