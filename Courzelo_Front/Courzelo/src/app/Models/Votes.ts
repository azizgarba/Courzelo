export class Vote{
    id!:number;
    type!:TypeVote;
}

export enum TypeVote{
    upvote = 1,
    downvote = -1
}