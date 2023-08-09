package www.dream.bbs.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import www.dream.bbs.board.model.BoardVO;
import www.dream.bbs.board.service.PostService;

@RestController  // Container에 담기도록 지정
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostService postService;
}
