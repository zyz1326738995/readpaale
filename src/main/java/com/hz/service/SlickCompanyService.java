package com.hz.service;

import com.hz.pojo.SlickCompany;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SlickCompanyService {

    public SlickCompany getSlickCompany(SlickCompany slickCompany);

    public SlickCompany getSlickCompanyByName(@Param("slickCompany") SlickCompany slickCompany);

    public List<SlickCompany> getCompanyLists(@Param("curr") Integer curr,
                                              @Param("limit") Integer limit,
                                              @Param("love") String love);

    public int getCompanyCount(@Param("love") String love);

    public int updateCompany(@Param("slickCompany") SlickCompany slickCompany);
}
