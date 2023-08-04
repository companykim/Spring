package www.dream.bb.model;

import java.util.ArrayList;
import java.util.List;

import www.dream.framework.display.FieldDisplay;
import www.dream.framework.display.VODisplayer;
import www.dream.framework.display.ViewType;

public class BillVO {
	//L : 내용, 수입, 지출
	//R : 내용, 지출
	@FieldDisplay(order={0, 0, 0, -1}, caption="내용")
	private String gttgtrhhh;
	@FieldDisplay(order={2, 1, 1, -1}, caption="지출")
	private int thjtyjh;
	@FieldDisplay(order={1, -1, 2, 0}, caption="수입")
	private int hjtjfhfy;
	@FieldDisplay(order={-1, -1, 2, 0}, caption="수bgb입")
	private int hjtjfhfyrege;
	@FieldDisplay(order={3, -1, 2, 0}, caption="수입gbg")
	private int hjtjfhfygtgtg;
	
	public BillVO() {
		super();
	}

	public BillVO(String gttgtrhhh, int thjtyjh, int hjtjfhfy) {
		super();
		this.gttgtrhhh = gttgtrhhh;
		this.thjtyjh = thjtyjh;
		this.hjtjfhfy = hjtjfhfy;
	}

	public BillVO(String gttgtrhhh, int thjtyjh, int hjtjfhfy, int hjtjfhfyrege, int hjtjfhfygtgtg) {
		super();
		this.gttgtrhhh = gttgtrhhh;
		this.thjtyjh = thjtyjh;
		this.hjtjfhfy = hjtjfhfy;
		this.hjtjfhfyrege = hjtjfhfyrege;
		this.hjtjfhfygtgtg = hjtjfhfygtgtg;
	}

	public static List<BillVO> getData() {
		List<BillVO> ret = new ArrayList<>();
		ret.add(new BillVO("rgtg", 3, 5, 0, 7));
		ret.add(new BillVO("ftgerfr", -3, -5, 4, 2));
		return ret;
	}
	
	public static void main(String[] args) {
		List<String> list = VODisplayer.getCaptionList(BillVO.class, ViewType.List);
		for (String s : list)
			System.out.println(s);
		
		list = VODisplayer.getCaptionList(BillVO.class, ViewType.Update);
		for (String s : list)
			System.out.println(s);
	}
}
