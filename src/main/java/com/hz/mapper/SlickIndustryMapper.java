package com.hz.mapper;

import com.hz.pojo.SlickIndustry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SlickIndustryMapper {

    public List<SlickIndustry>  getSlickIndustryList(long company_id);

    public List<SlickIndustry> getIndustryLists(@Param("curr") Integer curr,
                                          @Param("limit") Integer limit,
                                          @Param("love") String love);

    public int getIndustryCount(@Param("love") String love);

    public int updateIndustry(@Param("slickIndustry")SlickIndustry slickIndustry);

}
