import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Route, Router } from '@angular/router';

import { ProjetserviceService } from 'src/app/Services/ProjectServices/projetservice.service';
import { ProjectDetailsComponentComponent } from '../../getallproject/project-details-component/project-details-component.component';
import { GroupProject } from 'src/app/Models/ProjectEntities/GroupProject';
import { Observable } from 'rxjs';
import { FullCalendarComponent } from '@fullcalendar/angular';
import { CalendarOptions } from '@fullcalendar/core'; // useful for typechecking
import dayGridPlugin from '@fullcalendar/daygrid';
import { Tasks } from 'src/app/Models/ProjectEntities/Tasks';
@Component({
  selector: 'app-getallprojectbyuser-component',
  templateUrl: './getallprojectbyuser-component.component.html',
  styleUrls: ['./getallprojectbyuser-component.component.css']
})
export class GetallprojectbyuserComponentComponent implements OnInit  {
  @ViewChild('calendar') calendarComponent!: FullCalendarComponent;
  project!: Observable<GroupProject[]>;
 // projectss!: Observable<Project[]>;
  studentId!: string;
  id!: string;
  tasks: Tasks[]= [];
  selectedProject!: any;
  // Calendar options object
  calendarOptions: CalendarOptions = {
    initialView: 'dayGridMonth',
    plugins: [dayGridPlugin],
    events: [] // Initialize empty events array
    
  };

  constructor(
    private groupProjectService: ProjetserviceService,
    private dialog: MatDialog, private route: ActivatedRoute,
    private router: Router
   
  ) { }

  ngOnInit(): void {
    this.selectedProject = {};
    // Fetch the student ID from the route parameters
    this.route.paramMap.subscribe(params => {
      this.studentId = params.get('student_id') || '';
      // Load projects once we have the student ID
      this.loadProjects();
      
    });
  }
  
  selectProject(project: any) {
    this.selectedProject = project;
  }
  loadProjects(): void {
    this.project = this.groupProjectService.getProjectsForUser(this.studentId);
    this.project.subscribe(projects => {
      this.populateCalendar(projects);
    });
  }

  populateCalendar(project: GroupProject[]): void {
    const calendarEvents = project.map(project => ({
      title: project.name,
      start: project.project.datedebut,
      end: project.project.deadline
    }));

    // Set calendar events
    this.calendarOptions.events = calendarEvents;
  }
 
  showMore(project: GroupProject) {
    const dialogRef = this.dialog.open(ProjectDetailsComponentComponent, {
      width: '500px',
      data: project.project
    });
  
    const projectId = project.project.id.toString();
    this.groupProjectService.setProjectId(projectId);
    console.log('Project ID:', projectId);
  
   
    dialogRef.afterClosed()
  }
  
  

  

}