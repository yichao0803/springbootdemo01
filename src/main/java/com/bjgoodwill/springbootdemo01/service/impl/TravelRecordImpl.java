package com.bjgoodwill.springbootdemo01.service.impl;

import com.bjgoodwill.springbootdemo01.model.TravelRecord;
import com.bjgoodwill.springbootdemo01.model.TravelRecordMapper;
import com.bjgoodwill.springbootdemo01.service.TravelRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * TODO
 * @Classname TravelRecordImpl
 * @Date 2019/10/14 11:06
 * @Created by Zhangyichao
 */
@Service
public class TravelRecordImpl implements TravelRecordService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    // @Transactional(propagation = Propagation.REQUIRED)
    public void inserJdbcTravelRecord() {
        jdbcTemplate.update("insert  into travelrecord values(3,@@hostname,'2019-10-14',?,?)",200,3);
    }

    @Override
    public List<TravelRecord> list() {
        return jdbcTemplate.query("select * from travelrecord",new TravelRecordMapper());
    }


}
