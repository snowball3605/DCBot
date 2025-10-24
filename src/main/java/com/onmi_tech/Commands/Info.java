package com.onmi_tech.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.time.LocalDate;

public class Info extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("info")) {
            LocalDate myObj = LocalDate.now();
            event.replyEmbeds(new EmbedBuilder().setColor(Color.BLUE).setTitle("Info " + event.getJDA().getSelfUser().getName()).setDescription("Creation： 24/10/2025\nServer Time: " + myObj).build()).queue();

        }
    }
}
