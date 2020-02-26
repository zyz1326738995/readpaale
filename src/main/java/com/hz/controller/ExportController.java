package com.hz.controller;

import com.hz.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/exportExcel/")
public class ExportController {
	
	@Autowired
	private ExportService exportService;






	// 导出excel 从v
	@RequestMapping("exportExcelCurrentPagerUser")
	public ResponseEntity<byte[]> exportExcelMember(@RequestParam(value = "curr", required = false) Integer curr,
													@RequestParam(value = "limit", required = false) Integer limit,
													@RequestParam(value = "datemin",required = false) String datemin,
													@RequestParam(value ="datemax",required = false) String datemax,
													@RequestParam(value = "love",required = false) String love,
													HttpServletRequest request, HttpServletResponse response) throws Exception {
		return exportService.exportExcelCurrentPagerUser(request,response,curr,limit,datemin,datemax,love);
	}

	// 导出excel
	@RequestMapping("exportExcelMember")
	public ResponseEntity<byte[]> exportExcelMember(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		return exportService.exportExcelMember(request,response);
	}

	// 导出excel
	@RequestMapping("exportRechargerecord")
	public ResponseEntity<byte[]> exportRechargerecord(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		return exportService.exportRechargerecord(request,response);
	}

}
