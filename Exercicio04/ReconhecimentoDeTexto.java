import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ReconhecimentoDeTexto 
{
    public static void main(String[] args) 
    {
        HttpClient httpclient = HttpClients.createDefault();

        try
        {
            URIBuilder builder = new URIBuilder("https://westcentralus.cognitiveservices.azure.com/text/analytics/v2.0/languages");


            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "f9ef9a04c66348faa85928e90c022d10");

            StringEntity reqEntity = new StringEntity("{\r\n" + //
                                "\r\n" + //
                                "  \"documents\": [\r\n" + //
                                "\r\n" + //
                                "    {\r\n" + //
                                "\r\n" + //
                                "      \"id\": \"1\",\r\n" + //
                                "\r\n" + //
                                "      \"text\": \"Hello world\"\r\n" + //
                                "\r\n" + //
                                "    },\r\n" + //
                                "\r\n" + //
                                "    {\r\n" + //
                                "\r\n" + //
                                "      \"id\": \"2\",\r\n" + //
                                "\r\n" + //
                                "      \"text\": \"Je ne sais pas parler français\"\r\n" + //
                                "\r\n" + //
                                "    },\r\n" + //
                                "\r\n" + //
                                "    {\r\n" + //
                                "\r\n" + //
                                "      \"id\": \"3\",\r\n" + //
                                "\r\n" + //
                                "      \"text\": \"Ola esse foi meu exercicio quatro\"\r\n" + //
                                "\r\n" + //
                                "    },\r\n" + //
                                "\r\n" + //
                                "    {\r\n" + //
                                "\r\n" + //
                                "      \"id\": \"4\",\r\n" + //
                                "\r\n" + //
                                "      \"text\": \"من بلد نیستم فرانسوی صحبت کنم\"\r\n" + //
                                "\r\n" + //
                                "    },\r\n" + //
                                "\r\n" + //
                                "  ]\r\n" + //
                                "\r\n" + //
                                "}");
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) 
            {
                System.out.println(EntityUtils.toString(entity));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
