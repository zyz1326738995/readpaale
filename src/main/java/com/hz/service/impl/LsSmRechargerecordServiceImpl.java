package com.hz.service.impl;

import com.hz.mapper.LsSmRechargerecordMapper;
import com.hz.pojo.SmIntegral;
import com.hz.pojo.SmRechargerecord;
import com.hz.service.LsSmRechargerecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("lsSmRechargerecordService")
public class LsSmRechargerecordServiceImpl implements LsSmRechargerecordService {
    @Resource
    private LsSmRechargerecordMapper lsSmRechargerecordMapper;

    @Override
    public List<SmRechargerecord> getAllSmRechargerecord(Integer curr, Integer limit, String datemin, String datemax, String love) {
        return lsSmRechargerecordMapper.getAllSmRechargerecord((curr-1)*limit,  limit,  datemin,  datemax,  love);
    }

    @Override
    public int getSmRechargerecordCount(String datemin, String datemax, String love) {
        return lsSmRechargerecordMapper.getSmRechargerecordCount(datemin,  datemax,  love);
    }

    @Override
    public int addRechargerecord(SmRechargerecord smRechargerecord) {
        return lsSmRechargerecordMapper.addRechargerecord(smRechargerecord);
    }

    @Override
    public int addIntegral(SmIntegral smIntegral) {
        return lsSmRechargerecordMapper.addIntegral(smIntegral);
    }

    @Override
    public int editIntegralBymemberid(SmIntegral smIntegral) {
        return lsSmRechargerecordMapper.editIntegralBymemberid(smIntegral);
    }

    @Override
    public SmIntegral getIntegralBymemberid(SmIntegral smIntegral) {
        return lsSmRechargerecordMapper.getIntegralBymemberid(smIntegral);
    }

    @Override
    public List<SmRechargerecord> exportRechargerecord() {
        return lsSmRechargerecordMapper.exportRechargerecord();
    }

}
