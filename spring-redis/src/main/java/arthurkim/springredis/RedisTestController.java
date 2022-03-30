package arthurkim.springredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/redis")
public class RedisTestController {

    @Autowired
    private RedisTestService redisTestService;

    @GetMapping("/string")
    public String getRedisTestService(HttpSession session, String key) {
        return session.getId() + " : " + redisTestService.getRedisStringValue(key);
    }

    @PostMapping("/string")
    public void setRedisTestService(String key, String value) {
        redisTestService.setRedisStringValue(key, value);
    }

    @GetMapping("/session")
    public String getRedisTestService(HttpSession session) {
        return session.getId() + " : " + session.getAttribute("key-001");
    }

    @PostMapping("/session")
    public void setRedisTestService(HttpSession session, String value) {
        session.setAttribute("key-001", value);
    }

}
