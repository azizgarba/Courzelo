export class User{

    id!: number;
    firstName!: string;
    lastName!: string;
    email!: string;
    password!: string;
    image!: string;
    sexe!:string;
    dateOfBirth!:Date;
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
    approved = false;
    validVoteCount: number = 0;
    canVote : boolean = true;
    nbVoteForIncentives!:number;
    nbPrimeVoteForBadge!:number;
    PaymentDay!: Date;
    Hobbies!:string;
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
