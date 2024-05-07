package com.venkat.bookmarkerapi.domain;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
public class BookmarkService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BookmarkService.class);
	@Autowired
	private BookmarkRepository bookmarkRepository;
	@Autowired
	private BookmarkMaper bookmarkMaper;
	
	@Transactional(readOnly = true)
	public List<Bookmark> getAllBookMarksOne(Integer page){
		int pageCnt = page < 1 ? 0 : page-1;
		Pageable pageable = PageRequest.of(pageCnt, 5, Direction.DESC, "createdAt");
		return bookmarkRepository.findAll(pageable).getContent();
	}
	
	/***** This method getting all the table fields data and then converting to DTO which are may required  */
	/*
	@Transactional(readOnly = true)
	public BookmarksDTO getAllBookMarks(Integer page){
		int pageCnt = page < 1 ? 0 : page-1;
		Pageable pageable = PageRequest.of(pageCnt, 5, Direction.DESC, "createdAt");
		//Page<BookmarkDTO> bookmarkDTO = bookmarkRepository.findAll(pageable).map(bookmark -> bookmarkMaper.toDTO(bookmark));
		//Page<BookmarkDTO> bookmarkDTO = bookmarkRepository.findAll(pageable).map(bookmarkMaper::toDTO); //- Using Method reference
		Page<BookmarkDTO> bookmarkDTO = bookmarkRepository.findBookmarkWithAllCloumns(pageable).map(bookmarkMaper::toDTO); 
		return  new BookmarksDTO(bookmarkDTO);
	}*/
	
	/***** This method getting only required columns form table using - DTO projections*/
	@Transactional(readOnly = true)
	public BookmarksDTO getAllBookMarks(Integer page){
		LOGGER.warn("in getAllBookMarks () method page : {}",page);
		int pageCnt = page < 1 ? 0 : page-1;
		Pageable pageable = PageRequest.of(pageCnt, 5, Direction.DESC, "createdAt");
		Page<BookmarkDTO> bookmarkDTO = bookmarkRepository.findBookmarks(pageable);
		return  new BookmarksDTO(bookmarkDTO);
	}

}
