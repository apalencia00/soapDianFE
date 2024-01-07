/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colombia.dian.wcf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 *
 * @author USUARIO
 */
@Builder
@Data
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class InvoiceLine {
    
    private Integer ID;
    private String Note;
    private Double InvoicedQuantity;
    private Double LineExtensionAmount;
    private Boolean FreeOfChargeIndicator;
    private DeliveryLocation  DeliveryLocation;
    private AllowanceCharge AllowanceCharge;
    private TaxTotal TaxTotal;
    private Item Item;
    private Price Price;
    
    
}
