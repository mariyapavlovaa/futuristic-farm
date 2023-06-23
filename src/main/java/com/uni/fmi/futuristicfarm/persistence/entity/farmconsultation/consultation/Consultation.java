package com.uni.fmi.futuristicfarm.persistence.entity.farmconsultation.consultation;

import com.sun.istack.NotNull;
import com.uni.fmi.futuristicfarm.persistence.entity.BaseEntity;
import com.uni.fmi.futuristicfarm.persistence.entity.farmconsultation.illnesssymptom.Symptom;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import java.util.List;

import static com.uni.fmi.futuristicfarm.util.Constants.CONSULTATION_PLANT_NAME;
import static com.uni.fmi.futuristicfarm.util.Constants.CONSULTATION_PLANT_NAME_SIZE;
import static com.uni.fmi.futuristicfarm.util.Constants.CONSULTATION_TABLE_NAME;
import static com.uni.fmi.futuristicfarm.util.Constants.CONSULTATION_TREATMENT_DESCRIPTION;
import static com.uni.fmi.futuristicfarm.util.Constants.CONSULTATION_TREATMENT_DESCRIPTION_SIZE;
import static com.uni.fmi.futuristicfarm.util.Constants.IS_DELETED;

@Entity
@Table(name = CONSULTATION_TABLE_NAME)
public class Consultation extends BaseEntity {

    @NotNull
    @Size(max = CONSULTATION_PLANT_NAME_SIZE)
    @Column(name = CONSULTATION_PLANT_NAME)
    private String plantName;

    @ManyToMany
    @JoinTable(
            name = "consultation_symptom",
            joinColumns = @JoinColumn(name = "consultation_id"),
            inverseJoinColumns = @JoinColumn(name = "symptom_id"))
    private List<Symptom> symptoms;

    @Size(max = CONSULTATION_TREATMENT_DESCRIPTION_SIZE)
    @Column(name = CONSULTATION_TREATMENT_DESCRIPTION)
    private String treatmentDescription;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] picture;

    @Column(name = IS_DELETED, columnDefinition = "boolean default false")
    private Boolean isDeleted;

    public Consultation() {
    }

    public Consultation(String plantName, List<Symptom> symptoms, String treatmentDescription, byte[] picture, Boolean isDeleted) {
        this.plantName = plantName;
        this.symptoms = symptoms;
        this.treatmentDescription = treatmentDescription;
        this.picture = picture;
        this.isDeleted = isDeleted;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    public String getTreatmentDescription() {
        return treatmentDescription;
    }

    public void setTreatmentDescription(String treatmentDescription) {
        this.treatmentDescription = treatmentDescription;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
