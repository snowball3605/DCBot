package com.onmi_tech;

import com.onmi_tech.Commands.Info;
import com.onmi_tech.Commands.Reload;
import com.onmi_tech.Event.Dynamic_Voice;
import com.onmi_tech.Event.Join_Leave;
import com.onmi_tech.Util.LoggerManager;
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
    Reload reload = new Reload();
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String message = Main.data.get("Logger.bot.commands").toString();
        message = message.replace("%commands%", event.getName());
        LoggerManager.status(event.getName() + " " + message, LogLevel.INFO);
        reload.onSlashCommandInteraction(event);
        info.onSlashCommandInteraction(event);
    }

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        LoggerManager.status(Main.data.get("Logger.guild.member.join").toString(), LogLevel.INFO);
        join_leave.onGuildMemberJoin(event);
    }

    @Override
    public void onGuildVoiceUpdate(@NotNull GuildVoiceUpdateEvent event) {
        LoggerManager.status(Main.data.get("Logger.guild.voice.update").toString(), LogLevel.INFO);
        dynamic_voice.onGuildVoiceUpdate(event);
    }
}
