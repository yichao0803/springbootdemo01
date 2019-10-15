package com.bjgoodwill.springbootdemo01.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * TravelRecordRowMapper jdbcTemplate  生成对象实例
 *
 * @author by Zhangyichao
 * @see # TravelRecordRowMapper
 */
public class TravelRecordRowMapper implements RowMapper<TravelRecord> {

    /**
     * 根据jdbcTemplate的每一行数据生成一个TravelRecord实例对象
     *
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
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
