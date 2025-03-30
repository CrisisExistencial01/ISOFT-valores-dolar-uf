package com.isoft.actividad1.services;

import com.isoft.actividad1.services.CsvDataLoaderService;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class PrettyTables {

    private static final String TABLE_STYLE =
        "border-collapse: collapse; width: 100%;";
    private static final String HEADER_STYLE = "background-color: #f2f2f2;";
    private static final String CELL_STYLE =
        "border: 1px solid #ddd; padding: 8px;";
    private static final String HEADER_CELL_STYLE =
        "border: 1px solid #ddd; padding: 8px; text-align: left;";

    public static Document createTable(String filename) {
        CsvDataLoaderService csvData = new CsvDataLoaderService();
        List<String[]> data = csvData.readCsv(filename);

        Document doc = Jsoup.parse("<table></table>");
        Element table = doc.select("table").first();
        table.attr("style", TABLE_STYLE);

        Element header = table.appendElement("tr");
        header.attr("style", HEADER_STYLE);

        if (table != null) {
            // First row is the header
            for (String headerName : data.get(0)) {
                Element headerCell = header.appendElement("th");
                headerCell.attr("style", HEADER_CELL_STYLE);
                headerCell.text(headerName);
            }
            for (int i = 1; i < data.size(); i++) {
                Element row = table.appendElement("tr");
                for (String cellData : data.get(i)) {
                    Element cell = row.appendElement("td");
                    cell.attr("style", CELL_STYLE);
                    cell.text(cellData);
                }
            }
            return doc;
        } else {
            return null;
        }
    }
}
