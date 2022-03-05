package com.mindx.taivtse.livecode.service;

import com.mindx.taivtse.livecode.dto.request.BlogCreationRequest;
import com.mindx.taivtse.livecode.dto.response.BlogCreationResponse;
import com.mindx.taivtse.livecode.dto.response.BlogsResponse;

/**
 * @author taivt
 * @since 2022/03/05 19:54:57
 */
public interface BlogService {
    BlogCreationResponse createBlog(BlogCreationRequest request);
    BlogsResponse getAllBlogs();
}
