package www.dream.bbs.kor.pos.komoran.test;

import java.util.List;

import www.dream.bbs.framework.nlp.pos.service.NounExtractor;

public class KomoranTest {
	
    public static void main(String[] args) {
        String document = "우리집에는 강아지 네오가 있습니다. 네오는 밝은 성격입니다.";

        List<String> nounList = NounExtractor.extracteNoun(document);
        for(String noun : nounList) {
            System.out.println(noun);
        }
    }
}
