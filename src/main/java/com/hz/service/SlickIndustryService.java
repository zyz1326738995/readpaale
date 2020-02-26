package com.hz.service;

import com.hz.pojo.SlickIndustry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SlickIndustryService {

    public List<SlickIndustry> getSlickIndustryList(long company_id);

    public List<SlickIndustry> getIndustryLists(@Param("curr") Integer curr,
                                                @Param("limit") Integer limit,
                                                @Param("love") String love);

    public int getIndustryCount(@Param("love") String love);

    public int updateIndustry(@Param("slickAbout")SlickIndustry slickIndustry);

}
