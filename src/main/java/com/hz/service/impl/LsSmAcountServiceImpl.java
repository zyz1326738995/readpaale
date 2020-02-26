package com.hz.service.impl;

import com.hz.mapper.LsSmAcountMapper;
import com.hz.pojo.SmAcount;
import com.hz.service.LsSmAcountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("/lsSmAcountService")
public class LsSmAcountServiceImpl implements LsSmAcountService {

    @Resource
    private LsSmAcountMapper lsSmAcountMapper;

    @Override
    public int addSmAcount(SmAcount smAcount) {
        return lsSmAcountMapper.addSmAcount(smAcount);
    }

    @Override
    public SmAcount getSmAcountByMemberId(SmAcount smAcount) {
        return lsSmAcountMapper.getSmAcountByMemberId(smAcount);
    }

    @Override
    public int editSmAcountBySmAcount(SmAcount smAcount) {
        return lsSmAcountMapper.editSmAcountBySmAcount(smAcount);
    }
}
