/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Category;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ThaiBao
 */
public class CategoryDao {
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    
    public List<Category> LayDanhSachLoaiSanPham() {
        return template.query("select * from category", new RowMapper<Category>() {
            public Category mapRow(ResultSet rs, int row) throws SQLException {
                Category c = new Category();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));                                       
                return c;
            }
        });
    }
    
    public Category TimKiemLoaiSanPhamTheoID(int id) {
        String sql = "select * from category where id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Category>(Category.class));
    }
    
    public void Them(Category c) {
        String sql = String.format("insert into category (name) values('%s')", c.getName());
        template.update(sql);
    }
     
    public int Xoa(int id) {
        String sql = "delete from category where id = " + id;
        return template.update(sql);
    }
    
    public int CapNhat(Category c) {
        String sql = String.format("update category set name='%s' where id=%d",c.getName(), c.getId());
        return template.update(sql);
    }
}
