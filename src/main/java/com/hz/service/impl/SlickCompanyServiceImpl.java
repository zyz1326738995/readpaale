package com.hz.service.impl;

import com.hz.mapper.SlickCompanyMapper;
import com.hz.pojo.SlickCompany;
import com.hz.service.SlickCompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("/slickCompanyService")
public class SlickCompanyServiceImpl implements SlickCompanyService {

    @Resource
    private SlickCompanyMapper  slickCompanyMapper;



    @Override
    public SlickCompany getSlickCompany(SlickCompany slickCompany) {
        return slickCompanyMapper.getSlickCompany(slickCompany);
    }

    @Override
    public SlickCompany getSlickCompanyByName(SlickCompany slickCompany) {
        return slickCompanyMapper.getSlickCompanyByName(slickCompany);
    }

    @Override
    public List<SlickCompany> getCompanyLists(Integer curr, Integer limit,String love) {
        return slickCompanyMapper.getCompanyLists( (curr-1)*limit,limit,love);
    }

    @Override
    public int getCompanyCount(String love) {
        return slickCompanyMapper.getCompanyCount(love);
    }

    @Override
    public int updateCompany(SlickCompany slickCompany) {
        return slickCompanyMapper.updateCompany(slickCompany);
    }
}
