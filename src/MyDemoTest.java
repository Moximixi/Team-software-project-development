import static org.junit.Assert.*;

import org.junit.Test;

public class MyDemoTest {
	MyDemo mydemo=new MyDemo();
	@Test
	public void test() {
		
		mydemo.label_logIn.setText("修改测试");
		assertEquals("修改测试", mydemo.label_logIn.getText());
	}

}
