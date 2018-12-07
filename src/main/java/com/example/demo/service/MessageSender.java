package com.example.demo.service;


import java.io.IOException;
import java.io.StringReader;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.example.demo.repo.MessageRepo;
import com.example.demo.entity.MessageSend;


@Service("MessageSender")
public class MessageSender {
	
	Logger log = LoggerFactory.getLogger(MessageSender.class);
	@Autowired
	MessageRepo messagesend;
		
	public String sendMsg(String message) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException {
		//System.out.println(message);		
	MessageSend msg= new MessageSend(message);
	messagesend.save(msg);
		
	DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = factory.newDocumentBuilder();
	InputSource documentsource = new InputSource(new StringReader(message));
	Document doc = builder.parse(documentsource);
	XPath xPath =  XPathFactory.newInstance().newXPath();
	String expression = "/order/orderItem/isbn";	        
	String message1 = (String) xPath.compile(expression).evaluate(doc);
	if(message1==null) {
		return null;
	}
	else
	return  message;	
}
}

