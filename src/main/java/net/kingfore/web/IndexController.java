/**
 * 2017年10月27日
 */
package net.kingfore.web;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.kingfore.service.JFService;

/**
 * @author JF_Hao
 *
 */
@Controller
public class IndexController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JFService jfService;
	

	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/uploadData")
	@ResponseBody
	public Object uploadData(){
		//System.out.println("控制成被调用.............................................");
		//jfService.uploadData();
		logger.info("测试日志。。。。。。。。。。。。" + new Date());
		return "success";
	}
	
	/*@RequestMapping("/httpUrl")
	public Object httpUrl(HttpServletRequest request,HttpServletResponse response){
		
		String userId = "张迪";
		String password = "Jfntyf_2b";
		
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("password", password);
		
		try {
			URL url = new URL("http://211.161.5.6:13103/JF/CheckLogin.action");
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");

			connection.setDoOutput(true);
			connection.setDoInput(true);
			
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");;
			
			OutputStream os = connection.getOutputStream();
			
			//os.write(map.toString().getBytes());
			os.write("userId=张迪123&password=Jfntyf_2b".getBytes());
			
			// 得到响应码
			int responseCode = connection.getResponseCode();
			
			System.out.println(responseCode);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}*/
	
	
	
	
}
