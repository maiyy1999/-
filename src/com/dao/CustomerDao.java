package com.dao;

import com.entity.Customer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao extends BaseDao {

    /**
     * 查询全部或者单个查询，多个一起查询的方法
     *
     * @param customer
     * @return
     */
    public List<Customer> findByCus(Customer customer) {
        Connection conn = null;
        PreparedStatement prs = null;
        ResultSet rs = null;
        //创建一泛型为Customer的集合
        List<Customer> list = new ArrayList<>();
        try {
            //1.获取连接对象
            conn = this.getConnection();
            //2获得SQL语句
            StringBuffer sf = new StringBuffer();
            sf.append("select * from customer where 1=1 ");
            List paramList = new ArrayList();
            if (customer != null) {
                //拼接sql语句
                //id查询
                if (customer.getId() > 0) {
                    sf.append("and id = ? ");
                    paramList.add(customer.getId());
                }
                //名字查询
                if (customer.getNAME() != null) {
                    sf.append("and NAME like ? ");
                    paramList.add("%"+customer.getNAME()+"%");
                }
                //地址查询
                if (customer.getAddress() != null) {
                    sf.append("and address like ? ");
                    paramList.add("%"+customer.getAddress()+"%");
                }
                //电话号码查询码
                if (customer.getPhone() != null) {
                    sf.append("and phone = ? ");
                    paramList.add("%"+customer.getPhone()+"%");
                }

            }
            //3获得预编译语句集
            prs = conn.prepareStatement(sf.toString());
            //4设置占位符的值
            if (paramList != null && paramList.size() > 0) {
                for (int i = 0; i < paramList.size(); i++) {
                    prs.setObject(i + 1, paramList.get(i));
                }
            }
            //5执行SQL语句并获得结果集
            rs = prs.executeQuery();
            //遍历
            while (rs.next()) {
                Customer entity = new Customer();
                entity.setId(rs.getInt("id"));
                entity.setNAME(rs.getString("name"));
                entity.setAddress(rs.getString("address"));
                entity.setPhone(rs.getString("phone"));
                list.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            this.closeConnection(conn, prs, rs);
        }

        //返回集合
        return list;

    }

    /**
     * 增加customer的方法
     * @return
     */
    public int addCustomer(Customer customer){
        //新建一个Customer类
        //定义sql语句
        String sql = " INSERT INTO customer(NAME,address,phone) VALUES (?,?,?)";
        //为objects增加customer的属性作为数组的值
        Object[] objects = {customer.getNAME(),customer.getAddress(),customer.getPhone()};
        //调用BaseDao方法实现实现增加Customer
        return this.updateData(sql,objects);

    }

    /**
     * 删除数据库中customer的方法
     * @param customer
     * @return
     */
    public int delete(Customer customer){
        String sql = "DELETE FROM customer WHERE id = ?";
        Object[] objects = {customer.getId()};
        return this.updateData(sql,objects);
    }

    /**
     * 更改顾客属性
     * @param customer
     * @return
     */
    public int updateCus(Customer customer){
        //拼接SQL语句
        String sql = "UPDATE customer SET NAME = ? ,address = ? ,phone=? where id =?";
        //设置填充字符串的数组
        Object[]objects = {customer.getNAME(),customer.getAddress(),customer.getPhone(),customer.getId()};
        //调用方法修改customer属性
        return this.updateData(sql,objects);
    }


}
