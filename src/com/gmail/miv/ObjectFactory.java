package com.gmail.miv;


import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import java.util.HashSet;
import java.util.Set;

@XmlRegistry
public class ObjectFactory {
    public final static QName qname = new QName(XMLConstants.NULL_NS_URI, "data");

    @XmlElementDecl(name = "dataObj")
    public JAXBElement<ListOfGroups> createData(ListOfGroups groups) {
        return new JAXBElement<ListOfGroups>(qname, null, groups.getClass(), groups);
    }

}
