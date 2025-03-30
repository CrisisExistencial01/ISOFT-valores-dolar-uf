/* DOCUMENTATION
 *
 * USAGE:
 * Write the decorator: \@Autowired (without the "\")
 * ----------------------------------------------------------
 * \@Autowired // without the "\"
 * private CsvDataLoaderService objectName;
 *
 * \@whatever //please use in this ISOFT activity \@Controller
 * // example:
 * public YOUR_METHOD(){
 *   // return type: A List of String's List
 *   List <String[]> data = objectName.readCsv("path/to/the/file");
 * }
 * ----------------------------------------------------------
 *
 */
package com.isoft.actividad1.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CsvDataLoaderService {

    public List<String[]> readCsv(String filePath) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                data.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return data;
    }
}

