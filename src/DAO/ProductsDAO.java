/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DomainModel.Products;
import Jdbc.jdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author ducit
 */
public class ProductsDAO extends ShopDAO<Products, Integer> {

    @Override
    public void insert(Products e) {
        String sql = "insert into SanPham (idLoaiSp,idNhaCC, tenSp) values (?,?,?)";
        jdbcHelper.update(sql, e.getIdList(), 1,e.getNameProduct());
    }

    @Override
    public void update(Products e) {
        String sql = "UPDATE dbo.SanPham SET idList = ?, nameProduct = ?, description =?, status = ? WHERE idProduct = ?";
        jdbcHelper.update(sql, e.getIdList(), e.getNameProduct(), e.getDescription(), e.isStatus(), e.getIdProduct());
    }

    @Override
    public void delete(Integer k) {
        String sql = "update products set statusDelete = 0 where idProduct = ?";
        jdbcHelper.update(sql, k);
    }

    @Override
    public List<Products> selectAll() {
        //String sql = "SELECT * FROM dbo.SanPham JOIN dbo.List ON List.idList = Products.idList WHERE statusDelete = 1 AND List.status = 1 ORDER BY IdProduct Desc";
        String sql = "SELECT * FROM dbo.SanPham";
        return selectBySql(sql);
    }

    @Override
    public Products selectById(Integer k) {
        String sql = "SELECT * FROM dbo.Products JOIN dbo.List ON List.idList = Products.idList WHERE idProduct = ?";
        List<Products> list = selectBySql(sql, k);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    public Products selectByName(String name) {
        String sql = "select * from Products JOIN dbo.List ON List.idList = Products.idList where nameProduct= ?";
        List<Products> list = selectBySql(sql, name);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<Products> selectBySql(String sql, Object... args) {
        List<Products> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                Products p = new Products();
                p.setIdProduct(rs.getInt("IdSp"));
                p.setNameProduct(rs.getString("tenSp"));
                p.setDescription(rs.getString("moTa"));
                p.setIdList(rs.getInt("idLoaiSp"));
                p.setNameList(rs.getString("tenSp"));
                p.setStatus(rs.getBoolean("trangThai"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Products> selectByKeyWord(String keyword) {
        String sql = "SELECT * from Products JOIN dbo.List ON List.idList = Products.idList where nameProduct like ? and List.status = 1 and statusDelete = 1";
        return selectBySql(sql, "%" + keyword + "%");
    }
}
