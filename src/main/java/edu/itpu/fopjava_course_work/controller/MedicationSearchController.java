package edu.itpu.fopjava_course_work.controller;

import edu.itpu.fopjava_course_work.dao.MedicationCriteria;
import edu.itpu.fopjava_course_work.dao.Parameter;
import edu.itpu.fopjava_course_work.dao.SearchCriteria;
import edu.itpu.fopjava_course_work.entity.Medication;
import edu.itpu.fopjava_course_work.service.MedicationService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MedicationSearchController {
    protected final MedicationService medicationService ;

    protected final Map<String, ParameterConverter<Medication>> parameterConverters;

    public MedicationSearchController(MedicationService medicationService,  Map<String, ParameterConverter<Medication>> parameterConverters) {
        this.parameterConverters = parameterConverters;
        this.medicationService=medicationService;
    }

    public record MedicationResponse(FinishStatus status, Collection<Medication> medications) {}
    public MedicationResponse handleRequest(String requestData, boolean ignoreExpirationDate) {
        try {
            // Parse the request data into a SearchCriteria object.
            SearchCriteria<Medication> criteria = createCriteria(requestData);
            // Perform the search.
            Collection medications = medicationService.find(criteria,ignoreExpirationDate);

            // Create and return a response object.
            MedicationResponse response = new MedicationResponse(FinishStatus.SUCCESS, medications);
            return response;
        } catch (Exception e) {
            System.out.println("Error while processing the request: " + e.getMessage());
            // Create and return a failure response object.
            MedicationResponse response = new MedicationResponse(FinishStatus.FAILURE, null);
            return response;
        }
    }
    protected SearchCriteria<Medication> createCriteria(String requestData) {
        Map<String, String> params = parseRequestData(requestData);
        SearchCriteria<Medication> criteria = new MedicationCriteria<>();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            ParameterConverter<Medication> converter = getConverter(entry.getKey());
            if (converter != null) {
                Parameter<Medication> parameter = null;
                try {
                    parameter = converter.convert(entry.getValue());
                } catch (ParameterConversionException e) {
                    throw new RuntimeException(e);
                }
                criteria.add(parameter);
            }
        }//end of for

        return criteria;
    }//end of create criteria

    private Map<String, String> parseRequestData(String requestData) {
        Map<String, String> params = new HashMap<>();
        String[] pairs = requestData.split("&");

        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            if (keyValue.length == 2) {
                params.put(keyValue[0], keyValue[1]);
            }
        }//end of for
        return params;
    }//end of parseRequestData

    private ParameterConverter<Medication> getConverter(String key) {
        try {
            return RawConverters.valueOf(key.toUpperCase()).generic();
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }//end of getConverter
}

