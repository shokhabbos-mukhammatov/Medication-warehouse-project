package edu.itpu.fopjava_course_work.dao;

import edu.itpu.fopjava_course_work.entity.Medication;

import java.util.List;

public interface CsvLineParser<A extends Medication> {
    List<A> parseCsv(String path);
}
