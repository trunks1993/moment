package com.ijnkj.controller;

import com.ijnkj.dao.domain.Moment;
import com.ijnkj.dao.domain.User;
import com.ijnkj.rservice.RMomentService;
import com.ijnkj.rservice.RUserService;
import com.ijnkj.service.MomentService;
import com.ijnkj.util.ResponseBase;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/moment")
public class MomentController {
    @Autowired
    private MomentService momentService;

    @Autowired
    private RMomentService rMomentService;

    @Autowired
    private RUserService rUserService;


    @GetMapping("/getMoment/{id}")
    public ResponseBase<?> getMoment(@PathVariable("id") String id) {

        ResponseBase<Moment> responseMessage = new ResponseBase<>();

        responseMessage.setData(momentService.get(id));

        return  responseMessage;
    }

    @GetMapping("/getAllMoment/{userId}") //最新
    public ResponseBase<?> getAllMoment(@PathVariable("userId") String userId) {

        ResponseBase<List<Moment>> responseBase = new ResponseBase<>();

        List list = rMomentService.getMoment(0,0);

        responseBase.setData(list);

        return responseBase;
    }
    @GetMapping("/refreshMoment") //最新
    public ResponseBase<?> refreshMoment(@RequestParam int flag,@RequestParam String timeLine) {

        ResponseBase<List<Moment>> responseBase = new ResponseBase<>();

        List list = rMomentService.getMoment(flag,Long.parseLong(timeLine));

        responseBase.setData(list);

        return responseBase;
    }

    @PostMapping("/addMoment")
    public ResponseBase<?> addMoment(@RequestBody Moment newMoment){

        ResponseBase<String> responseMessage = new ResponseBase<>();

        rMomentService.put(newMoment.getId(),newMoment,-1);

        return responseMessage.success("success");

    }

    @GetMapping("/deleteMoment/{momentId}")
    public ResponseBase<?> deleteMoment(@PathVariable("momentId") String momentId) {

        ResponseBase<String> responseMessage = new ResponseBase<>();


        long flag = rMomentService.deleteMoment(momentId);
        if(flag > 0){
            return responseMessage.success("success");
        }else {
            return responseMessage.error("fail");
        }
    }
}
