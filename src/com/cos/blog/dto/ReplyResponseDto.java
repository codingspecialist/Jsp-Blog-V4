package com.cos.blog.dto;

import com.cos.blog.model.Reply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyResponseDto {
	private Reply reply;
	private String username;
	private String userProfile;
}
