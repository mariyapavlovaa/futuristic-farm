//package com.uni.fmi.futuristicfarm.persistence.entity.farmconsultation.soil;
//
//import com.sun.istack.NotNull;
//import com.uni.fmi.futuristicfarm.persistence.entity.BaseEntity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//import javax.validation.constraints.Size;
//
//import static com.uni.fmi.futuristicfarm.util.Constants.IS_DELETED;
//import static com.uni.fmi.futuristicfarm.util.Constants.SOIL_DESCRIPTION_SIZE;
//import static com.uni.fmi.futuristicfarm.util.Constants.SOIL_NAME_SIZE;
//import static com.uni.fmi.futuristicfarm.util.Constants.SOIL_TABLE_NAME;
//import static com.uni.fmi.futuristicfarm.util.Constants.SOIL_TEMPERATURE_SIZE;
//
//@Entity
//@Table(name = SOIL_TABLE_NAME)
//public class Soil extends BaseEntity {
//
//    @NotNull
//    @Size(max = SOIL_NAME_SIZE)
//    private String name;
//
//    @NotNull
//    @Size(max = SOIL_DESCRIPTION_SIZE)
//    private String description;
//
//    @NotNull
//    @Size(max = SOIL_TEMPERATURE_SIZE)
//    private String temperature;
//
//    @Column(name = IS_DELETED, columnDefinition = "boolean default false")
//    private Boolean isDeleted;
//
//    public Soil() {
//    }
//
//    public Soil(String name, String description, String temperature, Boolean isDeleted) {
//        this.name = name;
//        this.description = description;
//        this.temperature = temperature;
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
//    public String getTemperature() {
//        return temperature;
//    }
//
//    public void setTemperature(String temperature) {
//        this.temperature = temperature;
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
