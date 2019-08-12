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

public class AllSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //设置字符集
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;utf-8");

        //创建一个CustomerDAO对象
        CustomerDao customerDao = new CustomerDao();
        //创建一个新的顾客对象
        Customer cus = new Customer();
        //为顾客赋值
        //调用StringUtils.str2Int()将字符串转换为Integer
        String id = req.getParameter("id");
        id = StringUtils.str2Int(id,"0");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        cus.setId(Integer.parseInt(id));
        cus.setNAME(StringUtils.str2Int(name,null));
        cus.setAddress(StringUtils.str2Int(address,null));
        cus.setPhone(StringUtils.str2Int(phone,null));

        //调用customerDao方法查询顾客信息
        List<Customer> customers = customerDao.findByCus(cus);
        //设置键值对
        req.setAttribute("customers", customers);


        //用转发把得到的值发送到list.jsp
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }
}
