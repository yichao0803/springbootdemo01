package com.bjgoodwill.springbootdemo01.service.impl;

import com.bjgoodwill.springbootdemo01.mapper.TravelRecordMapper;
import com.bjgoodwill.springbootdemo01.model.TravelRecord;
import com.bjgoodwill.springbootdemo01.service.TravelRecordService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 调用TravelRecordMapper通过MyBatis实现管理 TravelRecordImpl
 *
 * @author by Zhangyichao
 * @see # TravelRecordImpl
 */
@Service("TravelRecordImpl")
public class TravelRecordImpl implements TravelRecordService {

    @Autowired
    private TravelRecordMapper travelRecordMapper;

    /**
     * 根据主键 ID 获取一条记录
     *
     * @param id 主键
     * @return 返回一条 TravelRecord 记录
     */
    @Override
    public TravelRecord getId(Integer id) {
        return travelRecordMapper.getId(id);
    }

    /**
     * 分页获取记录
     *
     * @param pageIndex 开始页数 0 开始
     * @param pageSize  页面大小
     * @return
     */
    @Override
    public Page<TravelRecord> getList(Integer pageIndex, Integer pageSize) {
        PageHelper.offsetPage(pageIndex * pageSize, pageSize);
        return travelRecordMapper.getList();
    }

    /**
     * 根据ID删除记录
     *
     * @param id 主键
     */
    @Override
    public void deleteTravelRecord(int id) {
        travelRecordMapper.deleteTravelRecord(id);
    }

    /**
     * 根据ID更新记录信息
     *
     * @param travelRecord 一条记录
     */
    @Override
    public void update(TravelRecord travelRecord) {
        travelRecordMapper.update(travelRecord);
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
        travelRecordMapper.insert(travelRecord);
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

}
