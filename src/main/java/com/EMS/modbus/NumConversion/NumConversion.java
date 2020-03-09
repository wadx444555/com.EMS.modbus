package com.EMS.modbus.NumConversion;

/**
 * 进制转换
 *
 */
public class NumConversion {
    /**
     * 十六进制转十进制
     */
    public  Long hex2dec(String num) {
        Long dec = Long.parseLong(num, 16);
        return dec;
    }

    /**十进制转十六进制*/
    public String dec2hex(int num){
        String hex = Integer.toHexString(num);
        return hex;
    }

    /**十六进制转二进制*/
    public byte[] hex2byte(String hex){
        if (hex.length() < 1)
            return null;
        byte[] result = new byte[hex.length() / 2];
        for (int i = 0; i < hex.length() / 2; i++) {
            int high = Integer.parseInt(hex.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hex.substring(i * 2 + 1, i * 2 + 2),
                    16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * 二进制转十六进制
     */

}
