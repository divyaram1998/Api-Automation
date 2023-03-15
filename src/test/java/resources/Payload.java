package resources;

import java.util.HashMap;
import java.util.Map;

public class Payload {
    public static Map<String, String> getAccessTokenBody(String username, String password) throws IllegalArgumentException {

        Map<String, String> payloadMap = new HashMap<>();
        payloadMap.put("username", username);
        payloadMap.put("password", password);
        payloadMap.put("grant_type", "password");
        payloadMap.put("provider", "other");
        payloadMap.put("clientId", "gaian");
        payloadMap.put("checkB2B", "true");
        payloadMap.put("tenantId", "618b6fdef5dacc0001a6b1b0");
        payloadMap.put("productId", "604789eb42b7dc00017a8341");
        return payloadMap;

    }
    public static String CreateConfigID()
    {
        String CreateConfigID= "{\n" +
                "    \"data\": {\n" +
                "        \"AUTH_TOKEN\": \"81dc373045d3608dfdcffaab9aea9673\",\n" +
                "        \"FROM_NUMBER\": \"+12764962687\",\n" +
                "        \"SID\": \"ACb0bf0779f36c1ab40256f1f956f809c0\",\n" +
                "        \"max_sms_per_request\": \"10\"\n" +
                "    },\n" +
                "    \"engagementType\": \"SMS\",\n" +
                "    \"providerId\": \"com.gaian.voxa.ri.twillo.ProviderImpl\"\n" +
                "}";
        return CreateConfigID;

    }
}
