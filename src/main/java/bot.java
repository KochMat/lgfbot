
import events.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class bot {

    public static JDA api;

    public static void main(String[] arguments) throws Exception {
        api = JDABuilder.createDefault("").enableIntents(GatewayIntent.GUILD_MEMBERS).setMemberCachePolicy(MemberCachePolicy.ALL).build();
        api.getPresence().setPresence(OnlineStatus.DO_NOT_DISTURB,Activity.playing("mit Feuer"));
        api.addEventListener(new laeuft());
        api.addEventListener(new r6());
        api.addEventListener(new role());
    }

}
