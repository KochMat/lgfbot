package events;

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.Objects;


public class role extends ListenerAdapter {
    public void onGuildMemberJoin(@Nonnull GuildMemberJoinEvent event){
        event.getGuild().addRoleToMember(event.getMember(), Objects.requireNonNull(event.getGuild().getRoleById(859161321076555776L))).queue();
        Objects.requireNonNull(event.getGuild().getTextChannelById(862331304142045205L)).sendMessage(event.getMember().getEffectiveName() + " ist gejoint").queue();
        Objects.requireNonNull(event.getGuild().getVoiceChannelById(862716129608204328L)).getManager().setName(event.getGuild().getMemberCount() + " sitzen um's Feuer").queue();


    }
    public void onGuildMemberRemove(@Nonnull GuildMemberRemoveEvent event){
        Objects.requireNonNull(event.getGuild().getTextChannelById(862331304142045205L)).sendMessage(event.getMember().getEffectiveName()+ " ist geleavt").queue();
        Objects.requireNonNull(event.getGuild().getVoiceChannelById(862716129608204328L)).getManager().setName(event.getGuild().getMemberCount() + " sitzen um's Feuer").queue();
        }
}
