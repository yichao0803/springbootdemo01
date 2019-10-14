package com.bjgoodwill.springbootdemo01.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * TravelRecordMapper
 *
 * @Classname TravelRecordMapper
 * @Date 2019/10/14 13:49
 * @Created by Zhangyichao
 */
public class TravelRecordMapper implements RowMapper<TravelRecord> {

    @Override
    public TravelRecord mapRow(ResultSet resultSet, int i) throws SQLException {
        Integer id = resultSet.getInt("id");
        String userId = resultSet.getString("user_id");
        Date travelDate = resultSet.getDate("traveldate");
        double fee = resultSet.getDouble("fee");
        Integer days = resultSet.getInt("days");

        TravelRecord travelRecord = new TravelRecord();
        travelRecord.setId(id);
        travelRecord.setUserId(userId);
        travelRecord.setTraveldate(travelDate);
        travelRecord.setFee(fee);
        travelRecord.setDays(days);

        return travelRecord;
    }
}
