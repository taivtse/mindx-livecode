package com.mindx.taivtse.livecode.repository;

import com.mindx.taivtse.livecode.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long>, JpaSpecificationExecutor<Tag> {
    List<Tag> findByNameIn(List<String> names);
}