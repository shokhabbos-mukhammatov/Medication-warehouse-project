package edu.itpu.fopjava_course_work.dao;

import edu.itpu.fopjava_course_work.entity.Medication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CsvLineParserImpl implements CsvLineParser<Medication>{
    private String line = "";
    protected CsvLineParserImpl(){
    }

    @Override
    public List<Medication> parseCsv(String path) {
        List<Medication> medicationList = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));

            int i=0;
            while ((line = reader.readLine())!=null){

                if(i==0) {
                    i++;
                    continue;
                }

                Medication medication = new Medication();
                List<String> tempCategories = new ArrayList<>();
                String[] row = line.split(";");
                String[] categoryRow = row[2].split(",");

                for(String str : categoryRow){
                    tempCategories.add(str);
                }

                medicationList.add(medication.setId(Integer.parseInt(row[0])).setName(row[1])
                .setCategories(tempCategories).setPrice(Double.parseDouble(row[3]))
                .setQuantity(Integer.parseInt(row[4])).setDate(row[5]));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    return medicationList;
    }
}
