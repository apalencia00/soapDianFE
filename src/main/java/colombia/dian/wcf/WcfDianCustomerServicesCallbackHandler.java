/**
 * WcfDianCustomerServicesCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package colombia.dian.wcf;


/**
 *  WcfDianCustomerServicesCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class WcfDianCustomerServicesCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public WcfDianCustomerServicesCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public WcfDianCustomerServicesCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for getStatusEvent method
     * override this method for handling normal response from getStatusEvent operation
     */
    public void receiveResultgetStatusEvent(
        colombia.dian.wcf.GetStatusEventResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getStatusEvent operation
     */
    public void receiveErrorgetStatusEvent(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for sendNominaSync method
     * override this method for handling normal response from sendNominaSync operation
     */
    public void receiveResultsendNominaSync(
        colombia.dian.wcf.SendNominaSyncResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from sendNominaSync operation
     */
    public void receiveErrorsendNominaSync(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for sendBillAttachmentAsync method
     * override this method for handling normal response from sendBillAttachmentAsync operation
     */
    public void receiveResultsendBillAttachmentAsync(
        colombia.dian.wcf.SendBillAttachmentAsyncResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from sendBillAttachmentAsync operation
     */
    public void receiveErrorsendBillAttachmentAsync(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getReferenceNotes method
     * override this method for handling normal response from getReferenceNotes operation
     */
    public void receiveResultgetReferenceNotes(
        colombia.dian.wcf.GetReferenceNotesResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getReferenceNotes operation
     */
    public void receiveErrorgetReferenceNotes(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getStatusZip method
     * override this method for handling normal response from getStatusZip operation
     */
    public void receiveResultgetStatusZip(
        colombia.dian.wcf.GetStatusZipResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getStatusZip operation
     */
    public void receiveErrorgetStatusZip(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getXmlByDocumentKey method
     * override this method for handling normal response from getXmlByDocumentKey operation
     */
    public void receiveResultgetXmlByDocumentKey(
        colombia.dian.wcf.GetXmlByDocumentKeyResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getXmlByDocumentKey operation
     */
    public void receiveErrorgetXmlByDocumentKey(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getExchangeEmails method
     * override this method for handling normal response from getExchangeEmails operation
     */
    public void receiveResultgetExchangeEmails(
        colombia.dian.wcf.GetExchangeEmailsResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getExchangeEmails operation
     */
    public void receiveErrorgetExchangeEmails(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for sendEventUpdateStatus method
     * override this method for handling normal response from sendEventUpdateStatus operation
     */
    public void receiveResultsendEventUpdateStatus(
        colombia.dian.wcf.SendEventUpdateStatusResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from sendEventUpdateStatus operation
     */
    public void receiveErrorsendEventUpdateStatus(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getNumberingRange method
     * override this method for handling normal response from getNumberingRange operation
     */
    public void receiveResultgetNumberingRange(
        colombia.dian.wcf.GetNumberingRangeResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getNumberingRange operation
     */
    public void receiveErrorgetNumberingRange(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for sendBillAsync method
     * override this method for handling normal response from sendBillAsync operation
     */
    public void receiveResultsendBillAsync(
        colombia.dian.wcf.SendBillAsyncResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from sendBillAsync operation
     */
    public void receiveErrorsendBillAsync(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for sendBillSync method
     * override this method for handling normal response from sendBillSync operation
     */
    public void receiveResultsendBillSync(
        colombia.dian.wcf.SendBillSyncResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from sendBillSync operation
     */
    public void receiveErrorsendBillSync(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getDocIdentifierWithEvents method
     * override this method for handling normal response from getDocIdentifierWithEvents operation
     */
    public void receiveResultgetDocIdentifierWithEvents(
        colombia.dian.wcf.GetDocIdentifierWithEventsResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getDocIdentifierWithEvents operation
     */
    public void receiveErrorgetDocIdentifierWithEvents(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for sendTestSetAsync method
     * override this method for handling normal response from sendTestSetAsync operation
     */
    public void receiveResultsendTestSetAsync(
        colombia.dian.wcf.SendTestSetAsyncResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from sendTestSetAsync operation
     */
    public void receiveErrorsendTestSetAsync(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getStatus method
     * override this method for handling normal response from getStatus operation
     */
    public void receiveResultgetStatus(
        colombia.dian.wcf.GetStatusResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getStatus operation
     */
    public void receiveErrorgetStatus(java.lang.Exception e) {
    }
}
