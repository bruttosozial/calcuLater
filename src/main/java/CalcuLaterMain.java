import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;
import reactor.core.publisher.Mono;

public class CalcuLaterMain {
    public static void main (String[] args) {
        DiscordClient client1 = DiscordClient.create("OTM3Nzc1NDIyMzA3OTYyOTIx.Yfgpaw.i7P1mI6zslhBRROdAHFU2REEsOk");

        Mono<Void> login = client1.withGateway((GatewayDiscordClient gateway) ->
                gateway.on(MessageCreateEvent.class, event -> {
                    Message message = event.getMessage();
                    User messageSentUser = message.getAuthor().get();
                    System.out.println(messageSentUser.getUsername());

                    return Mono.empty();
                }));

        login.block();
    }
}
