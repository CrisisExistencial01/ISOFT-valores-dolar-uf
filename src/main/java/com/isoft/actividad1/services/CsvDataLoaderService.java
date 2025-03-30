package com.isoft.actividad1.services;

/* DOCUMENTATION
  *
  * USAGE:
  * Write the decorator: \@Autowired (without the "\")
  * ----------------------------------------------------------
  * \@Autowired // without the "\"
  * private CsvDataLoaderService objectName;
  *
  * \@whatever //please use in this ISOFT activity \@Controller
  * public YOUR_METHOD(){
  *   // return type: A List of String's List
  *   List <String[]> data = objectName.readCsv("path/to/the/file");
  * }
  * ----------------------------------------------------------
  *
*/

import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvDataLoaderService {
    public List<String[]> readCsv(String filename) {
        List<String[]> data = new ArrayList<>();
        try(CSVReader reader = new CSVReader(new FileReader(filename))){
            String[] line;
            while((line = reader.readNext()) != null) {
                data.add(line);
            }
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
            return null;
        }
        return data;
    }
}


