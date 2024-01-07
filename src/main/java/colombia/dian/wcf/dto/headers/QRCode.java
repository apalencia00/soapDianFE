/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colombia.dian.wcf.dto.headers;

import java.sql.Date;

/**
 *
 * @author USUARIO
 */
public class QRCode {
    
    private String QRCODE;

    public QRCode(String QRCODE) {
        this.QRCODE = QRCODE;
    }

    public String getQRCODE() {
        return QRCODE;
    }

    public void setQRCODE(String QRCODE) {
        this.QRCODE = QRCODE;
    }
    
    private String generarQR(String nroFactura, Long nitFacturador, Long nitAdquiriente, Date fechaFactura){
        
        return QRCODE.concat("");
    }
    
}
