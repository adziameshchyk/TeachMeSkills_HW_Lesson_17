package com.tms.xml_and_json.xml.parser.stax_parser;

import com.tms.xml_and_json.xml.model.DocumentHandler;
import com.tms.xml_and_json.xml.parser.IParser;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class StaxParser implements IParser {

    private String firstName;
    private String lastName;
    private String title;
    private StringBuilder lines = new StringBuilder();
    private String lastElementName;

    @Override
    public void process(String xmlFile) {

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(xmlFile));

            while (reader.hasNext()) {
                int event = reader.next();
                if (event == XMLEvent.START_ELEMENT) {
                    switch (reader.getLocalName()) {
                        case "firstName" -> firstName = reader.getElementText();
                        case "lastName" -> lastName = reader.getElementText();
                        case "title" -> title = reader.getElementText();
                        case "line" -> lines.append(reader.getElementText()).append("\n");
                    }
                }
            }

        } catch (XMLStreamException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String fileToWriteName = String.join("_", firstName, lastName, title).concat(".txt");

        DocumentHandler documentHandler = DocumentHandler.getInstance(fileToWriteName);
        documentHandler.write(lines);
        documentHandler.write("-----------------------Parsed using StAX parser-----------------------" + "\n");

    }

}
