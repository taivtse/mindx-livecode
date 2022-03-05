package com.mindx.taivtse.livecode.repository;

import com.mindx.taivtse.livecode.entity.TagRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TagRelationRepository extends JpaRepository<TagRelation, Long>, JpaSpecificationExecutor<TagRelation> {
    List<TagRelation> findAllByBlogIdIn(List<Long> blogIds);
}