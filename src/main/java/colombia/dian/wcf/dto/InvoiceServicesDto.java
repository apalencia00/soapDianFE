/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colombia.dian.wcf.dto;

import colombia.dian.wcf.dto.AuthorizationProvider.AuthorizationProvider;
import colombia.dian.wcf.dto.BillingReference.BillingReference;
import colombia.dian.wcf.dto.InvoiceControl.InvoiceControl;
import colombia.dian.wcf.dto.InvoicePeriod.InvoicePeriod;
import colombia.dian.wcf.dto.InvoiceSource.InvoiceSource;
import colombia.dian.wcf.dto.SoftwareProviders.SoftwareProvider;
import colombia.dian.wcf.dto.headers.QRCode;
import java.time.LocalDate;
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

public class InvoiceServicesDto {
    
    
private InvoiceControl invoiceControl;
private InvoiceSource invoiceSource;
private SoftwareProvider softwareProvider;
private AuthorizationProvider authorizationProvider;
private QRCode qRCode;
private String SoftwareSecurityCode;
    
private String UBLVersionID;
private String CustomizationID;
private String ProfileID;
private Integer ProfileExecutionID;
private String ID;
private String UUID;
private String IssueDate;
private String IssueTime;
private String InvoiceTypeCode;
private String Note;
private String DocumentCurrencyCode;
private Integer LineCountNumeric;
private InvoicePeriod invoicePeriod;
private OrderReference orderReference;
private List<BillingReference> billingReference;
private String DespatchDocumentReference;
private String ReceiptDocumentReference;
private AccountingSupplierParty accountingSupplierParty;
private AccountingCustomerParty accountingCustomerParty;
private TaxRepresentativeParty taxRepresentativeParty;
private Delivery delivery;
private DeliveryTerms deliveryTerms;
private PaymentMeans paymentMeans;
private PaymentExchangeRate paymentExchangeRate;
private List<TaxTotal> taxTotal;
private LegalMonetaryTotal legalMonetaryTotal;
private List<InvoiceLine> invoiceLine;





    
}
