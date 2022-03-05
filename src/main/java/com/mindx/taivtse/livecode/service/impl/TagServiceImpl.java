package com.mindx.taivtse.livecode.service.impl;

import com.mindx.taivtse.livecode.entity.Blog;
import com.mindx.taivtse.livecode.entity.Tag;
import com.mindx.taivtse.livecode.entity.TagRelation;
import com.mindx.taivtse.livecode.repository.TagRelationRepository;
import com.mindx.taivtse.livecode.repository.TagRepository;
import com.mindx.taivtse.livecode.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author taivt
 * @since 2022/03/05 19:56:07
 */
@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final TagRelationRepository tagRelationRepository;

    @Override
    public void linkBlogToTags(Blog blog, List<String> tagNames) {
        List<Tag> existingTags = tagRepository.findByNameIn(tagNames);
        Map<String, Long> tagMap = existingTags.stream()
                .collect(Collectors.toMap(Tag::getName, Tag::getId));

        for (String tagName : tagNames) {
            Long tagId = tagMap.get(tagName);
            if (tagId == null) {
                // Create new tag
                Tag newTag = Tag.builder()
                        .name(tagName)
                        .build();
                newTag = tagRepository.save(newTag);
                tagId = newTag.getId();
            }

            // Create relationship
            TagRelation tagRelation = TagRelation.builder()
                    .blogId(blog.getId())
                    .tagId(tagId)
                    .build();
            tagRelationRepository.save(tagRelation);
        }
    }

    @Override
    public Map<Long, List<String>> getBlogTagsMap(List<Long> blogIds) {
        List<TagRelation> tagRelations = tagRelationRepository.findAllByBlogIdIn(blogIds);
        List<Long> tagIds = tagRelations.stream()
                .map(TagRelation::getTagId)
                .collect(Collectors.toList());

        List<Tag> tags = tagRepository.findAllById(tagIds);
        Map<Long, String> tagMap = tags.stream()
                .collect(Collectors.toMap(Tag::getId, Tag::getName));

        Map<Long, List<String>> blogTagsMap = new HashMap<>();
        for (TagRelation tagRelation : tagRelations) {
            String tagName = tagMap.get(tagRelation.getTagId());
            List<String> tagNames = blogTagsMap.computeIfAbsent(tagRelation.getBlogId(), missKey -> new ArrayList<>());
            tagNames.add(tagName);
        }

        return blogTagsMap;
    }
}
