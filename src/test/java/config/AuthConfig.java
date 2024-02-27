package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:auth.properties"
})

public interface AuthConfig extends Config {
    String login();

    String password();


    String remoteUrl();
}