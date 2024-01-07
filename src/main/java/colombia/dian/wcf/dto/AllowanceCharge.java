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
class AllowanceCharge {
    
    private Integer ID;
    private Boolean ChargeIndicator;
    private String AllowanceChargeReason;
    private Double MultiplierFactorNumeric;
    private Double Amount;
    private Double BaseAmount;

    
    
}
