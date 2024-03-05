import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';

import { ConsumerQuestionServiceService } from 'src/app/Services/ForumService/consumer-question-service.service';
import { ModalpopupComponentComponent } from '../modalpopup-component/modalpopup-component.component';
import { MdbModalRef, MdbModalService } from 'mdb-angular-ui-kit/modal';
import { QuestionForum } from 'src/app/Models/ForumEntities/QuestionForum';
import { Subscription, debounceTime, distinctUntilChanged } from 'rxjs';
import { WebSocketAPI } from 'src/app/Services/ForumService/WebSocketAPI';
import { Module as Mod } from 'src/app/Models/AcademicProgramEntities/Module';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit{

  listQuestion:QuestionForum[]=[]
  questionAddedSubscription!: Subscription;
  text = 'this is some test input';
  containsProfanity = false;
  ratesAverage: { [id: string]: number } = {};
 NaN: any;
 listModule:Mod[]=[];
 listQuestionModule:QuestionForum[]=[]
 //search  //search 
  searchValue = '';
  searchValueChangeSubscription!: Subscription;
 
  searchForm = this.fb.nonNullable.group({
    searchValue: '',
  });
  


  constructor(private questionService :ConsumerQuestionServiceService ,private route:Router,private modalService: MdbModalService,private fb: FormBuilder){
    this.questionAddedSubscription = this.questionService.questionAdded$.subscribe(() => {
      this.ngOnInit(); // Rafraîchir les données des questions
    });
  }
  
  ngOnDestroy() {
    this.questionAddedSubscription.unsubscribe();
    this.searchValueChangeSubscription.unsubscribe();
  }


  ngOnInit(){
    
    this.questionService.getAllQuestion().subscribe(
      (data) => {
        this.listQuestion = data;
        //rating
        this.listQuestion.forEach(d => {
          this.questionService.getRatesAverage(d.id).subscribe(
            (average) => {
              if(isNaN(average)){
                this.ratesAverage[d.id] = 0;
              } else {
                this.ratesAverage[d.id] = average;
              }
            });
        });
      }
    )
    this.questionService.getAllModules().subscribe(
      (data)=>this.listModule=data
    )
    this.searchValueChangeSubscription = this.searchForm.get('searchValue')?.valueChanges
    .pipe(
      debounceTime(400), // wait 400ms after the last event before emitting last event
      distinctUntilChanged() // only emit if value is different from previous value
    )
    .subscribe(() => {
      this.onSearchSubmit();
    }) || new Subscription();
  this.fetchData();

  
  
    }
    
    modalRef: MdbModalRef<ModalpopupComponentComponent> | null = null;



    openModal(update:boolean) {
      this.modalRef = this.modalService.open(ModalpopupComponentComponent)
      this.questionService.setupdate(update);
      
    }
    getQuestionsForModule(id:string){
      this.questionService.getAllQuestionByModul3e(id).subscribe(
        (data)=>{this.listQuestion =data
        console.log("moduleeeeeeeeeeee",this.listQuestionModule)}
      )

    }
    getAllQuestionsRated(){
      this.questionService.getAllQuestionRated().subscribe(
        (data) => {
          this.listQuestion = data;})

    }
    fetchData(): void {
      this.questionService.getAllQuestionByTitle(this.searchValue).subscribe((articles) => {
        this.listQuestion = articles;
      });
    }
  
    onSearchSubmit(): void {
      this.searchValue = this.searchForm.value.searchValue ?? '';
      this.fetchData();
    }

    
    
   
 
    
}
  
  







