import com.seniorsteps.trainningcenter.model.Lab;
import java.util.Arrays;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class LabRestClient {

    private static final String restUrl = "http://localhost:8081/TrainningCenterMS2020/api/v1";
    private static final String serviceUrl = "/lab";

    private static HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }

    public static void getById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = restUrl + serviceUrl + "/getById/" + String.valueOf(id);

        HttpHeaders httpHeaders = getHeaders();
        HttpEntity<String> request = new HttpEntity<>(httpHeaders);
        ResponseEntity<Lab> response = restTemplate.exchange(url, HttpMethod.GET, request, Lab.class);
        Lab lab = response.getBody();
        if (lab != null) {
            System.out.println("Name: " + lab.getName());
        } else {
            System.out.println("Not Found");
        }
    }

    public static void getList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = restUrl + serviceUrl + "/getAll";

        HttpHeaders httpHeaders = getHeaders();
        HttpEntity<String> request = new HttpEntity<>(httpHeaders);
        ParameterizedTypeReference parameterizedTypeReference = new ParameterizedTypeReference<List<Lab>>() {
        };
        ResponseEntity<List<Lab>> response = restTemplate.exchange(url, HttpMethod.GET, request, parameterizedTypeReference);
        List<Lab> labs = response.getBody();
        if (labs != null) {
            for (Lab lab : labs) {
                System.out.println("Name:" + lab.getName());
            }
        } else {
            System.out.println("Not Found");
        }
    }

    public static void createLab(Lab lab) {
        RestTemplate restTemplate = new RestTemplate();
        String url = restUrl + serviceUrl + "/saveLab";
        HttpEntity<Object> request = new HttpEntity<Object>(lab, getHeaders());
        Lab added = restTemplate.postForObject(url, request, Lab.class);
        if (added != null) {
            System.out.println(added.getName());
        } else {
            System.out.println("Can\'t Be Added");
        }

    }

    private static void updateLab(int id, Lab lab) {
        RestTemplate restTemplate = new RestTemplate();
        String url = restUrl + serviceUrl + "/updateLab";
        HttpEntity<Object> request = new HttpEntity<Object>(lab, getHeaders());
        Lab added = restTemplate.postForObject(url, request, Lab.class);
        if (added != null) {

            System.out.println(lab.getName());
        } else {
            System.out.println("Can\'t Be Updated");
        }
    }

  

    private static void deleteLab(int id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = restUrl + serviceUrl + "/deleteLab";
        HttpEntity<String> request = new HttpEntity<>(getHeaders());

        ResponseEntity<Boolean> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, Boolean.class);

        Boolean deleted = responseEntity.getBody();
        System.out.println(deleted);

    }
    public static void main(String[] args) {

//        getById(11);
//        System.out.println("=================");
//        getList();
//        System.out.println("======================");
//
//        Lab lab = new Lab();
//        lab.setName("Added From Clientt");
//        lab.setCapacity(8888);
//        createLab(lab);
//        System.out.println("====================");
//        lab.setName("Ahmed Updated From Client Successfully");
//        updateLab(10, lab);
        System.out.println("=========================");
        deleteLab(19);
    }
}
