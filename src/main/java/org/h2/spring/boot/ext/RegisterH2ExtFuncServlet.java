package org.h2.spring.boot.ext;


import java.sql.Connection;  
import java.sql.Statement;  

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  


/** 
* @ClassName: RegisterH2ExtFuncServlet 
* @Description:注册H2数据库的扩展函数 
* @author: 孤傲苍狼 
* @date: 2014-12-20 下午11:47:03 
* 
*/   
public class RegisterH2ExtFuncServlet extends HttpServlet {  

  /** 
  * @Field: serialVersionUID 
  */   
  private static final long serialVersionUID = 4379248469825545593L;  

  /*public void init() throws ServletException {
	  
      //1、注册uuid函数的SQL语句  
      String sql1 = "CREATE ALIAS IF NOT EXISTS uuid FOR \"h2db.function.ext.H2DBFunctionExt.uuid\"";  
      //2、注册currentTime函数的SQL语句  
      String sql2 = "CREATE ALIAS IF NOT EXISTS currentTime FOR \"h2db.function.ext.H2DBFunctionExt.now\"";  
      //3、注册IP函数的SQL语句  
      String sql3 = "CREATE ALIAS IF NOT EXISTS IP FOR \"h2db.function.ext.H2DBFunctionExt.getIp\"";  
      //4、注册date_format函数的SQL语句  
      String sql4 = "CREATE ALIAS IF NOT EXISTS date_format FOR \"h2db.function.ext.H2DBFunctionExt.date_format\"";  
      Connection connection = null;  
      Statement stmt = null;  
      try {
          //获取数据库连接  
          connection = JdbcUtil.getConnection();  
          //获取Statement对象  
          stmt = connection.createStatement();  
          //添加要执行的SQL  
          stmt.addBatch(sql1);  
          stmt.addBatch(sql2);  
          stmt.addBatch(sql3);  
          stmt.addBatch(sql4);  
          //批量执行上述的4条SQL  
          stmt.executeBatch();  
          System.out.println("H2数据库扩展函数注册成功！");  
          stmt.clearBatch();  
      } catch (Exception e) {  
          System.out.println("H2数据库扩展函数注册失败！");  
          e.printStackTrace();  
      }finally{  
          try {  
              stmt.close();  
              connection.close();  
          } catch (Exception e2) {  
              e2.printStackTrace();  
          }  
      }  
  }  */
}  