package com.bjgoodwill.springbootdemo01.mapper;

import com.bjgoodwill.springbootdemo01.model.TravelRecord;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * TravelRecordMapper
 *
 * @Classname TravelRecordMapper
 * @Date 2019/10/14 14:13
 * @Created by Zhangyichao
 */
@Mapper
public interface TravelRecordMapper {
    /**
     * 根据ID 获取记录
     * @param id
     * @return
     */
    @Select("select * from travelrecord where id=#{id}")
    TravelRecord getId(@Param("id") Integer id);

    @Select("select * from travelrecord")
    Page<TravelRecord> getList();
}
