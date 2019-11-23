package Azure;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URI;

public class AzureRequest {

    public static String request(String body, String kind)
    {
        HttpClient httpclient = HttpClients.createDefault();

        try
        {
            URIBuilder builder = null;
            if(kind.equals("sentiment") || kind.equals("keyPhrases") || kind.equals("entities")) {
                builder = new URIBuilder("https://westeurope.api.cognitive.microsoft.com/text/analytics/v2.0/" + kind);

            } else {
                System.out.println("NOPE");
            }

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "6657fb6f819b4665bb450b230b8e3c54");


            // Request body
            StringEntity reqEntity = new StringEntity(body);
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null)
            {
                //System.out.println(EntityUtils.toString(entity));
                return EntityUtils.toString(entity);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return "UPSI";
    }

}
