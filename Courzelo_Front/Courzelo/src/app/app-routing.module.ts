import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { QuestionComponent } from "./Components/Forum/question/question.component";
import { AnswerComponent } from "./Components/Forum/answer/answer.component";
import { ChatComponent } from "./Components/Forum/chat/chat.component";
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
