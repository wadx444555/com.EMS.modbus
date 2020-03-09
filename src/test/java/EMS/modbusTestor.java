package EMS;

import com.EMS.modbus.Utils.modbusMaster;
import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.exception.ErrorResponseException;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.ip.IpParameters;
import com.serotonin.modbus4j.locator.BaseLocator;
import com.sun.codemodel.internal.fmt.JStaticFile;
import org.junit.Test;
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

public class modbusTestor {

    @Test
    public void hex2bytetest(){
        String hex = "12F6";
        byte[] result = new byte[hex.length() / 2];
        for (int i = 0; i < hex.length() / 2; i++) {
            int high = Integer.parseInt(hex.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hex.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        System.out.println(result);
    }

    @Test
    public void testhex2dec(){
        String num = "a0";
        int num1 =160;
        Long dec = Long.parseLong(num, 16);
        String hex = Integer.toHexString(num1);
        System.out.println(hex);
        System.out.println(dec);
    }
    @Test
    public void testxmlread() throws IOException, SAXException, ParserConfigurationException {
        //xml文件位置
        File file = new File("src/main/resources/WTIP.xml");
        //获得解析器DocumentBuilder的工厂实例DocumentBuilderFactory  然后拿到DocumentBuilder对象
        DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        //获取一个与磁盘文件关联的非空Document对象
        Document doc = newDocumentBuilder.parse(file);
        //通过文档对象获得该文档对象的根节点
        Element root = doc.getDocumentElement();
        //通过根节点获得子节点
        NodeList WTList = root.getElementsByTagName("WT");
       // System.out.println(WTList.getLength());


        Node item = WTList.item(0);
        //System.out.println(item.getTextContent());
        Element element = (Element)item;
        NodeList IPList = element.getElementsByTagName("PROT");
        System.out.println(IPList.item(0).getTextContent());
    }
    @Test
    public void master(){
        ModbusFactory modbusFactory = new ModbusFactory();
        IpParameters params = new IpParameters();
        params.setHost("127.0.0.1");
        params.setPort(9876);
        params.setEncapsulated(true);
        ModbusMaster master = modbusFactory.createTcpMaster(params, false);// TCP 协议
        try {
            //设置超时时间
            //master.setTimeout(1000);
            //设置重连次数
            //master.setRetries(3);
            //初始化
            master.init();

            BaseLocator<Boolean> loc = BaseLocator.inputStatus(1, 2);
            Boolean value = master.getValue(loc);
            System.out.println(master);
        } catch (ModbusInitException e) {
            e.printStackTrace();
        } catch (ModbusTransportException e) {
            e.printStackTrace();
        } catch (ErrorResponseException e) {
            e.printStackTrace();
        }


    }
}
