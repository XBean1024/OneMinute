package com.company;

import java.io.IOException;

public class OneMinute {
    public static final long timeout = 2;

    public static void main(String[] args) {

        try {
            while (true) {
                adb(1030);
                adb(1034);
                adb(1040);
                adb(1032);
                adb(1034);
                adb(1040);
                adb(1032);
                adb(1032);
                adb(1040);
                adb(1034);
                adb(1040);
                adb(1032);
                adb(1034);
                adb(1030);
//                adb(1044);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void adb(long ms) {

        try {
            Runtime.getRuntime()
                    .exec("adb shell input swipe 540  1601 540 800 " + ms);
            // 获取手机截图
            Runtime.getRuntime()
                    .exec("adb shell /system/bin/screencap -p /sdcard/screenshot.png");
            Thread.sleep(1000);

            // 上传手机截图到电脑
            Runtime.getRuntime()
                    .exec("adb pull /sdcard/screenshot.png /Users/binny/Downloads/one/screenshot_" + System.currentTimeMillis() + ".png");
            Thread.sleep(1000);
            System.out.print("Get screenshot success!   " + ms + "\n");
//            Runtime.getRuntime()
//                    .exec("adb shell input swipe 1000  73 1060 73 " + 1000);
//            Thread.sleep(1000);
//            Runtime.getRuntime()
//                    .exec("adb shell input swipe 200  1500 300 1500 " + 1000);
//            Thread.sleep(1000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
