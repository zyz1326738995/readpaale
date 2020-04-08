package com.hz.controller;

import com.hz.pojo.SlickAdmin;
import com.hz.pojo.SlickCompany;
import com.hz.service.SlickAdminService;
import com.hz.service.SlickCompanyService;
import com.hz.utils.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/SlickAdminController")
public class SlickAdminController {

    @Resource
    private SlickAdminService slickAdminService;

    @Resource
    private SlickCompanyService slickCompanyService;


    @RequestMapping("/getSlickAdmin")
    @ResponseBody
    public SlickAdmin getSlickAdmin( @RequestParam(value = "admin_name", required = false) String admin_name,
                                     @RequestParam(value = "admin_pwd", required = false) String admin_pwd) {

        SlickAdmin slickAdmin=new SlickAdmin();
        slickAdmin.setAdmin_name(admin_name);
        slickAdmin.setAdmin_pwd(admin_pwd);
       // slickAdmin.setAdmin_state(2);
        slickAdmin.setCompany_id(1);
        SlickAdmin slickAdmi2= slickAdminService.getSlickAdmin(slickAdmin);
        if(slickAdmi2!=null){
            slickAdmi2.setAdmin_login_number(slickAdmi2.getAdmin_login_number()+1);
            slickAdminService.editSlickAdmin(slickAdmi2);
            return slickAdminService.getSlickAdmin(slickAdmi2);
        }else{
            SlickAdmin slickAdmin3=new SlickAdmin();
            slickAdmin3.setAdmin_state(3L);
            return slickAdmin3;
        }

    }

    @ResponseBody
    @RequestMapping("/getAdminPager")
    public Pager getAdminPager(@RequestParam(value = "curr", required = false) Integer curr,
                               @RequestParam(value = "limit", required = false) Integer limit,
                               @RequestParam(value = "datemin",required = false) String datemin,
                               @RequestParam(value ="datemax",required = false) String datemax,
                               @RequestParam(value = "love",required = false) String love){
        int total=slickAdminService.getAdminCount(datemin,datemax,love);
        List<SlickAdmin> data= slickAdminService.getAllAdmin(curr,limit,datemin,datemax,love);
        Pager<SlickAdmin> pager = new Pager<SlickAdmin>();
        pager.setCurr(curr);
        pager.setLimit(limit);
        pager.setTotal(total);
        pager.setData(data);//
        return pager;
    }

    @ResponseBody
    @RequestMapping("/editSlickAdmin")
    public int editSlickAdmin(@RequestParam(value = "admin_role_id", required = false) Long admin_role_id,
                              @RequestParam(value = "admin_id", required = false) Long admin_id,
                              @RequestParam(value = "admin_state", required = false) Long admin_state){
        SlickAdmin slickAdmin=new SlickAdmin();
        slickAdmin.setAdmin_role_id(admin_role_id);
        slickAdmin.setAdmin_state(admin_state);
        slickAdmin.setAdmin_id(admin_id);
        return slickAdminService.editSlickAdmin(slickAdmin);
    }
    @ResponseBody
    @RequestMapping("/addSlickAdmin")
    public int addSlickAdmin(@RequestParam(value = "admin_account", required = false)String admin_name,
                             @RequestParam(value = "admin_password", required = false) String admin_pwd,
                             @RequestParam(value = "admin_role_id", required = false)Long admin_role_id,
                             @RequestParam(value = "company_name", required = false)String company_name) {
        SlickAdmin slickAdmin=new SlickAdmin();
        slickAdmin.setAdmin_role_id(admin_role_id);
        slickAdmin.setAdmin_name(admin_name);
        slickAdmin.setAdmin_pwd(admin_pwd);
        SlickCompany slickCompany=new SlickCompany();
        slickCompany.setCompany_name(company_name);
        SlickCompany slickCompany1=slickCompanyService.getSlickCompanyByName(slickCompany);
        //slickAdmin.setCompany_id(slickCompany1.getCompany_id());
        return slickAdminService.addSlickAdmin(slickAdmin);
    }

    @ResponseBody
    @RequestMapping("/editSlickAdminPwd")
    public int editSlickAdminPwd(
                              @RequestParam(value = "admin_id", required = false) Long admin_id,
                              @RequestParam(value = "admin_password", required = false)String admin_pwd
                                 ){
        SlickAdmin slickAdmin=new SlickAdmin();
        slickAdmin.setAdmin_pwd(admin_pwd);
        slickAdmin.setAdmin_id(admin_id);

        return slickAdminService.editSlickAdmin(slickAdmin);
    }


}
