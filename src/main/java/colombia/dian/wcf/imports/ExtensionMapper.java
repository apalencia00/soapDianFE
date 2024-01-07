/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:06:07 GMT)
 */
package colombia.dian.wcf.imports;


/**
 *  ExtensionMapper class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ExtensionMapper {
    public static java.lang.Object getTypeObject(
        java.lang.String namespaceURI, java.lang.String typeName,
        javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
        if ("http://schemas.datacontract.org/2004/07/NumberRangeResponseList".equals(
                    namespaceURI) &&
                "NumberRangeResponseList".equals(typeName)) {
            return org.datacontract.schemas._2004._07.numberrangeresponselist.NumberRangeResponseList.Factory.parse(reader);
        }

        if ("http://schemas.microsoft.com/2003/10/Serialization/".equals(
                    namespaceURI) && "char".equals(typeName)) {
            return com.microsoft.schemas._2003._10.serialization._char.Factory.parse(reader);
        }

        if ("http://schemas.datacontract.org/2004/07/UploadDocumentResponse".equals(
                    namespaceURI) && "UploadDocumentResponse".equals(typeName)) {
            return org.datacontract.schemas._2004._07.uploaddocumentresponse.UploadDocumentResponse.Factory.parse(reader);
        }

        if ("http://schemas.microsoft.com/2003/10/Serialization/".equals(
                    namespaceURI) && "guid".equals(typeName)) {
            return com.microsoft.schemas._2003._10.serialization.Guid.Factory.parse(reader);
        }

        if ("http://schemas.datacontract.org/2004/07/XmlParamsResponseTrackId".equals(
                    namespaceURI) &&
                "XmlParamsResponseTrackId".equals(typeName)) {
            return org.datacontract.schemas._2004._07.xmlparamsresponsetrackid.XmlParamsResponseTrackId.Factory.parse(reader);
        }

        if ("http://schemas.datacontract.org/2004/07/DianResponse".equals(
                    namespaceURI) && "ArrayOfDianResponse".equals(typeName)) {
            return org.datacontract.schemas._2004._07.dianresponse.ArrayOfDianResponse.Factory.parse(reader);
        }

        if ("http://schemas.microsoft.com/2003/10/Serialization/".equals(
                    namespaceURI) && "duration".equals(typeName)) {
            return com.microsoft.schemas._2003._10.serialization.Duration.Factory.parse(reader);
        }

        if ("http://schemas.datacontract.org/2004/07/NumberRangeResponse".equals(
                    namespaceURI) && "NumberRangeResponse".equals(typeName)) {
            return org.datacontract.schemas._2004._07.numberrangeresponse.NumberRangeResponse.Factory.parse(reader);
        }

        if ("http://schemas.datacontract.org/2004/07/EventResponse".equals(
                    namespaceURI) && "EventResponse".equals(typeName)) {
            return org.datacontract.schemas._2004._07.eventresponse.EventResponse.Factory.parse(reader);
        }

        if ("http://schemas.microsoft.com/2003/10/Serialization/Arrays".equals(
                    namespaceURI) && "ArrayOfstring".equals(typeName)) {
            return com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring.Factory.parse(reader);
        }

        if ("http://schemas.datacontract.org/2004/07/NumberRangeResponse".equals(
                    namespaceURI) &&
                "ArrayOfNumberRangeResponse".equals(typeName)) {
            return org.datacontract.schemas._2004._07.numberrangeresponse.ArrayOfNumberRangeResponse.Factory.parse(reader);
        }

        if ("http://schemas.datacontract.org/2004/07/ExchangeEmailResponse".equals(
                    namespaceURI) && "ExchangeEmailResponse".equals(typeName)) {
            return org.datacontract.schemas._2004._07.exchangeemailresponse.ExchangeEmailResponse.Factory.parse(reader);
        }

        if ("http://schemas.datacontract.org/2004/07/DianResponse".equals(
                    namespaceURI) && "DianResponse".equals(typeName)) {
            return org.datacontract.schemas._2004._07.dianresponse.DianResponse.Factory.parse(reader);
        }

        if ("http://schemas.datacontract.org/2004/07/XmlParamsResponseTrackId".equals(
                    namespaceURI) &&
                "ArrayOfXmlParamsResponseTrackId".equals(typeName)) {
            return org.datacontract.schemas._2004._07.xmlparamsresponsetrackid.ArrayOfXmlParamsResponseTrackId.Factory.parse(reader);
        }

        if ("http://schemas.datacontract.org/2004/07/DocIdentifierWithEventsResponse".equals(
                    namespaceURI) &&
                "DocIdentifierWithEventsResponse".equals(typeName)) {
            return org.datacontract.schemas._2004._07.docidentifierwitheventsresponse.DocIdentifierWithEventsResponse.Factory.parse(reader);
        }

        throw new org.apache.axis2.databinding.ADBException("Unsupported type " +
            namespaceURI + " " + typeName);
    }
}
