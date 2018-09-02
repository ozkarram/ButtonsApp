package alvarez.oscar.buttonsapp.models;

import android.support.annotation.IntDef;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by Oscar Álvarez on 01/09/18.
 * Basic button object.
 */
public class ButtonObject {

    public static final int APPLE_TYPE = 0;
    public static final int YAHOO_TYPE = 1;
    public static final int GOOGLE_TYPE = 2;

    @Retention(SOURCE)
    @IntDef({APPLE_TYPE, YAHOO_TYPE, GOOGLE_TYPE})
    public @interface ButtonObjectType {
    }

    @JsonProperty("type")
    public int type;

    @JsonProperty("text")
    public String text;

    public ButtonObject() {

    }

    public ButtonObject(int type, String text) {
        this.type = type;
        this.text = text;
    }


}
