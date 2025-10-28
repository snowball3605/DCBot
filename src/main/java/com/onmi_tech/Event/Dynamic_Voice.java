package com.onmi_tech.Event;

import com.onmi_tech.Main;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Dynamic_Voice extends ListenerAdapter {

    @Override
    public void onGuildVoiceUpdate(@NotNull GuildVoiceUpdateEvent event) {

        List<String> id = (List<String>) Main.data.get("Dynamic_Voice_ID");

        for (String s : id) {
            String[] split = s.split("-");
            Long channel_id = Long.parseLong(split[0]);
            Long classification_id = Long.parseLong(split[1]);

            if (event.getChannelLeft() != null) {
                if (event.getChannelLeft().getParentCategoryIdLong() == classification_id && event.getChannelLeft().getMembers().isEmpty() && !(event.getChannelLeft().getIdLong() == channel_id)) {
                    event.getChannelLeft().delete().queue();
                }
            }
            if (event.getChannelJoined() != null) {
                if (event.getChannelJoined().getIdLong() == channel_id) {
                    String channel_name = Main.data.get("Dynamic_Voice_Name").toString();
                    channel_name = channel_name.replace("%Voice_Name%", event.getMember().getUser().getEffectiveName());
                    event.getJDA().getCategoryById(classification_id).createVoiceChannel(channel_name).queue(k -> {
                        Guild guild = event.getGuild();
                        guild.moveVoiceMember(event.getMember(), k).queue();
                    });
                }
            }
        }


    }
}
