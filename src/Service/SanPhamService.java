/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.SanPham;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface SanPhamService {

    public ArrayList<SanPham> getList();

    public Boolean them(SanPham sp);

    public Boolean xoa(int idSp);

    public Boolean sua(int idSp, SanPham sp);
}
