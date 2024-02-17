export class Project{
    id!:number;
    name!:string;
    description!:string;
    difficulty!: Difficulty;
    requirement!:string;

}
export enum Difficulty{
    Hard,
    Easy,
    Medium
}