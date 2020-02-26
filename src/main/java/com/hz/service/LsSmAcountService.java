package com.hz.service;

import com.hz.pojo.SmAcount;
import org.springframework.data.repository.query.Param;

public interface LsSmAcountService {

    /**
     * 用户开户
     * @param smAcount
     * @return
     */
    public int addSmAcount(@Param("smAcount") SmAcount smAcount);


    /**
     * 查询用户卡信息
     * @param smAcount
     * @return
     */
    public SmAcount getSmAcountByMemberId(@Param("smAcount") SmAcount smAcount);

    /**
     * 修改用户余额信息
     * @param smAcount
     * @return
     */
    public int editSmAcountBySmAcount(@Param("smAcount") SmAcount smAcount);

}
