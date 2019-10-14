package com.bjgoodwill.springbootdemo01.service;

import com.bjgoodwill.springbootdemo01.model.TravelRecord;

import java.util.List;

/**
 * TODO
 * @Classname TravelRecordService
 * @Date 2019/10/14 11:06
 * @Created by Zhangyichao
 */
public interface TravelRecordService {

    /**
     *  插入一条记录
     *
     */
    void  inserJdbcTravelRecord();

    /**
     *  返回 TravelRecord 集合
     */
    List<TravelRecord> list();
}
