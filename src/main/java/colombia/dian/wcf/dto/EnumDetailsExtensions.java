/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colombia.dian.wcf.dto;

/**
 *
 * @author USUARIO
 */
 public enum EnumDetailsExtensions {
    
        InvoiceControl("sts:InvoiceControl"),
        InvoiceSource("sts:InvoiceSource"),
        InvoiceSofttwareProvider("sts:SoftwareProvider");
        
        String valorExtension;

    private EnumDetailsExtensions(String valorExtension) {
        this.valorExtension = valorExtension;
    }
        
        

    public String getValorExtension() {
        return valorExtension;
    }

    public void setValorExtension(String valorExtension) {
        this.valorExtension = valorExtension;
    }
        
        
    
}
