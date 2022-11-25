/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DomainModel.LoaiSP;
import Jdbc.jdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class LoaiSPDAO extends ShopDAO<LoaiSP, Integer> {

    @Override
    public void insert(LoaiSP e) {
        String sql = "INSERT dbo.LoaiSp( tenLoaiSp) values(?)";
        jdbcHelper.update(sql, e.getTenLoaiSP());
    }

    @Override
    public void update(LoaiSP e) {
        String sql = "update dbo.LoaiSP set tenLoaiSp = ? where idLoaiSp = ?";
        jdbcHelper.update(sql, e.getTenLoaiSP(), e.getIdLoaiSp());
    }

    @Override
    public void delete(Integer k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LoaiSP> selectAll() {
        String sql = "SELECT * FROM dbo.LoaiSp";
        return selectBySql(sql);
    }

    @Override
    public LoaiSP selectById(Integer k) {
        String sql = "SELECT * FROM dbo.LoaiSp where idLoaiSp = ?";
        List<LoaiSP> list = selectBySql(sql, k);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public LoaiSP selectByName(String k) {
        String sql = "SELECT * FROM dbo.LoaiSp where idTenLoaiSp = ?";
        List<LoaiSP> list = selectBySql(sql, k);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<LoaiSP> selectBySql(String sql, Object... args) {
        List<LoaiSP> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                LoaiSP s = new LoaiSP();
                s.setIdLoaiSp(rs.getInt("idLoaiSp"));
                s.setTenLoaiSP(rs.getString("tenLoaiSp"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
