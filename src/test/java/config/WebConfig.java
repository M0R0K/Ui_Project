package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})
public interface WebConfig extends Config {

    @DefaultValue("chrome")
    String browser();


    @DefaultValue("100.0")
    String browserVersion();


    @DefaultValue("1920x1080")
    String browserSize();


    boolean isRemote();

    
    @DefaultValue("https://ptici.info")
    String baseUrl();
}