import { User } from "./User";

export class Session{
    id!:number;
    date!:Date;
    StartTime!: any;
    EndTime!: any;
    Participants!:Array<User>;
    conferanceLink!:string ;
    type!:TypeSession;
}
export enum TypeSession {
    Exam,
    Course
}