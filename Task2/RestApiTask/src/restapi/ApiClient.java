package restapi;

import java.io.BufferedReader;
import java.io.FileReader;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApiClient {

    public static void main(String[] args) {

        try {
            // Read local JSON file
            BufferedReader br = new BufferedReader(new FileReader("users.json"));
            StringBuilder jsonData = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                jsonData.append(line);
            }
            br.close();

            // Parse JSON
            JSONArray users = new JSONArray(jsonData.toString());

            System.out.println("USER DATA (OFFLINE JSON)\n");

            for (int i = 0; i < users.length(); i++) {
                JSONObject user = users.getJSONObject(i);

                System.out.println("ID    : " + user.getInt("id"));
                System.out.println("Name  : " + user.getString("name"));
                System.out.println("Email : " + user.getString("email"));
                System.out.println("City  : " +
                        user.getJSONObject("address").getString("city"));
                System.out.println("--------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
