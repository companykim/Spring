package www.dream.bbs.board.controller;
/**
 * RestController는 client 요청에 대한 분배 기능
 * service로 처리 위임하여 그 결과를
 * client에게 반환.
 * 길게 업무적 처리가 들어와 있으면 실수한 것임.
 */
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import www.dream.bbs.board.framework.nlp.pos.service.NounExtractor;
import www.dream.bbs.board.model.PostVO;
import www.dream.bbs.board.model.RipplyVO;
import www.dream.bbs.board.service.PostService;

@RestController // Container에 담기도록 지정
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}

	// post/listAll/000n
	@GetMapping("/annonymous/listAll/{boardId}")
	public ResponseEntity<List<PostVO>> listAllPost(@PathVariable String boardId) {
		List<PostVO> listResult = postService.listAllPost(boardId);
		return new ResponseEntity<>(postService.listAllPost(boardId), HttpStatus.OK);
	}

	/** 원글 상세, 첨부파일 목록, 댓글, 대댓 목록이 내부 변수에 채워짐 */
	// post/getPost/p001
	@GetMapping("/annonymous/getPost/{id}")
	public ResponseEntity<PostVO> findById(@PathVariable String id) {
		PostVO post = postService.findById(id);
		if (post == null) 
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(post, HttpStatus.OK);
	}

	// /post/extractTag/?docs=안녕하세요&docs=데이터분석
	// 유일한 단어 집합
	@GetMapping("/extractTag")
	public ResponseEntity<Set<String>> extractTag(String[] docs) {
		Set<String> ret = new HashSet<>();

		for (String doc : docs) {
			ret.addAll(NounExtractor.extracteNoun(doc));
		}
		return new ResponseEntity<>(ret, HttpStatus.OK);
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
	@PutMapping("/updatePost")
	public ResponseEntity<Integer> updatePost(PostVO post) {
		return new ResponseEntity<>(postService.updatePost(post), HttpStatus.OK);
	}

	/** */
	@PutMapping("/updateRipply")
	public ResponseEntity<Integer> updateRipply(PostVO post) {
		return new ResponseEntity<>(postService.updateRipply(post), HttpStatus.OK);
	}

	/** hid like로 지우기 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Integer> deleteRipply(@PathVariable String id) {
		return new ResponseEntity<>(postService.deleteRipply(id), HttpStatus.OK);
	}
}
