package com.onmi_tech;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Map<String, Object> data;
    public static SNLogger sn_logger;
    public static LocalDate my_obj = LocalDate.now();
    static void main() {
        sn_logger = new SNLogger(LogLevel.DEBUG);

        try (InputStream in = Files.newInputStream(Paths.get("SETTING.yml"))) {
            Yaml yaml = new Yaml();
            data = yaml.load(in);

            JDABuilder builder = JDABuilder.createDefault(data.get("TOKEN").toString());
            builder.enableIntents(GatewayIntent.GUILD_PRESENCES,  GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MESSAGE_REACTIONS, GatewayIntent.GUILD_MEMBERS);
            builder.addEventListeners(new Listener());
            builder.build();

            sn_logger.log(LogLevel.INFO, "running bot");
        } catch (IOException e) {
            sn_logger.log(LogLevel.ERROR, e.getMessage());
        }
    }
}
