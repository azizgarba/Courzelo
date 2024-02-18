import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { QuestionForum } from 'src/app/Models/QuestionForum';
import { catchError } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ConsumerQuestionServiceService {

  constructor(private http:HttpClient) { }

  getAllQuestion():Observable<QuestionForum[]>{
    return  this.http.get<QuestionForum[]>('http://localhost:8081/ForumQuestions')
    .pipe(
      catchError(error => {
        console.error('Error fetching questions:', error);
        return throwError(error);
      })
    );
  }
  // AddQuestion(question: QuestionForum){
  //   return  this.http.post('http://localhost:3000/products',question);
  // }
  // getQuestionById(id: number){
  //   return  this.http.get<QuestionForum>('http://localhost:3000/products'+'/'+ id);
  // }
  // deleteQuestion( id: number){
  //   return this.http.delete('http://localhost:3000/products'+'/'+ id);
  // }
  // updateQuestion( id: number, p:QuestionForum){
  //   return this.http.put('http://localhost:3000/products'+'/'+ id, p);
  // }
}
