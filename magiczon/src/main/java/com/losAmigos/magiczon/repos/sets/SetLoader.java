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
        if (!needToPopulate()) return;

//        CardRepo cardRepo = new CardRepo();
        int i = 0;

        do {
            if (this.tableExits()) {
                this.loadTable();
                break;
            }
            i++;
        } while (!this.tableExits() && (i < 10));

//        return this.getCardRepository();
    }


    private Boolean tableExits() {
        try {
            Long count = this.packRepository.count();
            System.out.println(count);
            if (count >= 0) return true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return false;
    }

    private boolean needToPopulate() {
        return this.packRepository.count() != 112;
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