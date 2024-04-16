import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { QuestionComponent } from './Components/Forum/question/question.component';
import { AnswerComponent } from './Components/Forum/answer/answer.component';
import { ChatComponent } from './Components/Forum/chat/chat.component';
import { IncentivesComponent } from './Components/Forum/incentives/incentives.component';
import { AcceuilPrimComponent } from './Components/Forum/acceuil-prim/acceuil-prim.component';
import { ChartComponentComponent } from './Components/Forum/chart-component/chart-component.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { ProfileComponent } from './profile/profile.component';
import { LoginComponent } from './login/login.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';


const routes: Routes = [
  {path:'forumQuestion', component:QuestionComponent},
  {path:'forumAnswers/:id', component:AnswerComponent},
  {path:'forumChat', component:ChatComponent},
  {path:'forumIncentives', component:IncentivesComponent},
  {path:'acceuilncentives', component:AcceuilPrimComponent},
  {path:'chart', component:ChartComponentComponent},
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  {
    path: 'admin',
    component: BoardAdminComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
