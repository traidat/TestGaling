import org.thingsboard.rest.client.RestClient;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.security.DeviceCredentials;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

public class MQTTTest {

    public static String[] createDevices(int numberOfDevice) {
//        String [] listID = new String[numberOfDevice];
//        RestClient restClient = new RestClient("http://10.240.177.70:8080");
//
//        restClient.login("truong@viettel.com.vn", "123456");
//        for (int i = 0; i < numberOfDevice; i++) {
//            Device device = restClient.createDevice("Device: " + UUID.randomUUID(), "Truong");
//            DeviceCredentials deviceCredentials = restClient.getCredentials(device.getId());
//            listID[i] = deviceCredentials.getCredentialsId();
//            System.out.printf("Total device created: %d\n", i +1);
//        }
//        return listID;

        String [] listID = new String[numberOfDevice];
        int i = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("device.csv"))) {
            String line;
            while ((line = br.readLine()) != null && i < numberOfDevice) {
                listID[i] = line;
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listID;
    }
}
