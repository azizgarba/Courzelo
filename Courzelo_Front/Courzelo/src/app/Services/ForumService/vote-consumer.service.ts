import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject, catchError, throwError } from 'rxjs';
import { Vote } from 'src/app/Models/ForumEntities/Votes';

@Injectable({
  providedIn: 'root'
})
export class VoteConsumerService {

  constructor(private http:HttpClient) { }
  AddVote(v:Vote,idAnswer: string){
    return  this.http.post('http://localhost:8081/ForumVote/create/65d3909015939e88eb26bd3c'+'/'+ idAnswer,v);
  }
  //http://localhost:8081/ForumVote/update

  updateVote(v:Vote){
    return this.http.put('http://localhost:8081/ForumVote/update', v);
  }
  deleteAnswer( id:string){
    return this.http.delete('http://localhost:8081/ForumVote'+'/'+ id);
  }
//65d3902c15939e88eb26bd3b
  getVotesByUserAndAnswer(idAnswer: string){
    return  this.http.get<Vote>('http://localhost:8081/ForumVote/getvoteByUseAndAnswer/65d3909015939e88eb26bd3c'+'/'+ idAnswer);
 
  }
  getVoteAnswerById(id:string){
    return  this.http.get<number>('http://localhost:8081/answers/nombreVote'+'/'+ id);

  }

  voteChanged = new Subject<void>();

}
