import { QuestionForum } from "../ForumEntities/QuestionForum";



export class UserCourzelo{

    id: string |undefined;    
    firstName!: string;
    lastName!: string;
    email!: string;
    password!: string;
    image!: string;
    sexe!:string;
    dateOfBirth:Date |undefined;
    dateOfCreation:Date | undefined;
    nbHoursMaxPerWeek!:number;
    nbHoursPerWeek = 0;
    role!:Role;
    companyName!:string;
    descriptionRecruiter!:string;
    scoreXp!:number;
    //resume!:
    level!:number;
    overAllAverage!:number;
    speciality!:Speciality;
    approved:boolean = false;
    validVoteCount: number = 0;
    canVote : boolean = true;
    nbVoteForIncentives!:number;
    nbPrimeVoteForBadge!:number;
    PaymentDay: Date |undefined;
    Hobbies!:string;
   
    questionForums:QuestionForum[]=[]

}
export enum Role{
   Teacher,
   Student,
   Moderator,
   Admin,
   Recruiter
}
export enum Speciality{
    DB,
    Angular,
    Spring,
    DotNet,
    Reseau
}
