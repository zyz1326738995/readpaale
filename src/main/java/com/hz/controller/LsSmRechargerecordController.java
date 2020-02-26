package com.hz.controller;

import com.hz.pojo.SmAcount;
import com.hz.pojo.SmIntegral;
import com.hz.pojo.SmMember;
import com.hz.pojo.SmRechargerecord;
import com.hz.service.LsSmAcountService;
import com.hz.service.LsSmMemberService;
import com.hz.service.LsSmRechargerecordService;
import com.hz.utils.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/LsSmRechargerecordController")
public class LsSmRechargerecordController {

    @Resource
    private LsSmRechargerecordService lsSmRechargerecordService;

    @Resource
    private LsSmMemberService lsSmMemberService;

    @Resource
    private LsSmAcountService lsSmAcountService;

    /**
     * http://127.0.0.1:65/LsSmRechargerecordController/getAllSmRechargerecord?curr=1&limit=20
     * @param curr
     * @param limit
     * @param datemin
     * @param datemax
     * @param love
     * @return
     */
    @RequestMapping("/getAllSmRechargerecord")
    @ResponseBody
    public Pager getAllSmRechargerecord(@RequestParam(value = "curr", required = false) Integer curr,
                                        @RequestParam(value = "limit", required = false) Integer limit,
                                        @RequestParam(value = "datemin",required = false) String datemin,
                                        @RequestParam(value ="datemax",required = false) String datemax,
                                        @RequestParam(value = "love",required = false) String love,
                                        @RequestParam(value = "Member_id",required = false) Long Member_id) {
       if(Member_id!=null){
           SmMember smMember=new SmMember();
           smMember.setMember_id(Member_id);
           love=lsSmMemberService.getMemberByNameAndNumb(smMember).getMember_name();
           System.out.println(love+"lovelove");
       }
        int total= lsSmRechargerecordService.getSmRechargerecordCount(datemin,  datemax,  love);
        Pager<SmRechargerecord> pager = new Pager<SmRechargerecord>();
        List<SmRechargerecord> data=lsSmRechargerecordService.getAllSmRechargerecord(curr,limit,datemin,datemax,love);
        pager.setCurr(curr);
        pager.setLimit(limit);
        pager.setTotal(total);
        pager.setData(data);
        return pager;
    }

    @RequestMapping("/addRechargerecord")
    @ResponseBody
    public int addRechargerecord(@RequestParam(value = "member_number", required = false) String member_number,
                                 @RequestParam(value = "member_name", required = false)  String member_name,
                                 @RequestParam(value = "rechargerecord_summoney",required = false)long rechargerecord_summoney,
                                 @RequestParam(value ="rechargerecord_type",required = false) long rechargerecord_type) {

        SmMember smMember=new SmMember();
        smMember.setMember_number(member_number);
        smMember.setMember_name(member_name);
        int result=0;
        if(lsSmMemberService.getMemberByNameAndNumb(smMember)==null){//个人信息出错
            result=2;
            return result;
        }else {
            long member_id=lsSmMemberService.getMemberByNameAndNumb(smMember).getMember_id();
            SmAcount smAcount=new SmAcount();
            smAcount.setAccount_member_id(member_id);
            SmAcount smAcount2=lsSmAcountService.getSmAcountByMemberId(smAcount);
            System.out.println(smAcount2.toString());
            smAcount2.setAccount_money(smAcount2.getAccount_money()+rechargerecord_summoney);
            smAcount2.setAccount_summoney(smAcount2.getAccount_summoney()+rechargerecord_summoney);
            lsSmAcountService.editSmAcountBySmAcount(smAcount2);

            SmRechargerecord smRechargerecord=new SmRechargerecord();
            smRechargerecord.setRechargerecord_member_id(member_id);
            smRechargerecord.setRechargerecord_summoney(rechargerecord_summoney);
            smRechargerecord.setRechargerecord_type(rechargerecord_type);
            lsSmRechargerecordService.addRechargerecord(smRechargerecord);

            SmIntegral smIntegral=new SmIntegral();
            smIntegral.setIntegral_member_id(member_id);
            SmIntegral smIntegral2=lsSmRechargerecordService.getIntegralBymemberid(smIntegral);
            smIntegral2.setIntegral_member_id(member_id);
            smIntegral2.setIntegral_integralnumbers(smIntegral2.getIntegral_integralnumbers()+rechargerecord_summoney);
            smIntegral2.setIntegral_times(smIntegral2.getIntegral_times()+1);
            lsSmRechargerecordService.editIntegralBymemberid(smIntegral2);


            result=1;
            return result;

        }


    }
}
