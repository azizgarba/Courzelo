import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { QuestionComponent } from "./Components/Forum/question/question.component";
import { AnswerComponent } from "./Components/Forum/answer/answer.component";
import { ChatComponent } from "./Components/Forum/chat/chat.component";
import { IncentivesComponent } from "./Components/Forum/incentives/incentives.component";
import { AcceuilPrimComponent } from "./Components/Forum/acceuil-prim/acceuil-prim.component";
import { ChartComponentComponent } from "./Components/Forum/chart-component/chart-component.component";
import { HomeComponent } from "./home/home.component";
import { RegisterComponent } from "./register/register.component";
import { ProfileComponent } from "./profile/profile.component";
import { LoginComponent } from "./login/login.component";
import { BoardAdminComponent } from "./board-admin/board-admin.component";

import { AddTestComponent } from "./components/EvaluationComponent/add-test/add-test.component";
import { AddQuestionComponent } from "./components/EvaluationComponent/add-question/add-question.component";
import { AllTestsComponent } from "./components/EvaluationComponent/all-tests/all-tests.component";
import { EditTestComponent } from "src/app/Components/EvaluationComponent/edit-test/edit-test.component";
import { AllModulesComponent } from "src/app/Components/EvaluationComponent/all-modules/all-modules.component";
import { TestOptionsDialogComponent } from "src/app/Components/EvaluationComponent/test-options-dialog/test-options-dialog.component";
import { TakeTestComponent } from "src/app/Components/EvaluationComponent/take-test/take-test.component";
import { GradesComponent } from "src/app/Components/EvaluationComponent/grades/grades.component";
import { RewardsComponent } from "src/app/Components/EvaluationComponent/rewards/rewards.component";
import { RewardsStatisticsComponent } from "./components/EvaluationComponent/rewards-statistics/rewards-statistics.component";
import { SuccesComponent } from "./components/EvaluationComponent/succes/succes.component";
import { FinalEvaluationComponent } from "./components/EvaluationComponent/final-evaluation/final-evaluation.component";
import { RevisionComponent } from "./components/EvaluationComponent/revision/revision.component";
import { JobOfferComponent } from "./Components/RecruitementComponents/job-offer/job-offer.component";
import { AddjobOfferComponent } from "./Components/RecruitementComponents/addjob-offer/addjob-offer.component";
import { UpdatejobOfferComponent } from "./Components/RecruitementComponents/updatejob-offer/updatejob-offer.component";
import { CandidancyComponent } from "./Components/RecruitementComponents/candidancy/candidancy.component";
import { CandidancyFormComponent } from "./Components/RecruitementComponents/candidancy-form/candidancy-form.component";
import { UpdateCandidancyComponent } from "./Components/RecruitementComponents/update-candidancy/update-candidancy.component";
import { AddQuestionFeedbackComponent } from "./Components/FeedBackComponents/add-question-feedback/add-question-feedback.component";
import { AddFeedbackModuleComponent } from "./Components/FeedBackComponents/add-feedback-module/add-feedback-module.component";
import { AddFeedbackTeacherComponent } from "./Components/FeedBackComponents/add-feedback-teacher/add-feedback-teacher.component";
import { ViewFeedbackModuleComponent } from "./Components/FeedBackComponents/view-feedback-module/view-feedback-module.component";
import { ViewFeedbackTeacherComponent } from "./Components/FeedBackComponents/view-feedback-teacher/view-feedback-teacher.component";
import { ViewFeedbacksComponent } from "./Components/FeedBackComponents/view-feedbacks/view-feedbacks.component";

const routes: Routes = [
  { path: "forumQuestion", component: QuestionComponent },
  { path: "forumAnswers/:id", component: AnswerComponent },
  { path: "forumChat", component: ChatComponent },
  { path: "forumIncentives", component: IncentivesComponent },
  { path: "acceuilncentives", component: AcceuilPrimComponent },
  { path: "chart", component: ChartComponentComponent },
  { path: "home", component: HomeComponent },
  { path: "login", component: LoginComponent },
  { path: "register", component: RegisterComponent },
  { path: "profile", component: ProfileComponent },
  { path: "admin", component: BoardAdminComponent },
  { path: "add-test", component: AddTestComponent },
  { path: "add-question", component: AddQuestionComponent },
  { path: "all-tests", component: AllTestsComponent }, // Ajoutez cette ligne
  { path: "all-Modules", component: AllModulesComponent }, // Ajoutez cette ligne
  { path: "testdialog", component: TestOptionsDialogComponent },
  { path: "take-test", component: TakeTestComponent },
  { path: "grades", component: GradesComponent },
  { path: "rewards", component: RewardsComponent },
  { path: "rewardsStat", component: RewardsStatisticsComponent },
  { path: "succes", component: SuccesComponent },
  { path: "finalGrade", component: FinalEvaluationComponent },
  { path: "revision", component: RevisionComponent },
  { path: "forumQuestion", component: QuestionComponent },
  { path: "forumAnswers", component: AnswerComponent },
  { path: "forumChat", component: ChatComponent },
  { path: "jobOffer", component: JobOfferComponent },
  { path: "addjobOffer", component: AddjobOfferComponent },
  { path: "updatejobOffer/:id", component: UpdatejobOfferComponent },
  { path: "candicancy", component: CandidancyComponent },
  { path: "apply/:jobId", component: CandidancyFormComponent },
  { path: "update/:id", component: UpdateCandidancyComponent },
  { path: "addQuestionfeedback", component: AddQuestionFeedbackComponent },
  { path: "addFeedbackModule", component: AddFeedbackModuleComponent },
  { path: "addFeedbackTeacher", component: AddFeedbackTeacherComponent },
  { path: "viewFeedbackModule", component: ViewFeedbackModuleComponent },
  { path: "viewFeedbackTeacher", component: ViewFeedbackTeacherComponent },
  { path: "viewfeedbacks", component: ViewFeedbacksComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
