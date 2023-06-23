//package com.uni.fmi.futuristicfarm.persistence.entity.farmconsultation.sort;
//
//import com.sun.istack.NotNull;
//import com.uni.fmi.futuristicfarm.persistence.entity.BaseEntity;
//import com.uni.fmi.futuristicfarm.persistence.entity.farmconsultation.crop.Crop;
//import com.uni.fmi.futuristicfarm.persistence.entity.farmconsultation.illnesssymptoms.Symptoms;
//import com.uni.fmi.futuristicfarm.persistence.entity.farmconsultation.plant.Plant;
//import com.uni.fmi.futuristicfarm.persistence.entity.seasonphase.SeasonPhase;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.validation.constraints.Size;
//
//
//import java.util.List;
//
//import static com.uni.fmi.futuristicfarm.util.Constants.IS_DELETED;
//import static com.uni.fmi.futuristicfarm.util.Constants.SORT_DESCRIPTION;
//import static com.uni.fmi.futuristicfarm.util.Constants.SORT_DESCRIPTION_SIZE;
//import static com.uni.fmi.futuristicfarm.util.Constants.SORT_NAME_SIZE;
//import static com.uni.fmi.futuristicfarm.util.Constants.SORT_TABLE_NAME;
//
//@Entity
//@Table(name = SORT_TABLE_NAME)
//public class Sort extends BaseEntity {
//
//    @NotNull
//    @Size(max = SORT_NAME_SIZE)
//    private String name;
//
//    @NotNull
//    @Size(max = SORT_DESCRIPTION_SIZE)
//    @Column(name = SORT_DESCRIPTION)
//    private String description;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "plant_id")
//    private Plant plant;
//
//    @ManyToMany
//    @JoinTable(
//            name = "season_phase_sort",
//            joinColumns = @JoinColumn(name = "sort_id"),
//            inverseJoinColumns = @JoinColumn(name = "season_phase_id"))
//    private List<SeasonPhase> seasonPhases;
//
//    @Column(name = IS_DELETED, columnDefinition = "boolean default false")
//    private Boolean isDeleted;
//
//    public Sort() {
//    }
//
//    public Sort(String name, String description, Boolean isDeleted) {
//        this.name = name;
//        this.description = description;
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
//    public Boolean getDeleted() {
//        return isDeleted;
//    }
//
//    public void setDeleted(Boolean deleted) {
//        isDeleted = deleted;
//    }
//}
