package com.tms.xml_and_json.xml.parser.dom_parser;

import com.tms.xml_and_json.xml.model.DocumentHandler;
import com.tms.xml_and_json.xml.parser.IParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomParser implements IParser {

    private String firstName;
    private String lastName;
    private String title;
    private StringBuilder lines = new StringBuilder();

    @Override
    public void process(String xmlFile) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document document;

        try {
            builder = builderFactory.newDocumentBuilder();
            document = builder.parse(xmlFile);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }

        firstName = document.getElementsByTagName("firstName").item(0).getTextContent();
        lastName = document.getElementsByTagName("lastName").item(0).getTextContent();
        title = document.getElementsByTagName("title").item(0).getTextContent();

        NodeList content = document.getElementsByTagName("line");
        for (int i = 0; i < content.getLength(); i++) {
            lines.append(content.item(i).getTextContent()).append("\n");
        }

        String fileToWriteName = String.join("_", firstName, lastName, title).concat(".txt");

        DocumentHandler documentHandler = DocumentHandler.getInstance(fileToWriteName);
        documentHandler.write(lines);
        documentHandler.write("-----------------------Parsed using dom parser-----------------------" + "\n");
    }

}
