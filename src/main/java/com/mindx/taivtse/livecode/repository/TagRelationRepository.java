package com.mindx.taivtse.livecode.repository;

import com.mindx.taivtse.livecode.entity.TagRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TagRelationRepository extends JpaRepository<TagRelation, Long>, JpaSpecificationExecutor<TagRelation> {

}