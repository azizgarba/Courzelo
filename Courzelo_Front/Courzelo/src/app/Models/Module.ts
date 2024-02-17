import { EducationalProgram } from "./EducationalProgram";

export class Module{
    id!:number;
    name!:string;
    description!:string;
    totalNbHours!:number;
    Image!:string;
    coef!:number;
    program!:EducationalProgram;
    
}