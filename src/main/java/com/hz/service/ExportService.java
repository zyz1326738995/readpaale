package com.hz.service;

import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ExportService {


	ResponseEntity<byte[]> exportExcelCurrentPagerUser(HttpServletRequest request, HttpServletResponse response,Integer curr, Integer limit, String datemin, String datemax, String love) throws Exception;
	ResponseEntity<byte[]> exportExcelMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
	ResponseEntity<byte[]> exportRechargerecord(HttpServletRequest request, HttpServletResponse response) throws Exception;



}
