package com.hz.controller;

import com.hz.pojo.SlickAbout;
import com.hz.pojo.SlickIndustry;
import com.hz.service.SlickAboutService;
import com.hz.service.SlickIndustryService;
import com.hz.utils.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/SlickIndustryController")
public class SlickIndustryController {

    @Resource
    private SlickIndustryService slickIndustryService;



    /**
     * http://127.0.0.1:69/SlickIndustryController/getSlickIndustryList
     * @return
     */
    @RequestMapping("/getSlickIndustryList")
    @ResponseBody
    public List<SlickIndustry> getSlickIndustryList(@RequestParam("company_id") long company_id) {

        return slickIndustryService.getSlickIndustryList(company_id);
    }


    @ResponseBody
    @RequestMapping("/getIndustryPager")
    public Pager getIndustryPager(@RequestParam(value = "curr", required = false) Integer curr,
                               @RequestParam(value = "limit", required = false) Integer limit,
                               @RequestParam(value = "love",required = false) String love
    ){
        int total=slickIndustryService.getIndustryCount(love);

        List<SlickIndustry> data= slickIndustryService.getIndustryLists(curr,limit,love);
        Pager<SlickIndustry> pager = new Pager<SlickIndustry>();
        pager.setCurr(curr);
        pager.setLimit(limit);
        pager.setTotal(total);
        pager.setData(data);//
        return pager;
    }

    @ResponseBody
    @RequestMapping("/updateIndustry")
    public int updateIndustry( @RequestParam("industry_name") String industry_name,
                            @RequestParam("industry_introduce") String industry_introduce,
                            @RequestParam("industry_id")long industry_id){
        SlickIndustry slickIndustry=new SlickIndustry(industry_id,industry_name,industry_introduce);
        return slickIndustryService.updateIndustry(slickIndustry);
    }

}
