package com.EMS.modbus.AGC;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class AGCParm {

    /**
     * AGC需要风机的点
     */

    private float AGC_WindSpeed;//32000
    private float AGC_WindDirection;//32001
    private float AGC_Ua;//32002
    private float AGC_Ia;//32003
    private float AGC_P;//32004
    private float AGC_Q;//32005
    private boolean AGC_WTCState_Normal;//10100 正常
    private boolean AGC_WTCState_Stop;//10101   停机
    private boolean AGC_WTCState_Wait;//10102   等风
    private boolean AGC_WTCState_Fault;//10103  故障



}
