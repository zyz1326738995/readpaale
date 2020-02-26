package com.hz.service.impl;

import com.hz.mapper.SlickIndustryMapper;
import com.hz.pojo.SlickIndustry;
import com.hz.service.SlickIndustryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("/slickIndustryService")
public class SlickIndustryServiceImpl implements SlickIndustryService {

    @Resource
    private SlickIndustryMapper slickIndustryMapper;


    @Override
    public List<SlickIndustry> getSlickIndustryList(long company_id) {
         return slickIndustryMapper.getSlickIndustryList(company_id);
    }

    @Override
    public List<SlickIndustry> getIndustryLists(Integer curr, Integer limit, String love) {
        return slickIndustryMapper.getIndustryLists((curr-1)*limit,limit,love);
    }

    @Override
    public int getIndustryCount(String love) {
        return slickIndustryMapper.getIndustryCount(love);
    }

    @Override
    public int updateIndustry(SlickIndustry slickIndustry) {
        return slickIndustryMapper.updateIndustry(slickIndustry);
    }
}
