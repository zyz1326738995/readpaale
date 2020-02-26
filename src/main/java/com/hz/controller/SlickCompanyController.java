package com.hz.controller;

import com.hz.pojo.SlickCompany;
import com.hz.service.SlickCompanyService;
import com.hz.utils.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/SlickCompanyController")
public class SlickCompanyController {

    @Resource
    private SlickCompanyService slickCompanyService;

    @RequestMapping("/getCompany")
    @ResponseBody
    public SlickCompany getSlickCompany(@RequestParam("company_id") long company_id){
        SlickCompany slickCompany=new SlickCompany();
        slickCompany.setCompany_id(company_id);
        return slickCompanyService.getSlickCompany(slickCompany);
    }

    @ResponseBody
    @RequestMapping("/getCompanyPager")
    public Pager getCompanyPager(@RequestParam(value = "curr", required = false) Integer curr,
                              @RequestParam(value = "limit", required = false) Integer limit,
                                 @RequestParam(value = "love",required = false) String love){
        int total=slickCompanyService.getCompanyCount(love);

        List<SlickCompany> data= slickCompanyService.getCompanyLists(curr,limit,love);
        Pager<SlickCompany> pager = new Pager<SlickCompany>();
        pager.setCurr(curr);
        pager.setLimit(limit);
        pager.setTotal(total);
        pager.setData(data);//
        return pager;
    }
    @ResponseBody
    @RequestMapping("/updateCompany")
    public int updateCompany(@RequestParam("company_id") long company_id,
                             @RequestParam("company_name") String company_name,
                             @RequestParam("company_hot_message") String company_hot_message,
                             @RequestParam("company_hot_message2") String company_hot_message2,
                             @RequestParam("copy_gufen")String copy_gufen,
                             @RequestParam("company_title") String company_title){
        SlickCompany slickCompany=new SlickCompany(company_name,company_title,company_hot_message,company_hot_message2,copy_gufen,company_id);
        return slickCompanyService.updateCompany(slickCompany);
    }
}
