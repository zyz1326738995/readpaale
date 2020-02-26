package com.hz.service.impl;

import com.hz.mapper.SlickUserMapper;
import com.hz.pojo.SlickAdmin;
import com.hz.pojo.SlickUser;
import com.hz.service.SlickUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("slickUserService")
public class SlickUserServiceImpl implements SlickUserService {
    @Resource
    private SlickUserMapper slickUserMapper;
    @Override
    public int insertUser(SlickUser slickUser) {
        return slickUserMapper.insertUser(slickUser);
    }

    @Override
    public int getUserCount(String datemin, String datemax, String love) {
        return slickUserMapper.getUserCount(datemin,datemax,love);
    }

    @Override
    public List<SlickUser> getAllUser(Integer curr, Integer limit, String datemin, String datemax, String love) {
        return slickUserMapper.getAllUser( (curr-1)*limit,  limit,  datemin,  datemax,  love);
    }
}
