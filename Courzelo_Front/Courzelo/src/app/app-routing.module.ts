import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { QuestionComponent } from './Components/Forum/question/question.component';
import { AnswerComponent } from './Components/Forum/answer/answer.component';
import { ChatComponent } from './Components/Forum/chat/chat.component';
import { LevelComponent } from './Components/AcademicProgram/level/level.component';
import { ClassComponent } from './Components/AcademicProgram/class/class.component';
import { GetlevelComponent } from './Components/AcademicProgram/level/getlevel/getlevel.component';
import { UpdatelevelComponent } from './Components/AcademicProgram/level/updatelevel/updatelevel/updatelevel.component';
import { GetallclassComponent } from './Components/AcademicProgram/class/getallClass/getallclass/getallclass.component';
import { UpdateclassComponent } from './Components/AcademicProgram/class/updatclass/updateclass/updateclass.component';
import { ModuleComponent } from './Components/AcademicProgram/module/module.component';
import { GetallmoduleComponent } from './Components/AcademicProgram/module/getallmodule/getallmodule.component';
import { UpdatemoduleComponent } from './Components/AcademicProgram/module/updatemodule/updatemodule.component';
import { UpdatecourseComponent } from './Components/AcademicProgram/course/updatecourse/updatecourse.component';
import { CourseComponent } from './Components/AcademicProgram/course/course.component';
import { GetallcoursesComponent } from './Components/AcademicProgram/course/getallcourses/getallcourses.component';
import { AcedemicProgramComponent } from './Components/AcademicProgram/acedemic-program/acedemic-program.component';
import { GetproandaccessmoduleComponent } from './Components/AcademicProgram/acedemic-program/getproandaccessmodule/getproandaccessmodule.component';
import { EtcoursesymoduleComponent } from './Components/AcademicProgram/course/etcoursesymodule/etcoursesymodule.component';
import { FilecomponentComponent } from './Components/AcademicProgram/class/filecomponent/filecomponent.component';
import { ViewfileComponent } from './Components/AcademicProgram/class/viewfile/viewfile.component';
import { ProjectComponent } from './Components/ProjectCompnents/project/project.component';
import { GetallprojectComponent } from './Components/ProjectCompnents/getallproject/getallproject.component';
import { GetallprojectbyuserComponentComponent } from './Components/ProjectCompnents/user/getallprojectbyuser-component/getallprojectbyuser-component.component';
import { LandingPageComponent } from './shared/HomeLandingPage/landing-page/landing-page.component';
import { TaskjiraComponent } from './Components/ProjectCompnents/user/taskjira/taskjira.component';
import { DocumentationsComponent } from './Components/ProjectCompnents/user/documentations/documentations.component';

const routes: Routes = [
  {path:'forumQuestion', component:QuestionComponent},
  {path:'forumAnswers', component:AnswerComponent},
  {path:'forumChat', component:ChatComponent},
  {path:'Level', component:LevelComponent},
  {path:'Class', component:ClassComponent},
  {path:'getalllevels', component:GetlevelComponent},
  {path:'updatelevels/:id', component:UpdatelevelComponent},
  {path:'updateclass/:id', component:UpdateclassComponent},
  {path:'getallmodules', component:GetallmoduleComponent},
  {path:'getallclasses', component:GetallclassComponent},
  {path:'addclass', component:ClassComponent},
  {path:'addmodule', component:ModuleComponent},
  {path:'updatemodule/:id', component:UpdatemoduleComponent},
  {path:'updatecourse/:id', component:UpdatecourseComponent},
  {path:'addcourse', component:CourseComponent},
  {path:'getallacourses', component:GetallcoursesComponent},
  {path:'getprogram', component:AcedemicProgramComponent},
  { path: 'courses/:moduleId', component: EtcoursesymoduleComponent},
  { path: 'getprogaccesstocourse', component: GetproandaccessmoduleComponent},
  { path: 'fileupload/:courseId', component: FilecomponentComponent},
  { path: 'file/:courseId', component: ViewfileComponent},
  {path:'addProject', component:ProjectComponent},
  { path: 'getallprojects', component: GetallprojectComponent },
  { path: 'getallprojectsbyuser', component: GetallprojectbyuserComponentComponent },
  { path: 'HomePage', component: LandingPageComponent },
  { path: 'progress/:id', component: TaskjiraComponent },
  { path: 'Documentation', component: DocumentationsComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
