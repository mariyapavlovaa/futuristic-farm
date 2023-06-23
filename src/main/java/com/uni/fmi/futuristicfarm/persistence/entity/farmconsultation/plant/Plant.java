//package com.uni.fmi.futuristicfarm.persistence.entity.farmconsultation.plant;
//
//import com.sun.istack.NotNull;
//import com.uni.fmi.futuristicfarm.persistence.entity.BaseEntity;
//import com.uni.fmi.futuristicfarm.persistence.entity.farmconsultation.crop.Crop;
//import com.uni.fmi.futuristicfarm.persistence.entity.farmconsultation.soil.Soil;
//import com.uni.fmi.futuristicfarm.persistence.entity.farmconsultation.sort.Sort;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//import javax.validation.constraints.Size;
//
//import static com.uni.fmi.futuristicfarm.util.Constants.IS_DELETED;
//import static com.uni.fmi.futuristicfarm.util.Constants.PLANT_DESCRIPTION_SIZE;
//import static com.uni.fmi.futuristicfarm.util.Constants.PLANT_NAME_SIZE;
//import static com.uni.fmi.futuristicfarm.util.Constants.PLANT_TABLE_NAME;
//
//@Entity
//@Table(name = PLANT_TABLE_NAME)
//public class Plant extends BaseEntity {
//
//    @NotNull
//    @Size(max = PLANT_NAME_SIZE)
//    private String name;
//
//    @NotNull
//    @Size(max = PLANT_DESCRIPTION_SIZE)
//    private String description;
//
////    @OneToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "sort_id", referencedColumnName = "id")
////    private Sort sort;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "soil_id", referencedColumnName = "id")
//    private Soil soil;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "crop_id")
//    private Crop crop;
//
//    @Column(name = IS_DELETED, columnDefinition = "boolean default false")
//    private Boolean isDeleted;
//
//    public Plant() {
//    }
//
//    public Plant(String name, String description, Soil soil, Boolean isDeleted) {
//        this.name = name;
//        this.description = description;
//        this.soil = soil;
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
//    public Soil getSoil() {
//        return soil;
//    }
//
//    public void setSoil(Soil soil) {
//        this.soil = soil;
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
