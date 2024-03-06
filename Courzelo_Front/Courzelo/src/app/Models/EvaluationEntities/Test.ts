import { UserCourzelo } from "../UserCorzelo/UserCourzelo";
import { QuestionTest } from "./QuestionTest";

export class Test {
  id!: number;
  name!: string;
  description!: string;
  grade!: number;
  rank!: number;
  date!: Date;
  duration!: number;
  Questions!: Array<QuestionTest>;
  type!: TestType;
  Teacher!: UserCourzelo;
}
export enum TestType {
  FinalTest,
  QuizTest,
  RevisionTest,
}
