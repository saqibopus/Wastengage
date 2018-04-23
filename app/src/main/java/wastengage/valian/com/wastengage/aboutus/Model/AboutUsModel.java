package wastengage.valian.com.wastengage.aboutus.Model;

import java.util.ArrayList;

/**
 * Created by emxcel on 13/3/18.
 */

public class AboutUsModel {

    public String status;
    public ArrayList<String> message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getMessage() {
        return message;
    }

    public void setMessage(ArrayList<String> message) {
        this.message = message;
    }
}
