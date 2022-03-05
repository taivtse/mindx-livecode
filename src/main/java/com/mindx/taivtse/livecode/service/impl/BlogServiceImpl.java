package com.mindx.taivtse.livecode.service.impl;

import com.mindx.taivtse.livecode.dto.request.AddCommentRequest;
import com.mindx.taivtse.livecode.dto.request.BlogCreationRequest;
import com.mindx.taivtse.livecode.dto.response.*;
import com.mindx.taivtse.livecode.entity.Blog;
import com.mindx.taivtse.livecode.entity.Comment;
import com.mindx.taivtse.livecode.entity.User;
import com.mindx.taivtse.livecode.repository.*;
import com.mindx.taivtse.livecode.service.BlogService;
import com.mindx.taivtse.livecode.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author taivt
 * @since 2022/03/05 19:55:19
 */
@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final TagService tagService;

    @Override
    public BlogCreationResponse createBlog(BlogCreationRequest request) {
        Blog blog = Blog.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .authorId(1L) // todo
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

    @Override
    public BlogsResponse getAllBlogs() {
        List<Blog> blogs = blogRepository.findAll();

        List<Long> blogIds = new ArrayList<>();
        List<Long> userIds = new ArrayList<>();
        for (Blog blog : blogs) {
            blogIds.add(blog.getId());
            userIds.add(blog.getAuthorId());
        }

        List<User> users = userRepository.findAllById(userIds);
        Map<Long, User> userMap = users.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));

        Map<Long, List<String>> blogTagsMap = tagService.getBlogTagsMap(blogIds);

        List<BlogResponse> blogResponses = blogs.stream()
                .map(blog -> {
                    return BlogResponse.builder()
                            .id(blog.getId())
                            .title(blog.getTitle())
                            .content(blog.getContent())
                            .createdAt(blog.getCreatedAt())
                            .authorId(blog.getAuthorId())
                            .authorName(userMap.get(blog.getAuthorId()).getFullName())
                            .tags(blogTagsMap.get(blog.getId()))
                            .build();
                })
                .collect(Collectors.toList());
        return BlogsResponse.builder()
                .blogs(blogResponses)
                .build();
    }

    @Override
    public AddCommentResponse addComment(AddCommentRequest request) {
        Comment comment = Comment.builder()
                .content(request.getContent())
                .blogId(request.getBlogId())
                .userId(1L)  // TODO
                .build();

        comment = commentRepository.save(comment);
        return AddCommentResponse.builder()
                .commentId(comment.getId())
                .build();
    }

    @Override
    public CommentsResponse getBlogComments(Long blogId) {
        List<Comment> comments = commentRepository.findAllByBlogId(blogId);
        List<CommentResponse> commentResponses = comments.stream()
                .map(comment -> {
                    return CommentResponse.builder()
                            .commentId(comment.getId())
                            .userId(comment.getUserId())
                            .content(comment.getContent())
                            .build();
                })
                .collect(Collectors.toList());

        return CommentsResponse.builder()
                .comments(commentResponses)
                .build();
    }
}
