package com.hz.mapper;

import com.hz.pojo.SlickAbout;
import com.hz.pojo.SlickCompany;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface SlickAboutMapper {

    public List<SlickAbout>  getSlickAboutList(long company_id);

    public List<SlickAbout> getAboutLists(@Param("curr") Integer curr,
                                              @Param("limit") Integer limit,
                                          @Param("love") String love);

    public int getAboutCount(@Param("love") String love);

    public int updateAbout(@Param("slickAbout")SlickAbout slickAbout);
}
