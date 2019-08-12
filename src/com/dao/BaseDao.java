package com.dao;




import java.sql.*;

public class BaseDao {
    /**
     * mysql 驱动{@value}
     */
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    /**
     * 连接地址{@value}
     */
    public static final String URL = "jdbc:mysql://localhost:3306/my1905?characterEncoding=utf8&useSSL=false&serverTimezone=CST";
    /**
     * 用户名{@value}
     */
    public static final String USERNAME = "root";
    /**
     * 密码{@value}
     */
    public static final String PASSWORD = "123456";

    /**
     * 获取数据库连接
     *
     * @return
     */

    public  Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭资源
     *
     * @param conn
     * @param prs
     * @param rs
     */
    public  void closeConnection(Connection conn, PreparedStatement prs, ResultSet rs) {
        try {
            if (rs != null) {rs.close();}
            if (prs != null) {prs.close();}
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 更新数据库的底层方法
     *
     * @param objects 传入的是顾客属性的数组
     * @param sql     拼接的sql 语句
     * @return 受影响的行数
     */
    public int updateData(String sql, Object[] objects) {
        Connection conn = null;
        PreparedStatement prs = null;
        try {
            //获取数据库连接
            conn = this.getConnection();
            //预编译
            prs = conn.prepareStatement(sql);
            if(objects!=null&&objects.length>0){
                //填充占位符
                for(int i = 0;i< objects.length;i++){
                    prs.setObject(i+1,objects[i]);
                }
            }
            //返回影响的行数
            return  prs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(conn,prs,null);
        }
        return 0;
    }
}
