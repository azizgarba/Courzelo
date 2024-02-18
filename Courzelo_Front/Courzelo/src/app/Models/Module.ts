import { EducationalProgram } from "./EducationalProgram";
import { QuestionForum } from "./QuestionForum";

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