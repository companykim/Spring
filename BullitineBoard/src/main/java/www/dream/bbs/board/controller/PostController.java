package www.dream.bbs.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import www.dream.bbs.board.model.PostVO;
import www.dream.bbs.board.model.RipplyVO;
import www.dream.bbs.board.service.PostService;

@RestController  // Container에 담기도록 지정
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}

	// post/listAll/000n
	@GetMapping("/listAll/{boardId}")
	public ResponseEntity<List<PostVO>> listAllPost(@PathVariable String boardId) {
		return new ResponseEntity<>(postService.listAllPost(boardId), HttpStatus.OK);
	}
	
	/** 원글 상세, 첨부파일 목록, 댓글, 대댓 목록이 내부 변수에 채워짐 */
	// post/p001
	@GetMapping("/{id}")
	public ResponseEntity<PostVO> findById(@PathVariable String id) {
		return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
	}
	
	/** 게시판에 원글 달기 /post/createPost */ 
	@PostMapping("/createPost")
	public ResponseEntity<Integer> createPost(PostVO post) {
		return new ResponseEntity<>(postService.createPost(post), HttpStatus.OK);
	}
	
	/** 댓글 달기, parent의 hid의 연결된 hid 만들기 */
	@PostMapping("/createRipply")
	public ResponseEntity<Integer> createRipply(RipplyVO parent, RipplyVO reply) {
		return new ResponseEntity<>(postService.createRipply(parent, reply), HttpStatus.OK);
	}
	
	/** */
	@PostMapping("/updatePost")
	public ResponseEntity<Integer> updatePost(PostVO post) {
		return new ResponseEntity<>(postService.updatePost(post), HttpStatus.OK);
	}
	/** */
	@PostMapping("/updateRipply")
	public ResponseEntity<Integer> updateRipply(PostVO post) {
		return new ResponseEntity<>(postService.updateRipply(post), HttpStatus.OK);
	}
	
	/** hid like로 지우기 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deleteRipply(@PathVariable String id) {
		return new ResponseEntity<>(postService.deleteRipply(id), HttpStatus.OK);
	}
}
