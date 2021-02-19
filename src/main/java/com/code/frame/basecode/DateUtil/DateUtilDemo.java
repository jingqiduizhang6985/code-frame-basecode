package com.code.frame.basecode.DateUtil;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

/**
 * 中文文档
 * https://www.hutool.cn/docs/#/
 * 参考API
 * https://apidoc.gitee.com/loolly/hutool/
 *
 *   开源工具包 https://gitee.com/loolly/hutool
 *         <dependency>
 *             <groupId>cn.hutool</groupId>
 *             <artifactId>hutool-all</artifactId>
 *              <version>5.3.8</version>
 *         </dependency>
 * 日期工具类
 * @author duran
 * @date 2020-11-05
 */
public class DateUtilDemo {

    /**
     * 字符串日期转换为 日期格式
     * @param dataStr  2017-05-06
     * @return
     */
    public static Date getStrToDate(String dataStr){
        return Convert.toDate(dataStr);
    }


     public static void main(String[] args) {
//        System.out.println(getStrToDate("2020-11-05"));

         //116进制（Hex）字符串 转换
//         String a = "我是一个小小的可爱的字符串";
//       //结果："e68891e698afe4b880e4b8aae5b08fe5b08fe79a84e58fafe788b1e79a84e5ad97e7aca6e4b8b2"
//         String hex = Convert.toHex(a, CharsetUtil.CHARSET_UTF_8);
//        System.out.println(hex);
//         //结果为："我是一个小小的可爱的字符串"
//         String raw = Convert.hexToStr(hex, CharsetUtil.CHARSET_UTF_8);
//         System.out.println(raw);

         //Unicode和字符串转换
//         String a = "我是一个小小的可爱的字符串";
//    //结果为："\\u6211\\u662f\\u4e00\\u4e2a\\u5c0f\\u5c0f\\u7684\\u53ef\\u7231\\u7684\\u5b57\\u7b26\\u4e32"
//         String unicode = Convert.strToUnicode(a);
//         System.out.println(unicode);
//    //结果为："我是一个小小的可爱的字符串"
//         String raw = Convert.unicodeToStr(unicode);
//         System.out.println(raw);

         //金额大小写转换
//        double a = 67556.32;
//        //结果为："陆万柒仟伍佰伍拾陆元叁角贰分"
//         String digitUppercase = Convert.digitToChinese(a);
//         System.out.println(digitUppercase);

         //当前时间
//         Date date = DateUtil.date();
        //当前时间
//         Date date2 = DateUtil.date(Calendar.getInstance());
//        //当前时间
//         Date date3 = DateUtil.date(System.currentTimeMillis());
        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
//         String now = DateUtil.now();
//         System.out.println(now);
//        //当前日期字符串，格式：yyyy-MM-dd
//         String today= DateUtil.today();
//         System.out.println(today);

//         String dateStr = "2017-03-01";
//         Date date = DateUtil.parse(dateStr, "yyyy-MM-dd");


//         String dateStr = "2017-03-01";
//         Date date = DateUtil.parse(dateStr);
//
//        //结果 2017/03/01
//         String format = DateUtil.format(date, "yyyy/MM/dd");
//        //常用格式的格式化，结果：2017-03-01
//         String formatDate = DateUtil.formatDate(date);
//        //结果：2017-03-01 00:00:00
//         String formatDateTime = DateUtil.formatDateTime(date);
//        //结果：00:00:00
//         String formatTime = DateUtil.formatTime(date);
//         获取Date对象的某个部分
//         Date date = DateUtil.date();
//        //获得年的部分
//         DateUtil.year(date);
//        //获得月份，从0开始计数
//         DateUtil.month(date);
//        //获得月份枚举
//         DateUtil.monthEnum(date);
         //.....

//         开始和结束时间
//         String dateStr = "2017-03-01 22:33:23";
//         Date date = DateUtil.parse(dateStr);
//
////一天的开始，结果：2017-03-01 00:00:00
//         Date beginOfDay = DateUtil.beginOfDay(date);
//
////一天的结束，结果：2017-03-01 23:59:59
//         Date endOfDay = DateUtil.endOfDay(date);


         File file = FileUtil.file("D:\\apache-tomcat-7.0.67\\webapps\\plant\\modeler.html");
         String type = FileTypeUtil.getType(file);
         System.out.println(type);







    }

}
