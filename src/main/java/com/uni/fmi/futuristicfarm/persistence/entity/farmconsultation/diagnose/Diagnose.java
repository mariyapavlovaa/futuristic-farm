package com.uni.fmi.futuristicfarm.persistence.entity.farmconsultation.diagnose;

import com.sun.istack.NotNull;
import com.uni.fmi.futuristicfarm.persistence.entity.BaseEntity;
import com.uni.fmi.futuristicfarm.persistence.entity.farmconsultation.consultation.Consultation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import static com.uni.fmi.futuristicfarm.util.Constants.CROP_NAME_SIZE;
import static com.uni.fmi.futuristicfarm.util.Constants.DIAGNOSE_TABLE_NAME;
import static com.uni.fmi.futuristicfarm.util.Constants.ILLNESS_DESCRIPTION_SIZE;
import static com.uni.fmi.futuristicfarm.util.Constants.IS_DELETED;

@Entity
@Table(name = DIAGNOSE_TABLE_NAME)
public class Diagnose extends BaseEntity {

    @Size(max = CROP_NAME_SIZE)
    private String name;

    @NotNull
    @Size(max = ILLNESS_DESCRIPTION_SIZE)
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consultation_id", referencedColumnName = "id")
    private Consultation consultation;

    @Column(name = IS_DELETED, columnDefinition = "boolean default false")
    private Boolean isDeleted;

    public Diagnose() {
    }

    public Diagnose(String name, String description, Consultation consultation, Boolean isDeleted) {
        this.name = name;
        this.description = description;
        this.consultation = consultation;
        this.isDeleted = isDeleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
