package com.EMS.modbus.WTinfo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class WTIP {
    /**
     * 风机和其他设备ip读取
     * @param i 1号风机对应此处值为i=0，以此类推；
     * @return ip
     * @throws Exception
     *
     */
    public String ipread(int i) throws Exception {
        //xml文件位置
        File file = new File("src/main/resources/WTIP.xml");
        //获得解析器DocumentBuilder的工厂实例DocumentBuilderFactory  然后拿到DocumentBuilder对象
        NodeList IPList;
        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            //获取一个与磁盘文件关联的非空Document对象
            Document doc = newDocumentBuilder.parse(file);
            //通过文档对象获得该文档对象的根节点
            Element root = doc.getDocumentElement();
            //通过根节点获得子节点
            NodeList WTList = root.getElementsByTagName("WT");
            // System.out.println(WTList.getLength());

            Node item = WTList.item(i);
            //System.out.println(item.getTextContent());
            Element element = (Element) item;
            IPList = element.getElementsByTagName("IP");
        } catch (Exception e) {
            throw e;
        }
        return IPList.item(0).getTextContent();
    }

    /**
     * 风机和其他设备端口读取
     * @param i 1号风机对应此处值为i=0，以此类推；
     * @return port
     * @throws Exception
     *
     */
    public String portread(int i) throws Exception {
        //xml文件位置
        File file = new File("src/main/resources/WTIP.xml");
        //获得解析器DocumentBuilder的工厂实例DocumentBuilderFactory  然后拿到DocumentBuilder对象
        NodeList IPList;
        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            //获取一个与磁盘文件关联的非空Document对象
            Document doc = newDocumentBuilder.parse(file);
            //通过文档对象获得该文档对象的根节点
            Element root = doc.getDocumentElement();
            //通过根节点获得子节点
            NodeList WTList = root.getElementsByTagName("WT");
            // System.out.println(WTList.getLength());

            Node item = WTList.item(i);
            //System.out.println(item.getTextContent());
            Element element = (Element) item;
            IPList = element.getElementsByTagName("PROT");
        } catch (Exception e) {
            throw e;
        }
        return IPList.item(0).getTextContent();
    }






}
