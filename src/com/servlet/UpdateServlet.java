package com.servlet;

import com.dao.CustomerDao;
import com.entity.Customer;
import com.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //根据URL获取参数
        String id = StringUtils.str2Int(req.getParameter("id"), "0");
        //然后根据ID查询结果显示在页面中
        Customer customer = new Customer();
        customer.setId(Integer.parseInt(id));
        CustomerDao customerDao = new CustomerDao();
        //调用方法产生一个集合
        List<Customer> list = customerDao.findByCus(customer);
        req.setAttribute("list", list);
        //转发到update.jsp页面
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获得参数
        String name = req.getParameter("name");

        String address = req.getParameter("address");

        String phone = req.getParameter("phone");

        String id = req.getParameter("id");

        Customer customer = new Customer();
        //为customer增加属性
        customer.setNAME(name);
        customer.setAddress(address);
        customer.setPhone(phone);
        customer.setId(Integer.parseInt(id));
        //调用方法更改数据
        CustomerDao customerDao = new CustomerDao();
        //返回结果
        int rows = customerDao.updateCus(customer);
        if(rows>0){
            //判断是否成功更改
            resp.sendRedirect("success.jsp");
        }


    }
}
