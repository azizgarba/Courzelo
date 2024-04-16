import { Component, OnInit } from '@angular/core';
import { Evaluation } from 'src/app/Models/EvaluationEntities/Evaluation';
import { EvaluationService } from 'src/app/Services/EvaluationServices/evalServices/evaluation.service';

@Component({
  selector: 'app-grades',
  templateUrl: './grades.component.html',
  styleUrls: ['./grades.component.css']
})

export class GradesComponent implements OnInit {
  evaluations! : Evaluation[] 
  EvaluationData!: Evaluation;

  constructor(private evaluationService: EvaluationService ) { }

  ngOnInit() {
    this.loadGrades();
  }
  loadGrades(): void {
    this.evaluationService.getAllEvaluationsByStudent("65e8948961747f0e353cfe85").subscribe(
      (data: Evaluation[]) => {
        this.evaluations = data;
        this.ModuleGrade(); 
      },
      (error) => {
        console.error('Error fetching modules: ', error);
      }
    );

  }
  ModuleGrade() {
    if (this.evaluations && Array.isArray(this.evaluations)) {
      for (const evaluation of this.evaluations) {
        console.log('Module id', evaluation.module.id);
        console.log('student id', evaluation.student.id);

        this.evaluationService.moduleEvaluation(evaluation.module.id, evaluation.student.id).subscribe(
          (data: Evaluation) => {
            this.EvaluationData = data;
            // Effectuez le calcul du grade du module ici et mettez à jour l'évaluation
            // ...
  
            console.log('Module evaluation data:', data);
          },
          (error) => {
            console.error('Error fetching module evaluation: ', error);
            // Ajoutez ce log pour afficher le détail de l'erreur
            console.error('Error details:', error.error);
          }
        );
      }
    } else {
      console.error('Evaluations data is undefined or not an array.');
    }
  }
  
  
}