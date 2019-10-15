package com.bjgoodwill.springbootdemo01.controller;

import com.bjgoodwill.springbootdemo01.mapper.TravelRecordMapper;
import com.bjgoodwill.springbootdemo01.model.TravelRecord;
import com.bjgoodwill.springbootdemo01.service.TravelRecordService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * IndexController
 *
 * @author by Zhangyichao
 * @see # IndexController
 */
@RestController
public class IndexController {

    @Autowired
    private TravelRecordMapper travelRecordMapper;

    @Resource(name = "TravelRecordImpl")
    private TravelRecordService travelRecordService;

    /**
     * 系统首页
     *
     * @return String
     */
    @RequestMapping("/")
    String home() {
        return "Hello World";
    }

    /**
     * 根据主键 ID 获取一条记录
     *
     * @param id 主键
     * @return 返回一条 TravelRecord 记录
     */
    @ResponseBody
    @RequestMapping("/t/getId")
    public TravelRecord getId(Integer id) {
        return travelRecordMapper.getId(id);
    }

    /**
     * 获取 分页获取记录
     * 运行后 示例地址： http://localhost:8888//t/pagelist?pageIndex=0&pageSize=2
     *
     * @param pageIndex 开始页数 0 开始
     * @param pageSize  页面大小
     * @return 返回 分页获取记录
     */
    @RequestMapping("/t/pagelist")
    public Page<TravelRecord> getTravelRecordList(Integer pageIndex, Integer pageSize) {
        return travelRecordMapper.getList();
    }

    @RequestMapping("/t/tlist")
    String getList() {
        StringBuilder stringBuilder = new StringBuilder();
        TravelRecord travelRecord = travelRecordMapper.getId(1);
        stringBuilder.append(travelRecord.getId()).append(",");
        stringBuilder.append(travelRecord.getUserId()).append(",");
        stringBuilder.append(travelRecord.getTraveldate()).append(",");
        stringBuilder.append(travelRecord.getFee()).append(",");
        stringBuilder.append(travelRecord.getDays()).append(",");
        return stringBuilder.toString();
    }
}
