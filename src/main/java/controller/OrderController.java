/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.OrderDao;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Order;
import model.OrderDetail;
import model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ThaiBao
 */
@Controller
public class OrderController {
    private static final Logger logger = Logger.getLogger(OrderController.class);   
    @Autowired
    OrderDao orderDao;
    @RequestMapping(value = "/order/add")
    public String TaoDonHang(HttpSession session){        
        logger.info("Xu li them san pham vao gio hang ");  
        HashMap<Long, Cart> map = (HashMap<Long, Cart>) session.getAttribute("myCart");   
        User user = (User)session.getAttribute("LoginInfo");
        int user_id;
        if(user == null){
            return "redirect:/account/login.html";
        } else {
             user_id = user.getId();
        }
        double totalPrice = (double)session.getAttribute("totalPrice");
        int totalQuantity = (int)session.getAttribute("totalQuantity");
        orderDao.Them(user_id, totalPrice, totalQuantity);                   
        return "redirect:./adddetail.html";    
    }
    
    
    @RequestMapping(value = "/order/adddetail")
    public String TaoChiTietDonHang(HttpSession session){        
        logger.info("Them chi tiet don hang ");  
        HashMap<Long, Cart> map = (HashMap<Long, Cart>) session.getAttribute("myCart");   
        User user = (User)session.getAttribute("LoginInfo");
        int user_id;      
        user_id = user.getId();       
        double totalPrice = (double)session.getAttribute("totalPrice");
        int totalQuantity = (int)session.getAttribute("totalQuantity");
        int order_id=0;
        List<Order> listOrder = orderDao.LayDongCuoi();
        for(Order o: listOrder){// duyet danh sach lay da id dong cuoi cung
            order_id = o.getId();
        }
        Set<Long> keySet = map.keySet();//lay cac key 
        for(Long i : keySet){
            Cart cart = map.get(i);          
            orderDao.ThemChiTietSanPham(order_id, cart.getProduct().getId(), cart.getQty());
        }              
        session.removeAttribute("myCart");
        return "redirect:./list.html";    
    }
    
    
    @RequestMapping(value = "/order/list")
    public ModelAndView ListDonHang(HttpSession session){        
        logger.info("hien thi gio hang ");   
        User user = (User)session.getAttribute("LoginInfo");
        int user_id;
        if(user == null){
            return new ModelAndView("viewAccount/login");
        } else {
             user_id = user.getId();
        }
        List<Order> listOrder = orderDao.LayDanhSachDonHang(user_id);
        return new ModelAndView("viewOrder/listOrder", "listOrder", listOrder);  
    }
    
    @RequestMapping(value = "/order/detail")
    public ModelAndView ListChiTietDonHang(){        
        logger.info("hien thi gio hang ");   
        List<OrderDetail> listOrderDetail = orderDao.LayDanhSachChiTietDonHang();
        return new ModelAndView("viewOrder/listOrderDetail", "listOrderDetail", listOrderDetail);  
    }
    
}
