import * as SockJS from 'sockjs-client';


import { Stomp } from '@stomp/stompjs';
import { ModalpopupComponentComponent } from 'src/app/Components/Forum/modalpopup-component/modalpopup-component.component';
import { ChatComponent } from 'src/app/Components/Forum/chat/chat.component';

export class WebSocketAPI {
    webSocketEndPoint: string = 'http://localhost:8081/ws';
    topic: string = "/topic/greetings";
    stompClient: any;
    appComponent: ChatComponent;
    connectCallback!: () => void;

    constructor(appComponent: ChatComponent) {
        this.appComponent = appComponent;
    }

    _connect() {
      console.log('Initialize WebSocket Connection');
      const ws = new SockJS(this.webSocketEndPoint);
      this.stompClient = Stomp.over(ws);
      this.stompClient.connect({}, () => {
        this.stompClient.subscribe(this.topic, (sdkEvent: string) => {
          this.onMessageReceived(sdkEvent);
        })
        console.log('WebSocket Connected !!!!');
        if (this.connectCallback) {
          this.connectCallback(); // Appeler le callback une fois la connexion établie
        }
      }, this.errorCallBack.bind(this));
    }
    
      _disconnect() {
        if (this.stompClient !== null) {
          this.stompClient.disconnect();
          console.log('WebSocket Disconnected');
        }
      }
    
      errorCallBack(error: string) {
        console.error('WebSocket Error: ', error);
      }
    
      _send(message: any) {
      
        this.stompClient.send('/app/hello', {}, JSON.stringify(message));
        console.log('Sending message via WebSocket: ', message);
      }
      _subscribeToChatRoom() {
        // Remplacez '/topic/chat/{chatId}' par le sujet WebSocket approprié
        this.stompClient.subscribe('/topic/greetings', (message:any) => {
            // Traitement du message reçu
            console.log('Message received from chat room:', message.body);
            // Vous pouvez traiter le message comme bon vous semble ici
        });
    }
    onMessageReceived(message: string) {
    
        console.log("Message Received from Server :: " + message);
        this.appComponent.handleMessage11(JSON.stringify(message));
     }
    onConnect(callback: () => void) {
      this.connectCallback = callback;
    }
}
