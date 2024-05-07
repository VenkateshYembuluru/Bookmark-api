package com.venkat.bookmarkerapi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.bookmarkerapi.domain.Bookmark;
import com.venkat.bookmarkerapi.domain.BookmarkService;
import com.venkat.bookmarkerapi.domain.BookmarksDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/bookmark")
public class BookmarkController {

	@Autowired
	private BookmarkService bookmarkService;

	@GetMapping("/one")
	public List<Bookmark> getBookmarksOne(@RequestParam(name = "page", defaultValue = "1")Integer page ){
		return bookmarkService.getAllBookMarksOne(page);
	}
	
	@GetMapping("/two")
	public BookmarksDTO getBookmarks(@RequestParam(name = "page", defaultValue = "1")Integer page ){
		return bookmarkService.getAllBookMarks(page);
	}
}
