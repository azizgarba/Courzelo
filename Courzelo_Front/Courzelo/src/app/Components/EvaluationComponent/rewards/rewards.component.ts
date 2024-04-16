import { Component } from '@angular/core';
import { Evaluation } from 'src/app/Models/EvaluationEntities/Evaluation';
import { UserCourzelo, badgeType } from 'src/app/Models/UserCorzelo/UserCourzelo';
import { EvaluationService } from 'src/app/Services/EvaluationServices/evalServices/evaluation.service';

@Component({
  selector: 'app-rewards',
  templateUrl: './rewards.component.html',
  styleUrls: ['./rewards.component.css']
})
export class RewardsComponent {
  evaluations! : Evaluation[] 
  userData!: UserCourzelo;
   silverBadge !: number;
   dimondBadge !: number;
   bronzeBadge !: number;
   goldBadge !: number;

  constructor(private evaluationService: EvaluationService ) { }

  ngOnInit() {
    this.StudentRewards();
  }

  StudentRewards() {
   
        this.evaluationService.getStudentById("65e8948961747f0e353cfe85").subscribe(
          (data: UserCourzelo) => {
            this.userData = data;
            console.log('user data:', this.userData);

            this.evaluationService.getStudentSilverBadges(this.userData.id).subscribe(
              (data: number) => {
                this.silverBadge = data;
    
                console.log('user data:', this.silverBadge);
              },
              (error) => {
                console.error('Error fetching user data: ', error);
                console.error('Error details:', error.error);
              }
            );




            this.evaluationService.getStudentbronzeBadges(this.userData.id).subscribe(
              (data: number) => {
                this.bronzeBadge = data;
    
                console.log('user data:', this.silverBadge);
              },
              (error) => {
                console.error('Error fetching user data: ', error);
                console.error('Error details:', error.error);
              }
            );






            this.evaluationService.getStudentDimondBadges(this.userData.id).subscribe(
              (data: number) => {
                this.dimondBadge = data;
    
                console.log('user data:', this.silverBadge);
              },
              (error) => {
                console.error('Error fetching user data: ', error);
                console.error('Error details:', error.error);
              }
            );




            this.evaluationService.getStudentgoldBadges(this.userData.id).subscribe(
              (data: number) => {
                this.goldBadge = data;
    
                console.log('user data:', this.silverBadge);
              },
              (error) => {
                console.error('Error fetching user data: ', error);
                console.error('Error details:', error.error);
              }
            );



          },
          (error) => {
            console.error('Error fetching user data: ', error);
            console.error('Error details:', error.error);
          }
        );
        
     
       

  }
}


