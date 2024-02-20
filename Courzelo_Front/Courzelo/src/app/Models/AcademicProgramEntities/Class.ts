import { Session } from "../SessionEntities/Session";
import { UserCourzelo } from "../UserCorzelo/UserCourzelo";

export class Class{
    id!:number;
    name!:string;
    Schedule!:Array<Session>;
    Students!:Array<UserCourzelo>;
    
}