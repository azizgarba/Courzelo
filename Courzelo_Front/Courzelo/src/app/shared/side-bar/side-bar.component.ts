import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { VoteConsumerService } from 'src/app/Services/ForumService/vote-consumer.service';
import { TokenStorageService } from 'src/app/Services/UserCorzeloServices/token-storage.service';
import { UserService } from 'src/app/Services/UserCorzeloServices/user.service';

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent {
  content?: string;
  private roles: string[] = [];
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username?: string;

  rangeVote!:number
  rangeExp!:number;
  rangeBadge!:number;
  

  constructor(private voteService:VoteConsumerService,private userService: UserService,private tokenStorageService: TokenStorageService,private router:Router) { }

  ngOnInit(): void {
  
      ///For session 
      this.isLoggedIn = !!this.tokenStorageService.getToken();

      if (this.isLoggedIn) {
        const user = this.tokenStorageService.getUser();
        this.roles = user.roles;
  
        this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
        this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');
  
        this.username = user.username;
      }
      
  
    
      
  }
  logout(): void {
    this.tokenStorageService.signOut();
    //window.location.reload();
    this.router.navigateByUrl('/login')
    
  }

}
