/**
 * 2017年11月9日
 */
package net.kingfore;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * @author JF_Hao
 *
 */
public class ServletInitializer extends SpringBootServletInitializer{
	
	@Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(Application.class);  
    }  

}
