package com.onmi_tech.Util;

import com.onmi_tech.LogLevel;
import com.onmi_tech.Main;
import com.onmi_tech.SNLogger;

public class LoggerManager {
    public static SNLogger sn_logger;

    public static void status(String message, LogLevel level) {
        sn_logger = new SNLogger(LogLevel.DEBUG);
        if (Main.data.get("Logger_Output") == null) {
            sn_logger.log(level, message);
        }
    }
}
