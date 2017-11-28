package com.lhyzp.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * excel导入导出工具类
 * Created by zhoupeng on 2017/11/28.
 */
public class ExcelUtil {

    public static HSSFWorkbook exportExcel(String[] titles,String[] keys, Class clazz, List<?> data) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        /*创建Workbook和Sheet*/
        HSSFWorkbook workbook = new HSSFWorkbook();
        String sheetName="Sheet0";

        /*创建Workbook和Sheet*/
        HSSFSheet sheet = workbook.createSheet(sheetName);//创建工作表(Sheet)

        /*创建单元格*/
        HSSFRow row = sheet.createRow(0);// 创建行,从0开始

        //创建标题
        for(int i=0;i<titles.length;i++){
            // 创建行的单元格,也是从0开始
            HSSFCell cell = row.createCell(i);
            // 设置单元格内容
            cell.setCellValue(titles[i]);
        }
        //创建数据
        for(int k = 0; k<data.size(); k++) {
            HSSFRow _row = sheet.createRow(k+1);// 创建行,从0开始
            for (int j=0;j<keys.length;j++) {
                //获取属性
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(keys[j], clazz);
                //获取get方法
                Method readMethod = propertyDescriptor.getReadMethod();
                //执行
                Object result = readMethod.invoke(data.get(k));

                // 创建行的单元格,也是从0开始
                HSSFCell cell = _row.createCell(j);
                if(result instanceof Date){
                    Date date = (Date) result;
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String strDate = sdf.format(date);
                    cell.setCellValue(strDate);
                }else if(result instanceof Integer){
                    cell.setCellValue(result+"");
                }else{
                    cell.setCellValue(result+"");
                }

            }
        }

        return workbook;

    }

    public static void importExcel(InputStream inputStream,String sheetName) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);//读取Excel
        HSSFSheet sheet= workbook.getSheet(sheetName);//得到Sheet
        for (Row row : sheet)
        {
            for (Cell cell : row)
            {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }
    public static List<Object> importExcel(String filePath,String sheetName,String[] keys,Class clazz) throws IOException, IllegalAccessException, InstantiationException, IntrospectionException, InvocationTargetException, ParseException {
        List<Object> list=new ArrayList();
        FileInputStream stream = new FileInputStream(filePath);
        HSSFWorkbook workbook = new HSSFWorkbook(stream);//读取Excel
        HSSFSheet sheet= workbook.getSheet(sheetName);//得到Sheet
        int index = 0;
        for (Row row : sheet)
        {
            if(index==0){
                index=1;
                continue;
            }
            Object instance = clazz.newInstance();
            for (int j=0;j<keys.length;j++) {
                //获取属性
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(keys[j], clazz);
                //获取get方法
                Method writeMethod = propertyDescriptor.getWriteMethod();
                Cell cell = row.getCell(j);
                Class<?> propertyType = propertyDescriptor.getPropertyType();
                //判断类型
                if(propertyType==String.class){
                    writeMethod.invoke(instance,cell.getStringCellValue());
                }else if(propertyType == Integer.class){
                    writeMethod.invoke(instance,Integer.parseInt(cell.getStringCellValue()));
                }else if(propertyType == Short.class){
                    writeMethod.invoke(instance,cell.getNumericCellValue());
                }else if(propertyType == Date.class){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = sdf.parse(cell.getStringCellValue());
                    writeMethod.invoke(instance,date);
                }else if(propertyType == Boolean.class){
                    String value = cell.getStringCellValue();
                    writeMethod.invoke(instance,Boolean.parseBoolean(value));
                }
            }
            list.add(instance);
        }
        return list;
    }


}
