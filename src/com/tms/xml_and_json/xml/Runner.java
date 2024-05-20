package com.tms.xml_and_json.xml;

import com.tms.xml_and_json.xml.model.DocumentHandler;
import com.tms.xml_and_json.xml.parser.dom_parser.DomParser;
import com.tms.xml_and_json.xml.parser.sax_parser.SaxParser;
import com.tms.xml_and_json.xml.parser.stax_parser.StaxParser;

/**
 * Task:
 *
 * Write a program to parse xml document.
 *
 * The program receives as input a string to the folder where the document is located.
 * You only need to parse one document - accordingly, provide various checks,
 * for example, that there are no files in the folder, or that there are several xml documents in the folder and other possible checks.
 *
 * It is necessary to parse the xml document and write the contents of the line tags into another document.
 * The file name for the entry must consist of tag values and look like: <firstName>_<lastName>_<title>.txt
 *
 * Additionally, implement the following functionality:
 *
 *  -if the value 1 is entered in the properties file - parse the document using SAX.
 *  -if the value 2 is entered in the properties file - parse the document using DOM.
 */

public class Runner {

    public static void main(String[] args) {
//        SAX
        SaxParser saxParser = new SaxParser();

//        DOM
        DomParser domParser = new DomParser();

//        StAX
        StaxParser staxParser = new StaxParser();

        saxParser.process("file:hw.xml");
        domParser.process("file:hw.xml");
        staxParser.process("hw.xml");
    }



}
