/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Customer;
import model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author ThaiBao
 */
public class AccountDao {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    //tim kiem nguoi dung theo ten dang nhap 
    public User SearchUserByName(String username) {
        String sql = "SELECT * FROM user WHERE username = ?";
        try {
            return template.queryForObject(sql, new Object[]{username}, new BeanPropertyRowMapper<User>(User.class));
        } catch (Exception e) {
            return null;
        }
    }

    // tim kiem customer voi username
    public Customer SearchCustomerByName(String username) {
        String sql = "SELECT * FROM customer WHERE username = ?";
        try {
            return template.queryForObject(sql, new Object[]{username}, new BeanPropertyRowMapper<Customer>(Customer.class));
        } catch (Exception e) {
            return null;
        }
    }

    //them customer vao db
    public void AddCustomer(Customer customer) {
        String sql = String.format("insert into customer (first_name,last_name,username,password,phone_number,address) values('%s','%s','%s','%s','%s','%s')", customer.getFirst_name(), customer.getLast_name(), customer.getUsername(), customer.getPassword(), customer.getPhone_number(), customer.getAddress());
        template.update(sql);
    }

    //them user khi dang ki customer
    public void AddUser(String username, String password, int customer_id) {
        String sql = String.format("insert into user (username,password,customer_id, rules_id) values('%s','%s','%d','%d')", username, password, customer_id, 2);
        template.update(sql);
    }

    //cap nhat lai quyen cua user
    public int UpdateRulesUser(int id) {
        String sql = String.format("update user set rules_id=3 where id=%d", id);
        return template.update(sql);
    }
}
