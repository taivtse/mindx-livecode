package com.mindx.taivtse.livecode.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author taivt
 * @since 2022/03/05 19:58:59
 */
@Getter
@Setter
@Builder
public class CommentResponse {
    private Long commentId;
    private Long userId;
    private String content;
}
