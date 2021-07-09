package events;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class laeuft  extends ListenerAdapter {
    public void onMessageReceived(@Nonnull MessageReceivedEvent event){
        Message message = event.getMessage();
        String content = message.getContentRaw();
        if (content.equals("läuft er?")){
            MessageChannel channel = event.getChannel();
            channel.sendMessage("https://tenor.com/view/das-boot-l%c3%a4uft-motor-tuning-reparatur-schrauber-gif-16436108").queue();
        }
    }
}
