package com.wade.springboot.wadespringbootdemo.jvm;

import com.wade.springboot.wadespringbootdemo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TaskRunner implements ApplicationRunner {

    @Autowired
//    private ISeckillService seckillService

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("task runner begin running......");

        while(true){
            //进程内队列
            User user = TaskQueue.getMailQueue().consume();
            if(user!=null){
                //seckillService.startSeckil(kill.getSeckillId(), kill.getUserId());
                System.out.println("save a user.");
            }
        }
    }
}
