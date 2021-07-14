package les22.retrofit;

import les22.retrofit.pojo.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import retrofit2.Response;

import java.io.IOException;

@SpringBootTest
class ApiHelperApplicationTests {

    private Register register = new Register("eve.holt@reqres.in", "pistol");

    @Test
    public void getUserTest() throws IOException {
        Response<Account> response;
        APIInterface client = APIClientHelper.getClient().create(APIInterface.class);
        response = client.getUserById().execute();

        Assert.isTrue(response.isSuccessful(), "Status should be 200");
        Assert.isTrue(response.body().getData().getEmail().equals("janet.weaver@reqres.in"), "Email is not as expected");
    }

    @Test
    public void getResourceTest() throws IOException{
        Response<Resource> response;
        APIInterface client = APIClientHelper.getClient().create(APIInterface.class);
        response = client.getResource().execute();

        Assert.isTrue(response.isSuccessful(), "Status should be 200");
        Assert.isTrue(response.body().getData().getName().equals("fuchsia rose"), "Resource name is not as expected");
        Assert.isTrue(response.body().getSupport().getText().equals("To keep ReqRes free, contributions towards server costs are appreciated!"), "Text is not as expected");
    }

    @Test
    public void registerTest() throws IOException{
        Response<RegisterOut> response;
        APIInterface client = APIClientHelper.getClient().create(APIInterface.class);
        response = client.register(register).execute();

        Assert.isTrue(response.isSuccessful(), "Status should be 200");
        Assert.isTrue(response.body().getId().equals(4), "Id is not as expected");
        Assert.isTrue(response.body().getToken().equals("QpwL5tke4Pnpja7X4"), "Token is not correct");
    }

    @Test
    public void loginTest() throws IOException {
        Response<LoginOut> response;
        APIInterface client = APIClientHelper.getClient().create(APIInterface.class);
        response = client.login(register).execute();

        Assert.isTrue(response.isSuccessful(), "Status should be 200");
    }
}
