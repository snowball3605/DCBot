package com.onmi_tech.Commands;

import com.onmi_tech.Main;
import com.onmi_tech.Util.LanguageManager;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Reload extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("reload")) {
            boolean t = true;
            List<Long> s = (List<Long>) Main.data.get("Owner_Discord_ID");

            for(Long id : s){
                if(event.getMember().getUser().getIdLong() == id){
                    try {
                        reload();
                        event.reply(LanguageManager.get("Reload.success").toString()).queue();
                        t = false;
                        break;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            if(t){
                event.reply(LanguageManager.get("Reload.no_permission").toString()).queue();
            }

        }
    }

    public void reload() throws IOException {
        InputStream in = Files.newInputStream(Paths.get("SETTING.yml"));
        Yaml yaml = new Yaml();
        Main.data = yaml.load(in);
        Main.language = Main.data.get("lang").toString();
    }
}
