package events;


import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.Objects;


public class r6 extends ListenerAdapter {
    public void onGuildVoiceUpdate(@Nonnull GuildVoiceUpdateEvent event) {
        if (Objects.requireNonNull(event.getChannelJoined()).getIdLong() == 862346567062519818L) {

            Objects.requireNonNull(event.getChannelJoined().getParent()).createVoiceChannel("R6[TEMP]").setUserlimit(5)
                    .queue(channel -> event.getGuild().moveVoiceMember( event.getMember(), channel).queue());

        }

        if (Objects.requireNonNull(event.getChannelLeft()).getName().equals("R6[TEMP]") && event.getChannelLeft().getMembers().isEmpty()) {

            event.getChannelLeft().delete().queue();

        }
    }
    public void onGuildVoiceLeave(@Nonnull GuildVoiceLeaveEvent event){
       if (event.getChannelLeft().getName().equals("R6[TEMP]") && event.getChannelLeft().getMembers().isEmpty()) {

            event.getChannelLeft().delete().queue();

       }
   }
}