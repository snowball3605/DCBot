package com.onmi_tech;

import com.onmi_tech.Commands.Info;
import com.onmi_tech.Event.Dynamic_Voice;
import com.onmi_tech.Event.Join_Leave;
import net.dv8tion.jda.api.events.guild.UnavailableGuildJoinedEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberUpdateEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.thread.member.ThreadMemberJoinEvent;
import net.dv8tion.jda.api.events.thread.member.ThreadMemberLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


public class Listener extends ListenerAdapter {
    Info info = new Info();
    Join_Leave join_leave = new Join_Leave();
    Dynamic_Voice dynamic_voice = new Dynamic_Voice();
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        Main.sn_logger.info("Loaded Slash Command");
        info.onSlashCommandInteraction(event);
    }

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        Main.sn_logger.log(LogLevel.INFO, "Loaded Guild Member Join");
        join_leave.onGuildMemberJoin(event);
    }

    @Override
    public void onGuildVoiceUpdate(@NotNull GuildVoiceUpdateEvent event) {
        dynamic_voice.onGuildVoiceUpdate(event);
    }
}
