import { Component } from '@angular/core';
import { CalendarEvent, CalendarView } from 'angular-calendar';
import { title } from 'process';
import { AppComponent } from 'src/app/app.component';
import { subWeeks, addWeeks } from 'date-fns';
@Component({
  selector: 'app-planning',
  templateUrl: './planning.component.html',
  styleUrls: ['./planning.component.css']
})
export class PlanningComponent {
  viewDate: Date = new Date();
  view: CalendarView = CalendarView.Week;
  events: CalendarEvent[] = [];

  constructor() {
    const event1: CalendarEvent = {
      title: "DataBase Course",
      start: new Date("2024-06-12T10:30"),
      end: new Date("2024-06-12T12:30")
    };
    const event2: CalendarEvent = {
      title: "SpringBoot",
      start: new Date("2024-06-12T08:00"),
      end: new Date("2024-06-12T10:00")
    };
    const event3: CalendarEvent = {
      title: "Angular",
      start: new Date("2024-06-13T10:30"),
      end: new Date("2024-06-13T12:30")
    };
    const event4: CalendarEvent = {
      title: "Mobile Course",
      start: new Date("2024-06-13T13:30"),
      end: new Date("2024-06-13T15:30")
    };
    const event5: CalendarEvent = {
      title: "Advanced Sex",
      start: new Date("2024-06-14T08:00"),
      end: new Date("2024-06-14T12:30")
    };
    const event6: CalendarEvent = {
      title: "Network",
      start: new Date("2024-06-11T08:00"),
      end: new Date("2024-06-11T12:30")
    };
    const event7: CalendarEvent = {
      title: "English",
      start: new Date("2024-06-10T08:00"),
      end: new Date("2024-06-10T12:30")
    };
    const event8: CalendarEvent = {
      title: "Admin System",
      start: new Date("2024-06-10T13:00"),
      end: new Date("2024-06-10T17:00")
    };
    this.events.push(event1);
    this.events.push(event2);
    this.events.push(event3);
    this.events.push(event4);
    this.events.push(event5);
    this.events.push(event6);
    this.events.push(event7);
    this.events.push(event8);

  }

  setView(view: CalendarView) {
    this.view = view;
  }

  ngOnInit() {}

  previous() {
    this.viewDate = subWeeks(this.viewDate, 1);
  }

  next() {
    this.viewDate = addWeeks(this.viewDate, 1);
  }

  today() {
    this.viewDate = new Date();
  }
}
