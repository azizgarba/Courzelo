import { Module } from "./Module";
import {UserCourzelo } from "./UserCourzelo";

export class QuestionForum{

    id!:string;
    title!:string;
    description!:string;
    student!: UserCourzelo ;
    module!:Module ;
    date!:Date ;
    
    
}