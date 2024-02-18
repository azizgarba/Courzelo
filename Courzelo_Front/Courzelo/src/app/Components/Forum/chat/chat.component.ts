import { Component } from '@angular/core';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent {
  isDone: boolean = false;

  markDone() {
    this.isDone = true; // Set the task state to 'done'
  }

}
