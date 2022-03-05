package com.mindx.taivtse.livecode.controller;

import com.mindx.taivtse.livecode.dto.request.BlogCreationRequest;
import com.mindx.taivtse.livecode.dto.request.AddCommentRequest;
import com.mindx.taivtse.livecode.dto.response.AddCommentResponse;
import com.mindx.taivtse.livecode.dto.response.BlogCreationResponse;
import com.mindx.taivtse.livecode.dto.response.BlogsResponse;
import com.mindx.taivtse.livecode.dto.response.CommentsResponse;
import com.mindx.taivtse.livecode.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author taivt
 * @since 2022/03/05 19:54:24
 */
@RestController
@RequestMapping("/api/v1/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping
    public ResponseEntity<BlogCreationResponse> createBlog(@RequestBody BlogCreationRequest request) {
        BlogCreationResponse blogCreationResponse = blogService.createBlog(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(blogCreationResponse);
    }

    @GetMapping
    public ResponseEntity<BlogsResponse> getAllBlogs() {
        BlogsResponse blogsResponse = blogService.getAllBlogs();
        return ResponseEntity.ok(blogsResponse);
    }

    @PostMapping("/{blogId}/comments")
    public ResponseEntity<AddCommentResponse> addComment(@RequestBody AddCommentRequest request) {
        AddCommentResponse addCommentResponse = blogService.addComment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(addCommentResponse);
    }

    @GetMapping("/{blogId}/comments")
    public ResponseEntity<CommentsResponse> getBlogComments(@PathVariable Long blogId) {
        CommentsResponse commentsResponse = blogService.getBlogComments(blogId);
        return ResponseEntity.ok(commentsResponse);
    }
}
