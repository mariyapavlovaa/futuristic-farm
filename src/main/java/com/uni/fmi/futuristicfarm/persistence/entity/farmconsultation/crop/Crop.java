//package com.uni.fmi.futuristicfarm.persistence.entity.farmconsultation.crop;
//
//import com.sun.istack.NotNull;
//import com.uni.fmi.futuristicfarm.persistence.entity.BaseEntity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//import javax.validation.constraints.Size;
//
//import static com.uni.fmi.futuristicfarm.util.Constants.CROP_NAME_SIZE;
//import static com.uni.fmi.futuristicfarm.util.Constants.CROP_TABLE_NAME;
//import static com.uni.fmi.futuristicfarm.util.Constants.IS_DELETED;
//
//@Entity
//@Table(name = CROP_TABLE_NAME)
//public class Crop extends BaseEntity {
//
//    @NotNull
//    @Size(max = CROP_NAME_SIZE)
//    private String name;
//
//    @Column(name = IS_DELETED, columnDefinition = "boolean default false")
//    private Boolean isDeleted;
//
//    public Crop() {
//
//    }
//
//    public Crop(String name, Boolean isDeleted) {
//        this.name = name;
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
//    public Boolean getDeleted() {
//        return isDeleted;
//    }
//
//    public void setDeleted(Boolean deleted) {
//        isDeleted = deleted;
//    }
//}
