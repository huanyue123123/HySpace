package com.gm.wj.controller;

import com.gm.wj.entity.Book;
import com.gm.wj.entity.Category;
import com.gm.wj.producer.MsgProducer;
import com.gm.wj.result.Result;
import com.gm.wj.result.ResultCode;
import com.gm.wj.result.ResultFactory;
import com.gm.wj.reveicer.MsgReceiver;
import com.gm.wj.service.BookService;
import com.gm.wj.service.JdbcTempService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Api(description = "mq发送数据")
@RestController
@RequestMapping("/api/test")
public class MsgController {

    @Autowired
    private MsgProducer msgProducer;

    @Autowired
    private MsgReceiver msgReceiver;

    @Autowired
    private JdbcTempService jdbcTempService;

    @ApiOperation(value = "发送")
    @PostMapping("/send")
    public Result list() throws Exception {
        msgProducer.sendMsg();
        return ResultFactory.buildResult(ResultCode.SUCCESS,"","");
    }

    @ApiOperation(value = "测试SQL")
    @GetMapping("/testIn")
    public Result testIn() throws Exception {
        jdbcTempService.testIn();
        return ResultFactory.buildResult(ResultCode.SUCCESS,"","");
    }

}
