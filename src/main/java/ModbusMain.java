import com.EMS.modbus.WTinfo.WTIP;
import com.EMS.modbus.modbus4j.Modbus4jReadUtils;
import com.serotonin.modbus4j.code.DataType;

public class ModbusMain {
    public static void main(String[] args) throws Exception {
        WTIP.ipread(27);
        Boolean s=Modbus4jReadUtils.readCoilStatus(WTIP.ipread(27),WTIP.portread(27),1,2000, DataType.FOUR_BYTE_FLOAT);
        System.out.println(s);
    }
}
