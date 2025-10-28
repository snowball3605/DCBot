package com.onmi_tech.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.time.LocalDate;

import static com.onmi_tech.Main.my_obj;
import static com.onmi_tech.Main.sn_logger;

public class Info extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("info")) {
            event.replyEmbeds(new EmbedBuilder().setColor(Color.BLUE).setTitle("Info " + event.getJDA().getSelfUser().getName()).setDescription("Creation： 24/10/2025\nServer Time: " + my_obj).build()).queue();
            sn_logger.info("info command ran");
            // wtf
        }
    }
}
