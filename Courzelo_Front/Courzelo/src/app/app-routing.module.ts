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
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
