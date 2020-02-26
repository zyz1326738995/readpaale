package com.hz.service;

import com.hz.pojo.SlickAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SlickAdminService {


    public SlickAdmin getSlickAdmin(SlickAdmin slickAdmin);


    public int editSlickAdmin(SlickAdmin slickAdmin);


    /**
     *
     * @param datemin
     * @param datemax
     * @param love
     * @return
     */
    public int getAdminCount( @Param("datemin") String datemin,
                              @Param("datemax") String datemax,
                              @Param("love") String love);

    /**
     * 获取所有管理员详细信息
     * @return admin信息
     * @throws Exception
     */
    public List<SlickAdmin> getAllAdmin(@Param("curr") Integer curr,
                                        @Param("limit") Integer limit,
                                        @Param("datemin") String datemin,//最小时间
                                        @Param("datemax") String datemax,//最大时间
                                        @Param("love") String love);//模糊查询输入的值

    /**
     * 添加管理员
     * @param slickAdmin
     * @return
     */
    public int addSlickAdmin(@Param("slickAdmin")SlickAdmin slickAdmin);
}
