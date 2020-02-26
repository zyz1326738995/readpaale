package com.hz.mapper;

import com.hz.pojo.SmIntegral;
import com.hz.pojo.SmRechargerecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LsSmRechargerecordMapper {

    /**
     *
     * @param curr
     * @param limit
     * @param datemin
     * @param datemax
     * @param love
     * @return
     */
    public List<SmRechargerecord> getAllSmRechargerecord(@Param("curr") Integer curr,
                                                         @Param("limit") Integer limit,
                                                         @Param("datemin") String datemin,//最小时间
                                                         @Param("datemax") String datemax,//最大时间
                                                         @Param("love") String love);//模糊查询输入的值);

    public List<SmRechargerecord> exportRechargerecord();
    /**
     *
     * @param datemin
     * @param datemax
     * @param love
     * @return
     */
    public int getSmRechargerecordCount(@Param("datemin") String datemin,
                                        @Param("datemax") String datemax,
                                        @Param("love") String love);

    /**
     * 插入充值记录
     * @param smRechargerecord
     * @return
     */
    public int  addRechargerecord( SmRechargerecord smRechargerecord);

    /**
     * 插入积分表
     * @param smIntegral
     * @return
     */
    public int  addIntegral( SmIntegral smIntegral);

    /**
     * 修改积分表数据
     * @param smIntegral
     * @return
     */
    public int editIntegralBymemberid( SmIntegral smIntegral);

    /**
     * 查看积分表数据
     * @param smIntegral
     * @return
     */
    public SmIntegral getIntegralBymemberid( SmIntegral smIntegral);
}
