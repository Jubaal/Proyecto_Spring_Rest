package com.group3.wineshop.Controllers;


import com.group3.wineshop.Services.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class recomendController {

    @Autowired
    private WineService wineService;
}
