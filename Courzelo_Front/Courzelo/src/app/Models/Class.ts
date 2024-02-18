import { Session } from "./Session";
import { User } from "./UserCourzelo";

export class Class{
    id!:number;
    name!:string;
    Schedule!:Array<Session>;
    Students!:Array<User>;
    
}