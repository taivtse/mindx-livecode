package com.mindx.taivtse.livecode.service;

import com.mindx.taivtse.livecode.entity.Blog;
import com.mindx.taivtse.livecode.entity.Tag;

import java.util.List;

/**
 * @author taivt
 * @since 2022/03/05 19:56:07
 */
public interface TagService {
    void linkBlogToTags(Blog blog, List<String> tagNames);
}
