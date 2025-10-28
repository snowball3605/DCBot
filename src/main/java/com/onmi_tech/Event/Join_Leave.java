package com.onmi_tech.Event;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import org.jetbrains.annotations.NotNull;
import com.onmi_tech.Main;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.thread.member.ThreadMemberJoinEvent;
import net.dv8tion.jda.api.events.thread.member.ThreadMemberLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;


public class Join_Leave extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        TextChannel text_channel = event.getGuild().getTextChannelById(Long.parseLong((String) Main.data.get("JOIN_CHANNEL")));
        text_channel.sendMessageEmbeds(
                new EmbedBuilder().setImage(event.getMember().getEffectiveAvatarUrl()).setColor(Color.BLUE).setTitle("Join Channel").setDescription("Welcome " + event.getMember().getUser().getName()+"\nJoined Time: " + Main.my_obj).build()
        ).queue();
    }

}
