package com.uni.fmi.futuristicfarm.persistence.entity.seasonphase;

import com.sun.istack.NotNull;
import com.uni.fmi.futuristicfarm.persistence.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import java.time.LocalDate;

import static com.uni.fmi.futuristicfarm.util.Constants.SEASON_END_DATE;
import static com.uni.fmi.futuristicfarm.util.Constants.SEASON_END_DATE_SIZE;
import static com.uni.fmi.futuristicfarm.util.Constants.SEASON_PHASE_DESCRIPTION;
import static com.uni.fmi.futuristicfarm.util.Constants.SEASON_PHASE_DESCRIPTION_SIZE;
import static com.uni.fmi.futuristicfarm.util.Constants.SEASON_PHASE_NAME;
import static com.uni.fmi.futuristicfarm.util.Constants.SEASON_PHASE_PHASE_NAME_SIZE;
import static com.uni.fmi.futuristicfarm.util.Constants.SEASON_PHASE_TABLE_NAME;
import static com.uni.fmi.futuristicfarm.util.Constants.SEASON_START_DATE;
import static com.uni.fmi.futuristicfarm.util.Constants.SEASON_START_DATE_SIZE;

@Entity
@Table(name = SEASON_PHASE_TABLE_NAME)
public class SeasonPhase extends BaseEntity {

    private static final long SERIAL_VERSION_ID = 1L;

    @NotNull
    @Size(max = SEASON_PHASE_PHASE_NAME_SIZE)
    @Column(name = SEASON_PHASE_NAME)
    private String phaseName;

    @Size(max = SEASON_PHASE_DESCRIPTION_SIZE)
    @Column(name = SEASON_PHASE_DESCRIPTION)
    private String description;

    @Size(max = SEASON_START_DATE_SIZE)
    @Column(name = SEASON_START_DATE)
    private LocalDate seasonStartDate;

    @Size(max = SEASON_END_DATE_SIZE)
    @Column(name = SEASON_END_DATE)
    private LocalDate seasonEndDate;

    public SeasonPhase() {
    }

    public SeasonPhase(String phaseName) {
        this.phaseName = phaseName;
    }

    //TODO add eaquals and hash code
    public SeasonPhase(String phaseName,
                       String description,
                       LocalDate seasonStartDate,
                       LocalDate seasonEndDate) {

        this.phaseName = phaseName;
        this.description = description;
        this.seasonStartDate = seasonStartDate;
        this.seasonEndDate = seasonEndDate;
    }

    public String getPhaseName() {
        return phaseName;
    }

    public void setPhaseName(String phaseName) {
        this.phaseName = phaseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getSeasonStartDate() {
        return seasonStartDate;
    }

    public void setSeasonStartDate(LocalDate seasonStartDate) {
        this.seasonStartDate = seasonStartDate;
    }

    public LocalDate getSeasonEndDate() {
        return seasonEndDate;
    }

    public void setSeasonEndDate(LocalDate seasonEndDate) {
        this.seasonEndDate = seasonEndDate;
    }
}