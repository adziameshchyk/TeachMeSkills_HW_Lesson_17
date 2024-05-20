package com.tms.xml_and_json.xml.parser.sax_parser;

import com.tms.xml_and_json.xml.model.DocumentHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.swing.*;

public class BookHandler extends DefaultHandler {
    private String firstName;
    private String lastName;
    private String title;
    private StringBuilder lines = new StringBuilder();
    private String lastElementName;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElementName = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String text = new String(ch, start, length);
        text = text.replace("\n", "").trim();

        if (!text.isEmpty()) {
            switch (lastElementName) {
                case "firstName" -> firstName = text;
                case "lastName" -> lastName = text;
                case "title" -> title = text;
                case "line" -> lines.append(text).append("\n");
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("lines")) {
            String fileToWriteName = String.join("_", firstName, lastName, title).concat(".txt");

            DocumentHandler documentHandler = DocumentHandler.getInstance(fileToWriteName);
            documentHandler.write(lines);
            documentHandler.write("-----------------------Parsed using SAX parser-----------------------" + "\n");
        }
    }
}
