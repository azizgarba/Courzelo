
import { QuestionForum } from "../ForumEntities/QuestionForum";
import { EducationalProgram } from "./EducationalProgram";


export class Module{
    id!:string;
    name!:string;
    description!:string;
    nbHeurePerWeek!:number;
    nbHeureTotal!:number;
    Image!:string;
    coef!:number ;
    program!:EducationalProgram;

    questionForums:QuestionForum[]=[]

    
    
}