import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { QuestionForum } from 'src/app/Models/QuestionForum';
import { ConsumerQuestionServiceService } from 'src/app/Services/ForumService/consumer-question-service.service';
import { ModalpopupComponentComponent } from '../modalpopup-component/modalpopup-component.component';
import { MdbModalRef, MdbModalService } from 'mdb-angular-ui-kit/modal';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent {
  listQuestion:QuestionForum[]=[]
  constructor(private questionService :ConsumerQuestionServiceService ,private route:Router,private modalService: MdbModalService){}
 

  ngOnInit(){
   this.questionService.getAllQuestion().subscribe(
      (data)=>this.listQuestion=data
    )
  
    }
    
    modalRef: MdbModalRef<ModalpopupComponentComponent> | null = null;



  openModal() {
    this.modalRef = this.modalService.open(ModalpopupComponentComponent)
  }
    }
  
  







