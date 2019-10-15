package com.bjgoodwill.springbootdemo01.service;

import com.bjgoodwill.springbootdemo01.model.TravelRecord;
import com.github.pagehelper.Page;

import java.util.Date;

/**
 * TravelRecordService
 *
 * @author Zhang Yichao
 * @see # TravelRecordService
 */
public interface TravelRecordService {

    /**
     * 根据主键 ID 获取一条记录
     *
     * @param id 主键
     * @return 返回一条 TravelRecord 记录
     */
    TravelRecord getId(Integer id);

    /**
     * 分页获取记录
     *
     * @param pageIndex 开始页数 0 开始
     * @param pageSize  页面大小
     * @return Page<TravelRecord>
     */
    Page<TravelRecord> getList(Integer pageIndex, Integer pageSize);

    /**
     * 根据ID删除记录
     *
     * @param id 主键
     */
    void deleteTravelRecord(int id);

    /**
     * 根据ID更新记录信息
     *
     * @param travelRecord 记录
     */
    void update(TravelRecord travelRecord);

    /**
     * 根据ID更新记录信息
     *
     * @param id         主键
     * @param userId     用户信息
     * @param traveldate 雇佣日期
     * @param fee        费用
     * @param days       天数
     */
    void update(int id, String userId, Date traveldate, double fee, int days);

    /**
     * 增加一条记录
     *
     * @param travelRecord 一条记录
     */
    void insert(TravelRecord travelRecord);

    /**
     * 增加一条记录
     *
     * @param id         主键
     * @param userId     用户信息
     * @param travelDate 雇佣日期
     * @param fee        费用
     * @param days       天数
     */
    void insert(int id, String userId, Date travelDate, double fee, int days);
}
