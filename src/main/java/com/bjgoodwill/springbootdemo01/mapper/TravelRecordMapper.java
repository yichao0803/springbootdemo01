package com.bjgoodwill.springbootdemo01.mapper;

import com.bjgoodwill.springbootdemo01.model.TravelRecord;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

/**
 * TravelRecordMapper
 *
 * @author Zhangyichao
 * @see # TravelRecordMapper
 */
@Mapper
public interface TravelRecordMapper {
    /**
     * 根据ID 获取记录
     *
     * @param id 主键
     * @return TravelRecord
     */
    @Select("SELECT * FROM travelrecord where id=#{id}")
    TravelRecord getId(@Param("id") Integer id);

    /**
     * 分页获取记录
     *
     * @return Page<TravelRecord> 记录列表及分页信息
     */
    @Select("SELECT * FROM travelrecord")
    Page<TravelRecord> getList();

    /**
     * 根据ID删除记录
     *
     * @param id 主键
     */
    @Delete("DELETE FROM travelrecord WHERE id=#{id}")
    void deleteTravelRecord(int id);

    /**
     * 根据ID更新记录信息
     *
     * @param travelRecord 记录
     */
    @Update("UPDATE travelrecord SET user_id=#{userId},traveldate=#{traveldate},fee=#{fee},days=#{days} WHERE id=#{id}")
    void update(TravelRecord travelRecord);

    /**
     * 插入记录
     *
     * @param travelRecord 记录
     */
    @Insert("INSERT INTO travelrecord(id,user_Id,traveldate,fee,days) VALUES(#{id},#{userId},#{traveldate},#{fee},#{days})")
    void insert(TravelRecord travelRecord);
}
