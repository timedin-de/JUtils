package de.timedin.jUtils.methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SuppressWarnings("unused")
public class Curl {
    private HttpURLConnection con;
    private boolean useDefaults = true;

    public Curl(String url) throws IOException {
        CurlSetup(new URL(url));
    }

    public Curl(URL url) throws IOException {
        CurlSetup(url);
    }

    public String getResponse() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    private void CurlSetup(URL url) throws IOException {
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(3000);
        con.setReadTimeout(3000);
        con.setInstanceFollowRedirects(true);
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
    }


    //Getter and Setter
    public void setRequestProperty(String key, String value) {
        con.setRequestProperty(key, value);
    }

    public String getRequestProperty(String key) {
        return con.getRequestProperty(key);
    }

    public boolean getUseDefaults() {
        return useDefaults;
    }

    public void setUseDefaults(Boolean useDefaults) {
        this.useDefaults = useDefaults;
    }

    public boolean isUsingProxy() {
        return con.usingProxy();
    }

    public Integer getResponseCode() throws IOException {
        return con.getResponseCode();
    }

    // TODO: 04.03.22 Not working
    protected void finalize() throws Throwable {
        super.finalize();
        con.disconnect();
    }
}