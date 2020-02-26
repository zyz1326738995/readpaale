package com.hz.service;

import com.hz.pojo.SmLevel;
import com.hz.pojo.SmMember;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * 会员信息
 */
public interface LsSmMemberService {
    public List<SmMember> getsmMemberAllInfo(@Param("curr") Integer curr,
                                             @Param("limit") Integer limit,
                                             @Param("datemin") String datemin,//最小时间
                                             @Param("datemax") String datemax,//最大时间
                                             @Param("love") String love);//模糊查询输入的值);

    public List<SmMember> getsAllmMemberAllInfoyears(@Param("curr") Integer curr,
                                                     @Param("limit") Integer limit,
                                                     @Param("datemin") String datemin,//最小时间
                                                     @Param("datemax") String datemax,//最大时间
                                                     @Param("love") String love);//模糊查询输入的值);

    /**
     * 获取用户数量
     * @param datemin
     * @param datemax
     * @param love
     * @return
     */
    public int getMemberCount(@Param("datemin") String datemin,
                              @Param("datemax") String datemax,
                              @Param("love") String love);
    /**
     * 获取用户数量
     * @param datemin
     * @param datemax
     * @param love
     * @return
     */
    public int getMemberCountyears(@Param("datemin") String datemin,
                                   @Param("datemax") String datemax,
                                   @Param("love") String love);

    public List<SmMember> exportExcelMember();

    /**
     * 修改会员状态
     * @param member_id
     * @param member_state
     * @return
     */
    public int UpdateStates(@Param("member_id") long member_id,
                            @Param("member_state") long member_state);


    /**
     * 添加会员
     * @param smMember 会员
     * @return
     */
    public int addSmMember(@Param("smMember") SmMember smMember);


    /**
     * 查询会员
     * @param smMember
     * @return
     */
    public SmMember getMemberByNameAndNumb(@Param("smMember") SmMember smMember);

    /**
     * 查询积分表数据
     * @return
     */
    public List<SmLevel> getAllSmLevel();


    /**
     * 更改会员等级
     * @param smMember
     * @return
     */
    public int editSmLevelId(@Param("smMember") SmMember smMember);


}
