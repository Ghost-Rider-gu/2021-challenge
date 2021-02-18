package siendev.corp.apps.other;

import java.io.IOException;

/**
 * @author Iurii Golubnichenko
 *
 * Fake blue screen in browser.
 */
public class Pranks {

    public static void bsodEmulator() throws IOException, InterruptedException {
        String[] cmd = new String[]{"cmd", "/c", "start chrome -incognito --kiosk http://fakebsod.com/windows-8-and-10"};
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();
    }
}
