package com.mindx.taivtse.livecode.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author taivt
 * @since 2022/03/05 19:58:59
 */
@Getter
@Setter
@Builder
public class BlogCreationResponse {
    private Long id;
    private LocalDateTime createdAt;
}
