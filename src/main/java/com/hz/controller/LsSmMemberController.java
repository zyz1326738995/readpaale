package com.hz.controller;

import com.hz.pojo.SmAcount;
import com.hz.pojo.SmIntegral;
import com.hz.pojo.SmLevel;
import com.hz.pojo.SmMember;
import com.hz.service.LsSmAcountService;
import com.hz.service.LsSmMemberService;
import com.hz.service.LsSmRechargerecordService;
import com.hz.utils.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 会员信息
 */
@Controller
@RequestMapping("/LsSmMemberController")
public class LsSmMemberController {

    @Resource
    private LsSmMemberService lsSmMemberService;

    @Resource
    private LsSmAcountService lsSmAcountService;

    @Resource
    private LsSmRechargerecordService lsSmRechargerecordService;



    /**
     * http://127.0.0.1:65/LsSmMemberController/getsAllmMemberAllInfo
     * @return
     */
    @RequestMapping("/getsAllmMemberAllInfo")
    @ResponseBody
    public Pager getsAllmMemberAllInfo(@RequestParam(value = "curr", required = false) Integer curr,
                                       @RequestParam(value = "limit", required = false) Integer limit,
                                       @RequestParam(value = "datemin",required = false) String datemin,
                                       @RequestParam(value ="datemax",required = false) String datemax,
                                       @RequestParam(value = "love",required = false) String love) {
        int total=lsSmMemberService.getMemberCount(datemin,datemax,love);
        List<SmMember> data=lsSmMemberService.getsmMemberAllInfo(curr,limit,datemin,datemax,love);
        System.out.println(data.size()+"aaaaaa大小");
        List<SmLevel> levelList=lsSmMemberService.getAllSmLevel();
        long[] integral_integralnumbers=new long[levelList.size()];
        List<SmMember> data2=new ArrayList<SmMember>();
        for(int i=0;i<=levelList.size()-1;i++){
            integral_integralnumbers[i]=levelList.get(i).getLevel_jifen();
        }
         for(int j=0;j<=data.size()-1;j++){
             System.out.println(data.get(j)+"aaaaaa2大小");
             System.out.println(data.get(j).getSmIntegral()+"aaaaaa22大小");
             System.out.println(data.get(j).getSmIntegral().getIntegral_integralnumbers()+"aaaaaa222大小");
             long integral_integralnumber=data.get(j).getSmIntegral().getIntegral_integralnumbers();
             int level_id=bijiao(integral_integralnumbers,integral_integralnumber);
             data.get(j).setMember_level_id(level_id);
             SmMember smMember2=data.get(j);
             lsSmMemberService.editSmLevelId(smMember2);
             data2.add(smMember2);
         }
System.out.println("data2:"+data2);
        System.out.println("data1:"+data);
        Pager<SmMember> pager = new Pager<SmMember>();
        pager.setCurr(curr);
        pager.setLimit(limit);
        pager.setTotal(total);
        pager.setData(data2);

        return pager;
    }
    @RequestMapping("/getsAllmMemberAllInfoyears")
    @ResponseBody
    public Pager getsAllmMemberAllInfoyears(@RequestParam(value = "curr", required = false) Integer curr,
                                            @RequestParam(value = "limit", required = false) Integer limit,
                                            @RequestParam(value = "datemin",required = false) String datemin,
                                            @RequestParam(value ="datemax",required = false) String datemax,
                                            @RequestParam(value = "love",required = false) String love) {
        int total=lsSmMemberService.getMemberCountyears(datemin,datemax,love);
        List<SmMember> data=lsSmMemberService.getsAllmMemberAllInfoyears(curr,limit,datemin,datemax,love);
        List<SmLevel> levelList=lsSmMemberService.getAllSmLevel();
        long[] integral_integralnumbers=new long[levelList.size()];
        List<SmMember> data2=new ArrayList<SmMember>();
        for(int i=0;i<=levelList.size()-1;i++){
            integral_integralnumbers[i]=levelList.get(i).getLevel_jifen();
        }
        for(int j=0;j<=data.size()-1;j++){
            long integral_integralnumber=data.get(j).getSmIntegral().getIntegral_integralnumbers();
            int level_id=bijiao(integral_integralnumbers,integral_integralnumber);
            data.get(j).setMember_level_id(level_id);
            SmMember smMember2=data.get(j);
            lsSmMemberService.editSmLevelId(smMember2);
            data2.add(smMember2);
        }
        System.out.println("data2:"+data2);
        System.out.println("data1:"+data);
        Pager<SmMember> pager = new Pager<SmMember>();
        pager.setCurr(curr);
        pager.setLimit(limit);
        pager.setTotal(total);
        pager.setData(data2);
        return pager;
    }
    public int bijiao( long[] integral_integralnumbers,long integral_integralnumber){
        for(int i=0;i<=integral_integralnumbers.length-1;i++){
            if(integral_integralnumber<integral_integralnumbers[i]){
                return i;
            }
        }
        return 0;
    }
    @ResponseBody
    @RequestMapping("/UpdateStates")
    public int UpdateStates(@RequestParam(value = "member_id", required = false) Long member_id,
                            @RequestParam(value = "member_state", required = false) long member_state){
        return lsSmMemberService.UpdateStates(member_id,member_state);
    }

    @ResponseBody
    @RequestMapping("/addSmMember")
    public int addSmMember(@RequestParam(value = "member_number", required = false) String member_number,
                           @RequestParam(value = "member_name", required = false) String member_name,
                           @RequestParam(value = "member_birthday", required = false) String member_birthday,
                           @RequestParam(value = "member_sex", required = false) int member_sex){
        SmMember smMember=new SmMember();
        smMember.setMember_number(member_number);
        smMember.setMember_name(member_name);
        smMember.setMember_sex(member_sex);
        smMember.setMember_birthday(member_birthday);
        int result=0;
       // int i= lsSmMemberService.addSmMember(smMember);
        if(lsSmMemberService.getMemberByNameAndNumb(smMember)==null){
            result=lsSmMemberService.addSmMember(smMember);
            long member_id=lsSmMemberService.getMemberByNameAndNumb(smMember).getMember_id();
            SmAcount smAcount=new SmAcount();
            smAcount.setAccount_member_id(member_id);
            lsSmAcountService.addSmAcount(smAcount);
            SmIntegral smIntegral=new SmIntegral();
            smIntegral.setIntegral_member_id(member_id);
            lsSmRechargerecordService.addIntegral(smIntegral);
            System.out.println(member_id+":member_id");
        }else {
            result=2;
        }
       return result;
    }

}
