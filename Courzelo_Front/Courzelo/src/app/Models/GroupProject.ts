import { Project } from "./Project";
import { User } from "./UserCourzelo";

export class GroupProject{
    id!:number;
    name!:string;
    Students!:Array<User>;
    project!:Project;
}