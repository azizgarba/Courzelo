import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { ModalConfirmationComponent } from "./Components/Forum/modal-confirmation/modal-confirmation.component";
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

    JobOfferComponent,
    AddjobOfferComponent,
    UpdatejobOfferComponent,
    DeleteConfirmationModelPopupComponent,
    CandidancyComponent,
    CandidancyFormComponent,
    UpdateCandidancyComponent,
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
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
