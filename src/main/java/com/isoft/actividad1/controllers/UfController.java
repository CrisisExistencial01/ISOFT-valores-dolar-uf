package com.isoft.actividad1.controllers;

// Dependencies
import com.isoft.actividad1.services.CsvDataLoaderService;
import com.isoft.actividad1.services.PrettyTable;

import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UfController {

    @Autowired
    CsvDataLoaderService ufData;

    @GetMapping(value = "/valor-uf", produces = "text/html")
    @ResponseBody
    public String valor_uf() {
        final String UF_PATH = "src/main/resources/shared/UF-2024.csv";
        Document doc = PrettyTable.createTable(UF_PATH);
        return doc.toString();
    }
}
