import { Component } from '@angular/core';
import { Evaluation } from 'src/app/Models/EvaluationEntities/Evaluation';
import { UserCourzelo } from 'src/app/Models/UserCorzelo/UserCourzelo';
import { EvaluationService } from 'src/app/Services/EvaluationServices/evalServices/evaluation.service';

@Component({
  selector: 'app-rewards-statistics',
  templateUrl: './rewards-statistics.component.html',
  styleUrls: ['./rewards-statistics.component.css']
})
export class RewardsStatisticsComponent {
  studentStatistics: UserCourzelo | undefined;
  evaluations!: Evaluation[];
  moduleEvaluations: any[] = [];
  strengths !: string[];
  weaknesses !: string[];

  constructor(private evaluationService: EvaluationService) {}

  ngOnInit(): void {
    this.loadStudentPerformanceStatistics('65e8948961747f0e353cfe85'); // Remplacez 'student-id' par l'identifiant réel de l'étudiant
 this.loadStudentStatistics('65e8948961747f0e353cfe85');
 this.loadStudentstrengths('65e8948961747f0e353cfe85');
 this.loadStudentweaknesses('65e8948961747f0e353cfe85');
  }

  loadStudentPerformanceStatistics(studentId: string): void {
    this.evaluationService.getStudentPerformanceStatistics(studentId)
      .subscribe(
        (data: UserCourzelo) => {
          this.studentStatistics = data;
        },
        (error) => {
          console.error('Erreur lors de la récupération des statistiques de performance de l\'étudiant:', error);
        }
      );
  }
  loadStudentStatistics(studentId: string): void {
    this.evaluationService.getAllEvaluationsByStudent(studentId)
    .subscribe(
      (data: Evaluation[]) => {
        this.evaluations = data;
        console.log("lalala", data);
        this.moduleEvaluations = data;
      },
      (error) => {
        console.error('Erreur lors de la récupération des évaluations de l\'étudiant:', error);
        // Afficher un message d'erreur à l'utilisateur ou prendre une autre action
      }
    );
  

    }

    loadStudentstrengths(studentId: string): void {
      this.evaluationService.getStrengths(studentId)
      .subscribe(
        (data: string[]) => {
          this.strengths = data;
          console.log("strengths", data);
      
        },
        (error) => {
          console.error('Erreur lors de la récupération des évaluations de l\'étudiant:', error);
          // Afficher un message d'erreur à l'utilisateur ou prendre une autre action
        }
      );
}

loadStudentweaknesses(studentId: string): void {
  this.evaluationService.getWeaknesses(studentId)
  .subscribe(
    (data: string[]) => {
      this.weaknesses = data;
      console.log("weaknesses", data);
  
    },
    (error) => {
      console.error('Erreur lors de la récupération des évaluations de l\'étudiant:', error);
      // Afficher un message d'erreur à l'utilisateur ou prendre une autre action
    }
  );
}
}