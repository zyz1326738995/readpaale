package com.hz.controller;

import com.hz.pojo.SlickAdmin;
import com.hz.pojo.SlickUser;
import com.hz.service.SlickUserService;
import com.hz.utils.FileUpload;
import com.hz.utils.Pager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/SlickUserController")
public class SlickUserController {
     @Resource
    private SlickUserService slickUserService;


    @Value("${file.location.path}")
    private String fileLocation;
    @RequestMapping("/insert")
    public String  insert(MultipartFile file,SlickUser slickUser){
        String uri = FileUpload.upload(file,"/upload",fileLocation);
        System.out.println(slickUser.getUser_name()+":url");
        System.out.println(uri+":url");
        return "login";
    }

    /**
     *
     * @param userName
     * @param userIndustryId
     * @param userBudget
     * @param usePhone
     * @param userMessage
     */
    @RequestMapping("/insertUser")
    @ResponseBody
    public void insertUser(@RequestParam("userName")String userName,
                           @RequestParam("userIndustryId")long userIndustryId,
                          @RequestParam("userBudget")double userBudget,
                          @RequestParam("usePhone")String usePhone,
                          @RequestParam("userMessage")String userMessage,
                           @RequestParam("company_id") long company_id) {
        SlickUser slickUser=new SlickUser(userName,userIndustryId,userMessage,userBudget,usePhone,company_id);
        System.out.println(slickUser);
        slickUserService.insertUser(slickUser);

    }


    @ResponseBody
    @RequestMapping("/getUserPager")
    public Pager getUserPager(@RequestParam(value = "curr", required = false) Integer curr,
                               @RequestParam(value = "limit", required = false) Integer limit,
                               @RequestParam(value = "datemin",required = false) String datemin,
                               @RequestParam(value ="datemax",required = false) String datemax,
                               @RequestParam(value = "love",required = false) String love){
        int total=slickUserService.getUserCount(datemin,datemax,love);
        List<SlickUser> data= slickUserService.getAllUser(curr,limit,datemin,datemax,love);
        Pager<SlickUser> pager = new Pager<SlickUser>();
        pager.setCurr(curr);
        pager.setLimit(limit);
        pager.setTotal(total);
        pager.setData(data);//
        return pager;
    }

}
