package com.losAmigos.magiczon.services;

import com.losAmigos.magiczon.repos.PackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PackService {

    private final PackRepository packRepository;

}
