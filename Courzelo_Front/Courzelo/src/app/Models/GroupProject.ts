import { Project } from "./Project";
import { User } from "./User";

export class GroupProject{
    id!:number;
    name!:string;
    Students!:Array<User>;
    project!:Project;
}