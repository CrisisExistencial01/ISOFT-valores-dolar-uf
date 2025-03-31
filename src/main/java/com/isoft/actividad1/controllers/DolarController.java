package com.isoft.actividad1.controllers;

import com.isoft.actividad1.services.DolarService;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DolarController {

    @Autowired
    private DolarService dolarService;

    @GetMapping(value = "/valor-dolar", produces = "text/html")
    @ResponseBody
    public String valor_dolar() {
        Document doc = dolarService.obtenerTablaDolar();
        return doc.toString();
    }
}

