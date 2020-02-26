package com.hz.service.impl;

import com.hz.controller.BaseFrontController;

import com.hz.pojo.SlickUser;
import com.hz.pojo.SmMember;
import com.hz.pojo.SmRechargerecord;
import com.hz.service.ExportService;

import com.hz.service.LsSmMemberService;
import com.hz.service.LsSmRechargerecordService;
import com.hz.service.SlickUserService;
import com.hz.utils.ExcelFormatUtil;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ExportServiceImpl implements ExportService {
	Logger logger = LoggerFactory.getLogger(ExportServiceImpl.class);
	@Resource
	private SlickUserService slickUserService;
	@Resource
	private LsSmMemberService lsSmMemberService;
	@Resource
	private LsSmRechargerecordService lsSmRechargerecordService;
	@Override
	public ResponseEntity<byte[]> exportExcelCurrentPagerUser(HttpServletRequest request, HttpServletResponse response,Integer curr, Integer limit, String datemin, String datemax, String love) throws Exception {

		List<SlickUser> data=slickUserService.getAllUser(curr,limit,datemin,datemax,love);
		BaseFrontController baseFrontController = new BaseFrontController();
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("当前时间：" + sdf.format(d));
		return baseFrontController.buildResponseEntity2(export0((List<SlickUser>) data),  sdf.format(d)+"用户门户页面咨询记录详情表.xls");

	}

	@Override
	public ResponseEntity<byte[]> exportExcelMember(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<SmMember> data=lsSmMemberService.exportExcelMember();
		BaseFrontController baseFrontController = new BaseFrontController();
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("当前时间：" + sdf.format(d));
		return baseFrontController.buildResponseEntity2(export((List<SmMember>) data),  sdf.format(d)+"超市会员记录表.xls");

	}

	@Override
	public ResponseEntity<byte[]> exportRechargerecord(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<SmRechargerecord> data=lsSmRechargerecordService.exportRechargerecord();
		BaseFrontController baseFrontController = new BaseFrontController();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strsystime = sf.format(System.currentTimeMillis());//系统当前时间
		String strsysnanotime = sf.format(System.nanoTime());//系统当前时间
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("当前时间：" + sdf.format(d));
		return baseFrontController.buildResponseEntity2(exportRechargerecord((List<SmRechargerecord>) data), sdf.format(d)+"超市会员充值记录流水.xls");
	}


	private InputStream export0(List<SlickUser> list) {
		logger.info(">>>>>>>>>>>>>>>>>>>>开始进入导出方法>>>>>>>>>>");
		ByteArrayOutputStream output = null;
		InputStream inputStream1 = null;
		SXSSFWorkbook wb = new SXSSFWorkbook(1000);// 保留1000条数据在内存中
		SXSSFSheet sheet = wb.createSheet();
		// 设置报表头样式
		CellStyle header = ExcelFormatUtil.headSytle(wb);// cell样式
		CellStyle content = ExcelFormatUtil.contentStyle(wb);// 报表体样式
		
		// 每一列字段名
		String[] strs = new String[] { "序号","姓名", "时间", "行业", "推荐APP", "实价","用户预算","咨询内容","手机号" };
		
		// 字段名所在表格的宽度
		int[] ints = new int[]{1000, 5000, 9000, 5000, 5000, 5000, 5000, 5000, 5000};
		
		// 设置表头样式
		ExcelFormatUtil.initTitleEX(sheet, header, strs, ints);
		logger.info(">>>>>>>>>>>>>>>>>>>>表头样式设置完成>>>>>>>>>>");
		
		if (list != null && list.size() > 0) {
			logger.info(">>>>>>>>>>>>>>>>>>>>开始遍历数据组装单元格内容>>>>>>>>>>");
			for (int i = 0; i < list.size(); i++) {
				SlickUser slickUser = list.get(i);

				SXSSFRow row = sheet.createRow(i + 1);
				int j = 0;

				SXSSFCell cell = row.createCell(j++);
				cell.setCellValue(i+1);
				cell.setCellStyle(content);

				cell = row.createCell(j++);
				cell.setCellValue(slickUser.getUser_name()); // 姓名
				cell.setCellStyle(content);

				cell = row.createCell(j++);
				cell.setCellValue(slickUser.getUser_addtime()); //时间
				cell.setCellStyle(content);

				if(slickUser.getSlickIndustry().getIndustry_name()==null){

					cell = row.createCell(j++);
					cell.setCellValue("其他行业"); //行业
					cell.setCellStyle(content);

					cell = row.createCell(j++);
					cell.setCellValue("待上架"); //推荐APP
					cell.setCellStyle(content);

					cell = row.createCell(j++);
					cell.setCellValue("待上架"); //实价
					cell.setCellStyle(content);

				}else{
					cell = row.createCell(j++);
					cell.setCellValue(slickUser.getSlickIndustry().getIndustry_name()); //行业
					cell.setCellStyle(content);

					cell = row.createCell(j++);
					cell.setCellValue(slickUser.getSlickApp().getApp_name()); //推荐APP
					cell.setCellStyle(content);

					cell = row.createCell(j++);
					cell.setCellValue(slickUser.getSlickApp().getApp_price()); //实价
					cell.setCellStyle(content);
				}

				cell = row.createCell(j++);
				cell.setCellValue(slickUser.getUser_budget()); //用户预算
				cell.setCellStyle(content);

				cell = row.createCell(j++);
				cell.setCellValue(slickUser.getUser_message()); //咨询内容
				cell.setCellStyle(content);

				cell = row.createCell(j++);
				cell.setCellValue(slickUser.getUse_phone()); //手机号
				cell.setCellStyle(content);


			}
			logger.info(">>>>>>>>>>>>>>>>>>>>结束遍历数据组装单元格内容>>>>>>>>>>");
		}
		try {
			output = new ByteArrayOutputStream();
			wb.write(output);
			inputStream1 = new ByteArrayInputStream(output.toByteArray());
			output.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (output != null) {
					output.close();
					if (inputStream1 != null)
						inputStream1.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return inputStream1;
	}

	private InputStream export(List<SmMember> list) {
		logger.info(">>>>>>>>>>>>>>>>>>>>开始进入导出方法>>>>>>>>>>");
		ByteArrayOutputStream output = null;
		InputStream inputStream1 = null;
		SXSSFWorkbook wb = new SXSSFWorkbook(1000);// 保留1000条数据在内存中
		SXSSFSheet sheet = wb.createSheet();
		// 设置报表头样式
		CellStyle header = ExcelFormatUtil.headSytle(wb);// cell样式
		CellStyle content = ExcelFormatUtil.contentStyle(wb);// 报表体样式

		// 每一列字段名
		String[] strs = new String[] { "NO","会员卡号", "会员姓名", "会员生日", "注册时间", "会员性别","会员级别","会员积分","会员状态" };

		// 字段名所在表格的宽度
		int[] ints = new int[] { 1000, 5000, 5000, 5000, 9000, 5000, 5000, 5000, 5000, 5000 };

		// 设置表头样式
		ExcelFormatUtil.initTitleEX(sheet, header, strs, ints);
		logger.info(">>>>>>>>>>>>>>>>>>>>表头样式设置完成>>>>>>>>>>");

		if (list != null && list.size() > 0) {
			logger.info(">>>>>>>>>>>>>>>>>>>>开始遍历数据组装单元格内容>>>>>>>>>>");
			for (int i = 0; i < list.size(); i++) {
				SmMember smMember = list.get(i);

				SXSSFRow row = sheet.createRow(i + 1);
				int j = 0;

				SXSSFCell cell = row.createCell(j++);
				cell.setCellValue(i+1);
				cell.setCellStyle(content);

				cell = row.createCell(j++);
				cell.setCellValue(smMember.getMember_number()); // 性别
				cell.setCellStyle(content);

				cell = row.createCell(j++);
				cell.setCellValue(smMember.getMember_name()); // 性别
				cell.setCellStyle(content);

				cell = row.createCell(j++);
				cell.setCellValue(smMember.getMember_birthday()); // 年龄
				cell.setCellStyle(content);

				cell = row.createCell(j++);
				cell.setCellValue(smMember.getMember_addtime()); // 手机号
				cell.setCellStyle(content);

				String sex="";
				if(smMember.getMember_sex()==2){
					sex="女";
				}else if(smMember.getMember_sex()==1){
					sex="男";
				}
				cell = row.createCell(j++);
				cell.setCellValue(sex); // 地址
				cell.setCellStyle(content);


				cell = row.createCell(j++);
				cell.setCellValue(smMember.getSmLevel().getLevel_name()); // 手机号
				cell.setCellStyle(content);

				cell = row.createCell(j++);
				cell.setCellValue(smMember.getSmIntegral().getIntegral_integralnumbers()); // 手机号
				cell.setCellStyle(content);

				String state="";
				if(smMember.getMember_state()==2){
					state="启用";
				}else if(smMember.getMember_state()==1){
					state="禁用";
				}
				cell = row.createCell(j++);
				cell.setCellValue(state); // 手机号
				cell.setCellStyle(content);
			}
			logger.info(">>>>>>>>>>>>>>>>>>>>结束遍历数据组装单元格内容>>>>>>>>>>");
		}
		try {
			output = new ByteArrayOutputStream();
			wb.write(output);
			inputStream1 = new ByteArrayInputStream(output.toByteArray());
			output.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (output != null) {
					output.close();
					if (inputStream1 != null)
						inputStream1.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return inputStream1;
	}

	private InputStream exportRechargerecord(List<SmRechargerecord> list) {
		logger.info(">>>>>>>>>>>>>>>>>>>>开始进入导出方法>>>>>>>>>>");
		ByteArrayOutputStream output = null;
		InputStream inputStream1 = null;
		SXSSFWorkbook wb = new SXSSFWorkbook(1000);// 保留1000条数据在内存中
		SXSSFSheet sheet = wb.createSheet();
		// 设置报表头样式
		CellStyle header = ExcelFormatUtil.headSytle(wb);// cell样式
		CellStyle content = ExcelFormatUtil.contentStyle(wb);// 报表体样式

		// 每一列字段名
		String[] strs = new String[] { "NO","会员卡号", "会员姓名", "充值金额", "充值时间", "支付类型","新增积分" };

		// 字段名所在表格的宽度
		int[] ints = new int[] { 4000, 5000, 5000, 5000, 9000, 5000, 5000, 5000 };

		// 设置表头样式
		ExcelFormatUtil.initTitleEX(sheet, header, strs, ints);
		logger.info(">>>>>>>>>>>>>>>>>>>>表头样式设置完成>>>>>>>>>>");

		if (list != null && list.size() > 0) {
			logger.info(">>>>>>>>>>>>>>>>>>>>开始遍历数据组装单元格内容>>>>>>>>>>");
			for (int i = 0; i < list.size(); i++) {
				SmRechargerecord smRechargerecord = list.get(i);

				SXSSFRow row = sheet.createRow(i + 1);
				int j = 0;

				SXSSFCell cell = row.createCell(j++);
				cell.setCellValue(i+1);
				cell.setCellStyle(content);

				cell = row.createCell(j++);
				cell.setCellValue(smRechargerecord.getSmMember().getMember_number()); // 性别
				cell.setCellStyle(content);

				cell = row.createCell(j++);
				cell.setCellValue(smRechargerecord.getSmMember().getMember_name()); // 性别
				cell.setCellStyle(content);

				cell = row.createCell(j++);
				cell.setCellValue(smRechargerecord.getRechargerecord_summoney()); // 年龄
				cell.setCellStyle(content);

				cell = row.createCell(j++);
				cell.setCellValue(smRechargerecord.getRechargerecord_time()); // 手机号
				cell.setCellStyle(content);

				String rechargerecord_type="";
				if(smRechargerecord.getRechargerecord_type()==1){
					rechargerecord_type="现金";
				} else if(smRechargerecord.getRechargerecord_type()==2){
					rechargerecord_type="微信";
				} else if(smRechargerecord.getRechargerecord_type()==3){
					rechargerecord_type="支付宝";
				} else if(smRechargerecord.getRechargerecord_type()==4){
					rechargerecord_type="银行卡";
				}
				cell = row.createCell(j++);
				cell.setCellValue(rechargerecord_type); // 地址
				cell.setCellStyle(content);

				cell = row.createCell(j++);
				cell.setCellValue(smRechargerecord.getRechargerecord_summoney()); // 年龄
				cell.setCellStyle(content);

			}
			logger.info(">>>>>>>>>>>>>>>>>>>>结束遍历数据组装单元格内容>>>>>>>>>>");
		}
		try {
			output = new ByteArrayOutputStream();
			wb.write(output);
			inputStream1 = new ByteArrayInputStream(output.toByteArray());
			output.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (output != null) {
					output.close();
					if (inputStream1 != null)
						inputStream1.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return inputStream1;
	}
}
