package com.cos.blog.dto;

import com.cos.blog.model.Board;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailResponseDto {
	private Board board;
	private String username;
}
