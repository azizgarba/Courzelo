import { UserCourzelo } from "../UserCorzelo/UserCourzelo";


export class Session{
    id!:number;
    date!:Date;
    StartTime!: any;
    EndTime!: any;
    Participants!:Array<UserCourzelo>;
    conferanceLink!:string ;
    type!:TypeSession;
}
export enum TypeSession {
    Exam,
    Course
}