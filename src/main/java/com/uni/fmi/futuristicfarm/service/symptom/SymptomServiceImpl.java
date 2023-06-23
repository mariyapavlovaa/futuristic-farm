package com.uni.fmi.futuristicfarm.service.symptom;

import com.uni.fmi.futuristicfarm.mapper.seasonphase.SeasonPhaseMapper;
import com.uni.fmi.futuristicfarm.mapper.seasonphase.SeasonPhaseMapperImpl;
import com.uni.fmi.futuristicfarm.mapper.symptom.SymptomMapper;
import com.uni.fmi.futuristicfarm.persistence.repository.seasonphase.SeasonPhaseRepository;
import com.uni.fmi.futuristicfarm.persistence.repository.symptom.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SymptomServiceImpl implements SymptomService{

    private final SymptomRepository symptomRepository;
   // private final SymptomMapper symptomMapper;

    @Autowired
    public SymptomServiceImpl(SymptomRepository symptomRepository) {
        this.symptomRepository = symptomRepository;
       // this.symptomMapper = symptomMapper;
    }

}
