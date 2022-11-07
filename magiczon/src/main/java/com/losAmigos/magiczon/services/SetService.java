package com.losAmigos.magiczon.services;

import com.losAmigos.magiczon.repos.sets.SetLoader;
import com.losAmigos.magiczon.repos.sets.SetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
//@RequiredArgsConstructor
public class SetService {

    private final SetRepository setRepository;

    @Autowired
    public SetService(SetRepository setRepository) {
        this.setRepository = setRepository;
        this.initPackRepo();
    }

    public void initPackRepo() {
        SetLoader setLoader = new SetLoader(setRepository);
        setLoader.getSetRepo();
    }
    public List<String> findSet_Names(){
        return setRepository.findSet_Names();
    }
}