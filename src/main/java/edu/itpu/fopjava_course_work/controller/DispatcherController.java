package edu.itpu.fopjava_course_work.controller;

import edu.itpu.fopjava_course_work.entity.Medication;
import edu.itpu.fopjava_course_work.service.MedicationService;

import java.util.Collection;
import java.util.Map;

import static edu.itpu.fopjava_course_work.controller.FinishStatus.FAILURE;
import static edu.itpu.fopjava_course_work.controller.FinishStatus.SUCCESS;

public class DispatcherController {
    private final MedicationSearchController controller;
    private boolean ignoredExpirationDate = true;

    public DispatcherController(MedicationService medicationService, Map<String, ParameterConverter<Medication>> parameterConverters) {
        controller = new MedicationSearchController(medicationService, parameterConverters);
    }

    public void setIgnoredExpirationDate(boolean ignoredExpirationDate) {
        this.ignoredExpirationDate = ignoredExpirationDate;
    }

    public Collection retrieveAllMedications() {
        return controller.medicationService.retrieveAllMedications();
    }

    public void listen(String requestData) {

        MedicationSearchController.MedicationResponse response
                = controller.handleRequest(requestData, ignoredExpirationDate);
        if (response != null) {
            if (response.status() == SUCCESS && !response.medications().isEmpty() && response.medications() != null) {
                System.out.println("Response Status:" + response.status());
            } else {
                System.out.println("Responce Status" + FAILURE);
            }
        } else {
            System.out.println("No response received from the controller.");
        }
    }
}