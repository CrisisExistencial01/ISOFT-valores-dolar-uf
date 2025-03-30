package com.isoft.actividad1.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DolarService {

    private final CsvDataLoaderService csvDataLoader;
    private static final String DOLAR_PATH = "src/main/resources/shared/DOLAR-2024.csv";

    @Autowired
    public DolarService(CsvDataLoaderService csvDataLoader) {
        this.csvDataLoader = csvDataLoader;
    }

    public Document obtenerTablaDolar() {
        List<String[]> data = csvDataLoader.readCsv(DOLAR_PATH);

        Document doc = Jsoup.parse("<table></table>");
        Element table = doc.select("table").first();
        table.attr("style", "border-collapse: collapse; width: 100%;");

        if (data != null && !data.isEmpty()) {
            Element headerRow = table.appendElement("tr");
            for (String header : data.get(0)) {
                Element th = headerRow.appendElement("th");
                th.attr("style", "border: 1px solid #ddd; padding: 8px; background-color: #f2f2f2;");
                th.text(header);
            }
            for (int i = 1; i < data.size(); i++) {
                Element row = table.appendElement("tr");
                for (String cellData : data.get(i)) {
                    Element td = row.appendElement("td");
                    td.attr("style", "border: 1px solid #ddd; padding: 8px;");
                    td.text(cellData);
                }
            }
        }
        return doc;
    }
}
