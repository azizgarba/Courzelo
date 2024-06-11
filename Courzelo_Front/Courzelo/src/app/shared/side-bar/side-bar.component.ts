import { Component } from '@angular/core';
import { WebSocketService } from 'src/app/Services/EventServices/web-socket.service';
import { Client, IStompSocket, Message } from '@stomp/stompjs';
import { NotifService } from 'src/app/Services/EventServices/notif.service';
import { Notif } from 'src/app/Models/SessionEntities/Notif';
import { EventC } from 'src/app/Models/SessionEntities/Event';
import { DatePipe } from '@angular/common';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Rsvp } from 'src/app/Models/SessionEntities/Rsvp';
import { Router } from '@angular/router';

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent {

  event!:EventC;
  addform:FormGroup;
  rsvp!:Rsvp;
  constructor(private r:Router,private ss: NotifService,private datePipe: DatePipe,private fb : FormBuilder){
    this.addform = fb.group({
      status : ['',Validators.required],
    });
      this.event = {
        id:"string",
        name : "string",
        date : new Date(),
        location : "string",
        price : 25,
        description : "string",
        category:"",
        estimation : 10
      }
      this.rsvp = {
        id:undefined,
        event:this.event,
        status:"",
        user:undefined
      }
  }
  AddRsvp(){
    this.rsvp.event = this.event;
    this.rsvp.status = this.addform.get('status')?.value;
    this.ss.AddRsvp(this.rsvp).subscribe(
      {next: ()=> this.r.navigateByUrl('/events')}
    )

  }
  initializeEvent(notif: Notif){
    this.event = notif.event;
  }
  formatDate(timestamp: Date): string {
    const date = new Date(timestamp);
    return this.datePipe.transform(date, 'yyyy-MM-dd') || '';
  }
  notifs:Notif[]=[];
  ngOnInit(){
    this.ss.getNotifs().subscribe(
      (data)=>{
        this.notifs=data;
        console.log(this.notifs);
      }
    )
  }

}
