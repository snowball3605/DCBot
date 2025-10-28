package com.onmi_tech.Commands;

import com.onmi_tech.Main;
import com.onmi_tech.Util.LanguageManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;

import static com.onmi_tech.Main.my_obj;

public class Info extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("info")) {
            String s = LanguageManager.get("Info.message.Created").replace("%created_data%", "24/10/2025");
            String t = LanguageManager.get("Info.message.Server_Time").replace("%server_time%", String.valueOf(my_obj));
            event.replyEmbeds(new EmbedBuilder().setColor(Color.BLUE).setTitle(LanguageManager.get("Info.message") + " " + event.getJDA().getSelfUser().getName()).setDescription(s + "\n" + t).build()).queue();
            // wtf
        }
    }
}
