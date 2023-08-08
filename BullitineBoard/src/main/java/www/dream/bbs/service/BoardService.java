package www.dream.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.dream.bbs.model.BoardVO;
import www.dream.bbs.model.mapper.BoardMapper;

@Service   // Container에 담기도록 지정
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;
	
	public List<BoardVO> listAll() {
		return boardMapper.listAll();
	}
	
	public BoardVO findById(String id) {
		return boardMapper.findById(id);
	}
}
