package tn.esprit.courzelo.Services.ForumService;

public class ChatNotFoundException extends Throwable {
    public ChatNotFoundException() {
        super("Chat not found");
    }


}
