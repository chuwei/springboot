package com.ngari.ucenter.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by win on 2019/8/21.
 */

@Component
public class SchedulerTask {

    private int count=0;

    @Scheduled(cron="*/6 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task runing  "+(count++));
//        UserService service = new UserService();
//        User user = service.createRandomUser();
//        System.out.println(user.toString());
    }

}