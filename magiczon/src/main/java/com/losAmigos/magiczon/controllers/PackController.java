package com.losAmigos.magiczon.controllers;

import com.losAmigos.magiczon.services.PackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/card-packs")
public class PackController {

    private final PackService packService;
}
