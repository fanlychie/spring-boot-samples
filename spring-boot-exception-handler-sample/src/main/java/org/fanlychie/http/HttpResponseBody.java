package org.fanlychie.http;

/**
 * Created by fanlychie on 2017/6/18.
 */
public class HttpResponseBody {

    private int code;

    private String errmsg;

    private Object data;

    public HttpResponseBody(int code, String errmsg, Object data) {
        this.code = code;
        this.data = data;
        this.errmsg = errmsg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}