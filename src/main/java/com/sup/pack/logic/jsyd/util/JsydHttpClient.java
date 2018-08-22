package com.sup.pack.logic.jsyd.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

/**
 * @author yangyiqiang
 */
public class JsydHttpClient {
    public static final String CHARACTER_ENCODING_GBK = "GBK";

    public static String postRequest(String url, String requestData) throws IOException {
        return postRequest(url, requestData.getBytes(CHARACTER_ENCODING_GBK), null);
    }

    public static String postRequest(String url, byte[] requestData, Properties requestProperties) throws IOException {
        HttpURLConnection httpConn = null;
        StringBuffer sBuffer = new StringBuffer("");
        try {
            httpConn = (HttpURLConnection) new URL(url).openConnection();
            // 封住包体
            if (requestProperties != null) {
            }
            String length = "0";
            if (requestData != null) {
                length = Integer.toString(requestData.length);
            }
            httpConn.setConnectTimeout(15000);
            httpConn.setRequestMethod("POST");
            httpConn.setRequestProperty("Content-type", "application/json;charset="+CHARACTER_ENCODING_GBK);
            httpConn.setRequestProperty("Connection", "close");
            httpConn.setRequestProperty("Content-Length", length);
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);
            OutputStream outStream = httpConn.getOutputStream();
            outStream.write(requestData);
            outStream.flush();
            outStream.close();
            BufferedReader in = null;
            String inputLine = null;
            in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), CHARACTER_ENCODING_GBK));
            while ((inputLine = in.readLine()) != null) {
                sBuffer.append(inputLine);
            }

            in.close();

        } catch (IOException e) {
            throw e;
        } finally {
            if (httpConn != null) {
                httpConn.disconnect();
                httpConn = null;
            }
        }

        return sBuffer.toString();
    }

}