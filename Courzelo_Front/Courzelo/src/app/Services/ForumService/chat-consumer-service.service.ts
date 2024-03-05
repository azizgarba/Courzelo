import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, catchError, throwError } from 'rxjs';
import { ChatRoom } from 'src/app/Models/ForumEntities/ChatRoom';
import { Media } from 'src/app/Models/ForumEntities/Media';
import { Message } from 'src/app/Models/ForumEntities/Message';

@Injectable({
  providedIn: 'root'
})
export class ChatConsumerServiceService {

  constructor(private http:HttpClient) { }

    //je vais passer le id user session par lien
  createChatRoom(chat: ChatRoom, receiverId:string ) {
    return this.http.post('http://localhost:8081/ForumChat/createChat/65d3909015939e88eb26bd3c'+'/'+receiverId,chat);
  }
   //je vais passer le id user session par lien
  getChatRoomsByUser():Observable<ChatRoom[]>{
    return  this.http.get<ChatRoom[]>('http://localhost:8081/ForumChat/getAllChatsByUser/65d3909015939e88eb26bd3c')
    .pipe(
      catchError(error => {
        console.error('Error fetching questions:', error);
        return throwError(error);
      })
    );
  }
  //je vais passer le id user1p session ar lien
  getChatRoomByUse1AndUser2( idUser2:string){
    return  this.http.get<ChatRoom>('http://localhost:8081/ForumChat/getChatBySenderAndReceiver/65d3909015939e88eb26bd3c'+'/'+ idUser2);
  }
  getChatRoomByUse1AndUsernajiba( idUser2:string){
    return  this.http.get<ChatRoom>('http://localhost:8081/ForumChat/get/getChatBySenderAndReceiver/65d3909715939e88eb26bd3d'+'/'+ idUser2);
  }
  //get chat by id
    //je vais passer le id user1p session ar lien
    getChatById( id:number){
      return  this.http.get<ChatRoom>('http://localhost:8081/ForumChat'+'/'+ id);
    }


    sendMessage(p:Message,idChat:number){
      return this.http.put('http://localhost:8081/ForumChat/message'+'/'+idChat+'/'+'65d3909015939e88eb26bd3c', p);
    }

    updateMediaChat(
      chatId: any,
      image: any,
      fileType: string,
      username: string
    ): Observable<Object> {
      const formData = new FormData();
      formData.append('chatId', chatId);
      formData.append('image', image);
      formData.append('fileType', fileType);
      formData.append('username', username);
      return this.http.post('http://localhost:8081/ForumChat/media/message',formData);
  
    
    }

    getMediaById( id:string){
      return  this.http.get<Media>('http://localhost:8081/ForumChat/media'+'/'+ id);
    }
  //des manipulations services


private idSubject = new BehaviorSubject<number>(0); // Initialisez avec une valeur par défaut
id$: Observable<number> = this.idSubject.asObservable();

setId(id: number) {
  this.idSubject.next(id);
}

getId(): Observable<number> {
  return this.id$;
}
}
