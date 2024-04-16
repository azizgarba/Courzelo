import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SideBarComponent } from './shared/side-bar/side-bar.component';
import { NavBarComponent } from './shared/nav-bar/nav-bar.component';
import { QuestionComponent } from './Components/Forum/question/question.component';
import { AnswerComponent } from './Components/Forum/answer/answer.component';
import { ChatComponent } from './Components/Forum/chat/chat.component';
import { HttpClientModule } from '@angular/common/http';
import { ModalpopupComponentComponent } from './Components/Forum/modalpopup-component/modalpopup-component.component';
import { ReactiveFormsModule } from '@angular/forms';
import { MatDialogModule } from '@angular/material/dialog';
import { MatSelectModule } from '@angular/material/select';
import { FormsModule } from '@angular/forms'; // Import FormsModule here
import { MdbModalModule } from 'mdb-angular-ui-kit/modal';
import { ModalConfirmationComponent } from './Components/Forum/modal-confirmation/modal-confirmation.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { IncentivesComponent } from './Components/Forum/incentives/incentives.component';
import { MatIconModule } from '@angular/material/icon';


import { ChartComponentComponent } from './Components/Forum/chart-component/chart-component.component';
import { ChartModule } from 'angular-highcharts';
import { AuthGuard } from './auth-guard.guard';
import { authInterceptorProviders } from './_helpers/auth.interceptor';
import { UserCorzeloComponent } from './Components/user-corzelo/user-corzelo.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { EmptyComponentComponent } from './empty-component/empty-component.component';
import { AcceuilPrimComponent } from './Components/Forum/acceuil-prim/acceuil-prim.component';
import { NavBarOUTComponent } from './shared/nav-bar-out/nav-bar-out.component';



import { AddTestComponent } from './components/EvaluationComponent/add-test/add-test.component';
import { AddQuestionComponent } from './components/EvaluationComponent/add-question/add-question.component';
import { CommonModule } from '@angular/common';
import { AllTestsComponent } from './components/EvaluationComponent/all-tests/all-tests.component';
import { EditTestComponent } from 'src/app/Components/EvaluationComponent/edit-test/edit-test.component';
import { TakeTestComponent } from 'src/app/Components/EvaluationComponent/take-test/take-test.component';
import { AllModulesComponent } from 'src/app/Components/EvaluationComponent/all-modules/all-modules.component';
import { TestOptionsDialogComponent } from 'src/app/Components/EvaluationComponent/test-options-dialog/test-options-dialog.component';
import { GradesComponent } from 'src/app/Components/EvaluationComponent/grades/grades.component';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { RewardsComponent } from 'src/app/Components/EvaluationComponent/rewards/rewards.component';
import { RewardsStatisticsComponent } from './components/EvaluationComponent/rewards-statistics/rewards-statistics.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule } from '@angular/material/card';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { SuccesComponent } from './components/EvaluationComponent/succes/succes.component';
import { FinalEvaluationComponent } from './components/EvaluationComponent/final-evaluation/final-evaluation.component';
import { RevisionComponent } from './components/EvaluationComponent/revision/revision.component';
@NgModule({
  declarations: [
    AppComponent,
    SideBarComponent,
    NavBarComponent,
    QuestionComponent,
    AnswerComponent,
    ChatComponent,
    ModalpopupComponentComponent,
    ModalConfirmationComponent,
    IncentivesComponent,
    ChartComponentComponent,
    UserCorzeloComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardModeratorComponent,
    BoardUserComponent,
    EmptyComponentComponent,
    AcceuilPrimComponent,
    NavBarOUTComponent,
  
    
    AddTestComponent,
    AddQuestionComponent,
    AllTestsComponent,
    EditTestComponent,
    TakeTestComponent,
    AllModulesComponent,
    TestOptionsDialogComponent,
    GradesComponent,
    RewardsComponent,
    RewardsStatisticsComponent,
    SuccesComponent,
    FinalEvaluationComponent,
    RevisionComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatSelectModule,
    FormsModule,
    MdbModalModule,
    NgbModule,
    MatIconModule,
    MatProgressBarModule,
    ChartModule,
    MdbModalModule, CommonModule,
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
        MatCardModule,
        MatProgressBarModule,
        
        
        


  ],
  providers: [authInterceptorProviders , AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
