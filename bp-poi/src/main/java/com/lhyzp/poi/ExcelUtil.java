package com.lhyzp.poi;

import com.lhyzp.poi.entity.ColumnParam;
import com.lhyzp.poi.entity.ExcelType;
import com.lhyzp.poi.entity.TableParam;
import com.lhyzp.poi.func.ConvertValue;
import com.lhyzp.poi.util.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * excel导入导出工具类
 * Created by zhoupeng on 2017/11/28.
 */
public class ExcelUtil {
    //默认日期转换格式
    private static final String FORMAT="yyyy-MM-dd HH:mm:ss";
    private static SimpleDateFormat sdf= new SimpleDateFormat(FORMAT);


    /**
     * 简单导出：设置列参数的导出--表格属性为默认值
     * @param columnParams 列参数对象集合
     * @param data 数据
     * @return
     * @throws IntrospectionException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static Workbook exportExcel(List<ColumnParam> columnParams, List<?> data) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        TableParam tableParam=new TableParam();
        tableParam.setColumnParams(columnParams);
        return exportExcel(tableParam,data);

    }

    /**
     * 导出 -- 对象方式
     * @param tableParam Excel参数对象
     * @param data 数据
     * @return
     * @throws IntrospectionException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static Workbook exportExcel(TableParam tableParam, List<?> data) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        /*创建Workbook和Sheet*/
        Workbook workbook;
        if(ExcelType.XLSX.equals(tableParam.getExcelType())){
            workbook = new XSSFWorkbook();
        }else if(ExcelType.XLS.equals(tableParam.getExcelType())){
            workbook = new HSSFWorkbook();
        }else {
            workbook = new SXSSFWorkbook();
        }

        /*创建Workbook和Sheet*/
        Sheet sheet = workbook.createSheet(tableParam.getSheetName());//创建工作表(Sheet)

        Integer startRow = tableParam.getStartRow();

