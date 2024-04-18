import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
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
import { SessionsComponent } from './Components/SessionComponenets/sessions/sessions.component';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { ScheduleComponent } from './Components/SessionComponenets/schedule/schedule.component';
import { SessionChatComponent } from './Components/SessionComponenets/session-chat/session-chat.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatSidenavModule } from '@angular/material/sidenav';
import { EventBackComponent } from './Components/EventComponent/event-back/event-back.component';
import { DatePipe } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    SideBarComponent,
    NavBarComponent,
    QuestionComponent,
    AnswerComponent,
    ChatComponent,
    ModalpopupComponentComponent,
    SessionsComponent,
    ScheduleComponent,
    SessionChatComponent,
    EventBackComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatSelectModule,
    FormsModule,
    BrowserAnimationsModule,
    CalendarModule.forRoot({ provide: DateAdapter, useFactory: adapterFactory }),
    //MdbModalModule,
    //session chat 
    MatToolbarModule,
    MatButtonModule,
    MatGridListModule,
    MatSidenavModule,
  
  ],
  providers: [
    DatePipe,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
