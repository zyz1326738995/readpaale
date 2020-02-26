package com.hz.mapper;

import com.hz.pojo.SlickCompany;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SlickCompanyMapper {

    public SlickCompany getSlickCompany(@Param("slickCompany") SlickCompany slickCompany);


    public SlickCompany getSlickCompanyByName(@Param("slickCompany") SlickCompany slickCompany);


    public List<SlickCompany> getCompanyLists(@Param("curr") Integer curr,
                                              @Param("limit") Integer limit,
                                              @Param("love") String love);

    public int getCompanyCount(@Param("love") String love);

    public int updateCompany(@Param("slickCompany") SlickCompany slickCompany);

}
