package com.uni.fmi.futuristicfarm.persistence.repository.tag;

import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findByName(String name);

    Optional<Tag> findByAbbreviation(String abbreviation);
}
