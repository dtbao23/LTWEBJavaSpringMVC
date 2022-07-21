/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AccountDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

    private static final Logger logger = Logger.getLogger(AccountController.class);

    @Autowired
    AccountDao accountDao;

    @RequestMapping(value = "/account/login")
    public ModelAndView Login() {
        logger.info("Hien thi giao dien login");
        return new ModelAndView("viewAccount/login");
    }

    
    
    @RequestMapping(value = "/account/logout")
    public String Logout(HttpSession session) {
        logger.info("Xu li logout");
        //lay gia tri trong session ra kiem tra
        if(session.getAttribute("LoginInfo") != null){
            session.invalidate();
        }
        return "redirect:/homepage.html";
    }
    
    @RequestMapping(value = "/account/signup")
    public ModelAndView Signup() {
        logger.info("Hien thi giao dien signup");
        return new ModelAndView("viewAccount/signup");

    }
    //@RequestParam("first_name") String first_name, @RequestParam("last_name") String last_name, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("phone_number") String phone_number, @RequestParam("address") String address
    @RequestMapping(value = "/account/signup/add")
    public String AddCustomer(Customer customer) {
        logger.info("Them nguoi dung vao database");
        logger.info("Tao tai khoan cho nguoi dung");
        accountDao.AddCustomer(customer);
        Customer ctm = accountDao.SearchCustomerByName(customer.getUsername());
        accountDao.AddUser(customer.getUsername(), customer.getPassword(), ctm.getId());
        return "redirect:/account/login.html";
    }    
    
    @RequestMapping(value = "/account/checklogin", method = RequestMethod.POST)
    public ModelAndView CheckLogin(HttpSession session, @RequestParam("txtUsername") String txtusername, @RequestParam("txtPassword") String txtpassword) {
        logger.info("Kiem tra login");
        
        ModelAndView modelAndView = new ModelAndView();
        User user = accountDao.SearchUserByName(txtusername);
        if (user != null) {
            if(user.getPassword().equals(txtpassword)){   
                modelAndView.setViewName("redirect:/homepage.html");                                                 
            } else {
                modelAndView.setViewName("viewAccount/login");
                modelAndView.addObject("statusLogin", "Invalid Password!");                                  
            }                                 
        } else {
            modelAndView.setViewName("viewAccount/login");
            modelAndView.addObject("statusLogin", "Invalid account or password!");         
        }
         //tao sesson luu tru id username
        session.setAttribute("LoginInfo", user);  
        return modelAndView;
    }

}
