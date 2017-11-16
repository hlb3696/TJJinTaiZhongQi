/**
 * 2017年10月27日
 */
package net.kingfore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author JF_Hao
 *
 */

@SpringBootApplication
@EnableScheduling //启用定时任务的配置
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}