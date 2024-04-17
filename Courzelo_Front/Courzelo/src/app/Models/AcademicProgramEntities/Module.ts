
import { QuestionForum } from "../ForumEntities/QuestionForum";
import { Class } from "./Class";
import { EducationalProgram } from "./EducationalProgram";
import { Semestre } from "./Semestre";

export class Module{
    id!:string;
    name!:string;
    description!:string;
    nbHeurePerWeek!:number;
    nbHeureTotal!:number;
    Image!:string;
    couef!:number ;
    program!:EducationalProgram;
    semestre!:Semestre;
    questionForums:QuestionForum[]=[];
    classes: Class[] = [];
    
    
}