package com.mindx.taivtse.livecode.service;

import com.mindx.taivtse.livecode.entity.Blog;
import com.mindx.taivtse.livecode.entity.Tag;

import java.util.List;
import java.util.Map;

/**
 * @author taivt
 * @since 2022/03/05 19:56:07
 */
public interface TagService {
    void linkBlogToTags(Blog blog, List<String> tagNames);
    Map<Long, List<String>> getBlogTagsMap(List<Long> blogIds);
}
