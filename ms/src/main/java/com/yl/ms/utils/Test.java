package com.yl.ms.utils;

/**
 * @author yl on 2021/6/28
 */
public class Test {
    private static volatile boolean m_bInUse = false;

    protected static void Lock(int nSeconds) throws Exception {
        if (nSeconds <= 0) {
            while (!setInUseFlag(true)) {
                Thread.sleep(100);
            }
        } else {
            while (!setInUseFlag(true) && nSeconds-- > 0) {
                Thread.sleep(100);
            }

            if (nSeconds == 0) {
                throw new Exception("Lock time out");
            }
        }
    }

    protected static synchronized boolean setInUseFlag(boolean bNewValue) {
        if (bNewValue == true) { // 请求“使用标志”
            if (m_bInUse == true) { // “使用标志”已经被占用
                return false;
            } else {
                m_bInUse = true;
                return true;
            }
        } else { // 释放“使用标志”
            m_bInUse = false;
            return true;
        }
    }

}
