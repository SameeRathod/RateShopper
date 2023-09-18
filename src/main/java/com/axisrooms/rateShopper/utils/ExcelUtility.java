package com.axisrooms.rateShopper.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.axisrooms.rateShopper.constants.FrameworkConstant;

public class ExcelUtility {

	public static List<Map<String, String>> getTestDetails(String sheetName) {
		List<Map<String,String>> list=null;
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(FrameworkConstant.excelFilePath());
			
			@SuppressWarnings("resource")
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
			String sheetname = sheetName;
			XSSFSheet sheet = xssfWorkbook.getSheet(sheetname);

			
			int lastRowNum = sheet.getLastRowNum();
			
			int lastCellNum = sheet.getRow(0).getLastCellNum();

			Map<String, String> map = null;
			list=new ArrayList<>();
			for (int i = 0; i <= lastRowNum; i++) {
				map=new HashMap<>();
				for (int j = 0; j < lastCellNum; j++) {
					
				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);

				}
				list.add(map);

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		finally {
			try {
				if(Objects.nonNull(fileInputStream))
				fileInputStream.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

		return list;
	}

}
