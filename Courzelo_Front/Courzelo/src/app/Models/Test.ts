import { QuestionTest } from "./QuestionTest";
import { User } from "./User";

export class Test{
    id!:number;
    name!:string;
    description!:string;
    grade!:number;
    rank!: number;
    date!:Date;
    duration!:number;
    Questions!:Array<QuestionTest>;
    type!:TestType;
    Teacher!:User;
}
export enum TestType{
    FinalTest,
    QuizTest,
    RevisionTest
}