package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

public class Visit extends BaseEntity {

    private Pet pet;

    private LocalDate dateOfVisit;

    private String description;

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public LocalDate getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(LocalDate dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}