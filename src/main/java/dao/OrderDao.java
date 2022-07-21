/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Order;
import model.OrderDetail;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ThaiBao
 */
public class OrderDao {
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    
    public void Them(int customer_id, double totalPrice,  int quantity) {
        String sql = String.format("insert into order1 (customer_id, totalPrice, quantity, status) values('%d', '%s', '%d', '%d')"  , customer_id, totalPrice, quantity, 0);
        template.update(sql);
    }
    
    public void ThemChiTietSanPham(int order_id, int product_id, int quantity) {
        String sql = String.format("insert into order_detail (order_id, product_id, quantity) values('%d', '%d', '%d')", order_id, product_id, quantity);
        template.update(sql);
    }
    
    
    public List<Order> LayDanhSachDonHang(int customer_id) {
        return template.query("select * from order1 where customer_id=" + customer_id,new RowMapper<Order>() {
            public Order mapRow(ResultSet rs, int row) throws SQLException {
                Order od = new Order();
                od.setId(rs.getInt(1));
                od.setTotalPrice(rs.getDouble(2));
                od.setQuantity(rs.getInt(3));
                od.setStatus(rs.getInt(4));
                od.setCustomer_id(rs.getInt(5));                                             
                return od;
            }
        });
    }      
    
    public List<Order> LayDongCuoi() {
        return template.query("select * from order1 " ,new RowMapper<Order>() {
            public Order mapRow(ResultSet rs, int row) throws SQLException {
                Order od = new Order();
                od.setId(rs.getInt(1));
                od.setTotalPrice(rs.getDouble(2));
                od.setQuantity(rs.getInt(3));
                od.setStatus(rs.getInt(4));
                od.setCustomer_id(rs.getInt(5));                                             
                return od;
            }
        });
    }     
    
    public List<OrderDetail> LayDanhSachChiTietDonHang() {
        return template.query("select od.*, p.name from order_detail od JOIN product p on od.product_id = p.id" , new RowMapper<OrderDetail>() {
            public OrderDetail mapRow(ResultSet rs, int row) throws SQLException {
                OrderDetail o = new OrderDetail();
                o.setId(rs.getInt(1));
                o.setOrder_id(rs.getInt(2));
                o.setProduct_id(rs.getInt(3));
                o.setQuantity(rs.getInt(4));     
                o.setProduct_name(rs.getString(5));
                return o;
            }
        });
        
        
    }
}
