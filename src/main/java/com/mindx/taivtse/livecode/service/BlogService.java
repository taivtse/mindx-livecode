package com.mindx.taivtse.livecode.service;

import com.mindx.taivtse.livecode.dto.request.AddCommentRequest;
import com.mindx.taivtse.livecode.dto.request.BlogCreationRequest;
import com.mindx.taivtse.livecode.dto.response.AddCommentResponse;
import com.mindx.taivtse.livecode.dto.response.BlogCreationResponse;
import com.mindx.taivtse.livecode.dto.response.BlogsResponse;
import com.mindx.taivtse.livecode.dto.response.CommentsResponse;

/**
 * @author taivt
 * @since 2022/03/05 19:54:57
 */
public interface BlogService {
    BlogCreationResponse createBlog(BlogCreationRequest request);
    BlogsResponse getAllBlogs();
    AddCommentResponse addComment(Long blogId, AddCommentRequest request);
    CommentsResponse getBlogComments(Long blogId);
}
