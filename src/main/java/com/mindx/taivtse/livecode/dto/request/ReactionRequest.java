package com.mindx.taivtse.livecode.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author taivt
 * @since 2022/03/05 19:58:59
 */
@Getter
@Setter
public class ReactionRequest {
    private Long blogId;
    private String content;
    private List<String> tags;
}
