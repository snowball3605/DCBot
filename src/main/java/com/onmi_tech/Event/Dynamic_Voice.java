package com.onmi_tech.Event;

import com.onmi_tech.Main;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Dynamic_Voice extends ListenerAdapter {
    @Override
    public void onGuildVoiceUpdate(@NotNull GuildVoiceUpdateEvent event) {
        Main.sn_logger.info("onGuildVoiceUpdate");
    }
}
