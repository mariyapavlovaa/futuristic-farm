//package com.uni.fmi.futuristicfarm.persistence.entity.farmconsultation.illness;
//
//import com.sun.istack.NotNull;
//import com.uni.fmi.futuristicfarm.persistence.entity.BaseEntity;
//import com.uni.fmi.futuristicfarm.persistence.entity.farmconsultation.illnesssymptoms.Symptoms;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//import javax.validation.constraints.Size;
//
//import java.util.List;
//
//import static com.uni.fmi.futuristicfarm.util.Constants.ILLNESS_DESCRIPTION_SIZE;
//import static com.uni.fmi.futuristicfarm.util.Constants.ILLNESS_NAME_SIZE;
//import static com.uni.fmi.futuristicfarm.util.Constants.ILLNESS_TABLE_NAME;
//import static com.uni.fmi.futuristicfarm.util.Constants.IS_DELETED;
//
//@Entity
//@Table(name = ILLNESS_TABLE_NAME)
//public class Illness extends BaseEntity {
//
//    @NotNull
//    @Size(max = ILLNESS_NAME_SIZE)
//    private String name;
//
//    @NotNull
//    @Size(max = ILLNESS_DESCRIPTION_SIZE)
//    private String description;
//
//    @ManyToMany
//    @JoinTable(
//            name = "illness_symptoms",
//            joinColumns = @JoinColumn(name = "illness_id"),
//            inverseJoinColumns = @JoinColumn(name = "symptoms_id"))
//    private List<Symptoms> symptoms;
//
////    @OneToMany(mappedBy = "illness", fetch = FetchType.LAZY)
////    private List<IllnessSymptoms> illnessSymptoms;
//
//    @Column(name = IS_DELETED, columnDefinition = "boolean default false")
//    private Boolean isDeleted;
//
//    public Illness() {
//    }
//
//    public Illness(String name, String description, List<Symptoms> symptoms, Boolean isDeleted) {
//        this.name = name;
//        this.description = description;
//        this.symptoms = symptoms;
//        this.isDeleted = isDeleted;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public List<Symptoms> getIllnessSymptoms() {
//        return symptoms;
//    }
//
//    public void setIllnessSymptoms(List<Symptoms> symptoms) {
//        this.symptoms = symptoms;
//    }
//
//    public Boolean getDeleted() {
//        return isDeleted;
//    }
//
//    public void setDeleted(Boolean deleted) {
//        isDeleted = deleted;
//    }
//}
