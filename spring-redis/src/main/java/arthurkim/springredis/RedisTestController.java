package arthurkim.springredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisTestController {

    @Autowired
    private RedisTestService redisTestService;

    @GetMapping("/string")
    public String getRedisTestService(String key) {
        return redisTestService.getRedisStringValue(key);
    }

    @PostMapping("/string")
    public void setRedisTestService(String key, String value) {
        redisTestService.setRedisStringValue(key, value);
    }
}
