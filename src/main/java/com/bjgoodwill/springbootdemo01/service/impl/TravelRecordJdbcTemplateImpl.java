package com.bjgoodwill.springbootdemo01.service.impl;

import com.bjgoodwill.springbootdemo01.model.TravelRecord;
import com.bjgoodwill.springbootdemo01.model.TravelRecordRowMapper;
import com.bjgoodwill.springbootdemo01.service.TravelRecordService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * TravelRecordJdbcTemplateImpl
 *
 * @author by Zhangyichao
 * @see # TravelRecordJdbcTemplateImpl
 */
@Service("TravelRecordJdbcTemplateImpl")
public class TravelRecordJdbcTemplateImpl implements TravelRecordService {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据主键 ID 获取一条记录
     *
     * @param id 主键
     * @return 返回一条 TravelRecord 记录
     */
    @Override
    public TravelRecord getId(Integer id) {
        String sql = String.format("select id,user_Id,traveldate,fee,days " +
                "from travelrecord where id=?", id);
        List<TravelRecord> list = jdbcTemplate.query(sql, new TravelRecordRowMapper());
        if (!list.isEmpty()) {
            return list.get(0);
        } else return null;
    }

    @Override
    public Page<TravelRecord> getList(Integer pageIndex, Integer pageSize) {
        // TODO:该方法的返回，需要改造
        getTravelrecordList();
        return null;
    }

    /**
     * 根据ID删除记录
     *
     * @param id 主键
     */
    @Override
    public void deleteTravelRecord(int id) {
        jdbcTemplate.update("DELETE FROM travelrecord WHERE id=?", id);
    }

    /**
     * 根据ID更新记录信息
     *
     * @param travelRecord 记录
     */
    @Override
    public void update(TravelRecord travelRecord) {
        jdbcTemplate.update("UPDATE travelrecord SET user_id=?,traveldate=?,fee=?,days=? WHERE id=?",
                travelRecord.getUserId(), travelRecord.getTraveldate(), travelRecord.getFee(), travelRecord.getDays());
    }

    /**
     * 根据ID更新记录信息
     *
     * @param id         主键
     * @param userId     用户信息
     * @param traveldate 雇佣日期
     * @param fee        费用
     * @param days       天数
     */
    @Override
    public void update(int id, String userId, Date traveldate, double fee, int days) {
        update(new TravelRecord(id, userId, traveldate, fee, days));
    }

    /**
     * 增加一条记录
     *
     * @param travelRecord 一条记录
     */
    @Override
    public void insert(TravelRecord travelRecord) {
        jdbcTemplate.update("insert  into travelrecord values(?,@@hostname,?,?,?)", travelRecord.getId(),
                travelRecord.getTraveldate(), travelRecord.getFee(), travelRecord.getDays());
    }

    /**
     * 增加一条记录
     *
     * @param id         主键
     * @param userId     用户信息
     * @param traveldate 雇佣日期
     * @param fee        费用
     * @param days       天数
     */
    @Override
    public void insert(int id, String userId, Date traveldate, double fee, int days) {
        insert(new TravelRecord(id, userId, traveldate, fee, days));
    }

    /**
     * getTravelrecordList
     *
     * @return List<TravelRecord>
     */
    private List<TravelRecord> getTravelrecordList() {

        TravelRecordRowMapper travelRecordRowMapper = new TravelRecordRowMapper();
        return jdbcTemplate.query("select * from travelrecord", travelRecordRowMapper);
    }
}
