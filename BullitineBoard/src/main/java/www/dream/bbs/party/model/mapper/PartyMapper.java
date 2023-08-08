package www.dream.bbs.party.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import www.dream.bbs.party.model.PartyVO;

@Mapper
public interface PartyMapper {
	// LRCUD 순서로 함수들을 배치하여 빠르게 따라갈(추적성) 수 있도록 합니다.
	public List<PartyVO> listAll();
}
