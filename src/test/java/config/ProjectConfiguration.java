package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class ProjectConfiguration {
    static WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
    static AuthConfig authconfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

    public void configure() {
        Configuration.baseUrl = webConfig.baseUrl();
        Configuration.browser = webConfig.browser();
        Configuration.browserVersion = webConfig.browserVersion();
        Configuration.browserSize = webConfig.browserSize();
        Configuration.pageLoadStrategy = "eager";
        String remoteUrl = "https://" + authconfig.login() + ":" + authconfig.password() + "@" + authconfig.remoteUrl() + "/wd/hub";
        if (webConfig.isRemote()) {
            Configuration.remote = remoteUrl;
            Configuration.pageLoadStrategy = "normal";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }
}