package com.hz.service;

import com.hz.pojo.SlickApp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SlickAppService {

    public List<SlickApp> getSlickAppList(long company_id);

    public List<SlickApp> getAppLists(@Param("curr") Integer curr,
                                      @Param("limit") Integer limit,
                                      @Param("love") String love);

    public int getAppCount(@Param("love") String love);

    public int updateApp(@Param("slickApp")SlickApp slickApp);
}
