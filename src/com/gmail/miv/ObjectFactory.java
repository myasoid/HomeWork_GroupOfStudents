package com.gmail.miv;


import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {
    public final static QName qname = new QName(XMLConstants.NULL_NS_URI, "data");

    @XmlElementDecl(name = "dataObj")
    public JAXBElement<Group> createData(Group group){
        return new JAXBElement<Group>(qname, null, Group.class, group);
    }
}
