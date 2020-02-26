package com.hz.service.impl;

import com.hz.mapper.SlickAdminMapper;
import com.hz.pojo.SlickAdmin;
import com.hz.service.SlickAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("/SlickAdminService")
public class SlickAdminServiceImpl implements SlickAdminService{

    @Resource
    private SlickAdminMapper slickAdminMapper;

    @Override
    public SlickAdmin getSlickAdmin(SlickAdmin slickAdmin) {
        return slickAdminMapper.getSlickAdmin(slickAdmin);
    }

    @Override
    public int editSlickAdmin(SlickAdmin slickAdmin) {
        return slickAdminMapper.editSlickAdmin(slickAdmin);
    }

    @Override
    public int getAdminCount(String datemin, String datemax, String love) {
        return slickAdminMapper.getAdminCount(datemin,datemax,love);
    }

    @Override
    public List<SlickAdmin> getAllAdmin(Integer curr, Integer limit, String datemin, String datemax, String love) {
        return slickAdminMapper.getAllAdmin( (curr-1)*limit,  limit,  datemin,  datemax,  love);
    }

    @Override
    public int addSlickAdmin(SlickAdmin slickAdmin) {
        return slickAdminMapper.addSlickAdmin(slickAdmin);
    }

}
