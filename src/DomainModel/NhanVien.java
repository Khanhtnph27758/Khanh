/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author pqd15
 */
public class NhanVien {
    private String tennv,ngaysinh,email,diachi,sdt;
    private int idnv,tt,gioitinh,vaitro;
    private float luong;

    public NhanVien() {
    }

    public NhanVien(String tennv, String ngaysinh, String email, String diachi, String sdt, int idnv, int tt, int gioitinh, int vaitro, float luong) {
        this.tennv = tennv;
        this.ngaysinh = ngaysinh;
        this.email = email;
        this.diachi = diachi;
        this.sdt = sdt;
        this.idnv = idnv;
        this.tt = tt;
        this.gioitinh = gioitinh;
        this.vaitro = vaitro;
        this.luong = luong;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getIdnv() {
        return idnv;
    }

    public void setIdnv(int idnv) {
        this.idnv = idnv;
    }

    public int getTt() {
        return tt;
    }

    public void setTt(int tt) {
        this.tt = tt;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public int getVaitro() {
        return vaitro;
    }

    public void setVaitro(int vaitro) {
        this.vaitro = vaitro;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

   

   
    
}
