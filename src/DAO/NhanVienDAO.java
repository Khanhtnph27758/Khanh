/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DomainModel.Account;
import DomainModel.NhanVien;
import Jdbc.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Khanh
 */
public class NhanVienDAO extends ShopDAO<NhanVien, Integer>{

    @Override
    public void insert(NhanVien e) {
        jdbcHelper.update("insert into nguoidung values( ?,?,?,?,?,?,?,?,?)", e.getTennv(),e.getNgaysinh(),e.getGioitinh(),e.getSdt(),e.getEmail()
                ,e.getDiachi(),e.getLuong(),e.getVaitro(),e.getTt());
    }

    @Override
    public void update(NhanVien e) {
        jdbcHelper.update("update nguoidung set ten=?,ngsinh=?,gioitinh=?,sdt=?,email=?,diachi = ?,luong=?,vaitro=?,trangthai=? where idnguoidung=?", e.getTennv(),e.getNgaysinh(),e.getGioitinh(),e.getSdt(),e.getEmail()
                ,e.getDiachi(),e.getLuong(),e.getVaitro(),e.getTt(),e.getIdnv());
    }

    @Override
    public void delete(Integer k) {
        jdbcHelper.update("delete nguoidung where idnguoidung = ?",k);
    }

    @Override
    public List<NhanVien> selectAll() {
 return this.selectBySql("select * from nguoidung");
    }

    @Override
    public NhanVien selectById(Integer k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> listA = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                NhanVien nv= new NhanVien();
                nv.setIdnv(rs.getInt(1));                
                nv.setTennv(rs.getString(2));
                nv.setNgaysinh(rs.getString(3));
                nv.setGioitinh(rs.getInt(4));
                nv.setSdt(rs.getString(5)); 
                nv.setEmail(rs.getString(6));
                nv.setDiachi(rs.getString(7));
                nv.setLuong(rs.getFloat("luong"));       
                nv.setVaitro(rs.getInt(9));
                nv.setTt(rs.getInt(10));
                
                listA.add(nv);
            }
            rs.getStatement().getConnection().close();
            return listA;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
