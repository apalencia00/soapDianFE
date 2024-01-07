package com.dian.ws.soapdianfe.resources;

import colombia.dian.wcf.SendBillSync;
import colombia.dian.wcf.WcfDianCustomerServicesSkeleton;
import colombia.dian.wcf.dto.AccountingCustomerParty;
import colombia.dian.wcf.dto.AccountingSupplierParty;
import colombia.dian.wcf.dto.AddressLine;
import colombia.dian.wcf.dto.AuthorizationProvider.AuthorizationProvider;
import colombia.dian.wcf.dto.BillingReference.BillingReference;
import colombia.dian.wcf.dto.BillingReference.InvoiceDocumentReference;
import colombia.dian.wcf.dto.Contact;
import colombia.dian.wcf.dto.CorporateRegistrationScheme;
import colombia.dian.wcf.dto.Country;
import colombia.dian.wcf.dto.Delivery;
import colombia.dian.wcf.dto.DeliveryAddress;
import colombia.dian.wcf.dto.DeliveryParty;
import colombia.dian.wcf.dto.DeliveryTerms;
import colombia.dian.wcf.dto.Invoice;
import colombia.dian.wcf.dto.InvoiceControl.AuthorizationPeriod;
import colombia.dian.wcf.dto.InvoiceControl.AuthorizedInvoices;
import colombia.dian.wcf.dto.InvoiceControl.InvoiceControl;
import colombia.dian.wcf.dto.InvoiceLine;
import colombia.dian.wcf.dto.InvoicePeriod.InvoicePeriod;
import colombia.dian.wcf.dto.InvoiceServicesDto;
import colombia.dian.wcf.dto.LegalMonetaryTotal;
import colombia.dian.wcf.dto.OrderReference;
import colombia.dian.wcf.dto.Party;
import colombia.dian.wcf.dto.PartyLegalEntity;
import colombia.dian.wcf.dto.PartyName;
import colombia.dian.wcf.dto.PartyTaxScheme;
import colombia.dian.wcf.dto.PaymentExchangeRate;
import colombia.dian.wcf.dto.PaymentMeans;
import colombia.dian.wcf.dto.PhysicalLocation;
import colombia.dian.wcf.dto.SoftwareProviders.SoftwareProvider;
import colombia.dian.wcf.dto.TaxRepresentativeParty;
import colombia.dian.wcf.dto.TaxTotal;
import colombia.dian.wcf.dto.headers.QRCode;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.Arrays;
import javax.activation.DataHandler;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xades4j.algorithms.Algorithm;
import xades4j.algorithms.EnvelopedSignatureTransform;
import xades4j.production.DataObjectReference;
import xades4j.production.SignedDataObjects;
import xades4j.production.XadesEpesSigningProfile;
import xades4j.production.XadesSigner;
import xades4j.production.XadesSigningProfile;
import xades4j.properties.DataObjectDesc;
import xades4j.properties.DataObjectFormatProperty;
import xades4j.properties.ObjectIdentifier;
import xades4j.properties.SignaturePolicyBase;
import xades4j.properties.SignaturePolicyIdentifierProperty;
import xades4j.providers.KeyingDataProvider;
import xades4j.providers.SignaturePolicyInfoProvider;
import xades4j.providers.impl.FileSystemKeyStoreKeyingDataProvider;
import xades4j.providers.impl.KeyStoreKeyingDataProvider.SigningCertificateSelector;
import colombia.dian.wcf.dto.InvoiceSource.*;
import colombia.dian.wcf.dto.TaxCategory;
import colombia.dian.wcf.dto.TaxCategory;
import colombia.dian.wcf.dto.TaxScheme;
import colombia.dian.wcf.dto.TaxSubtotal;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.json.JSONArray;
import org.json.JSONObject;
import xades4j.utils.XadesProfileResolutionException;

/**
 *
 * @author
 */
@Path("/facturacion")
public class InvoiceProducts {

    private static final String nombreCertficado = "C:\\Certs\\PRONTASALUD S.A.S..p12";
    private static final String passCertficado = "BTLfNQpgKCVvmuLX";
    @Context
    private UriInfo context;

    public InvoiceProducts() {

    }

