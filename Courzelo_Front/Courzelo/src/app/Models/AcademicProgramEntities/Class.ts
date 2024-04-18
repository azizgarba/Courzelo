import { Session } from "../SessionEntities/Session";
import { UserCourzelo } from "../UserCorzelo/UserCourzelo";

export class Class{
    id:number |undefined;
    name!:string;
    Schedule:Array<Session> | undefined;
    Students:Array<UserCourzelo> |undefined;
    
}