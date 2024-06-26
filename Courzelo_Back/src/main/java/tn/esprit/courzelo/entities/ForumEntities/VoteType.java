package tn.esprit.courzelo.entities.ForumEntities;

public enum VoteType {
    UPVOTE(1),
    NEUTRAL(0),
    DOWNVOTE(-1);

    private final int value;

    VoteType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}