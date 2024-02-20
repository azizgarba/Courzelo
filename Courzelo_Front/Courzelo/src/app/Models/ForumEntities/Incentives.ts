export class Incentives{
    id!:number;
    dateOfObtaining!:Date;
    DeliberationDate!:Date;
    type!:IncentiveType;
}
export enum IncentiveType{
    IncentiveExplanation,
    IncentiveVote
}