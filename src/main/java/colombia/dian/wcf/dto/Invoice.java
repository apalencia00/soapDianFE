/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colombia.dian.wcf.dto;

import colombia.dian.wcf.dto.InvoicePeriod.InvoicePeriod;
import colombia.dian.wcf.dto.InvoiceControl.InvoiceControl;
import colombia.dian.wcf.dto.AuthorizationProvider.AuthorizationProvider;
import colombia.dian.wcf.dto.SoftwareProviders.SoftwareProvider;
import colombia.dian.wcf.dto.InvoiceSource.InvoiceSource;
import colombia.dian.wcf.dto.headers.QRCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
public class Invoice {
    
private InvoiceControl InvoiceControl;
private InvoiceSource InvoiceSource;
private SoftwareProvider SoftwareProvider;
private String SoftwareSecurityCode;
private AuthorizationProvider AuthorizationProvider;  
 private String UBLVersionID;
 private String CustomizationID;
 private String ProfileID;
 private String ProfileExecutionID;
 private String ID;
 private String UUID;
 private String IssueDate;
 private String IssueTime;
 private String InvoiceTypeCode;
 private String Note;
 private String NumeroFactura;
 private Integer NitFacturador;
 private Integer NitAdquiriente;
 private String FechaFactura;
 private BigDecimal ValorTotalFactura;
 private String CUFE;
 private String URL;
 private String DocumentCurrencyCode;
 private String LineCountNumeric;
 private InvoicePeriod InvoicePeriod;
 private ArrayList < Object > BillingReference;
 private AccountingSupplierParty AccountingSupplierParty;
 private AccountingCustomerParty AccountingCustomerParty;
 private TaxRepresentativeParty TaxRepresentativeParty;
 private Delivery Delivery;
 private DeliveryTerms DeliveryTerms;
 private PaymentMeans PaymentMeans;
 private PrepaidPayment PrepaidPayment;
 private List   <TaxTotal> TaxTotal;
 private LegalMonetaryTotal LegalMonetaryTotal;
 private List <InvoiceLine> InvoiceLine;


    
}


