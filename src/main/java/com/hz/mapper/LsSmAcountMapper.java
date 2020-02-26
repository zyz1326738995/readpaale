package com.hz.mapper;

import com.hz.pojo.SmAcount;
import org.apache.ibatis.annotations.Param;


public interface LsSmAcountMapper {

    /**
     * 用户开户
     * @param smAcount
     * @return
     */
    public int addSmAcount( SmAcount smAcount);

    /**
     * 查询用户卡信息
     * @param smAcount
     * @return
     */
    public SmAcount getSmAcountByMemberId( SmAcount smAcount);


    /**
     * 修改用户余额信息
     * @param smAcount
     * @return
     */
    public int editSmAcountBySmAcount( SmAcount smAcount);
}
