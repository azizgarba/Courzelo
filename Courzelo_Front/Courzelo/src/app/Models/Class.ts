import { Session } from "./Session";
import { User } from "./User";

export class Class{
    id!:number;
    name!:string;
    Schedule!:Array<Session>;
    Students!:Array<User>;
    
}