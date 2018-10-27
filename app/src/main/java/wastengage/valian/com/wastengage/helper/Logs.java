package wastengage.valian.com.wastengage.helper;

import android.app.Activity;
import android.widget.Toast;

import wastengage.valian.com.wastengage.AppConstant;

/**
 * Created by john lenon on 12/3/18.
 */

public class Logs {
    private static String TAG = "----**";

    public static void p(String s) {
        if (AppConstant.isDebuggable) {
            System.out.println(TAG + s);
        }
    }

    public static void t(Activity activity, String msg) {
        if (AppConstant.isDebuggable) {
            Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
        }
    }

    public static void tFinal(Activity activity, String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
    }
}
