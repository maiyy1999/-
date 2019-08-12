package com.servlet;

import com.dao.CustomerDao;
import com.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int rows = 0;
        System.out.println(req.getParameter("id")+"-----------------");
        //获取从URL传来的参数
        String id = req.getParameter("id");
        //把参数的结果当做customer的属性
        Customer customer = new Customer();
        customer.setId(Integer.parseInt(id));
        //然后调用删除的方法根据ID删除对象
        CustomerDao customerDao = new CustomerDao();
        rows = customerDao.delete(customer);
        //然后判断是否删除是否成功
        if(rows>0){
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        }
    }
}
