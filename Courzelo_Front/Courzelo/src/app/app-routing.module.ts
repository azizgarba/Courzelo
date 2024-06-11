import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { QuestionComponent } from './Components/Forum/question/question.component';
import { AnswerComponent } from './Components/Forum/answer/answer.component';
import { ChatComponent } from './Components/Forum/chat/chat.component';
import { SessionsComponent } from './Components/SessionComponenets/sessions/sessions.component';
import { ScheduleComponent } from './Components/SessionComponenets/schedule/schedule.component';
import { SessionChatComponent } from './Components/SessionComponenets/session-chat/session-chat.component';
import { EventBackComponent } from './Components/EventComponent/event-back/event-back.component';
import { PlanningComponent } from './Components/SessionComponenets/planning/planning.component';

const routes: Routes = [
  {path:'forumQuestion', component:QuestionComponent},
  {path:'forumAnswers', component:AnswerComponent},
  {path:'forumChat', component:ChatComponent},
  {path:'sessions', component:SessionsComponent},
  {path:'schedule', component:ScheduleComponent},
  {path:'sessionchat', component:SessionChatComponent},
  {path: 'events', component:EventBackComponent},
  {path: 'planning', component:PlanningComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
