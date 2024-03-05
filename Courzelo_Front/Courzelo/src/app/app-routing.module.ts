import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { QuestionComponent } from './Components/Forum/question/question.component';
import { AnswerComponent } from './Components/Forum/answer/answer.component';
import { ChatComponent } from './Components/Forum/chat/chat.component';

const routes: Routes = [
  {path:'forumQuestion', component:QuestionComponent},
  {path:'forumAnswers/:id', component:AnswerComponent},
  {path:'forumChat', component:ChatComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
