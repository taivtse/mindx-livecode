package com.mindx.taivtse.livecode.service.impl;

import com.mindx.taivtse.livecode.dto.request.BlogCreationRequest;
import com.mindx.taivtse.livecode.dto.response.BlogCreationResponse;
import com.mindx.taivtse.livecode.entity.Blog;
import com.mindx.taivtse.livecode.entity.Tag;
import com.mindx.taivtse.livecode.repository.BlogRepository;
import com.mindx.taivtse.livecode.repository.TagRepository;
import com.mindx.taivtse.livecode.service.BlogService;
import com.mindx.taivtse.livecode.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author taivt
 * @since 2022/03/05 19:55:19
 */
@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final TagService tagService;

    @Override
    public BlogCreationResponse createBlog(BlogCreationRequest request) {
        Blog blog = Blog.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .userId(1L) // todo
                .build();
        blogRepository.save(blog);

        if (!CollectionUtils.isEmpty(request.getTags())) {
            tagService.linkBlogToTags(blog, request.getTags());
        }

        return BlogCreationResponse.builder()
                .id(blog.getId())
                .createdAt(blog.getCreatedAt())
                .build();
    }
}
