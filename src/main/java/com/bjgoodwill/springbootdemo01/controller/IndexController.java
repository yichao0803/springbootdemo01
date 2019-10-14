package com.bjgoodwill.springbootdemo01.controller;

import com.bjgoodwill.springbootdemo01.mapper.TravelRecordMapper;
import com.bjgoodwill.springbootdemo01.model.TravelRecord;
import com.bjgoodwill.springbootdemo01.service.TravelRecordService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * IndexController
 * @Classname IndexController
 * @Date 2019/10/12 10:47
 * @Created by Zhangyichao
 */
@RestController
public class IndexController {

    @Autowired
    private TravelRecordService travelRecordService;
    @Autowired
    private TravelRecordMapper travelRecordMapper;
    @RequestMapping("/")
    String home() {
        return "Hello World";
    }

    @RequestMapping("/t/insert")
    public String insertTravel() {
        travelRecordService.inserJdbcTravelRecord();
        return "success";
    }

    @ResponseBody
    @RequestMapping("/t/getId")
    public TravelRecord getId(Integer id) {
        return travelRecordMapper.getId(id);
    }


    @RequestMapping("/t/list")
    public List<TravelRecord> list() {
        return travelRecordService.list();
    }

    // http://localhost:8080/t/pagelist?pageIndex=1&pageSize=2
    @RequestMapping("/t/pagelist")
    public Page<TravelRecord> getTravelRecordList(Integer pageIndex, Integer pageSize) {
        PageHelper.offsetPage(pageIndex, pageSize);
        Page<TravelRecord> pageList = travelRecordMapper.getList();
        return pageList;
    }

}