    @POST
    @Path("/productos")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void enviarFacturaFE(String jsonString) throws Exception {

        Logger logger = LoggerFactory.getLogger(InvoiceProducts.class);
        WcfDianCustomerServicesSkeleton wfcCustomerServicesSkeleton = new WcfDianCustomerServicesSkeleton();
        System.out.println("========================================");
        logger.info("========================================");
        System.out.println(jsonString);
        logger.info(jsonString);
        logger.info("========================================");
        System.out.println("========================================");

        ArrayList<TaxTotal> taxTotal = new ArrayList<>();
        ArrayList<TaxSubtotal> taxSubtotals = new ArrayList<>();
        ArrayList<BillingReference> billingReferences = new ArrayList<>();
        ArrayList<InvoiceLine> invoiceLines = new ArrayList<>();

        try {

            JSONObject jsonObject = new JSONObject(jsonString);

            // DECODE OBJECT
            String NroFactura = jsonObject.getString("NumeroFactura");
            Integer NitFacturador = jsonObject.getInt("NitFacturador");
            Integer NitAdquiriente = jsonObject.getInt("NitAdquiriente");
            String FechaFactura = jsonObject.getJSONObject(jsonObject.getString("FechaFactura")).toString();
            BigDecimal ValorTotalFactura = jsonObject.getBigDecimal("ValorTotalFactura");
            String CUFE = jsonObject.getString("CUFE");

            String URL = "https://catalogo-vpfe-hab.dian.gov.co/Document/FindDocument?documentKey=9a6f53fdd2c1dc2bddb28fc4f3e4321adb744db019739aa1acec82b41d392d54026b6acaeca997a7cffa59294a911199&amp;partitionKey=co|06|9a&amp;emissionDate=20190621";

            // Access the "TaxTotal" array
            JSONArray taxTotalArray = jsonObject.getJSONArray("TaxTotal");

            // Access values within the array
            for (int i = 0; i < taxTotalArray.length(); i++) {
                JSONObject taxTotalObject = taxTotalArray.getJSONObject(i);
                String taxAmount = taxTotalObject.getString("TaxAmount");
                System.out.println("TaxAmount: " + taxAmount);

                JSONArray taxSubtotalArray = taxTotalObject.getJSONArray("TaxSubtotal");

                // Access values within the "TaxSubtotal" array
                for (int j = 0; j < taxSubtotalArray.length(); j++) {
                    JSONObject taxSubtotalObject = taxSubtotalArray.getJSONObject(j);
                    String taxableAmount = taxSubtotalObject.getString("TaxableAmount");
                    System.out.println("TaxableAmount: " + taxableAmount);

                    // Access values within the "TaxCategory" object
                    JSONObject taxCategoryObject = taxSubtotalObject.getJSONObject("TaxCategory");
                    String percent = taxCategoryObject.getString("Percent");
                    System.out.println("Percent: " + percent);

                    JSONObject taxSchemeObject = taxCategoryObject.getJSONObject("TaxScheme");
                    int id = taxSchemeObject.getInt("ID");

                    String name = taxSchemeObject.getString("Name");
                    System.out.println("ID: " + id + ", Name: " + name);

                    taxSubtotals.add(j, TaxSubtotal
                            .builder()
                            .TaxAmount(Double.parseDouble(taxAmount))
                            .TaxableAmount(Double.parseDouble(taxableAmount))
                            .TaxCategory(TaxCategory
                                    .builder()
                                    .Percent(Double.parseDouble(percent))
                                    .TaxScheme(TaxScheme
                                            .builder()
                                            .ID(id)
                                            .Name(name)
                                            .build())
                                    .build())
                            .build());

                    taxTotal.add(TaxTotal
                            .builder()
                            .TaxableAmount(Double.parseDouble(taxAmount))
                            .TaxSubtotal(taxSubtotals)
                            .build());

                }

            }

            // Access values within the "InvoiceControl" object
            JSONObject invoiceControlObject = jsonObject.getJSONObject("InvoiceControl");
            String invoiceAuthorization = invoiceControlObject.getString("InvoiceAuthorization");
            System.out.println("InvoiceAuthorization: " + invoiceAuthorization);

            // Access values within the "AuthorizationPeriod" object
            JSONObject authorizationPeriodObject = invoiceControlObject.getJSONObject("AuthorizationPeriod");
            String startDate = authorizationPeriodObject.getString("StartDate");
            String endDate = authorizationPeriodObject.getString("EndDate");
            System.out.println("StartDate: " + startDate);
            System.out.println("EndDate: " + endDate);

            // Access values within the "AuthorizedInvoices" object
            JSONObject authorizedInvoicesObject = invoiceControlObject.getJSONObject("AuthorizedInvoices");
            String prefix = authorizedInvoicesObject.getString("Prefix");
            String from = authorizedInvoicesObject.getString("From");
            String to = authorizedInvoicesObject.getString("To");
            System.out.println("Prefix: " + prefix);
            System.out.println("From: " + from);
            System.out.println("To: " + to);

            // Access values withing the "InvoiceSource"
            JSONObject invoiceSourceObject = invoiceControlObject.getJSONObject("InvoiceSource");
            String IdentificationCode = invoiceSourceObject.getString("IdentificationCode");
            System.out.println("IdentificationCode: " + IdentificationCode);

            // Access values withing the "SoftwareProvider"
            JSONObject softwareProviderObject = invoiceControlObject.getJSONObject("SoftwareProvider");
            String ProviderID = softwareProviderObject.getString("ProviderID");
            String SoftwareID = softwareProviderObject.getString("SoftwareID");
            System.out.println("ProviderID: " + ProviderID);
            System.out.println("SoftwareID: " + SoftwareID);

            // Access values withing the "SoftwareSecurityCode"
            String SoftwareSecurityCode = invoiceControlObject.getString("SoftwareSecurityCode");
            System.out.println("SoftwareSecurityCode: " + SoftwareSecurityCode);

            // Access values withing the "AuthorizationProvider"
            JSONObject AuthorizationProviderObject = invoiceControlObject.getJSONObject("AuthorizationProvider");
            String AuthorizationProviderID = AuthorizationProviderObject.getString("AuthorizationProviderID");

            // Access values withing the "UBLVersionID"
            String UBLVersionIDValue = invoiceControlObject.getString("UBLVersionID");
            System.out.println("UBLVersionIDValue: " + UBLVersionIDValue);

            // Access values withing the "CustomizationID"
            String CustomizationIDValue = invoiceControlObject.getString("CustomizationID");
            System.out.println("CustomizationIDValue: " + CustomizationIDValue);

            // Access values withing the "CustomizationID"
            String IDValue = invoiceControlObject.getString("ID");
            System.out.println("IDValue: " + IDValue);

            // Access values withing the "UUID"
            String UUIDValue = invoiceControlObject.getString("UUID");
            System.out.println("UUID: " + UUIDValue);

            // Access values withing the "IssueDate"
            String IssueDateValue = invoiceControlObject.getString("IssueDate");
            System.out.println("IssueDate: " + IssueDateValue);

            // Access values withing the "IssueTime"
            String IssueTimeValue = invoiceControlObject.getString("IssueTime");
            System.out.println("IssueTime: " + IssueTimeValue);

            // Access values withing the "Note"
            String NoteValue = invoiceControlObject.getString("Note");
            System.out.println("Note: " + NoteValue);

            // Access values withing the "InvoicePeriod"
            JSONObject InvoicePeriodObject = invoiceControlObject.getJSONObject("InvoicePeriod");
            String StartDate = InvoicePeriodObject.getString("StartDate");
            String EndDate = InvoicePeriodObject.getString("EndDate");
            System.out.println("StartDate: " + StartDate);
            System.out.println("EndDate: " + EndDate);

            // Access the "BillingReference" array
            JSONArray BillingReferenceArray = jsonObject.getJSONArray("BillingReference");

            // Access values within the array
            for (int p = 0; p < BillingReferenceArray.length(); p++) {
                JSONObject InvoiceDocumentReferenceObject = BillingReferenceArray.getJSONObject(p);
                String ID = InvoiceDocumentReferenceObject.getString("ID");
                System.out.println("ID: " + ID);
                String UUID = InvoiceDocumentReferenceObject.getString("UUID");
                System.out.println("UUID: " + UUID);
                String IssueDate = InvoiceDocumentReferenceObject.getString("IssueDate");
                System.out.println("IssueDate: " + IssueDate);
                String DocumentDescription = InvoiceDocumentReferenceObject.getString("DocumentDescription");
                System.out.println("DocumentDescription: " + DocumentDescription);

                // Billing Reference
                billingReferences.add(BillingReference
                        .builder()
                        .invoiceDocumentReference(InvoiceDocumentReference
                                .builder()
                                .ID(ID)
                                .DocumentDescription(DocumentDescription)
                                .IssueDate(IssueDate)
                                .UUID_CUFE(UUIDValue)
                                .build())
                        .build());
            }
            
            /* INIT AccountingSupplierParty */

            // Access values withing the "AccountingSupplierParty"
            JSONObject accountingSupplierPartyObject = invoiceControlObject.getJSONObject("AccountingSupplierParty");
            String accountingSupplierPartyAdditionalAccountID = accountingSupplierPartyObject.getString("AdditionalAccountID");
            JSONObject accountingSupplierPartyPartyObject = accountingSupplierPartyObject.getJSONObject("Party");
            JSONArray accountingSupplierPartyPartyPartyNameArray = accountingSupplierPartyObject.getJSONArray("PartyName");
            List<String> accountingSupplierPartyPartyPartyNameArrayList = (List) accountingSupplierPartyPartyPartyNameArray;
            
            
            JSONObject accountingSupplierPartyPartyPhysicalLocationObject = accountingSupplierPartyObject.getJSONObject("PhysicalLocation");
            JSONObject accountingSupplierPartyPartyAddressObject = accountingSupplierPartyPartyPhysicalLocationObject.getJSONObject("Address");

            String accountingSupplierPartyPartyIDAddress = accountingSupplierPartyPartyAddressObject.getString("ID");
            String accountingSupplierPartyPartyCityName = accountingSupplierPartyPartyAddressObject.getString("CityName");
            String accountingSupplierPartyPartyCountrySubentity = accountingSupplierPartyPartyAddressObject.getString("CountrySubentity");
            String accountingSupplierPartyPartyCountrySubentityCode = accountingSupplierPartyPartyAddressObject.getString("CountrySubentityCode");
            JSONObject accountingSupplierPartyPartyAddressLine = accountingSupplierPartyPartyAddressObject.getJSONObject("AddressLine");
            String accountingSupplierPartyPartyLine = accountingSupplierPartyPartyAddressLine.getString("Line");
            JSONObject accountingSupplierPartyPartyCountry = accountingSupplierPartyPartyAddressObject.getJSONObject("Country");
            String accountingSupplierPartyPartyIdentificationCodeCountry = accountingSupplierPartyPartyCountry.getString("IdentificationCode");
            String accountingSupplierPartyPartyName = accountingSupplierPartyPartyCountry.getString("Name");

            // Access values within the "PartyTaxScheme" object
            JSONObject accountingSupplierPartyPartyTaxSchemeObject = jsonObject.getJSONObject("PartyTaxScheme");

            // Access values within the "RegistrationAddress" object
            JSONObject accountingSupplierPartyRegistrationAddressObject = accountingSupplierPartyPartyTaxSchemeObject.getJSONObject("RegistrationAddress");
            String accountingSupplierPartyId = accountingSupplierPartyRegistrationAddressObject.getString("ID");
            String accountingSupplierPartyCityName = accountingSupplierPartyRegistrationAddressObject.getString("CityName");
            String accountingSupplierPartyCountrySubentity = accountingSupplierPartyRegistrationAddressObject.getString("CountrySubentity");
            int accountingSupplierPartyCountrySubentityCode = accountingSupplierPartyRegistrationAddressObject.getInt("CountrySubentityCode");

            // Access values within the "AddressLine" object
            JSONObject accountingSupplierPartyAddressLineObject = accountingSupplierPartyRegistrationAddressObject.getJSONObject("AddressLine");
            String accountingSupplierPartyAddressLine = accountingSupplierPartyAddressLineObject.getString("Line");

            // Access values within the "Country" object
            JSONObject accountingSupplierPartyCountryObject = accountingSupplierPartyRegistrationAddressObject.getJSONObject("Country");
            String accountingSupplierPartyCountryIdentificationCode = accountingSupplierPartyCountryObject.getString("identificationCode");
            String accountingSupplierPartyCountryName = accountingSupplierPartyCountryObject.getString("name");

            // Access values within the "TaxScheme" object
            JSONObject accountingSupplierPartyTaxSchemeObject = accountingSupplierPartyPartyTaxSchemeObject.getJSONObject("TaxScheme");
            String accountingSupplierTaxSchemeId = accountingSupplierPartyTaxSchemeObject.getString("ID");
            String accountingSupplierTaxSchemeName = accountingSupplierPartyTaxSchemeObject.getString("Name");

            // Access values within the "PartyLegalEntity" object
            JSONObject partyLegalEntityObject = accountingSupplierPartyPartyTaxSchemeObject.getJSONObject("PartyLegalEntity");
            String accountingSupplierLegalEntityRegistrationName = partyLegalEntityObject.getString("RegistrationName");
            String accountingSupplierLegalEntityCompanyId = partyLegalEntityObject.getString("CompanyID");

            // Access values within the "CorporateRegistrationScheme" object
            JSONObject accountingSupplierCorporateRegistrationSchemeObject = partyLegalEntityObject.getJSONObject("CorporateRegistrationScheme");
            String accountingSupplierCorporateRegistrationSchemeId = accountingSupplierCorporateRegistrationSchemeObject.getString("ID");
            String accountingSupplierCorporateRegistrationSchemeName = accountingSupplierCorporateRegistrationSchemeObject.getString("Name");

            // Access values within the "Contact" object
            JSONObject accountingSupplierContactObject = accountingSupplierPartyPartyTaxSchemeObject.getJSONObject("Contact");
            String accountingSupplierContactName = accountingSupplierContactObject.getString("Name");
            String accountingSupplierContactTelephone = accountingSupplierContactObject.getString("Telephone");
            String accountingSupplierContactElectronicMail = accountingSupplierContactObject.getString("ElectronicMail");
            String accountingSupplierContactNote = accountingSupplierContactObject.getString("Note");
            
            /* END AccountingSupplierParty */
            
            
            /* INIT AccountingCustomerParty */
            
        // Access values within the "AccountingCustomerParty" object
        JSONObject accountingCustomerPartyObject = jsonObject.getJSONObject("AccountingCustomerParty");

        // Access values within the "Party" object
        JSONObject accountingCustomerPartyPartyObject = accountingCustomerPartyObject.getJSONObject("Party");

        // Access values within the "PartyName" array
        JSONObject accountingCustomerPartyNameObject = accountingCustomerPartyPartyObject.getJSONArray("PartyName").getJSONObject(0);
        String accountingCustomerPartyName = accountingCustomerPartyNameObject.getString("Name");

        // Access values within the "PhysicalLocation" object
        JSONObject accountingCustomerPartyPhysicalLocationObject = accountingCustomerPartyNameObject.getJSONObject("PhysicalLocation");
        JSONObject accountingCustomerPartyPhysicalLocationObjectAddressObject = accountingCustomerPartyPhysicalLocationObject.getJSONObject("Address");
        String accountingCustomerPartyAddressId = accountingCustomerPartyPhysicalLocationObjectAddressObject.getString("ID");
        String accountingCustomerPartyCityName = accountingCustomerPartyPhysicalLocationObjectAddressObject.getString("CityName");
        String accountingCustomerPartyCountrySubentity = accountingCustomerPartyPhysicalLocationObjectAddressObject.getString("CountrySubentity");
        int accountingCustomerPartyCountrySubentityCode = accountingCustomerPartyPhysicalLocationObjectAddressObject.getInt("CountrySubentityCode");
        JSONObject accountingCustomerPartyAddressLineObject = accountingCustomerPartyPhysicalLocationObjectAddressObject.getJSONObject("AddressLine");
        String accountingCustomerPartyAddressLine = accountingCustomerPartyAddressLineObject.getString("Line");
        JSONObject accountingCustomerPartyAddressLineCountryObject = accountingCustomerPartyPhysicalLocationObjectAddressObject.getJSONObject("Country");
        String accountingCustomerPartyCountryIdentificationCode = accountingCustomerPartyAddressLineCountryObject.getString("IdentificationCode");
        String accountingCustomerPartyCountryName = accountingCustomerPartyAddressLineCountryObject.getString("Name");

        // Access values within the "PartyTaxScheme" object
        JSONObject accountingCustomerPartyPartyTaxSchemeObject = accountingCustomerPartyPartyObject.getJSONObject("PartyTaxScheme");
        String accountingCustomerPartyPartyTaxSchemeRegistrationName = accountingCustomerPartyPartyTaxSchemeObject.getString("RegistrationName");
        String accountingCustomerPartyPartyTaxSchemeCompanyID = accountingCustomerPartyPartyTaxSchemeObject.getString("CompanyID");
        String accountingCustomerPartyPartyTaxSchemeTaxLevelCode = accountingCustomerPartyPartyTaxSchemeObject.getString("TaxLevelCode");

        // Access values within the "RegistrationAddress" object
        JSONObject accountingCustomerPartyPartyRegistrationAddressObject = accountingCustomerPartyPartyTaxSchemeObject.getJSONObject("RegistrationAddress");
        String accountingCustomerPartyPartyRegistrationAddressId = accountingCustomerPartyPartyRegistrationAddressObject.getString("ID");
        String accountingCustomerPartyPartyRegistrationAddressCityName = accountingCustomerPartyPartyRegistrationAddressObject.getString("CityName");
        String accountingCustomerPartyPartyRegistrationAddressCountrySubentity = accountingCustomerPartyPartyRegistrationAddressObject.getString("CountrySubentity");
        int accountingCustomerPartyPartyRegistrationAddressCountrySubentityCode = accountingCustomerPartyPartyRegistrationAddressObject.getInt("CountrySubentityCode");
        JSONObject accountingCustomerPartyRegistrationAddressLineObject = accountingCustomerPartyPartyRegistrationAddressObject.getJSONObject("AddressLine");
        String accountingCustomerPartyRegistrationAddressLine = accountingCustomerPartyRegistrationAddressLineObject.getString("Line");
        JSONObject accountingCustomerPartyRegistrationCountryObject = accountingCustomerPartyRegistrationAddressLineObject.getJSONObject("Country");
        String accountingCustomerPartyRegistrationCountryIdentificationCode = accountingCustomerPartyRegistrationCountryObject.getString("IdentificationCode");
        String accountingCustomerPartyRegistrationCountryName = accountingCustomerPartyRegistrationAddressLineObject.getString("Name");

        // Access values within the "TaxScheme" object
        JSONObject accountingCustomerPartyTaxSchemeObject = accountingCustomerPartyPartyTaxSchemeObject.getJSONObject("TaxScheme");
        String accountingCustomerPartyTaxSchemeId = accountingCustomerPartyTaxSchemeObject.getString("ID");
        String accountingCustomerPartyTaxSchemeName = accountingCustomerPartyTaxSchemeObject.getString("Name");

        // Access values within the "PartyLegalEntity" object
        JSONObject accountingCustomerPartyLegalEntityObject = accountingCustomerPartyPartyObject.getJSONObject("PartyLegalEntity");
        String accountingCustomerLegalEntityRegistrationName = accountingCustomerPartyLegalEntityObject.getString("RegistrationName");
        String accountingCustomerLegalEntityCompanyId = accountingCustomerPartyLegalEntityObject.getString("CompanyID");

        // Access values within the "CorporateRegistrationScheme" object
        JSONObject accountingCustomerPartyCorporateRegistrationSchemeObject = accountingCustomerPartyLegalEntityObject.getJSONObject("CorporateRegistrationScheme");
        String accountingCustomerPartyCorporateRegistrationSchemeName = accountingCustomerPartyCorporateRegistrationSchemeObject.getString("Name");

        // Access values within the "Contact" object
        JSONObject accountingCustomerContactObject = accountingCustomerPartyPartyObject.getJSONObject("Contact");
        String accountingCustomerContactName = accountingCustomerContactObject.getString("Name");
        String accountingCustomerContactTelephone = accountingCustomerContactObject.getString("Telephone");
        String accountingCustomerContactElectronicMail = accountingCustomerContactObject.getString("ElectronicMail");

            
       /*   END AccountingCustomerParty  */
            

            //UUID (Consecutivo factura electronica)
            InvoiceServicesDto invoiceServicesDto = InvoiceServicesDto.builder()
                    .invoiceControl(InvoiceControl
                            .builder()
                            .InvoiceAuthorization(Long.parseLong(String.valueOf(invoiceAuthorization)))
                            .AuthorizationPeriod(AuthorizationPeriod
                                    .builder()
                                    .StartDate(startDate)
                                    .EndDate(endDate)
                                    .build())
                            .AuthorizedInvoices(AuthorizedInvoices
                                    .builder()
                                    .From(Long.parseLong(from))
                                    .To(Long.parseLong(to))
                                    .build())
                            .build())
                    .invoiceSource(InvoiceSource
                            .builder()
                            .IdentificationCode(IdentificationCode)
                            .build())
                    .softwareProvider(SoftwareProvider.builder()
                            .ProviderID(ProviderID)
                            .SoftwareID(SoftwareID)
                            .build())
                    .SoftwareSecurityCode(SoftwareSecurityCode)
                    .authorizationProvider(AuthorizationProvider
                            .builder()
                            .AuthorizationProviderID(Long.parseLong(AuthorizationProviderID))
                            .build())
                    .qRCode(new QRCode("NroFactura=" + NroFactura + "\n"
                            + "								NitFacturador=" + NitFacturador + "\n"
                            + "								NitAdquiriente=" + NitAdquiriente.toString() + "\n"
                            + "								FechaFactura=" + FechaFactura + "\n"
                            + "								ValorTotalFactura=" + ValorTotalFactura.setScale(3, RoundingMode.FLOOR) + "\n"
                            + "								CUFE=" + CUFE + "\n"
                            + "								URL=" + URL + ""))
                    .UBLVersionID(UBLVersionIDValue)
                    .CustomizationID(CustomizationIDValue)
                    .ProfileID("DIAN 2.1")
                    .ProfileExecutionID(2)
                    .ID(IDValue)
                    .UUID(UUIDValue)
                    .IssueDate(IssueDateValue)
                    .IssueTime(IssueTimeValue)
                    .InvoiceTypeCode("01")
                    .Note(NoteValue)
                    .DocumentCurrencyCode("CO")
                    .LineCountNumeric(2)
                    .invoicePeriod(InvoicePeriod.builder()
                            .StartDate(StartDate)
                            .EndDate(EndDate)
                            .build())
                    .orderReference(OrderReference.builder().ID(CUFE).build())
                    .billingReference(billingReferences)
                    .DespatchDocumentReference("")
                    .ReceiptDocumentReference("")
                    .accountingSupplierParty(AccountingSupplierParty
                            .builder()
                            .AdditionalAccountID(Integer.parseInt(accountingSupplierPartyAdditionalAccountID))
                            .ListaParty(Arrays.asList(Party
                                    .builder()
                                    .partyName(PartyName.builder().Name(accountingSupplierPartyPartyPartyNameArrayList).build())
                                    .contact(Contact
                                            .builder()
                                            .ElectronicMail(accountingSupplierContactElectronicMail)
                                            .Name(requestDataFe.getAccountingSupplierParty().getListaParty().get(0).getContact().getName())
                                            .Note(requestDataFe.getAccountingSupplierParty().getListaParty().get(0).getContact().getNote())
                                            .Telephone(requestDataFe.getAccountingSupplierParty().getListaParty().get(0).getContact().getTelephone())
                                            .build())
                                    .partyLegalEntity(PartyLegalEntity
                                            .builder()
                                            .CompanyID(requestDataFe.getAccountingSupplierParty().getListaParty().get(0).getPartyLegalEntity().getCompanyID())
                                            .RegistrationName(requestDataFe.getAccountingCustomerParty().getListaParty().get(1).getPartyNameRazon())
                                            .corporateRegistrationScheme(CorporateRegistrationScheme.builder()
                                                    .ID(requestDataFe.getAccountingCustomerParty().getListaParty().get(1).getPartyNameRazon())
                                                    .Name(requestDataFe.getAccountingSupplierParty().getListaParty().get(0).getPartyLegalEntity().getCorporateRegistrationScheme().getName())
                                                    .build())
                                            .build())
                                    .partyTaxScheme(PartyTaxScheme.builder().build())
                                    .physicalLocation(PhysicalLocation
                                            .builder()
                                            .ID(String.valueOf(requestDataFe.getAccountingSupplierParty().getAdditionalAccountID()))
                                            .CityName(requestDataFe.getAccountingSupplierParty().getListaParty().get(0).getPhysicalLocation().getCityName())
                                            .CountrySubentity(requestDataFe.getAccountingSupplierParty().getListaParty().get(0).getPhysicalLocation().getCountrySubentity())
                                            .build())
                                    .build()
                            )
                            )
                            .build())
                    .accountingCustomerParty(AccountingCustomerParty
                            .builder()
                            .AdditionalAccountID(Integer.MIN_VALUE)
                            .ListaParty(Arrays.asList(Party.builder()
                                    .PartyNameEstablecimiento(requestDataFe
                                            .getAccountingCustomerParty()
                                            .getListaParty().get(0)
                                            .getPartyNameEstablecimiento())
                                    .PartyNameRazon(requestDataFe
                                            .getAccountingCustomerParty()
                                            .getListaParty().get(0)
                                            .getPartyNameRazon())
                                    .PartyNameUbicacion(requestDataFe
                                            .getAccountingCustomerParty()
                                            .getListaParty().get(0)
                                            .getPartyNameUbicacion())
                                    .contact(Contact.builder()
                                            .ElectronicMail(requestDataFe
                                                    .getAccountingCustomerParty()
                                                    .getListaParty().get(0)
                                                    .getContact()
                                                    .getElectronicMail())
                                            .Name(requestDataFe
                                                    .getAccountingCustomerParty()
                                                    .getListaParty().get(0)
                                                    .getContact()
                                                    .getName())
                                            .Note(requestDataFe
                                                    .getAccountingCustomerParty()
                                                    .getListaParty().get(0)
                                                    .getContact().getNote())
                                            .Telephone(requestDataFe
                                                    .getAccountingCustomerParty()
                                                    .getListaParty().get(0)
                                                    .getContact().getTelephone())
                                            .build())
                                    .partyLegalEntity(PartyLegalEntity.builder()
                                            .CompanyID(requestDataFe
                                                    .getAccountingCustomerParty()
                                                    .getListaParty().get(0)
                                                    .getPartyLegalEntity()
                                                    .getCompanyID())
                                            .RegistrationName(requestDataFe
                                                    .getAccountingCustomerParty()
                                                    .getListaParty().get(0)
                                                    .getPartyLegalEntity()
                                                    .getRegistrationName())
                                            .corporateRegistrationScheme(CorporateRegistrationScheme
                                                    .builder()
                                                    .ID(requestDataFe
                                                            .getAccountingCustomerParty()
                                                            .getListaParty().get(0)
                                                            .getPartyLegalEntity()
                                                            .getCorporateRegistrationScheme()
                                                            .getID())
                                                    .Name(requestDataFe.getAccountingCustomerParty().getListaParty().get(0).getPartyLegalEntity().getCorporateRegistrationScheme().getName())
                                                    .build())
                                            .build())
                                    .partyTaxScheme(PartyTaxScheme
                                            .builder()
                                            .CompanyID(requestDataFe.getAccountingCustomerParty().getListaParty().get(0).getPartyTaxScheme().getCompanyID())
                                            .RegistrationName(requestDataFe.getAccountingCustomerParty().getListaParty().get(0).getPartyTaxScheme().getRegistrationName())
                                            .TaxLevelCode(requestDataFe.getAccountingCustomerParty().getListaParty().get(0).getPartyTaxScheme().getTaxLevelCode())
                                            .build())
                                    .physicalLocation(PhysicalLocation.builder().build())
                                    .build()))
                            .build()
                    )
                    .taxRepresentativeParty(TaxRepresentativeParty
                            .builder()
                            .ID(requestDataFe.getTaxRepresentativeParty().getID())
                            .build())
                    .delivery(Delivery
                            .builder()
                            .DeliveryAddress(DeliveryAddress
                                    .builder()
                                    .CityName(requestDataFe.getDelivery().getDeliveryAddress().getCityName())
                                    .CountrySubentity(requestDataFe.getDelivery().getDeliveryAddress().getCountrySubentity())
                                    .ID(requestDataFe.getDelivery().getDeliveryAddress().getID())
                                    .addressLine(AddressLine.builder()
                                            .Line(requestDataFe.getDelivery().getDeliveryAddress().getAddressLine().getLine())
                                            .build())
                                    .countrySubentityCode(requestDataFe.getDelivery().getDeliveryAddress().getCountrySubentityCode())
                                    .country(Country
                                            .builder()
                                            .IdentificationCode(requestDataFe.getDelivery().getDeliveryAddress().getCountry().getIdentificationCode())
                                            .Name(requestDataFe.getDelivery().getDeliveryAddress().getCountry().getName())
                                            .build())
                                    .build())
                            .DeliveryParty(DeliveryParty
                                    .builder()
                                    .partyName(PartyName
                                            .builder()
                                            .Name(requestDataFe.getDelivery().getDeliveryParty().getPartyName().getName())
                                            .build())
                                    .physicalLocation(PhysicalLocation
                                            .builder()
                                            .CityName(requestDataFe.getDelivery().getDeliveryParty().getPhysicalLocation().getCityName())
                                            .build())
                                    .contact(Contact
                                            .builder()
                                            .ElectronicMail(requestDataFe.getDelivery().getDeliveryParty().getContact().getElectronicMail())
                                            .Name(requestDataFe.getDelivery().getDeliveryParty().getContact().getName())
                                            .Note(requestDataFe.getDelivery().getDeliveryParty().getContact().getNote())
                                            .Telephone(requestDataFe.getDelivery().getDeliveryParty().getContact().getTelephone())
                                            .build())
                                    .partyLegalEntity(PartyLegalEntity
                                            .builder()
                                            .CompanyID(requestDataFe.getDelivery().getDeliveryParty().getPartyLegalEntity().getCompanyID())
                                            .RegistrationName(requestDataFe.getDelivery().getDeliveryParty().getPartyLegalEntity().getRegistrationName())
                                            .corporateRegistrationScheme(CorporateRegistrationScheme
                                                    .builder()
                                                    .ID(requestDataFe.getDelivery().getDeliveryParty().getPartyLegalEntity().getCorporateRegistrationScheme().getID())
                                                    .Name(requestDataFe.getDelivery().getDeliveryParty().getPartyLegalEntity().getCorporateRegistrationScheme().getName())
                                                    .build())
                                            .build())
                                    .partyTaxScheme(PartyTaxScheme
                                            .builder()
                                            .CompanyID(requestDataFe.getDelivery().getDeliveryParty().getPartyTaxScheme().getCompanyID())
                                            .RegistrationName(requestDataFe.getDelivery().getDeliveryParty().getPartyTaxScheme().getRegistrationName())
                                            .TaxLevelCode(requestDataFe.getDelivery().getDeliveryParty().getPartyTaxScheme().getTaxLevelCode())
                                            .build())
                                    .build())
                            .build())
                    .deliveryTerms(DeliveryTerms
                            .builder()
                            .LossRisk(requestDataFe.getDeliveryTerms().getLossRisk())
                            .LossRiskResponsibilityCode(requestDataFe.getDeliveryTerms().getLossRiskResponsibilityCode())
                            .SpecialTerms(requestDataFe.getDeliveryTerms().getSpecialTerms())
                            .build())
                    .paymentMeans(PaymentMeans
                            .builder()
                            .ID(requestDataFe.getPaymentMeans().getID())
                            .PaymentDueDate(requestDataFe.getPaymentMeans().getPaymentDueDate())
                            .PaymentID(requestDataFe.getPaymentMeans().getPaymentID())
                            .PaymentMeansCode(requestDataFe.getPaymentMeans().getPaymentMeansCode())
                            .build())
                    .taxTotal(TaxTotal
                            .builder()
                            .TaxableAmount(requestDataFe
                                    .getTaxTotal()
                                    .get(0)
                                    .getTaxableAmount())
                            .TaxSubtotal(
                                    taxSubtotals
                            )
                            .build()
                    )
                    .legalMonetaryTotal(LegalMonetaryTotal
                            .builder()
                            .LineExtensionAmount(requestDataFe.getLegalMonetaryTotal().getLineExtensionAmount())
                            .PayableAmount(requestDataFe.getLegalMonetaryTotal().getPayableAmount())
                            .PrepaidAmount(requestDataFe.getLegalMonetaryTotal().getPrepaidAmount())
                            .TaxExclusiveAmount(requestDataFe.getLegalMonetaryTotal().getTaxExclusiveAmount())
                            .TaxInclusiveAmount(requestDataFe.getLegalMonetaryTotal().getTaxInclusiveAmount())
                            .build())
                    .build();

            logger.info("Policy Provider");
            SignaturePolicyInfoProvider policyInfoProvider = new SignaturePolicyInfoProvider() {
                @Override
                public SignaturePolicyBase getSignaturePolicy() {
                    return new SignaturePolicyIdentifierProperty(
                            new ObjectIdentifier("https://tribunet.hacienda.go.cr/docs/esquemas/2017/v4.2/facturaElectronica"),
                            new ByteArrayInputStream("Politica de Factura Digital".getBytes()));
                }
            };
            // Define the signing key/certificate
            KeyingDataProvider kp = FileSystemKeyStoreKeyingDataProvider
                    .builder("pkcs12", nombreCertficado, SigningCertificateSelector.single())
                    .storePassword(new DirectPasswordProvider(passCertficado))
                    .entryPassword(new DirectPasswordProvider(passCertficado))
                    .build();

            logger.info("Xades EPES Signing Profile");

            Algorithm algorithm = new Algorithm("http://www.w3.org/2001/10/xml-exc-c14n#") {

            };

            XadesSigningProfile p = new XadesEpesSigningProfile(kp, policyInfoProvider);

            // Define the signed object
            DataObjectDesc obj = new DataObjectReference("")
                    .withTransform(new EnvelopedSignatureTransform())
                    .withDataObjectFormat(new DataObjectFormatProperty("text/xml"));

            SignedDataObjects dataObjs = new SignedDataObjects(obj);
            XadesSigner signer = null;
            try {
                signer = p.newSigner();

            } catch (XadesProfileResolutionException e) {
                System.out.println("Could not create Signer");

            }
            /*
        Element elemToSign = doc.getDocumentElement();
        signer.sign(dataObjs, elemToSign);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(elemToSign);
        StreamResult result = new StreamResult(new File("outputPathFile"));
        transformer.transform(source, result);
             */

            logger.info("Enviando factura electronica a DIAN");

            JAXBContext context = JAXBContext.newInstance(invoiceServicesDto.getClass());
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            mar.marshal(context, sw);
            String xmlString = sw.toString();

            DataHandler testHandler = new DataHandler(xmlString, "text/xml");
            SendBillSync enviarFE = new SendBillSync();
            enviarFE.setFileName("7000054312.zip");
            enviarFE.setContentFile(testHandler);

            wfcCustomerServicesSkeleton.sendBillSync(enviarFE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GET
    public Response ping() {

        return Response
                .ok("ping Jakarta EE")
                .build();
    }
}
