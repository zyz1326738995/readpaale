package com.hz.controller;

import com.hz.service.SlickCompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class CenterController {

    @Resource
    private SlickCompanyService slickCompanyService;
 /*return "redirect:/index1.html?" + "admin_account=" + admin_account*/
    @RequestMapping("/sem")
    public String ftlIndex(@RequestParam(value = "company_id",required = false) long company_id) {
            return "forward:company/index.html?company_id="+company_id;
        }
}
