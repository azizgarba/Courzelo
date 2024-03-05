import { Component, ViewChild, ElementRef, AfterViewInit, OnInit, ChangeDetectorRef } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, NavigationStart, Router } from '@angular/router';
import { Observable, Subscription, catchError, map, of } from 'rxjs';
import { ChatRoom } from 'src/app/Models/ForumEntities/ChatRoom';
import { Media } from 'src/app/Models/ForumEntities/Media';
import { Message } from 'src/app/Models/ForumEntities/Message';
import { UserCourzelo } from 'src/app/Models/UserCorzelo/UserCourzelo';
import { WebSocketAPI } from 'src/app/Services/ForumService/WebSocketAPI';
import { ChatConsumerServiceService } from 'src/app/Services/ForumService/chat-consumer-service.service';
import { ConsumerQuestionServiceService } from 'src/app/Services/ForumService/consumer-question-service.service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent   {
      //notif
      webSocketAPI!: WebSocketAPI;
      greeting: any;
      name!: "you recieve a message ";
    //
 
  pollingInterval: any;
  isDone: boolean = false;
   chatForm: FormGroup;
   msg = 'Good work';
  idq!:string;
  id!:number ;
  user!:UserCourzelo;
  public chatList!: ChatRoom [];
  public chatData: any;
  public chatRoom!: ChatRoom;
  public idSubscription!: Subscription;
  public idSubscription1!: Subscription;
  public idSubscription2!: Subscription;
  public messageList: Message []=[];
  usernameChatSender!: any ;
  replymessage: String = 'checking';
  messageObj: Message = new Message();
  sendermessage:any 
  chatId!: number ;
  reeiver1!:any;
  sender1!:any;
  replyMediaContent!:Media
  senderId:any;
  idnew!: number;
  userStorage:any
  dataUri!:any ; 
  scrollTop!: number;

  constructor(private cdr: ChangeDetectorRef,private chatService:ChatConsumerServiceService,private questionService:ConsumerQuestionServiceService,private route:Router)
    {
      this.chatForm = new FormGroup({
        replymessage: new FormControl(),
      });
  }
  ngAfterViewInit() {
    setTimeout(() => {
      // Modifier la valeur de scrollTop ici
      // Par exemple, si vous modifiez la valeur de scrollTop d'un élément avec un identifiant "scrollElement"
      const scrollElement = document.getElementById('scrollElement');
      if (scrollElement) {
        scrollElement.scrollTop = 675; // Modifier la valeur selon vos besoins
      }
      // Forcer la détection des modifications après l'initialisation
      this.cdr.detectChanges();
    });
  }

  ngOnInit(){
    //scroll
       //scroll
     
      //
   
     // notif
     this.webSocketAPI = new WebSocketAPI(new ChatComponent(this.cdr,this.chatService,this.questionService,this.route));

     // Écouter un événement ou utiliser un callback pour savoir quand la connexion est établie
     this.webSocketAPI.onConnect(() => {
       // Une fois la connexion établie, s'abonner à la salle de discussion
       this.webSocketAPI._subscribeToChatRoom();
   
     });
     
     // Établir la connexion WebSocket
     this.webSocketAPI._connect();
  
     
     //

    // Abonnez-vous aux événements de navigation du Router
    this.route.events.subscribe(event => {
      // Vérifiez si l'événement est un démarrage de navigation
      if (event instanceof NavigationStart) {
        // Si oui, arrêtez le processus de long polling
        this.stopLongPolling();
      }
    });
 
    //
    this.sendermessage=sessionStorage.getItem('User');
    //le id de user provint de question (receiver)
    this.idSubscription = this.questionService.getId().subscribe(id => {
      this.idq = id;
    });
    
    //le id de chat
    this.idSubscription1 = this.chatService.getId().subscribe(id => {
      this.id = id;
      sessionStorage.setItem('id', this.id.toString());
      
    });
    this.senderId =sessionStorage.getItem('UserSession')
    const idFromSessionStorage = sessionStorage.getItem('chatId');
    this.userStorage =sessionStorage.getItem('UserSession');

    // Check if idFromSessionStorage is not null before parsing
    if (idFromSessionStorage !== null && this.id==0) {
      // Parse the id to an integer
      this.id = parseInt(idFromSessionStorage, 10);
      this.idnew = parseInt(idFromSessionStorage, 10);
      this.chatService
      .getChatRoomsByUser()
      .subscribe((data) => {
        // console.log(data);
        this.chatData = data;
        this.chatList = this.chatData;
    
       
      });
      this.pollingInterval =setInterval(() => {
      this.chatService.getChatById(this.idnew).subscribe(
        (data)=>{this.chatRoom=data
        
          this.messageList = this.chatRoom.messages;
          this.senderId=this.userStorage;
          this.reeiver1=this.chatRoom.receiver.firstName;
          this.sender1=this.chatRoom.sender.firstName;
        
     
       
        console.log("msg111**************",this.chatRoom.sender.firstName)  }
       
      )
    
    },1000) 
    } else {
      // Handle the case where the id is not found in sessionStorage
      console.error('ID not found in sessionStorage');
    
    console.log("***********idchayt:", idFromSessionStorage );
    
    //la list de chat pour le user en session
    this.chatService
    .getChatRoomsByUser()
    .subscribe((data) => {
      // console.log(data);
      this.chatData = data;
      this.chatList = this.chatData;
  
     
    });
    //recupére le user sender (je vais la refaire avec session) 
    this.pollingInterval =setInterval(() => {
    this.chatService.getChatById(this.id).subscribe(
      (data)=>{this.chatRoom=data
      
        this.messageList = this.chatRoom.messages;
        this.senderId=this.userStorage;
        this.reeiver1=this.chatRoom.receiver.firstName;
        this.sender1=this.chatRoom.sender.firstName;
      
   
     
      console.log("msg***************",this.chatRoom.sender.firstName)  }
     
    )},1000
    )
    
  }
    //this.usernameChatSender= sessionStorage.getItem('chatUser');
   

  }
  stopLongPolling(): void {
    // Arrêter le processus de long polling en effaçant l'intervalle
    clearInterval(this.pollingInterval);
  }
  ngOnDestroy() {
    if (this.idSubscription) {
      this.idSubscription.unsubscribe();
    }
    if (this.idSubscription1) {
      this.idSubscription1.unsubscribe();
    }
    if (this.idSubscription2) {
      this.idSubscription2.unsubscribe();
    }
    this.stopLongPolling();
    this.disconnect();
   
  }


  markDone() {
    this.isDone = true; // Set the task state to 'done'
  }
  sendMessage() {
    this.messageObj.replymessage = this.chatForm.value.replymessage;
    //local stoarge 
    //this.messageObj.sendermessage = this.sendermessage;
    if (this.messageObj.replymessage.length > 1) {
      this.chatService
        .sendMessage(this.messageObj, this.id)
        .subscribe((data) => {
          //console.log(data);
          this.chatForm.reset();
          this.sendMessageSocket(this.messageObj.replymessage)
          this.handleMessage11(this.messageObj.replymessage)
          console.log("greeeet",this.greeting);

          // for displaying the messageList by the chatId
          this.chatService.getChatById(this.id).subscribe((data: any) => {
            //console.log(data);
            this.chatData = data;
            // console.log(this.chatData.messageList);console.log(JSON.stringify(this.chatData.messageList));
      
              this.messageList = this.chatData .messages;
              this.senderId=this.userStorage;
              this.reeiver1=this.chatData .receiver.firstName;
              this.sender1=this.chatData .sender.firstName;
              this.cdr.detectChanges();
          });
        });
    }
    }

    getChatById(idc:number){
      this.chatService.getChatById(idc).subscribe(
        (data)=>{this.chatRoom=data
        
          this.messageList = this.chatRoom.messages;
          this.senderId=this.userStorage;
          this.reeiver1=this.chatRoom.receiver.firstName;
          this.sender1=this.chatRoom.sender.firstName;
        
     
       
        console.log("msg111**************",this.chatRoom.sender.firstName)  }
       
      )
    }
    getChatBy2Users(id2:string){
      this.chatService.getChatRoomByUse1AndUser2(id2).subscribe(
        (data) => {
         
            this.chatId = data.id;
            sessionStorage.setItem('chatId', this.chatId.toString());
            sessionStorage.setItem('UserSession', data.sender.id);
            sessionStorage.setItem('UserSession', data.sender.firstName);
            console.log("***************** the chat id ", this.chatId);
            this.chatService.setId(this.chatId);
            // Setting user session
            this.questionService.setuser(data.sender);
            this.route.navigate(['/forumChat']);
    
  })}

  sendMedia(event: any) {
    const idFromSessionStorage1 = sessionStorage.getItem('chatId');

   
    if (idFromSessionStorage1 !== null && event?.target?.files?.length)
       this.idnew = parseInt(idFromSessionStorage1, 10);
      this.chatService
        .updateMediaChat(
          this.idnew ,
          event.target.files[0],
          event.target.files[0]?.type,
          '65d3909015939e88eb26bd3c'
        )
        .subscribe((data) => {
          // for displaying the messageList by the chatId
          this.chatService.getChatById(this.idnew).subscribe((data: any) => {
           console.log(data);
            this.chatData = data;
            console.log(this.chatData.messageList);console.log(JSON.stringify(this.chatData.messageList));
            this.messageList = this.chatData.messageList;
            this.reeiver1 = this.chatData.secondUserName;
            this.sender1= this.chatData.firstUserName;
            this.cdr.detectChanges();
          });
        });
       
  }

  imageCache: { [key: string]: string } = {};

