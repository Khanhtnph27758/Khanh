/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

/**
 *
 * @author Admin
 */
public class LoaiSP {
    private int idLoaiSp;
    private String tenLoaiSP;

    public LoaiSP() {
    }

    public LoaiSP(int idLoaiSp, String tenLoaiSP) {
        this.idLoaiSp = idLoaiSp;
        this.tenLoaiSP = tenLoaiSP;
    }

    public int getIdLoaiSp() {
        return idLoaiSp;
    }

    public void setIdLoaiSp(int idLoaiSp) {
        this.idLoaiSp = idLoaiSp;
    }

    public String getTenLoaiSP() {
        return tenLoaiSP;
    }

    public void setTenLoaiSP(String tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }
    
    
}
