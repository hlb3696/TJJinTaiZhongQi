/**
 * 2017年10月27日
 */
package net.kingfore.test;

import java.lang.reflect.Field;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import net.kingfore.model.Propertie;

/**
 * @author JF_Hao
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class JieKongTest {
	
	
	@Test
	public void testJK(){
		
		
	}
	
	//测试反射
	@Test
	public void testReflection(){
		
		Class clazz = Propertie.class;
		
		System.out.println("结果：" + clazz.toString());
		
		/*Field[] fields = clazz.getFields();
		for (Field field : fields) {
			
			String name = field.getName();
			System.out.println("name:" + name);
			
		}*/
		
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.println(field.getName());
		}
		
		
	}
	
	

}
