import org.example.dao.UserRegisterDAO;
import org.example.service.RegisterService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class tesing
{
    private RegisterService registerSer;
    private UserRegisterDAO userRegDAO;

    @Test
    void testLogin() {
        String email = "muzamil@gmail.com";
        String password = "muzamil@1";
        assertTrue(registerSer.validateUser(email,password));
    }
}
