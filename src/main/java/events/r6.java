package events;


import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;


public class r6 extends ListenerAdapter {
    public void onGuildVoiceUpdate(@Nonnull GuildVoiceUpdateEvent event) {
        if (Objects.requireNonNull(event.getChannelJoined()).getIdLong() == 862346567062519818L) {

            Objects.requireNonNull(event.getChannelJoined().getParent()).createVoiceChannel("R6[TEMP]").setUserlimit(5)
                    .queue(channel -> event.getGuild().moveVoiceMember( event.getMember(), channel).queue());

        }


        if (!event.getGuild().getVoiceChannelsByName("R6[TEMP]", false).isEmpty()){
            List<VoiceChannel> voice = event.getGuild().getVoiceChannelsByName("R6[TEMP]",false);
            for(int i = voice.size(); i > 0; i--){
                if(voice.get(i-1).getMembers().isEmpty()){
                    voice.get(i-1).delete().queue();
                }
            }
        }
    }
    public void onGuildVoiceLeave(@Nonnull GuildVoiceLeaveEvent event){
        if (!event.getGuild().getVoiceChannelsByName("R6[TEMP]", false).isEmpty()) {
            List<VoiceChannel> voice = event.getGuild().getVoiceChannelsByName("R6[TEMP]", false);
            for (int i = voice.size(); i > 0; i--) {
                if (voice.get(i - 1).getMembers().isEmpty()) {
                    voice.get(i - 1).delete().queue();
                }
            }
        }
   }
}