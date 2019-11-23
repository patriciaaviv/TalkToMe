package Azure;

import java.util.ArrayList;
import java.util.List;

public class Analytics {

    private String patientName;
    private int requests;
    private int overallSentiment;
    private List<String> logs;

    public Analytics(String name){
        patientName = name;
        requests = 0;
        overallSentiment = 0;
        logs = new ArrayList<>();
    }

    private String makeBody(String message){

        String body = "{\n" +
                "  \"documents\": [\n" +
                "    {\n" +
                "      \"language\": \"en\",\n" +
                "      \"id\": \"1\",\n" +
                "      \"text\": \"" + message + "\"\n" +
                "    }]\n" +
                "}";

        return body;

    }

    public void analyseRequest(String message, String kind){

        String body = makeBody(message);

        logs.add(body);
        overallSentiment *= requests;

        requests ++;

        String value = AzureRequest.request(body, kind);

        String currentScore = value.substring(value.indexOf("0."),value.indexOf("}"));

        overallSentiment += Double.parseDouble(currentScore) / requests;

    }

    public int getOverallSentiment() {
        return overallSentiment;
    }

    public List<String> getLogs() {
        return logs;
    }

    /*
    public static void main(String[] args) {
        Analytics a = new Analytics("FIRST");
        a.analyseRequest("{\n" +
                "  \"documents\": [\n" +
                "    {\n" +
                "      \"language\": \"en\",\n" +
                "      \"id\": \"1\",\n" +
                "      \"text\": \"Microsoft released Windows 10\"\n" +
                "    }]\n" +
                "}", "sentiment");
    }
*/

}
