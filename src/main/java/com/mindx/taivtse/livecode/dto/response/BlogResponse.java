package com.mindx.taivtse.livecode.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author taivt
 * @since 2022/03/05 19:58:59
 */
@Getter
@Setter
@Builder
public class BlogResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private Long authorId;
    private String authorName;
    private List<String> tags;
}
