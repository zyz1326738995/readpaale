package com.hz.controller;



import com.hz.pojo.SlickApp;
import com.hz.service.SlickAppService;
import com.hz.utils.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/SlickAppController")
public class SlickAppController {

    @Resource
    private SlickAppService slickAppService;

    @RequestMapping("/getSlickAppList")
    @ResponseBody
    public List<SlickApp> getSlickAppList(@RequestParam("company_id") long company_id) {
        return slickAppService.getSlickAppList(company_id);
    }

    @ResponseBody
    @RequestMapping("/getAppPager")
    public Pager getAppPager(@RequestParam(value = "curr", required = false) Integer curr,
                                  @RequestParam(value = "limit", required = false) Integer limit,
                                  @RequestParam(value = "love",required = false) String love
    ){
        int total=slickAppService.getAppCount(love);

        List<SlickApp> data= slickAppService.getAppLists(curr,limit,love);
        Pager<SlickApp> pager = new Pager<SlickApp>();
        pager.setCurr(curr);
        pager.setLimit(limit);
        pager.setTotal(total);
        pager.setData(data);//
        return pager;
    }
    @ResponseBody
    @RequestMapping("/updateApp")
    public int updateApp( @RequestParam("app_name") String app_name,
                               @RequestParam("app_message") String app_message,
                               @RequestParam("app_id")long app_id,
                             @RequestParam("app_price") double app_price){
        SlickApp slickApp=new SlickApp(app_id,app_name,app_price,app_message);
        return slickAppService.updateApp(slickApp);
    }

}
