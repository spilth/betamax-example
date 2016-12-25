package spilth.org;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddressFinder {
    public String getIpAddress() {
        String url = "https://api.ipify.org";

        HttpClient client =  HttpClients.createSystem();
        HttpGet request = new HttpGet(url);
        try {
            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                BufferedReader rd = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));

                StringBuilder result = new StringBuilder();
                String line;
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }

                return result.toString();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
