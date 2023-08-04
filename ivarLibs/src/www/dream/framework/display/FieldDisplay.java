package www.dream.framework.display;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface FieldDisplay {
	// @FieldDisplay(order={3,4,4,2}, caption="내용")

	// 각 LRCU 화면에서의 출력 순서 -1 : no, 1~
	int[] order();
	// caption
	String caption();
}
