package com.huanyue.spacepageclient.task;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SchedulerTask {


    @Scheduled(cron = "* 0,3 10 * * ? ")
    public void scheduled(){

        log.info("使用cron: {}");
    }
}
