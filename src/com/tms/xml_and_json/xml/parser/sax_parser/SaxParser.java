package com.tms.xml_and_json.xml.parser.sax_parser;

import com.tms.xml_and_json.xml.parser.IParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.net.URL;

public class SaxParser implements IParser {

    @Override
    public void process(String xmlFile) {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser;
        BookHandler handler = new BookHandler();

        try {
            parser = parserFactory.newSAXParser();
            parser.parse(xmlFile, handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
