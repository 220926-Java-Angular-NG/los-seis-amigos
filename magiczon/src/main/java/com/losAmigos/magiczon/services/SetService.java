package com.losAmigos.magiczon.services;

import com.losAmigos.magiczon.models.Set;
import com.losAmigos.magiczon.repos.sets.SetLoader;
import com.losAmigos.magiczon.repos.sets.SetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    public List<String> findSetcodes(){
        return setRepository.findSetcodes();
    }
    public List<Set> findAllSets(){
        return setRepository.findAll();
    }

    public Set findBySetCode(String setcode){
        return setRepository.findSetBySetcode(setcode);
    }

    public Map<String, String> getNameBySetcode(String setcode){
        Map<String, String> a = new HashMap<>();
        a.put("name", setRepository.findNameBySetcode(setcode));
        return a;
    }
}