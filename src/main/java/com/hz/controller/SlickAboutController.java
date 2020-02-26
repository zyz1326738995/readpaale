package com.hz.controller;

import com.hz.pojo.SlickAbout;
import com.hz.pojo.SlickCompany;
import com.hz.service.SlickAboutService;
import com.hz.utils.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/SlickAboutController")
public class SlickAboutController {

    @Resource
    private SlickAboutService slickAboutService;


    @RequestMapping("/getSlickAboutList")
    @ResponseBody
    public List<SlickAbout> getSlickAboutList(@RequestParam("company_id") long company_id) {
        return slickAboutService.getSlickAboutList(company_id);
    }

    @ResponseBody
    @RequestMapping("/getAboutPager")
    public Pager getAboutPager(@RequestParam(value = "curr", required = false) Integer curr,
                                 @RequestParam(value = "limit", required = false) Integer limit,
                                 @RequestParam(value = "love",required = false) String love
                                 ){
        int total=slickAboutService.getAboutCount(love);

        List<SlickAbout> data= slickAboutService.getAboutLists(curr,limit,love);
        Pager<SlickAbout> pager = new Pager<SlickAbout>();
        pager.setCurr(curr);
        pager.setLimit(limit);
        pager.setTotal(total);
        pager.setData(data);//
        return pager;
    }

    @ResponseBody
    @RequestMapping("/updateAbout")
    public int updateAbout( @RequestParam("about_title") String about_title,
                            @RequestParam("about_message") String about_message,
                            @RequestParam("about_id")long about_id){
        SlickAbout slickAbout=new SlickAbout(about_id,about_title,about_message);
        return slickAboutService.updateAbout(slickAbout);
    }

}
