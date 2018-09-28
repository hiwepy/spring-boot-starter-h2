package org.h2.spring.boot.ext;

/**
 * @author Administrator
 * https://blog.csdn.net/guicaizhou/article/details/51862423
 */

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;  

/** 
* @ClassName: H2DBFunctionExt 
* @Description: 针对H2数据库函数的扩展 
* @author: 孤傲苍狼 
* @date: 2014-12-20 下午11:20:34 
* 
*/   
public class H2DBFunctionExt {  

  /** 
  * 用法：SELECT uuid(); 
  * H2数据库注册uuid函数：CREATE ALIAS IF NOT EXISTS uuid FOR "h2db.function.ext.H2DBFunctionExt.uuid"; 
  * @Method: uuid 
  * @Description: 实现MySQL数据库的uuid函数，用于生成UUID 
  * @Anthor:孤傲苍狼 
  * 
  * @return 
  */   
  public static String uuid(){  
      return UUID.randomUUID().toString();  
  }  

  /** 
  * H2数据库注册currentTime函数：CREATE ALIAS IF NOT EXISTS currentTime FOR "h2db.function.ext.H2DBFunctionExt.now"; 
  * @Method: now 
  * @Description: 实现MySQL数据库的now()函数，用于生成当前系统时间 
  * @Anthor:孤傲苍狼 
  * 
  * @return 
  */   
  public static String now(){  
      return new Date().toLocaleString();  
  }  
    
  /** 
   * H2数据库注册IP函数：CREATE ALIAS IF NOT EXISTS IP FOR "h2db.function.ext.H2DBFunctionExt.getIp"; 
  * @Method: getIp 
  * @Description:  
  * @Anthor:孤傲苍狼 
  * 
  * @return 
  */   
  public static String getIp(){  
      try {  
          InetAddress addr = InetAddress.getLocalHost();  
          //获得本机IP  
          return addr.getHostAddress();  
      } catch (UnknownHostException e) {  
          e.printStackTrace();  
          return "未知的IP地址";  
      }   
  }  
    
  /** 
  * H2数据库注册date_format函数：CREATE ALIAS IF NOT EXISTS date_format FOR "h2db.function.ext.H2DBFunctionExt.date_format"; 
  * @Method: date_format 
  * @Description: 实现MySQL数据库的date_format()函数，用于格式化日期 
  * @Anthor:孤傲苍狼 
  * @param date 
  * @param pattern 
  * @return 
  */   
  public static String date_format(String date,String pattern){  
      if (date != null) {  
          SimpleDateFormat sdf = new SimpleDateFormat(pattern);  
          try {  
              Date temp = sdf.parse(date);  
              return sdf.format(temp);  
          } catch (ParseException e) {  
              e.printStackTrace();  
          }  
      }  
      return "";  
  }  
}  