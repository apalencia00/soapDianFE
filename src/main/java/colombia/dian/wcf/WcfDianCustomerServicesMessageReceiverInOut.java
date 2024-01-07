/**
 * WcfDianCustomerServicesMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package colombia.dian.wcf;


/**
 *  WcfDianCustomerServicesMessageReceiverInOut message receiver
 */
public class WcfDianCustomerServicesMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver {
    public void invokeBusinessLogic(
        org.apache.axis2.context.MessageContext msgContext,
        org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault {
        try {
            // get the implementation class for the Web Service
            Object obj = getTheImplementationObject(msgContext);

            WcfDianCustomerServicesSkeletonInterface skel = (WcfDianCustomerServicesSkeletonInterface) obj;

            //Out Envelop
            org.apache.axiom.soap.SOAPEnvelope envelope = null;

            //Find the axisOperation that has been set by the Dispatch phase.
            org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext()
                                                                      .getAxisOperation();

            if (op == null) {
                throw new org.apache.axis2.AxisFault(
                    "Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
            }

            java.lang.String methodName;

            if ((op.getName() != null) &&
                    ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(
                            op.getName().getLocalPart())) != null)) {
                if ("getStatusEvent".equals(methodName)) {
                    colombia.dian.wcf.GetStatusEventResponse getStatusEventResponse85 =
                        null;
                    colombia.dian.wcf.GetStatusEvent wrappedParam = (colombia.dian.wcf.GetStatusEvent) fromOM(msgContext.getEnvelope()
                                                                                                                        .getBody()
                                                                                                                        .getFirstElement(),
                            colombia.dian.wcf.GetStatusEvent.class);

                    getStatusEventResponse85 = skel.getStatusEvent(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            getStatusEventResponse85, false,
                            new javax.xml.namespace.QName(
                                "http://wcf.dian.colombia",
                                "GetStatusEventResponse"));
                } else
                 if ("sendNominaSync".equals(methodName)) {
                    colombia.dian.wcf.SendNominaSyncResponse sendNominaSyncResponse87 =
                        null;
                    colombia.dian.wcf.SendNominaSync wrappedParam = (colombia.dian.wcf.SendNominaSync) fromOM(msgContext.getEnvelope()
                                                                                                                        .getBody()
                                                                                                                        .getFirstElement(),
                            colombia.dian.wcf.SendNominaSync.class);

                    sendNominaSyncResponse87 = skel.sendNominaSync(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            sendNominaSyncResponse87, false,
                            new javax.xml.namespace.QName(
                                "http://wcf.dian.colombia",
                                "SendNominaSyncResponse"));
                } else
                 if ("sendBillAttachmentAsync".equals(methodName)) {
                    colombia.dian.wcf.SendBillAttachmentAsyncResponse sendBillAttachmentAsyncResponse89 =
                        null;
                    colombia.dian.wcf.SendBillAttachmentAsync wrappedParam = (colombia.dian.wcf.SendBillAttachmentAsync) fromOM(msgContext.getEnvelope()
                                                                                                                                          .getBody()
                                                                                                                                          .getFirstElement(),
                            colombia.dian.wcf.SendBillAttachmentAsync.class);

                    sendBillAttachmentAsyncResponse89 = skel.sendBillAttachmentAsync(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            sendBillAttachmentAsyncResponse89, false,
                            new javax.xml.namespace.QName(
                                "http://wcf.dian.colombia",
                                "SendBillAttachmentAsyncResponse"));
                } else
                 if ("getReferenceNotes".equals(methodName)) {
                    colombia.dian.wcf.GetReferenceNotesResponse getReferenceNotesResponse91 =
                        null;
                    colombia.dian.wcf.GetReferenceNotes wrappedParam = (colombia.dian.wcf.GetReferenceNotes) fromOM(msgContext.getEnvelope()
                                                                                                                              .getBody()
                                                                                                                              .getFirstElement(),
                            colombia.dian.wcf.GetReferenceNotes.class);

                    getReferenceNotesResponse91 = skel.getReferenceNotes(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            getReferenceNotesResponse91, false,
                            new javax.xml.namespace.QName(
                                "http://wcf.dian.colombia",
                                "GetReferenceNotesResponse"));
                } else
                 if ("getStatusZip".equals(methodName)) {
                    colombia.dian.wcf.GetStatusZipResponse getStatusZipResponse93 =
                        null;
                    colombia.dian.wcf.GetStatusZip wrappedParam = (colombia.dian.wcf.GetStatusZip) fromOM(msgContext.getEnvelope()
                                                                                                                    .getBody()
                                                                                                                    .getFirstElement(),
                            colombia.dian.wcf.GetStatusZip.class);

                    getStatusZipResponse93 = skel.getStatusZip(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            getStatusZipResponse93, false,
                            new javax.xml.namespace.QName(
                                "http://wcf.dian.colombia",
                                "GetStatusZipResponse"));
                } else
                 if ("getXmlByDocumentKey".equals(methodName)) {
                    colombia.dian.wcf.GetXmlByDocumentKeyResponse getXmlByDocumentKeyResponse95 =
                        null;
                    colombia.dian.wcf.GetXmlByDocumentKey wrappedParam = (colombia.dian.wcf.GetXmlByDocumentKey) fromOM(msgContext.getEnvelope()
                                                                                                                                  .getBody()
                                                                                                                                  .getFirstElement(),
                            colombia.dian.wcf.GetXmlByDocumentKey.class);

                    getXmlByDocumentKeyResponse95 = skel.getXmlByDocumentKey(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            getXmlByDocumentKeyResponse95, false,
                            new javax.xml.namespace.QName(
                                "http://wcf.dian.colombia",
                                "GetXmlByDocumentKeyResponse"));
                } else
                 if ("getExchangeEmails".equals(methodName)) {
                    colombia.dian.wcf.GetExchangeEmailsResponse getExchangeEmailsResponse97 =
                        null;
                    colombia.dian.wcf.GetExchangeEmails wrappedParam = (colombia.dian.wcf.GetExchangeEmails) fromOM(msgContext.getEnvelope()
                                                                                                                              .getBody()
                                                                                                                              .getFirstElement(),
                            colombia.dian.wcf.GetExchangeEmails.class);

                    getExchangeEmailsResponse97 = skel.getExchangeEmails(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            getExchangeEmailsResponse97, false,
                            new javax.xml.namespace.QName(
                                "http://wcf.dian.colombia",
                                "GetExchangeEmailsResponse"));
                } else
                 if ("sendEventUpdateStatus".equals(methodName)) {
                    colombia.dian.wcf.SendEventUpdateStatusResponse sendEventUpdateStatusResponse99 =
                        null;
                    colombia.dian.wcf.SendEventUpdateStatus wrappedParam = (colombia.dian.wcf.SendEventUpdateStatus) fromOM(msgContext.getEnvelope()
                                                                                                                                      .getBody()
                                                                                                                                      .getFirstElement(),
                            colombia.dian.wcf.SendEventUpdateStatus.class);

                    sendEventUpdateStatusResponse99 = skel.sendEventUpdateStatus(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            sendEventUpdateStatusResponse99, false,
                            new javax.xml.namespace.QName(
                                "http://wcf.dian.colombia",
                                "SendEventUpdateStatusResponse"));
                } else
                 if ("getNumberingRange".equals(methodName)) {
                    colombia.dian.wcf.GetNumberingRangeResponse getNumberingRangeResponse101 =
                        null;
                    colombia.dian.wcf.GetNumberingRange wrappedParam = (colombia.dian.wcf.GetNumberingRange) fromOM(msgContext.getEnvelope()
                                                                                                                              .getBody()
                                                                                                                              .getFirstElement(),
                            colombia.dian.wcf.GetNumberingRange.class);

                    getNumberingRangeResponse101 = skel.getNumberingRange(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            getNumberingRangeResponse101, false,
                            new javax.xml.namespace.QName(
                                "http://wcf.dian.colombia",
                                "GetNumberingRangeResponse"));
                } else
                 if ("sendBillAsync".equals(methodName)) {
                    colombia.dian.wcf.SendBillAsyncResponse sendBillAsyncResponse103 =
                        null;
                    colombia.dian.wcf.SendBillAsync wrappedParam = (colombia.dian.wcf.SendBillAsync) fromOM(msgContext.getEnvelope()
                                                                                                                      .getBody()
                                                                                                                      .getFirstElement(),
                            colombia.dian.wcf.SendBillAsync.class);

                    sendBillAsyncResponse103 = skel.sendBillAsync(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            sendBillAsyncResponse103, false,
                            new javax.xml.namespace.QName(
                                "http://wcf.dian.colombia",
                                "SendBillAsyncResponse"));
                } else
                 if ("sendBillSync".equals(methodName)) {
                    colombia.dian.wcf.SendBillSyncResponse sendBillSyncResponse105 =
                        null;
                    colombia.dian.wcf.SendBillSync wrappedParam = (colombia.dian.wcf.SendBillSync) fromOM(msgContext.getEnvelope()
                                                                                                                    .getBody()
                                                                                                                    .getFirstElement(),
                            colombia.dian.wcf.SendBillSync.class);

                    sendBillSyncResponse105 = skel.sendBillSync(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            sendBillSyncResponse105, false,
                            new javax.xml.namespace.QName(
                                "http://wcf.dian.colombia",
                                "SendBillSyncResponse"));
                } else
                 if ("getDocIdentifierWithEvents".equals(methodName)) {
                    colombia.dian.wcf.GetDocIdentifierWithEventsResponse getDocIdentifierWithEventsResponse107 =
                        null;
                    colombia.dian.wcf.GetDocIdentifierWithEvents wrappedParam = (colombia.dian.wcf.GetDocIdentifierWithEvents) fromOM(msgContext.getEnvelope()
                                                                                                                                                .getBody()
                                                                                                                                                .getFirstElement(),
                            colombia.dian.wcf.GetDocIdentifierWithEvents.class);

                    getDocIdentifierWithEventsResponse107 = skel.getDocIdentifierWithEvents(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            getDocIdentifierWithEventsResponse107, false,
                            new javax.xml.namespace.QName(
                                "http://wcf.dian.colombia",
                                "GetDocIdentifierWithEventsResponse"));
                } else
                 if ("sendTestSetAsync".equals(methodName)) {
                    colombia.dian.wcf.SendTestSetAsyncResponse sendTestSetAsyncResponse109 =
                        null;
                    colombia.dian.wcf.SendTestSetAsync wrappedParam = (colombia.dian.wcf.SendTestSetAsync) fromOM(msgContext.getEnvelope()
                                                                                                                            .getBody()
                                                                                                                            .getFirstElement(),
                            colombia.dian.wcf.SendTestSetAsync.class);

                    sendTestSetAsyncResponse109 = skel.sendTestSetAsync(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            sendTestSetAsyncResponse109, false,
                            new javax.xml.namespace.QName(
                                "http://wcf.dian.colombia",
                                "SendTestSetAsyncResponse"));
                } else
                 if ("getStatus".equals(methodName)) {
                    colombia.dian.wcf.GetStatusResponse getStatusResponse111 = null;
                    colombia.dian.wcf.GetStatus wrappedParam = (colombia.dian.wcf.GetStatus) fromOM(msgContext.getEnvelope()
                                                                                                              .getBody()
                                                                                                              .getFirstElement(),
                            colombia.dian.wcf.GetStatus.class);

                    getStatusResponse111 = skel.getStatus(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            getStatusResponse111, false,
                            new javax.xml.namespace.QName(
                                "http://wcf.dian.colombia", "GetStatusResponse"));
                } else {
                    throw new java.lang.RuntimeException("method not found");
                }

                newMsgContext.setEnvelope(envelope);
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    //
    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.GetStatusEvent param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.GetStatusEvent.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.GetStatusEventResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.GetStatusEventResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.SendNominaSync param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.SendNominaSync.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.SendNominaSyncResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.SendNominaSyncResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.SendBillAttachmentAsync param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.SendBillAttachmentAsync.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.SendBillAttachmentAsyncResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.SendBillAttachmentAsyncResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.GetReferenceNotes param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.GetReferenceNotes.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.GetReferenceNotesResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.GetReferenceNotesResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.GetStatusZip param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.GetStatusZip.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.GetStatusZipResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.GetStatusZipResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.GetXmlByDocumentKey param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.GetXmlByDocumentKey.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.GetXmlByDocumentKeyResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.GetXmlByDocumentKeyResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.GetExchangeEmails param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.GetExchangeEmails.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.GetExchangeEmailsResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.GetExchangeEmailsResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.SendEventUpdateStatus param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.SendEventUpdateStatus.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.SendEventUpdateStatusResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.SendEventUpdateStatusResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.GetNumberingRange param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.GetNumberingRange.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.GetNumberingRangeResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.GetNumberingRangeResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.SendBillAsync param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.SendBillAsync.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.SendBillAsyncResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.SendBillAsyncResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.SendBillSync param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.SendBillSync.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.SendBillSyncResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.SendBillSyncResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.GetDocIdentifierWithEvents param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.GetDocIdentifierWithEvents.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.GetDocIdentifierWithEventsResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.GetDocIdentifierWithEventsResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.SendTestSetAsync param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.SendTestSetAsync.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.SendTestSetAsyncResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.SendTestSetAsyncResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.GetStatus param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.GetStatus.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        colombia.dian.wcf.GetStatusResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(colombia.dian.wcf.GetStatusResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        colombia.dian.wcf.GetStatusEventResponse param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    colombia.dian.wcf.GetStatusEventResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private colombia.dian.wcf.GetStatusEventResponse wrapGetStatusEvent() {
        colombia.dian.wcf.GetStatusEventResponse wrappedElement = new colombia.dian.wcf.GetStatusEventResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        colombia.dian.wcf.SendNominaSyncResponse param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    colombia.dian.wcf.SendNominaSyncResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private colombia.dian.wcf.SendNominaSyncResponse wrapSendNominaSync() {
        colombia.dian.wcf.SendNominaSyncResponse wrappedElement = new colombia.dian.wcf.SendNominaSyncResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        colombia.dian.wcf.SendBillAttachmentAsyncResponse param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    colombia.dian.wcf.SendBillAttachmentAsyncResponse.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private colombia.dian.wcf.SendBillAttachmentAsyncResponse wrapSendBillAttachmentAsync() {
        colombia.dian.wcf.SendBillAttachmentAsyncResponse wrappedElement = new colombia.dian.wcf.SendBillAttachmentAsyncResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        colombia.dian.wcf.GetReferenceNotesResponse param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    colombia.dian.wcf.GetReferenceNotesResponse.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private colombia.dian.wcf.GetReferenceNotesResponse wrapGetReferenceNotes() {
        colombia.dian.wcf.GetReferenceNotesResponse wrappedElement = new colombia.dian.wcf.GetReferenceNotesResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        colombia.dian.wcf.GetStatusZipResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    colombia.dian.wcf.GetStatusZipResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private colombia.dian.wcf.GetStatusZipResponse wrapGetStatusZip() {
        colombia.dian.wcf.GetStatusZipResponse wrappedElement = new colombia.dian.wcf.GetStatusZipResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        colombia.dian.wcf.GetXmlByDocumentKeyResponse param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    colombia.dian.wcf.GetXmlByDocumentKeyResponse.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private colombia.dian.wcf.GetXmlByDocumentKeyResponse wrapGetXmlByDocumentKey() {
        colombia.dian.wcf.GetXmlByDocumentKeyResponse wrappedElement = new colombia.dian.wcf.GetXmlByDocumentKeyResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        colombia.dian.wcf.GetExchangeEmailsResponse param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    colombia.dian.wcf.GetExchangeEmailsResponse.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private colombia.dian.wcf.GetExchangeEmailsResponse wrapGetExchangeEmails() {
        colombia.dian.wcf.GetExchangeEmailsResponse wrappedElement = new colombia.dian.wcf.GetExchangeEmailsResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        colombia.dian.wcf.SendEventUpdateStatusResponse param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    colombia.dian.wcf.SendEventUpdateStatusResponse.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private colombia.dian.wcf.SendEventUpdateStatusResponse wrapSendEventUpdateStatus() {
        colombia.dian.wcf.SendEventUpdateStatusResponse wrappedElement = new colombia.dian.wcf.SendEventUpdateStatusResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        colombia.dian.wcf.GetNumberingRangeResponse param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    colombia.dian.wcf.GetNumberingRangeResponse.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private colombia.dian.wcf.GetNumberingRangeResponse wrapGetNumberingRange() {
        colombia.dian.wcf.GetNumberingRangeResponse wrappedElement = new colombia.dian.wcf.GetNumberingRangeResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        colombia.dian.wcf.SendBillAsyncResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    colombia.dian.wcf.SendBillAsyncResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private colombia.dian.wcf.SendBillAsyncResponse wrapSendBillAsync() {
        colombia.dian.wcf.SendBillAsyncResponse wrappedElement = new colombia.dian.wcf.SendBillAsyncResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        colombia.dian.wcf.SendBillSyncResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    colombia.dian.wcf.SendBillSyncResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private colombia.dian.wcf.SendBillSyncResponse wrapSendBillSync() {
        colombia.dian.wcf.SendBillSyncResponse wrappedElement = new colombia.dian.wcf.SendBillSyncResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        colombia.dian.wcf.GetDocIdentifierWithEventsResponse param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    colombia.dian.wcf.GetDocIdentifierWithEventsResponse.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private colombia.dian.wcf.GetDocIdentifierWithEventsResponse wrapGetDocIdentifierWithEvents() {
        colombia.dian.wcf.GetDocIdentifierWithEventsResponse wrappedElement = new colombia.dian.wcf.GetDocIdentifierWithEventsResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        colombia.dian.wcf.SendTestSetAsyncResponse param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    colombia.dian.wcf.SendTestSetAsyncResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private colombia.dian.wcf.SendTestSetAsyncResponse wrapSendTestSetAsync() {
        colombia.dian.wcf.SendTestSetAsyncResponse wrappedElement = new colombia.dian.wcf.SendTestSetAsyncResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        colombia.dian.wcf.GetStatusResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    colombia.dian.wcf.GetStatusResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private colombia.dian.wcf.GetStatusResponse wrapGetStatus() {
        colombia.dian.wcf.GetStatusResponse wrappedElement = new colombia.dian.wcf.GetStatusResponse();

        return wrappedElement;
    }

    /**
     *  get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private java.lang.Object fromOM(org.apache.axiom.om.OMElement param,
        java.lang.Class type) throws org.apache.axis2.AxisFault {
        try {
            if (colombia.dian.wcf.GetDocIdentifierWithEvents.class.equals(type)) {
                return colombia.dian.wcf.GetDocIdentifierWithEvents.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.GetDocIdentifierWithEventsResponse.class.equals(
                        type)) {
                return colombia.dian.wcf.GetDocIdentifierWithEventsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.GetExchangeEmails.class.equals(type)) {
                return colombia.dian.wcf.GetExchangeEmails.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.GetExchangeEmailsResponse.class.equals(type)) {
                return colombia.dian.wcf.GetExchangeEmailsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.GetNumberingRange.class.equals(type)) {
                return colombia.dian.wcf.GetNumberingRange.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.GetNumberingRangeResponse.class.equals(type)) {
                return colombia.dian.wcf.GetNumberingRangeResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.GetReferenceNotes.class.equals(type)) {
                return colombia.dian.wcf.GetReferenceNotes.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.GetReferenceNotesResponse.class.equals(type)) {
                return colombia.dian.wcf.GetReferenceNotesResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.GetStatus.class.equals(type)) {
                return colombia.dian.wcf.GetStatus.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.GetStatusEvent.class.equals(type)) {
                return colombia.dian.wcf.GetStatusEvent.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.GetStatusEventResponse.class.equals(type)) {
                return colombia.dian.wcf.GetStatusEventResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.GetStatusResponse.class.equals(type)) {
                return colombia.dian.wcf.GetStatusResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.GetStatusZip.class.equals(type)) {
                return colombia.dian.wcf.GetStatusZip.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.GetStatusZipResponse.class.equals(type)) {
                return colombia.dian.wcf.GetStatusZipResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.GetXmlByDocumentKey.class.equals(type)) {
                return colombia.dian.wcf.GetXmlByDocumentKey.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.GetXmlByDocumentKeyResponse.class.equals(type)) {
                return colombia.dian.wcf.GetXmlByDocumentKeyResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.SendBillAsync.class.equals(type)) {
                return colombia.dian.wcf.SendBillAsync.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.SendBillAsyncResponse.class.equals(type)) {
                return colombia.dian.wcf.SendBillAsyncResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.SendBillAttachmentAsync.class.equals(type)) {
                return colombia.dian.wcf.SendBillAttachmentAsync.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.SendBillAttachmentAsyncResponse.class.equals(
                        type)) {
                return colombia.dian.wcf.SendBillAttachmentAsyncResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.SendBillSync.class.equals(type)) {
                return colombia.dian.wcf.SendBillSync.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.SendBillSyncResponse.class.equals(type)) {
                return colombia.dian.wcf.SendBillSyncResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.SendEventUpdateStatus.class.equals(type)) {
                return colombia.dian.wcf.SendEventUpdateStatus.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.SendEventUpdateStatusResponse.class.equals(
                        type)) {
                return colombia.dian.wcf.SendEventUpdateStatusResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.SendNominaSync.class.equals(type)) {
                return colombia.dian.wcf.SendNominaSync.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.SendNominaSyncResponse.class.equals(type)) {
                return colombia.dian.wcf.SendNominaSyncResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.SendTestSetAsync.class.equals(type)) {
                return colombia.dian.wcf.SendTestSetAsync.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (colombia.dian.wcf.SendTestSetAsyncResponse.class.equals(type)) {
                return colombia.dian.wcf.SendTestSetAsyncResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

        return null;
    }

    private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();

        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }
} //end of class
