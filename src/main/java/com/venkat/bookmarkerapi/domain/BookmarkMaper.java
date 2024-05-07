package com.venkat.bookmarkerapi.domain;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public class BookmarkMaper {


	public  BookmarkDTO toDTO(Bookmark bookmark ) {
		BookmarkDTO dto = new BookmarkDTO();

		dto.setCreatedAt(bookmark.getCreatedAt());
		dto.setId(bookmark.getId());
		dto.setTitle(bookmark.getTitle());
		dto.setUrl(bookmark.getUrl());
		
		return dto;
		
	}
}
