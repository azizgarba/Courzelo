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
import { AcedemicProgramComponent } from './Components/AcademicProgram/acedemic-program/acedemic-program.component';
import { ModuleComponent } from './Components/AcademicProgram/module/module.component';
import { ClassComponent } from './Components/AcademicProgram/class/class.component';
import { LevelComponent } from './Components/AcademicProgram/level/level.component';
import { CourseComponent } from './Components/AcademicProgram/course/course.component';
import { ProjectComponent } from './Components/ProjectCompnents/project/project.component';
import { UpdatelevelComponent } from './Components/AcademicProgram/level/updatelevel/updatelevel/updatelevel.component';
import { GetlevelComponent } from './Components/AcademicProgram/level/getlevel/getlevel.component';
import { UpdateclassComponent } from './Components/AcademicProgram/class/updatclass/updateclass/updateclass.component';
import { GetallclassComponent } from './Components/AcademicProgram/class/getallClass/getallclass/getallclass.component';
import { UpdatemoduleComponent } from './Components/AcademicProgram/module/updatemodule/updatemodule.component';
import { GetallmoduleComponent } from './Components/AcademicProgram/module/getallmodule/getallmodule.component';
import { GetallcoursesComponent } from './Components/AcademicProgram/course/getallcourses/getallcourses.component';
import { UpdatecourseComponent } from './Components/AcademicProgram/course/updatecourse/updatecourse.component';
import { GetproandaccessmoduleComponent } from './Components/AcademicProgram/acedemic-program/getproandaccessmodule/getproandaccessmodule.component';
import { EtcoursesymoduleComponent } from './Components/AcademicProgram/course/etcoursesymodule/etcoursesymodule.component';
import { FilecomponentComponent } from './Components/AcademicProgram/class/filecomponent/filecomponent.component';
import { ViewfileComponent } from './Components/AcademicProgram/class/viewfile/viewfile.component';
import { GetallprojectComponent } from './Components/ProjectCompnents/getallproject/getallproject.component';
import { UpdateprojectComponent } from './Components/ProjectCompnents/updateproject/updateproject.component';
import { ProjectDetailsComponentComponent } from './Components/ProjectCompnents/getallproject/project-details-component/project-details-component.component';
import { GroupGenerateComponentComponent } from './Components/ProjectCompnents/group-generate-component/group-generate-component.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { GetallprojectbyuserComponentComponent } from './Components/ProjectCompnents/user/getallprojectbyuser-component/getallprojectbyuser-component.component';
import { LandingPageComponent } from './shared/HomeLandingPage/landing-page/landing-page.component';
import { FullCalendarComponent, FullCalendarModule } from '@fullcalendar/angular';
import { TaskjiraComponent } from './Components/ProjectCompnents/user/taskjira/taskjira.component';
//import { FilterByStatusPipe } from './Models/ProjectEntities/FilterByStatusPipe';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { DocumentationsComponent } from './Components/ProjectCompnents/user/documentations/documentations.component';

@NgModule({
  declarations: [
    AppComponent,
    SideBarComponent,
    NavBarComponent,
    QuestionComponent,
    AnswerComponent,
    ChatComponent,
    ModalpopupComponentComponent,
   
    AcedemicProgramComponent,
    ModuleComponent,
    ClassComponent,
    LevelComponent,
    CourseComponent,
    ProjectComponent,
    UpdatelevelComponent,
    
    GetlevelComponent,
    UpdateclassComponent,
    GetallclassComponent,
    UpdatemoduleComponent,
    GetallmoduleComponent,
    GetallcoursesComponent,
    UpdatecourseComponent,
    GetproandaccessmoduleComponent,
    EtcoursesymoduleComponent,
    FilecomponentComponent,
    ViewfileComponent,
    GetallprojectComponent,
    UpdateprojectComponent,
    ProjectDetailsComponentComponent,
    GroupGenerateComponentComponent,
    GetallprojectbyuserComponentComponent,
    LandingPageComponent,
    TaskjiraComponent,
    DocumentationsComponent,
    
   
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
    MatSnackBarModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
   FullCalendarModule,
   DragDropModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
