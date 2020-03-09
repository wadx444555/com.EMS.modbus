package com.EMS.modbus.Utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLRead {
    public NodeList IPread(int i) throws IOException, SAXException, ParserConfigurationException {
        //xml文件位置
        File file = new File("src/WTIP.xml");
        //获得解析器DocumentBuilder的工厂实例DocumentBuilderFactory  然后拿到DocumentBuilder对象
        DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        //获取一个与磁盘文件关联的非空Document对象
        Document doc = newDocumentBuilder.parse(file);
        //通过文档对象获得该文档对象的根节点
        Element root = doc.getDocumentElement();
        //通过根节点获得子节点
        NodeList personList = root.getElementsByTagName("WT");

        Node item = personList.item(i);
        Element element = (Element)item;
        NodeList nameList = element.getElementsByTagName("IP");
        return nameList;
    }


}
