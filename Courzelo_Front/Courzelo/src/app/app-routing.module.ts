import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { QuestionComponent } from "./Components/Forum/question/question.component";
import { AnswerComponent } from "./Components/Forum/answer/answer.component";
import { ChatComponent } from "./Components/Forum/chat/chat.component";
import { JobOfferComponent } from "./Components/RecruitementComponents/job-offer/job-offer.component";
import { AddjobOfferComponent } from "./Components/RecruitementComponents/addjob-offer/addjob-offer.component";
import { UpdatejobOfferComponent } from "./Components/RecruitementComponents/updatejob-offer/updatejob-offer.component";

const routes: Routes = [
  { path: "forumQuestion", component: QuestionComponent },
  { path: "forumAnswers", component: AnswerComponent },
  { path: "forumChat", component: ChatComponent },
  { path: "jobOffer", component: JobOfferComponent },
  { path: "addjobOffer", component: AddjobOfferComponent },
  { path: "updatejobOffer/:id", component: UpdatejobOfferComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