        List<ColumnParam> columnParams = tableParam.getColumnParams();
        //创建标题
        if(tableParam.getCreateHeadRow()){
            /*创建标题行*/
            Row row = sheet.createRow(startRow);// 创建行,从0开始
            //标题设置
            setHeadRow(workbook,row,tableParam);
        }
        //创建数据
        for(int k = 0; k<data.size(); k++) {
            // 创建行,从标题下一行开始
            Row _row = sheet.createRow(k+startRow+1);
            //设置行的高度
            _row.setHeightInPoints(tableParam.getHeight());
            for (int j=0;j<columnParams.size();j++) {
                //获取属性
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnParams.get(j).getKey(), data.get(k).getClass());
                //获取get方法
                Method readMethod = propertyDescriptor.getReadMethod();
                //执行
                Object result = readMethod.invoke(data.get(k));

                //设置列宽
                sheet.setColumnWidth(j,columnParams.get(j).getWidth()*256);

                // 创建行的单元格
                Cell cell = _row.createCell(j);
                //设置单元格值及属性
                String format = columnParams.get(j).getFormat();//获取日期的格式化的格式字符串
                ConvertValue convertValue = columnParams.get(j).getConvertValue();//需要转换值的方法对象
                setCell(cell,result,format,convertValue);

            }
        }
        return workbook;
    }

    /**
     * 导出--Map集合方式
     * @param tableParam Excel参数对象
     * @param data 数据--List<Map<></>>
     * @return
     * @throws IntrospectionException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static Workbook exportExcelMap(TableParam tableParam, List<? extends Map<?,?>> data) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        /*创建Workbook和Sheet*/
        Workbook workbook;
        if(ExcelType.XLSX.equals(tableParam.getExcelType())){
            workbook = new XSSFWorkbook();
        }else if(ExcelType.XLS.equals(tableParam.getExcelType())){
            workbook = new HSSFWorkbook();
        }else {
            workbook = new SXSSFWorkbook();
        }

        /*创建Workbook和Sheet*/
        Sheet sheet = workbook.createSheet(tableParam.getSheetName());//创建工作表(Sheet)

        Integer startRow = tableParam.getStartRow();

        List<ColumnParam> columnParams = tableParam.getColumnParams();
        //创建标题
        if(tableParam.getCreateHeadRow()){
            /*创建标题行*/
            Row row = sheet.createRow(startRow);// 创建行,从0开始
            //标题设置
            setHeadRow(workbook,row,tableParam);
        }
        //创建数据
        for(int k = 0; k<data.size(); k++) {
            // 创建行,从标题下一行开始
            Row _row = sheet.createRow(k+startRow+1);
            //设置行的高度
            _row.setHeightInPoints(tableParam.getHeight());
            for (int j=0;j<columnParams.size();j++) {
                //根据key获取map的value值
                Object result = data.get(k).get(columnParams.get(j).getKey());

                //设置列宽
                sheet.setColumnWidth(j,columnParams.get(j).getWidth()*256);

                // 创建行的单元格
                Cell cell = _row.createCell(j);
                //设置单元格值及属性
                String format = columnParams.get(j).getFormat();//获取日期的格式化的格式字符串
                ConvertValue convertValue = columnParams.get(j).getConvertValue();//需要转换值的方法对象
                setCell(cell,result,format,convertValue);
            }
        }
        return workbook;
    }

    /**
     * 标题行设置
     * @param workbook
     * @param row
     * @param tableParam
     */
    private static void setHeadRow(Workbook workbook, Row row, TableParam tableParam){
        //标题行样式
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        //加粗
        font.setBold(tableParam.getHeadRowStyle().getHeadBold());
        style.setFont(font);
        //居中
        style.setAlignment(tableParam.getHeadRowStyle().getHorizontalAlignment());
        List<ColumnParam> columnParams = tableParam.getColumnParams();
        for(int i=0;i<columnParams.size();i++){
            // 创建行的单元格,也是从0开始
            Cell cell = row.createCell(i);
            // 设置单元格内容
            cell.setCellValue(columnParams.get(i).getTitle());
            cell.setCellStyle(style);
        }
    }

    /**
     * 单元格cell值设置
     * @param cell
     * @param result
     */
    private static void setCell(Cell cell, Object result, String format, ConvertValue convertValue){
        if(result!=null) {
            if (result instanceof Date) {
                Date date = (Date) result;
                String strDate = sdf.format(date);
                if (StringUtils.isNotEmptyString(format)) {
                    SimpleDateFormat s = new SimpleDateFormat(format);
                    strDate = s.format(date);
                }
                cell.setCellValue(strDate);

            } else {
                //如果需要值替换
                if (convertValue != null) {
                    String val = convertValue.convert(result);
                    cell.setCellValue(val);
                } else {
                    cell.setCellValue(String.valueOf(result));
                }
            }
        }else{
            cell.setCellValue("");
        }
    }

    /**
     * 参数设置导出--xls格式
     * @param tableParam Excel参数对象
     * @param data 数据
     * @return
     * @throws IntrospectionException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static HSSFWorkbook exportXLS(TableParam tableParam, List<?> data) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        /*创建Workbook和Sheet*/
        HSSFWorkbook workbook = new HSSFWorkbook();
        /*创建Workbook和Sheet*/
        HSSFSheet sheet = workbook.createSheet(tableParam.getSheetName());//创建工作表(Sheet)

        Integer startRow = tableParam.getStartRow();

        List<ColumnParam> columnParams = tableParam.getColumnParams();
        //创建标题
        if(tableParam.getCreateHeadRow()){
            /*创建标题行*/
            HSSFRow row = sheet.createRow(startRow);// 创建行,从0开始
            //标题行样式
            HSSFCellStyle style = workbook.createCellStyle();
            HSSFFont font = workbook.createFont();
            //加粗
            //font.setBold(tableParam.getHeadRowStyle().getHeadBold());
            style.setFont(font);
            //居中
            //style.setAlignment(tableParam.getHeadRowStyle().getHorizontalAlignment());

            for(int i=0;i<columnParams.size();i++){
                // 创建行的单元格,也是从0开始
                HSSFCell cell = row.createCell(i);
                // 设置单元格内容
                cell.setCellValue(columnParams.get(i).getTitle());
                cell.setCellStyle(style);
            }
        }
        //创建数据
        for(int k = 0; k<data.size(); k++) {
            // 创建行,从标题下一行开始
            HSSFRow _row = sheet.createRow(k+startRow+1);
            //设置行的高度
            _row.setHeightInPoints(tableParam.getHeight());
            for (int j=0;j<columnParams.size();j++) {
                //获取属性
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnParams.get(j).getKey(), data.get(k).getClass());
                //获取get方法
                Method readMethod = propertyDescriptor.getReadMethod();
                //执行
                Object result = readMethod.invoke(data.get(k));

                //设置列宽
                sheet.setColumnWidth(j,columnParams.get(j).getWidth()*256);

                // 创建行的单元格
                HSSFCell cell = _row.createCell(j);
                //设置单元格值及属性
                String format = columnParams.get(j).getFormat();//获取日期的格式化的格式字符串
                ConvertValue convertValue = columnParams.get(j).getConvertValue();//需要转换值的方法对象
                setCell(cell,result,format,convertValue);

            }
        }
        return workbook;
    }

    /**
     * 参数设置导出-xlsx
     * @param tableParam Excel参数对象
     * @param data 数据
     * @return
     * @throws IntrospectionException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static XSSFWorkbook exportXLSX(TableParam tableParam, List<?> data) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        /*创建Workbook和Sheet*/
        XSSFWorkbook workbook = new XSSFWorkbook();
        /*创建Workbook和Sheet*/
        XSSFSheet sheet = workbook.createSheet(tableParam.getSheetName());//创建工作表(Sheet)

        Integer startRow = tableParam.getStartRow();

        List<ColumnParam> columnParams = tableParam.getColumnParams();
        //创建标题
        if(tableParam.getCreateHeadRow()){
            /*创建标题行*/
            XSSFRow row = sheet.createRow(startRow);// 创建行,从0开始
            //标题行样式
            XSSFCellStyle style = workbook.createCellStyle();
            XSSFFont font = workbook.createFont();
            //加粗
            //font.setBold(tableParam.getHeadRowStyle().getHeadBold());
            style.setFont(font);
            //居中
            //style.setAlignment(tableParam.getHeadRowStyle().getHorizontalAlignment());

            for(int i=0;i<columnParams.size();i++){
                // 创建行的单元格,也是从0开始
                XSSFCell cell = row.createCell(i);
                // 设置单元格内容
                cell.setCellValue(columnParams.get(i).getTitle());
                cell.setCellStyle(style);
            }
        }
        //创建数据
        for(int k = 0; k<data.size(); k++) {
            // 创建行,从标题下一行开始
            XSSFRow _row = sheet.createRow(k+startRow+1);
            //设置行的高度
            _row.setHeightInPoints(tableParam.getHeight());
            for (int j=0;j<columnParams.size();j++) {
                //获取属性
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnParams.get(j).getKey(), data.get(k).getClass());
                //获取get方法
                Method readMethod = propertyDescriptor.getReadMethod();
                //执行
                Object result = readMethod.invoke(data.get(k));

                //设置列宽
                sheet.setColumnWidth(j,columnParams.get(j).getWidth()*256);

                // 创建行的单元格
                XSSFCell cell = _row.createCell(j);
                //设置单元格值及属性
                String format = columnParams.get(j).getFormat();//获取日期的格式化的格式字符串
                ConvertValue convertValue = columnParams.get(j).getConvertValue();//需要转换值的方法对象
                setCell(cell,result,format,convertValue);

            }
        }

        return workbook;

    }


    /**
     * Excel文件导入
     * @param filePath 文件地址
     * @param tableParam Excel配置对象
     * @param clazz 类
     * @return
     * @throws IOException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws IntrospectionException
     * @throws InvocationTargetException
     * @throws ParseException
     */
    public static List<?> importExcel(String filePath,TableParam tableParam, Class clazz) throws IOException, IllegalAccessException, InstantiationException, IntrospectionException, InvocationTargetException, ParseException, InvalidFormatException {
        FileInputStream fileInputStream=new FileInputStream(filePath);
        return importExcel(fileInputStream,tableParam,clazz);
    }

    /**
     * 导入--支持xls和xlsx
     * @param stream 文件流
     * @param tableParam Excel配置对象
     * @param clazz Class
     * @return
     * @throws IOException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws IntrospectionException
     * @throws InvocationTargetException
     * @throws ParseException
     */
    public static List<?> importExcel(InputStream stream,TableParam tableParam, Class clazz) throws IOException, IllegalAccessException, InstantiationException, IntrospectionException, InvocationTargetException, ParseException, InvalidFormatException {
        List<Object> list=new ArrayList();
        Workbook workbook = WorkbookFactory.create(stream);//读取Excel
        Sheet sheet= workbook.getSheet(tableParam.getSheetName());//得到Sheet

        //数据开始行
        int startRow=tableParam.getReadRow();

        for(int i=startRow;i<=sheet.getLastRowNum();i++){
            Row row = sheet.getRow(i);
            Object instance = clazz.newInstance();
            List<ColumnParam> columnParams = tableParam.getColumnParams();
            for (int j=0;j<columnParams.size();j++) {
                //获取属性
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnParams.get(j).getKey(), clazz);
                //获取set方法
                Method writeMethod = propertyDescriptor.getWriteMethod();
                Cell cell = row.getCell(j);
                Class<?> propertyType = propertyDescriptor.getPropertyType();

                //列的值
                String value = "";
                if(cell!=null) {
                    //判断格式
                    switch (cell.getCellTypeEnum()) {
                        case STRING:
                            value = cell.getStringCellValue();
                            break;
                        case BOOLEAN:
                            value = String.valueOf(cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            value = cell.getCellFormula();
                            break;
                        case NUMERIC:
                            //判断是否为日期格式
                            if (DateUtil.isCellDateFormatted(cell)) {
                                value = sdf.format(cell.getDateCellValue());
                            } else {
                                // 不是日期格式，则防止当数字过长时以科学计数法显示
                                cell.setCellType(CellType.STRING);
                                value = cell.toString();
                            }
                            break;
                        default:
                            value = cell.getStringCellValue();
                            break;
                    }
                }


                //判断是否需要转换--传了此参数说明需要转换
                ConvertValue convertValue = columnParams.get(j).getConvertValue();
                if(convertValue!=null){
                    value = convertValue.convert(value);
                }

                //判断类型---说明：如果传进来为空或空字符串时,统一把值设置为(Object)null,否则invoke赋值会报错
                if(StringUtils.isEmptyString(value)){
                    writeMethod.invoke(instance, (Object)null);
                }else {
                    if (propertyType == String.class) {
                        writeMethod.invoke(instance, value);
                    } else if (propertyType == Integer.class) {
                        writeMethod.invoke(instance, Integer.parseInt(value));
                    } else if (propertyType == Short.class) {
                        writeMethod.invoke(instance, Short.parseShort(value));
                    } else if (propertyType == Date.class) {
                        String format = columnParams.get(j).getFormat();
                        if (StringUtils.isNotEmptyString(format)) {
                            sdf = new SimpleDateFormat(format);
                        }
                        Date date = sdf.parse(value);
                        writeMethod.invoke(instance, date);
                    } else if (propertyType == Boolean.class) {
                        writeMethod.invoke(instance, Boolean.parseBoolean(value));
                    } else if (propertyType == Long.class) {
                        writeMethod.invoke(instance, Long.parseLong(value));
                    } else if (propertyType == Double.class) {
                        writeMethod.invoke(instance, Double.parseDouble(value));
                    } else if (propertyType == Float.class) {
                        writeMethod.invoke(instance, Float.parseFloat(value));
                    } else if (propertyType == BigDecimal.class) {
                        writeMethod.invoke(instance, BigDecimal.valueOf(Long.parseLong(value)));
                    }
                }
            }
            list.add(instance);
        }
        return list;
    }
    /**
     * 导入--支持xls格式导入
     * @param stream 文件流
     * @param tableParam Excel配置对象
     * @param clazz Class
     * @return
     * @throws IOException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws IntrospectionException
     * @throws InvocationTargetException
     * @throws ParseException
     */
    public static List<?> importXLS(InputStream stream,TableParam tableParam, Class clazz) throws IOException, IllegalAccessException, InstantiationException, IntrospectionException, InvocationTargetException, ParseException {
        List<Object> list=new ArrayList();
        HSSFWorkbook workbook = new HSSFWorkbook(stream);//读取Excel
        HSSFSheet sheet= workbook.getSheet(tableParam.getSheetName());//得到Sheet

        //数据开始行
        int startRow=tableParam.getReadRow();

        for(int i=startRow;i<=sheet.getLastRowNum();i++){
            HSSFRow row = sheet.getRow(i);
            Object instance = clazz.newInstance();
            List<ColumnParam> columnParams = tableParam.getColumnParams();
            for (int j=0;j<columnParams.size();j++) {
                //获取属性
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnParams.get(j).getKey(), clazz);
                //获取set方法
                Method writeMethod = propertyDescriptor.getWriteMethod();
                Cell cell = row.getCell(j);
                Class<?> propertyType = propertyDescriptor.getPropertyType();

                //列的值
                String value = "";
                if(cell!=null) {
                    //判断格式
                    switch (cell.getCellTypeEnum()) {
                        case STRING:
                            value = cell.getStringCellValue();
                            break;
                        case BOOLEAN:
                            value = String.valueOf(cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            value = cell.getCellFormula();
                            break;
                        case NUMERIC:
                            //判断是否为日期格式
                            if (DateUtil.isCellDateFormatted(cell)) {
                                value = sdf.format(cell.getDateCellValue());
                            } else {
                                // 不是日期格式，则防止当数字过长时以科学计数法显示
                                cell.setCellType(CellType.STRING);
                                value = cell.toString();
                            }
                            break;
                        default:
                            value = cell.getStringCellValue();
                            break;
                    }
                }


                //判断是否需要转换--传了此参数说明需要转换
                ConvertValue convertValue = columnParams.get(j).getConvertValue();
                if(convertValue!=null){
                    value = convertValue.convert(value);
                }

                //判断类型---说明：如果传进来为空或空字符串时,统一把值设置为(Object)null,否则invoke赋值会报错
                if(StringUtils.isEmptyString(value)){
                    writeMethod.invoke(instance, (Object)null);
                }else {
                    if (propertyType == String.class) {
                        writeMethod.invoke(instance, value);
                    } else if (propertyType == Integer.class) {
                        writeMethod.invoke(instance, Integer.parseInt(value));
                    } else if (propertyType == Short.class) {
                        writeMethod.invoke(instance, Short.parseShort(value));
                    } else if (propertyType == Date.class) {
                        String format = columnParams.get(j).getFormat();
                        if (StringUtils.isNotEmptyString(format)) {
                            sdf = new SimpleDateFormat(format);
                        }
                        Date date = sdf.parse(value);
                        writeMethod.invoke(instance, date);
                    } else if (propertyType == Boolean.class) {
                        writeMethod.invoke(instance, Boolean.parseBoolean(value));
                    } else if (propertyType == Long.class) {
                        writeMethod.invoke(instance, Long.parseLong(value));
                    } else if (propertyType == Double.class) {
                        writeMethod.invoke(instance, Double.parseDouble(value));
                    } else if (propertyType == Float.class) {
                        writeMethod.invoke(instance, Float.parseFloat(value));
                    } else if (propertyType == BigDecimal.class) {
                        writeMethod.invoke(instance, BigDecimal.valueOf(Long.parseLong(value)));
                    }
                }
            }
            list.add(instance);
        }
        return list;
    }
    /**
     * 导入--支持xlsx格式导入
     * @param stream 文件流
     * @param tableParam Excel配置对象
     * @param clazz Class
     * @return
     * @throws IOException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws IntrospectionException
     * @throws InvocationTargetException
     * @throws ParseException
     */
    public static List<?> importXLSX(InputStream stream,TableParam tableParam, Class clazz) throws IOException, IllegalAccessException, InstantiationException, IntrospectionException, InvocationTargetException, ParseException {
        List<Object> list=new ArrayList();
        XSSFWorkbook workbook = new XSSFWorkbook(stream);//读取Excel
        XSSFSheet sheet= workbook.getSheet(tableParam.getSheetName());//得到Sheet

        //数据开始行
        int startRow=tableParam.getReadRow();

        for(int i=startRow;i<=sheet.getLastRowNum();i++){
            XSSFRow row = sheet.getRow(i);
            Object instance = clazz.newInstance();
            List<ColumnParam> columnParams = tableParam.getColumnParams();
            for (int j=0;j<columnParams.size();j++) {
                //获取属性
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnParams.get(j).getKey(), clazz);
                //获取set方法
                Method writeMethod = propertyDescriptor.getWriteMethod();
                Cell cell = row.getCell(j);
                Class<?> propertyType = propertyDescriptor.getPropertyType();

                //列的值
                String value = "";
                if(cell!=null) {
                    //判断格式
                    switch (cell.getCellTypeEnum()) {
                        case STRING:
                            value = cell.getStringCellValue();
                            break;
                        case BOOLEAN:
                            value = String.valueOf(cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            value = cell.getCellFormula();
                            break;
                        case NUMERIC:
                            //判断是否为日期格式
                            if (DateUtil.isCellDateFormatted(cell)) {
                                value = sdf.format(cell.getDateCellValue());
                            } else {
                                // 不是日期格式，则防止当数字过长时以科学计数法显示
                                cell.setCellType(CellType.STRING);
                                value = cell.toString();
                            }
                            break;
                        default:
                            value = cell.getStringCellValue();
                            break;
                    }
                }


                //判断是否需要转换--传了此参数说明需要转换
                ConvertValue convertValue = columnParams.get(j).getConvertValue();
                if(convertValue!=null){
                    value = convertValue.convert(value);
                }

                //判断类型---说明：如果传进来为空或空字符串时,统一把值设置为(Object)null,否则invoke赋值会报错
                if(StringUtils.isEmptyString(value)){
                    writeMethod.invoke(instance, (Object)null);
                }else {
                    if (propertyType == String.class) {
                        writeMethod.invoke(instance, value);
                    } else if (propertyType == Integer.class) {
                        writeMethod.invoke(instance, Integer.parseInt(value));
                    } else if (propertyType == Short.class) {
                        writeMethod.invoke(instance, Short.parseShort(value));
                    } else if (propertyType == Date.class) {
                        String format = columnParams.get(j).getFormat();
                        if (StringUtils.isNotEmptyString(format)) {
                            sdf = new SimpleDateFormat(format);
                        }
                        Date date = sdf.parse(value);
                        writeMethod.invoke(instance, date);
                    } else if (propertyType == Boolean.class) {
                        writeMethod.invoke(instance, Boolean.parseBoolean(value));
                    } else if (propertyType == Long.class) {
                        writeMethod.invoke(instance, Long.parseLong(value));
                    } else if (propertyType == Double.class) {
                        writeMethod.invoke(instance, Double.parseDouble(value));
                    } else if (propertyType == Float.class) {
                        writeMethod.invoke(instance, Float.parseFloat(value));
                    } else if (propertyType == BigDecimal.class) {
                        writeMethod.invoke(instance, BigDecimal.valueOf(Long.parseLong(value)));
                    }
                }
            }
            list.add(instance);
        }
        return list;
    }

}
