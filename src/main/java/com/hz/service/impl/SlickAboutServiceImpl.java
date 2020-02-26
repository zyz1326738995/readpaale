package com.hz.service.impl;

import com.hz.mapper.SlickAboutMapper;
import com.hz.pojo.SlickAbout;
import com.hz.service.SlickAboutService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("/slickAboutService")
public class SlickAboutServiceImpl implements SlickAboutService{

    @Resource
    private SlickAboutMapper slickAboutMapper;


    @Override
    public List<SlickAbout> getSlickAboutList(long company_id) {
        return slickAboutMapper.getSlickAboutList(company_id);
    }

    @Override
    public List<SlickAbout> getAboutLists(Integer curr, Integer limit,String love) {
        return slickAboutMapper.getAboutLists((curr-1)*limit,limit,love);
    }

    @Override
    public int getAboutCount(String love) {
        return slickAboutMapper.getAboutCount( love);
    }

    @Override
    public int updateAbout(SlickAbout slickAbout) {
        return slickAboutMapper.updateAbout(slickAbout);
    }
}
