package www.dream.bbs.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.dream.bbs.board.mapper.PostMapper;
import www.dream.bbs.board.model.BoardVO;

@Service   // Container에 담기도록 지정
public class PostService {
	@Autowired
	private PostMapper postMapper;
}