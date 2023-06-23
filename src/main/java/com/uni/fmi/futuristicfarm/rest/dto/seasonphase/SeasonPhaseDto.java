package com.uni.fmi.futuristicfarm.rest.dto.seasonphase;

import com.uni.fmi.futuristicfarm.rest.dto.BaseDto;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class SeasonPhaseDto extends BaseDto {

    @NotBlank
    private String phaseName;

    @NotBlank
    private String description;

    private LocalDate seasonStartDate;

    private LocalDate seasonEndDate;

    public SeasonPhaseDto() {
    }

    public SeasonPhaseDto(String phaseName,
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
