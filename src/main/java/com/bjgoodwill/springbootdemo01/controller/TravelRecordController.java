package com.bjgoodwill.springbootdemo01.controller;

import com.bjgoodwill.springbootdemo01.model.TravelRecord;
import com.bjgoodwill.springbootdemo01.service.TravelRecordService;
import com.github.pagehelper.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TravelRecordController 对外接口
 *
 * @author by Zhangyichao
 * @see # TravelRecordController
 */
@RestController
@RequestMapping("/traRec")
public class TravelRecordController {

    // @Autowired
    @Resource(name = "TravelRecordJdbcTemplateImpl")
    private TravelRecordService travelRecordService;

    /**
     * 默认主页
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "TravelRecordController";
    }

    /**
     * 根据主键 ID 获取一条记录
     *
     * @param id 主键
     * @return 返回一条 TravelRecord 记录
     */
    @ResponseBody
    @RequestMapping("/getId")
    public TravelRecord getId(Integer id) {
        return travelRecordService.getId(id);
    }

    /**
     * 获取 分页获取记录
     * 运行后 示例地址： http://localhost:8888/traRec/getlist?pageIndex=0&pageSize=2
     *
     * @param pageIndex 开始页数 0 开始
     * @param pageSize  页面大小
     * @return
     */
    @RequestMapping("/getlist")
    public Page<TravelRecord> getList(Integer pageIndex, Integer pageSize) {
        return travelRecordService.getList(pageIndex, pageSize);
    }

    /**
     * 添加/修改 增加一条记录
     *
     * @param travelRecord 一条记录对象
     */
    @RequestMapping("/postTraveRecordInfo")
    public void postTraveRecordInfo(TravelRecord travelRecord) {
        TravelRecord travelR= new TravelRecord();
        travelR.setId(travelRecord.getId());
        travelR.setUserId(travelRecord.getUserId());
        travelR.setTraveldate(travelRecord.getTraveldate());
        travelR.setFee(travelRecord.getFee());
        travelR.setDays(travelRecord.getDays());
        if (travelR.getId() == null) {
            travelR.setId(10);
            // 增加一条记录
            travelRecordService.insert(travelR);
        } else {
            // 根据ID更新记录信息
            travelRecordService.update(travelR);
        }
    }
}
