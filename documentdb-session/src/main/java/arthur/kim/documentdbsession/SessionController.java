package arthur.kim.documentdbsession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SessionController {
    @GetMapping("/session")
    public String getSession(HttpSession httpSession) {
        return httpSession.getId();
    }
}
