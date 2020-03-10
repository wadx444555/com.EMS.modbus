package com.EMS.modbus.WTinfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WTinfo {
    /**
     * 从主控读取的点
     */

    private float WT_WindSpeed; //瞬时风速 300427
    private float WT_WindDirection;//风向 300405
    private float WT_Ua;//电压 302823
    private float WT_Ia;//电流 302835
    private float WT_P;//有功 302843
    private float WT_Q;//无功 302845
    private boolean WT_WTCState;//风机主状态 300219
}
