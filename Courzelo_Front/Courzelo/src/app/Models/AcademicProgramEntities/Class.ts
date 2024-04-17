import { Session } from "../SessionEntities/Session";
import { UserCourzelo } from "../UserCorzelo/UserCourzelo";
import { Level } from "./Level";

export class Class{
    id!:number;
    name!:string;
    level!: Level; 
    Schedule!:Array<Session>;
    Students!:Array<UserCourzelo>;
    
}