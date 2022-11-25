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
public class ChatLieu {
    private int idChatLieu;
    private String tenChatLieu;

    public ChatLieu() {
    }

    public ChatLieu(int idChatLieu, String tenChatLieu) {
        this.idChatLieu = idChatLieu;
        this.tenChatLieu = tenChatLieu;
    }

    public int getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(int idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }
    
    
}
