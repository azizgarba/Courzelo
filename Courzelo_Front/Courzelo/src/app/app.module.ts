import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { SideBarComponent } from "./shared/side-bar/side-bar.component";
import { NavBarComponent } from "./shared/nav-bar/nav-bar.component";
import { QuestionComponent } from "./Components/Forum/question/question.component";
import { AnswerComponent } from "./Components/Forum/answer/answer.component";
import { ChatComponent } from "./Components/Forum/chat/chat.component";
import { HttpClientModule } from "@angular/common/http";
import { ModalpopupComponentComponent } from "./Components/Forum/modalpopup-component/modalpopup-component.component";
import { ReactiveFormsModule } from "@angular/forms";
import { MatDialogModule } from "@angular/material/dialog";
import { MatSelectModule } from "@angular/material/select";
import { FormsModule } from "@angular/forms"; // Import FormsModule here
import { MdbModalModule } from "mdb-angular-ui-kit/modal";
import { JobOfferComponent } from "./Components/RecruitementComponents/job-offer/job-offer.component";
import { AddjobOfferComponent } from "./Components/RecruitementComponents/addjob-offer/addjob-offer.component";
import { UpdatejobOfferComponent } from "./Components/RecruitementComponents/updatejob-offer/updatejob-offer.component";
import { DeleteConfirmationModelPopupComponent } from "./Components/RecruitementComponents/delete-confirmation-model-popup/delete-confirmation-model-popup.component";
import { CandidancyComponent } from "./Components/RecruitementComponents/candidancy/candidancy.component";
import { CandidancyFormComponent } from "./Components/RecruitementComponents/candidancy-form/candidancy-form.component";
import { UpdateCandidancyComponent } from "./Components/RecruitementComponents/update-candidancy/update-candidancy.component";
import { ViewQuestionFeedbackComponent } from "./Components/FeedBackComponents/view-question-feedback/view-question-feedback.component";
import { AddQuestionFeedbackComponent } from "./Components/FeedBackComponents/add-question-feedback/add-question-feedback.component";
import { AddFeedbackModuleComponent } from "./Components/FeedBackComponents/add-feedback-module/add-feedback-module.component";
import { ViewFeedbackModuleComponent } from "./Components/FeedBackComponents/view-feedback-module/view-feedback-module.component";
import { AddFeedbackTeacherComponent } from "./Components/FeedBackComponents/add-feedback-teacher/add-feedback-teacher.component";
import { ViewFeedbackTeacherComponent } from "./Components/FeedBackComponents/view-feedback-teacher/view-feedback-teacher.component";
import { ViewFeedbacksComponent } from "./Components/FeedBackComponents/view-feedbacks/view-feedbacks.component";

import { ChartComponentComponent } from "./Components/Forum/chart-component/chart-component.component";
import { ChartModule } from "angular-highcharts";
import { AuthGuard } from "./auth-guard.guard";
import { authInterceptorProviders } from "./_helpers/auth.interceptor";
import { UserCorzeloComponent } from "./Components/user-corzelo/user-corzelo.component";
import { LoginComponent } from "./login/login.component";
import { RegisterComponent } from "./register/register.component";
import { HomeComponent } from "./home/home.component";
import { ProfileComponent } from "./profile/profile.component";
import { BoardAdminComponent } from "./board-admin/board-admin.component";
import { BoardModeratorComponent } from "./board-moderator/board-moderator.component";
import { BoardUserComponent } from "./board-user/board-user.component";
import { EmptyComponentComponent } from "./empty-component/empty-component.component";
import { AcceuilPrimComponent } from "./Components/Forum/acceuil-prim/acceuil-prim.component";
import { NavBarOUTComponent } from "./shared/nav-bar-out/nav-bar-out.component";

import { AddTestComponent } from "./Components/EvaluationComponent/add-test/add-test.component";
import { AddQuestionComponent } from "./Components/EvaluationComponent/add-question/add-question.component";
import { CommonModule, DatePipe } from "@angular/common";
import { AllTestsComponent } from "./Components/EvaluationComponent/all-tests/all-tests.component";
import { EditTestComponent } from "src/app/Components/EvaluationComponent/edit-test/edit-test.component";
import { TakeTestComponent } from "src/app/Components/EvaluationComponent/take-test/take-test.component";
import { AllModulesComponent } from "src/app/Components/EvaluationComponent/all-modules/all-modules.component";
import { TestOptionsDialogComponent } from "src/app/Components/EvaluationComponent/test-options-dialog/test-options-dialog.component";
import { GradesComponent } from "src/app/Components/EvaluationComponent/grades/grades.component";
import { MatInputModule } from "@angular/material/input";
import { MatButtonModule } from "@angular/material/button";
import { MatFormFieldModule } from "@angular/material/form-field";
import { RewardsComponent } from "src/app/Components/EvaluationComponent/rewards/rewards.component";
import { RewardsStatisticsComponent } from "./Components/EvaluationComponent/rewards-statistics/rewards-statistics.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { MatCardModule } from "@angular/material/card";
import { MatProgressBarModule } from "@angular/material/progress-bar";
import { SuccesComponent } from "./Components/EvaluationComponent/succes/succes.component";
import { FinalEvaluationComponent } from "./Components/EvaluationComponent/final-evaluation/final-evaluation.component";
import { RevisionComponent } from "./Components/EvaluationComponent/revision/revision.component";
import { NgbRatingModule } from "@ng-bootstrap/ng-bootstrap";
import { MatIconModule } from "@angular/material/icon";
import { IncentivesComponent } from "./Components/Forum/incentives/incentives.component";
import { EvGuideComponent } from './Components/EvaluationComponent/ev-guide/ev-guide.component';
@NgModule({
  declarations: [
    AppComponent,
    SideBarComponent,
    NavBarComponent,
    QuestionComponent,
    AnswerComponent,
    ChatComponent,
    ModalpopupComponentComponent,
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
    JobOfferComponent,
    AddjobOfferComponent,
    UpdatejobOfferComponent,
    DeleteConfirmationModelPopupComponent,
    CandidancyComponent,
    CandidancyFormComponent,
    UpdateCandidancyComponent,
    ViewQuestionFeedbackComponent,
    AddQuestionFeedbackComponent,
    AddFeedbackModuleComponent,
    ViewFeedbackModuleComponent,
    AddFeedbackTeacherComponent,
    ViewFeedbackTeacherComponent,
    ViewFeedbacksComponent,
    IncentivesComponent,
    EvGuideComponent,
  ],
  imports: [
    BrowserModule,
    MatIconModule,
    NgbRatingModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatSelectModule,
    FormsModule,
    MdbModalModule,
    MatProgressBarModule,
    ChartModule,
    MdbModalModule,
    CommonModule,
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatProgressBarModule,
  ],
  providers: [authInterceptorProviders, AuthGuard, DatePipe],
  bootstrap: [AppComponent],
})
export class AppModule {}
