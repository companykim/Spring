package www.dream.framework.display;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class VODisplayer {
	public static List<String> getCaptionList(Class cls, ViewType viewType) {
		List<String> ret = new ArrayList<>();
		Field[] fields = cls.getDeclaredFields();
		FieldDisplay[] displayes = new FieldDisplay[fields.length];

		for (Field field : fields) {
			FieldDisplay dis = field.getAnnotation(FieldDisplay.class);
			if (dis != null) {
				int 출력순서 = dis.order()[viewType.ordinal()];
				if (출력순서 != -1) {
					displayes[출력순서] = dis;
				}
			}
		}
		for (FieldDisplay fdAnno : displayes) {
			if (fdAnno != null) 
				ret.add(fdAnno.caption());
		}
		
		return ret;
	}
	
	public static List<Object> getDataList(Object data, ViewType viewType) {
		List<Object> listFieldData = new ArrayList<>();
		
		Field[] fields = data.getClass().getDeclaredFields();
		Field[] displayOrder = new Field[fields.length];

		for (Field field : fields) {
			FieldDisplay dis = field.getAnnotation(FieldDisplay.class);
			if (dis != null) {
				int 출력순서 = dis.order()[viewType.ordinal()];
				if (출력순서 != -1) {
					displayOrder[출력순서] = field;
				}
			}
		}
		
		for (Field 관심정보 : displayOrder) {
			if (관심정보 != null) {
				관심정보.setAccessible(true);
				try {
					Object ooo = 관심정보.get(data);
					if (ooo instanceof Integer) {
						ooo = (int) ooo + 100;
						관심정보.set(data, ooo);
					}
					
					listFieldData.add(관심정보.get(data));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return listFieldData;
	}
}
