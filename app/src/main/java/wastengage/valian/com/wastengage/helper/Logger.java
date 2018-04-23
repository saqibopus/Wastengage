package wastengage.valian.com.wastengage.helper;

import wastengage.valian.com.wastengage.AppConstant;

/**
 * Created by john lenon on 12/3/18.
 */

public class Logger {
    private static String TAG = "----**";
    public static void p(String s){
        if(AppConstant.isDebuggable){
            System.out.println(TAG+s);
        }
    }
}