getMediaUri3(replyMedia: string): string {
  // If the image is already cached, return its Base64 data
  if (this.imageCache[replyMedia]) {
    return this.imageCache[replyMedia];
  }

  // If the image is not cached, fetch it from the service
  this.chatService.getMediaById(replyMedia).subscribe((data: any) => {
    this.replyMediaContent = data;
    const base64Data = `data:${this.replyMediaContent.fileType};base64,${this.replyMediaContent.picture.data}`;
    // Cache the Base64 data for future use
    this.imageCache[replyMedia] = base64Data;
    console.log(base64Data, "Base64 Data"); // Log to verify Base64 data
    this.cdr.detectChanges(); // Ensure change detection is triggered
  });
  

  // Initially return null or a placeholder image to avoid errors in template
  return "null"; // or return a placeholder image URL
}
  
//notif
connect(){
  this.webSocketAPI._connect();
  console.log("connexion*******")
}

disconnect(){
  this.webSocketAPI._disconnect();
}

sendMessageSocket(m:any) {
  // Check if WebSocket connection is available
  if (this.webSocketAPI && this.webSocketAPI.stompClient && this.webSocketAPI.stompClient.connected) {
      // Envoyer le message via WebSocket
      this.webSocketAPI._send({ message: m});
      console.log('Message sent!!!!!!!!!!: ', m);
  } else {
      console.error('WebSocket connection is not available.');
  }
}

handleMessage11(message:any){
  console.log('Message recieve!!!!!!!!!!: ', message);
  this.greeting = message;
}

   
 
}
