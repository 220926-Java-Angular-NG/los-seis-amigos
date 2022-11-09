package com.losAmigos.magiczon.repos.sets;

import com.losAmigos.magiczon.models.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SetRepository extends JpaRepository<Set,String> {
    @Query("SELECT name From Set")
    List<String> findSet_Names();

    @Query("SELECT setcode From Set")
    List<String> findSetcodes();




}
