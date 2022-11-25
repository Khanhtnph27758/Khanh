/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import DomainModel.Size;
import Jdbc.jdbcHelper;
/**
 *
 * @author Admin
 */
public class SizeDAO extends ShopDAO<Size, Integer>{

    @Override
    public void insert(Size e) {
        String sql = "insert into KichThuoc(giaTriKichThuoc) values(?)";
        jdbcHelper.update(sql, e.getGiaTriKichThuoc());
    }

    @Override
    public void update(Size e) {
        String sql = "update KichThuoc set giaTriKichThuoc = ? where idKichThuoc = ?";
        jdbcHelper.update(sql, e.getGiaTriKichThuoc(), e.getIdKichThuoc());
    }

    @Override
    public void delete(Integer k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Size> selectAll() {
        String sql = "select * from KichThuoc";
        return selectBySql(sql);
    }

    @Override
    public Size selectById(Integer k) {
        String sql = "select * from KichThuoc where idKichThuoc = ?";
        List<Size> list = selectBySql(sql, k);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public Size selectByName(String k) {
        String sql = "select * from KichThuoc where giaTriKichThuoc = ?";
        List<Size> list = selectBySql(sql, k);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<Size> selectBySql(String sql, Object... args) {
        List<Size> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                Size s = new Size();
                s.setIdKichThuoc(rs.getInt("idKichThuoc"));
                s.setGiaTriKichThuoc(rs.getString("giaTriKichThuoc"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
