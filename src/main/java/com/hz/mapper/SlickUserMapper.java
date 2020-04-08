package com.hz.mapper;

import com.hz.pojo.SlickAdmin;
import com.hz.pojo.SlickUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SlickUserMapper {


    public int insertUser(SlickUser slickUser);

    /**
     *
     * @param datemin
     * @param datemax
     * @param love
     * @return
     */
    public int getUserCount( @Param("datemin") String datemin,
                              @Param("datemax") String datemax,
                              @Param("love") String love);

    /**
     * 获取所有管理员详细信息
     * @return admin信息
     * @throws Exception
     */
    public List<SlickUser> getAllUser   (@Param("curr") Integer curr,
                                        @Param("limit") Integer limit,
                                        @Param("datemin") String datemin,//最小时间
                                        @Param("datemax") String datemax,//最大时间
                                        @Param("love") String love);//模糊查询输入的值

    /**
     * 查询全部信息导出表
     * @return
     */
    public List<SlickUser> exportExeclAllUser();
}
