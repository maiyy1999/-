package com.servlet;

import com.dao.CustomerDao;
import com.entity.Customer;
import com.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;utf-8");
        int rows = 0;

        try {
            //获取参数
            String name = req.getParameter("name");
            //判断姓名是否为空
            if (!StringUtils.isNotNull(name)) {
                throw new RuntimeException("顾客姓名不能为空");
            }
            String address = req.getParameter("address");
            String phone = req.getParameter("phone");
            //创建新的顾客对象
            Customer customer = new Customer();
            //为对象增加属性
            customer.setNAME(name);
            customer.setAddress(StringUtils.str2Int(address, null));
            customer.setPhone(StringUtils.str2Int(phone, null));
            //新建一个CustomerDao对象
            CustomerDao customerDao = new CustomerDao();
            //返回受影响的行数
            rows = customerDao.addCustomer(customer);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }//调用方法打印数据
        PrintWriter out = resp.getWriter();
        if (rows > 0) {
            //如果保存成功则返回信息
            out.println("<script type='text/javascript'>alert('保存成功');location.href='';</script>");
        } else {
            //保存不成功返回信息，并保留填入的信息
            out.println("<script type='text/javascript'>alert('保存失败');history.back();</script>");
        }



    }

}
