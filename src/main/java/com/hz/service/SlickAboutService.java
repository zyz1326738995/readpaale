package com.hz.service;

import com.hz.pojo.SlickAbout;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SlickAboutService {
    public List<SlickAbout> getSlickAboutList(long company_id);

    public List<SlickAbout> getAboutLists(@Param("curr") Integer curr,
                                          @Param("limit") Integer limit,
                                          @Param("love") String love);

    public int getAboutCount(@Param("love") String love);

    public int updateAbout(@Param("slickAbout")SlickAbout slickAbout);
}
