package com.hz.service.impl;

import com.hz.mapper.SlickAppMapper;
import com.hz.pojo.SlickApp;
import com.hz.service.SlickAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("/slickAppService")
public class SlickAppServiceImpl implements SlickAppService {
    @Resource
    private SlickAppMapper slickAppMapper;


    @Override
    public List<SlickApp> getSlickAppList(long company_id) {
        return slickAppMapper.getSlickAppList(company_id);
    }

    @Override
    public List<SlickApp> getAppLists(Integer curr, Integer limit, String love) {
        return slickAppMapper.getAppLists((curr-1)*limit,limit,love);
    }

    @Override
    public int getAppCount(String love) {
        return slickAppMapper.getAppCount(love);
    }

    @Override
    public int updateApp(SlickApp slickApp) {
        return slickAppMapper.updateApp(slickApp);
    }
}
