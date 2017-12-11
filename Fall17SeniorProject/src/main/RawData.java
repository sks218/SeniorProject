package main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;
import java.util.Base64;

/**
 * Contains structures and methods for accessing JSON encoded energy data from
 * metered buildings at Lehigh, specifically residence halls.
 *
 * @author willt
 * @version Sep 29, 2017
 */
public class RawData
{
    private String                  username;
    private String                  password;


    /**
     * constructor our plan is to have a lehigh account made for this app to
     * use, rather than our own lehigh login
     *
     * @param user
     *            a lehigh id
     * @param pass
     *            a lehigh password
     */
    public RawData(String user, String pass)
    {
        username = user;
        password = pass;
    }


    /**
     * Access the metered data for a specific building
     *
     * @param building
     *            the name of the building, case sensitive
     * @return all the data from pi web api, specifically shark meters on
     *         certain buildings
     */
    public String requestBdg(String building)
    {
        try
        {
            // Avoid SSLHandshakeException by telling client to trust
            // certificates
            TrustManager[] trustAllCerts =
                new TrustManager[] { new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers()
                    {
                        return null;
                    }


                    public void checkClientTrusted(
                        X509Certificate[] certs,
                        String authType)
                    {
                        return;
                    }


                    public void checkServerTrusted(
                        X509Certificate[] certs,
                        String authType)
                    {
                        return;
                    }
                } };
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection
                .setDefaultSSLSocketFactory(sc.getSocketFactory());
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session)
                {
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
            // Make the request, including auth and building-specific url
            String buildingURL = Sources.url_list.get(building);
            String authCode = username + ":" + password;
            URL url = new URL(buildingURL);
            String encoding =
                Base64.getEncoder().encodeToString(authCode.getBytes("UTF-8"));

            HttpURLConnection connection =
                (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            connection.setRequestProperty("Accept", "application/json");
            InputStream content = connection.getInputStream();
            // Read whatever the server has returned
            BufferedReader in =
                new BufferedReader(new InputStreamReader(content));
            String result = in.readLine();
            connection.disconnect();
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Could not get data. Read errors for info.");
            return null;
        }
    }
}
