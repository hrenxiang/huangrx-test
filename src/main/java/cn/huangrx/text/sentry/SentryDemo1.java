package cn.huangrx.text.sentry;

import io.sentry.Sentry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangrx
 * @date 2023/4/2 23:55
 */
@Slf4j
@RestController
public class SentryDemo1 {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public void get() {
        try {
            throw new Exception("This is a test.");
        } catch (Exception e) {
            Sentry.captureException(e);
        }
    }

    @RequestMapping(value = "/sentry/get", method = RequestMethod.GET)
    public void get2() {
        try {
            throw new Exception("This is test2.");
        } catch (Exception e) {
            Sentry.captureException(e);
        }
    }

}
