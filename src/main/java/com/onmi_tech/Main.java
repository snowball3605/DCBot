package com.onmi_tech;

import com.onmi_tech.Util.LoggerManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Map;
import java.util.logging.Level;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Map<String, Object> data;
    public static String language = "en_UK";

    public static LocalDate my_obj = LocalDate.now();
    static void main() {
        try (InputStream in = Files.newInputStream(Paths.get("SETTING.yml"))) {
            Yaml yaml = new Yaml();
            data = yaml.load(in);
            language = data.get("lang").toString();
            JDA builder = JDABuilder.createDefault(data.get("TOKEN").toString())
            .enableIntents(GatewayIntent.GUILD_PRESENCES,  GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MESSAGE_REACTIONS, GatewayIntent.GUILD_MEMBERS)
            .addEventListeners(new Listener())
            .build();

            CommandListUpdateAction commands = builder.updateCommands();

            commands.addCommands(
                    Commands.slash("info", "info about bot"),
                    Commands.slash("reload", "Reload the settig")
            );

            commands.queue();
            LoggerManager.status(data.get("Logger.bot.running").toString(), LogLevel.INFO);
        } catch (IOException e) {
            LoggerManager.status(e.getMessage(), LogLevel.ERROR);
        }
    }
}
