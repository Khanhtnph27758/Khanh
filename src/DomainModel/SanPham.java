/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author DELL
 */
public class SanPham {
    private int IdSp;
    private int IdNhaCC;
    private int IdLoaiSp;
    private String tenSp;
    private String moTa;
    private String tranngThai;

    public SanPham() {
    }

    public SanPham(int IdSp, int IdNhaCC, int IdLoaiSp, String tenSp, String moTa, String tranngThai) {
        this.IdSp = IdSp;
        this.IdNhaCC = IdNhaCC;
        this.IdLoaiSp = IdLoaiSp;
        this.tenSp = tenSp;
        this.moTa = moTa;
        this.tranngThai = tranngThai;
    }

    public int getIdSp() {
        return IdSp;
    }

    public void setIdSp(int IdSp) {
        this.IdSp = IdSp;
    }

    public int getIdNhaCC() {
        return IdNhaCC;
    }

    public void setIdNhaCC(int IdNhaCC) {
        this.IdNhaCC = IdNhaCC;
    }

    public int getIdLoaiSp() {
        return IdLoaiSp;
    }

    public void setIdLoaiSp(int IdLoaiSp) {
        this.IdLoaiSp = IdLoaiSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTranngThai() {
        return tranngThai;
    }

    public void setTranngThai(String tranngThai) {
        this.tranngThai = tranngThai;
    }

    @Override
    public String toString() {
        return "SanPham{" + "IdSp=" + IdSp + ", IdNhaCC=" + IdNhaCC + ", IdLoaiSp=" + IdLoaiSp + ", tenSp=" + tenSp + ", moTa=" + moTa + ", tranngThai=" + tranngThai + '}';
    }
    
}
