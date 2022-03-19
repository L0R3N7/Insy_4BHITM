# <center> Exercise XML.02 – XSD </center>

# General
For both tasks provide not only the required document but also copy/screenshot the result
of the validation tool you used.

# 1 Complying with XSD
Often you will receive a XSD from a vendor which your service requests have to comply with.
Equally often they do not provide an XML sample (because of data protection and general
enterprise-weirdness), so you should be able to create a XML based on a XSD to get a better
grasp what your object model has to look like.
- Write down a XML document which complies to the XSD given below.
- The XML has to contain at least two products, one with and one without size
```xsd
<?xml version="1.0" encoding="UTF−8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
    <xs:element name="products">
        <xs:complexType>
            <xs:sequence>
                <xs:element maxOccurs="unbounded"ref="product"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:element name="product">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="number" type="xs:integer"/>
                <xs:element name="name" type="xs:string"/>
                <xs:element name="size" type="size" minOccurs="0"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>
    
    <xs:simpleType name="size" final="restriction">
        <xs:restriction base="xs:string">
            <xs:enumeration value="small"/>
            <xs:enumeration value="medium"/>
            <xs:enumeration value="large"/>
        </xs:restriction>
    </xs:simpleType>
</xs:schema>
```

## Result
```xml
<?xml version="1.0" encoding="UTF−8"?>
<products>
    <product>
        <number>120</number>
        <name>T-Shirt</name>
        <size>small</size>
    </product>
    <product>
        <number>35</number>
        <name>Sneakers</name>
    </product>
</products>
```

# 2 Creating XSD
It might not always be possible to generate a XSD (from an object model) if you need to provide
one. In any case you have to be able to validate the output, because such a generated model
is often not fully correct or might impose bigger/smaller constraints than desired based on the
given sample data and data types.
- Create a XSD to which the XML given below complies.
- Make sensible assumptions about constraints (if any) and explain your decisions.
```xml
<account>
    <clientId>123</clientId>
    <clientName>Lovely Products</clientName>
    <clientAddress>5 HighStreet</clientAddress>
    <clientAddress>Metropolis</clientAddress>
</account>
```

## Result 
```xsd
<?xml version="1.0" encoding="UTF−8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
    <xs:element name="account">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="clientId" type="xs:integer"/>
                <xs:element name="clientName" type="xs:string"/>
                <xs:element maxOccurs="unbounded" minOccurs ="1" ref="clientAddress"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>
    <xs:element name="clientAddress" type="xs:string"/>
</xs:schema>
```
### Assuption
I assumed that an account needed at least on "clientAddress"
