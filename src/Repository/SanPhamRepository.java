/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Jdbc.DBContext;
import DomainModel.SanPham;
import java.util.ArrayList;
import java.sql.*;

public class SanPhamRepository {

    private DBContext connection;

    public ArrayList<DomainModel.SanPham> getList() {
        ArrayList<DomainModel.SanPham> lstSanPh = new ArrayList<>();
        String sql = "select SanPham.idSp,idNhaCC,idLoaiSp,tenSp,moTa,trangThai from SanPham";
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setIdSp(rs.getInt(1));
                sp.setIdNhaCC(rs.getInt(2));
                sp.setIdLoaiSp(rs.getInt(3));
                sp.setTenSp(rs.getString(4));
                sp.setMoTa(rs.getString(5));
                sp.setTranngThai(rs.getString(6));             
                lstSanPh.add(sp);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return lstSanPh;
    }
    public static void main(String[] args) {
        ArrayList<SanPham> lsSP = new SanPhamRepository().getList();
        System.out.println(lsSP.toString());
    }
}

