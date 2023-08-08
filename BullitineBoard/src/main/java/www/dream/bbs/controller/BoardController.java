package www.dream.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import www.dream.bbs.model.BoardVO;
import www.dream.bbs.service.BoardService;

@RestController  // Container에 담기도록 지정
@RequestMapping("/bb")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/listAll")
	public ResponseEntity<?> listAll() {
		List<BoardVO> list = boardService.listAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable String id) {
		BoardVO board = boardService.findById(id);
		return new ResponseEntity<>(board, HttpStatus.OK);
	}
}
