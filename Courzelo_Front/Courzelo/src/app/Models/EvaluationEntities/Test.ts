import { QuestionTest } from "./QuestionTest";
import { UserCourzelo } from "../UserCorzelo/UserCourzelo";

export class Test{
    id!:string;
    name!:string;
    description!:string;
    grade!:number;
    rank!: number;
    date!:Date;
    duration!:number;
    questions!:Array<QuestionTest>;
    type!:TestType;
    teacher!:UserCourzelo;
}
export enum TestType{
    QuizTest = 'QuizTest',
    FinalTest = 'FinalTest',
    RevisionTest ='RevisionTest'
}