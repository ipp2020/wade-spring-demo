package com.wade.springboot.wadespringbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WadeSpringbootDemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(WadeSpringbootDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WadeSpringbootDemoApplication.class, args);

        new Thread() {
            @Override
            public void run() {
                try {
                    String s = "上面%d{yyyy-MM-dd}表示命名的文件名字以原始的名字后面加上日期作为后缀，<maxFileSize>100MB</maxFileSize>表示每个文件大小为100MB。这样日志文件就会以日期来进行切割并且进行保存了。\n" +
                            "\n" +
                            "所以说如果要自定义日志的格式， 就可以通过自己编写logback-spring.xml这个文件来自己定义了。\n" +
                            "\n" +
                            "最后在配置文件appication.yaml设置好文件名称和日志级别就可以了\n" +
                            "\n" +
                            "作者：LOC_Thomas\n" +
                            "链接：https://www.jianshu.com/p/077f437eaaca\n" +
                            "來源：简书\n" +
                            "简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。";
                    while (true) {

                        logger.info("print log test------------------------------------");

                        logger.info(s);
                        if(s.length()>3000){
                            s = s.substring(500);
                        } else {
                            s += s;
                        }

                        logger.info("print log test------------------------------------");
                        Thread.sleep(100L);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }
}
