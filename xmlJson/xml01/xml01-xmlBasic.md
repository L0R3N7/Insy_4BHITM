# XML Basic
## Attributes
### Case 1
We want to represent a person in XML. A person has a name. You can assume that every
person always has a first and a last name. However, some also have a middle name.
- Can (and if yes, how) this situation be represented with attributes or would you have to
use elements (e.g. a Name element with 2-3 child elements for the name parts)?

### Result
```xml
<person lastname="Doe" firsname="John">
    <middle-name>FizzBuzz</middle-name>
</person>
```

### Case 2
A web service is returning a XML document to clients. This document is very large and
requested often. To reduce the length of the document and save bandwidth management
demanded to optimize the following structure utilizing attributes:
```xml
<Store>
    <Id>1234</Id>
    <Manager>
        <PersNo>8765</PersNo>
        <Name>Sepp</Name>
    </Manager>
    <Location>
        <Street>
            <StreetName>Salesstr.</StreetName>
            <StreetNo>11</StreetNo>
        </Street>
        <City>
            <Name>Storestadt</Name>
            <ZIP>4004</ZIP>
            <Country>
                <Name>Salesia</Name>
                <Continent>Eurasia</Continent>
            </Country>
        </City>
    </Location>
</Store>
```
- With regards to pure document length, why can an attribute save space?
- What are good use cases for attributes?
- Write down the ’optimized’ structure replacing elements with attributes where appropriate.
- Explain the choices you made while optimizing the document.
- Bonus (for a good answer): Assuming you are allowed to think beyond the letters of your
current assignment, what would you propose to actually reduce message size significantly?

### Result
- Durch die Verwendung von Attributen müssen weniger Elemente benutz werden. Elemente sind Speicherintensiver. (Ende </fizz>, Klammer, Generell zeremonielle Schritte)
- Attribute können bei Elemente verwendet werden die gewöhnlichen Variablen haben. (Bsp. Auto -> Marke) (Schlechtes Bsp. Auto -> Plüschwürfel Marke)
```xml
<Store id="1234">
    <Manager PersNo="8765" Name="Sepp"></Manager>
    <Location>
        <Street StreetName="Salesstr." StreetNo="11"></Street>
        <City Name="Storestadt" ZIP="4004">
            <Country Name="Salesia" Continent="Eurasia"></Country>
        </City>
    </Location>
</Store>
```
- Ich habe verschachtelte Elemente, die auch als Attribute ausgedrückt werden könnten, zu Attribute deren Parent - Elemente gemacht. 
- Switch to a JSON - Representation of the Objects

## Structure
### DOM
- What does the term ’Document Object Model’ stand for?
- Explain the relationship between HTML and XML.
- Write down the XML document for the following graph:

### Result
- Das DOM ist eine Schnittstelle zwischen HTML und JS. Alle Elemente der HTML-File werden in Objecte umgewandelt. 
- HTML und XML ähneln sich sehr. Beide sind Markup-Language. Ein Unterschied wäre aber das HTML "predefined Attribute" für Elemente hat
```xml
<Catalog>
    <Plants type="Array">
        <Plant>
            <Zone id="4"></Zone>
        </Plant>
        <Plant>
            <Zone id="4"></Zone>
        </Plant>
    </Plants>
</Catalog>

<Botanical name="Aquilegia">
</Botanical>
```
### Collections
You are tasked with developing a service which returns (GPS) coordinates for off-road tracks.
Each coordinate requires a latitude and a longitude value. Additionally, it is important to know
in which order the coordinates have to be visited. Each track has a name, an average duration
and a total (walking/driving) distance.
- Write down a XML document for such a track containing at least two coordinates.
- Is this an efficient way of representing huge amounts of similar data?

### Result

```xml
<Route>
    <GPSArray type="Array">
        <GPS longitude="48.295979" latitude="14.276915" order="1">
        <GPS longitude="48.267817" latitude="14.253679" order="2">
    </GPSArray> 
</Route>
```
- Nein

# Working with XML
Usually XML documents are processed by programs so you will attempt that as well.
- Write a C# program which:
    1. Reads the XML document you created in 1.2.2.
    1. Adds a new coordinate to the collection.
    1. Writes the new (extended) XML document to disk again.
- Be careful to not operate on the string level, but find a library/high level language feature
for working with XML.
- No user interaction is necessary.