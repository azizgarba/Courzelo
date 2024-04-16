import { Component, OnInit } from "@angular/core";
import { Feedback } from "src/app/Models/FeedBackEntitie/Feedback";
import { FeedbackService } from "src/app/Services/FeedBackServices/feedback.service";
declare var Morris: any;
@Component({
  selector: "app-view-feedbacks",
  templateUrl: "./view-feedbacks.component.html",
  styleUrls: ["./view-feedbacks.component.css"],
})
export class ViewFeedbacksComponent implements OnInit {
  feedbackList: any;
  moduleFeedback: any;
  teacherFeedback: any;
  chartData: any;

  constructor(private feedbackService: FeedbackService) {}

  ngOnInit() {
    this.fetchFeedbacks();
  }

  fetchFeedbacks() {
    this.feedbackService.getAll().subscribe(
      (response) => {
        this.feedbackList = response;
        this.groupbFeedbackByType();
        this.rendergraph();
        console.log(response);
      },
      (error) => {
        console.log(error);
      }
    );
  }
  groupbFeedbackByType() {
    this.moduleFeedback = this.feedbackList.filter(
      (feedback: Feedback) => feedback.typeFeedback.toString() == "Module"
    );
    this.teacherFeedback = this.feedbackList.filter(
      (feedback: Feedback) => feedback.typeFeedback.toString() === "Teacher"
    );

    // count
    const modulefeedbackCount = this.moduleFeedback.length;
    const teacherfeedbackCount = this.teacherFeedback.length;

    this.chartData = [
      { label: "Module", value: modulefeedbackCount },
      { label: "Teacher", value: teacherfeedbackCount },
    ];
  }
  rendergraph() {
    new Morris.Donut({
      element: "morris-donut-example",
      data: this.chartData,
      labels: ["value"],
    });
  }
}
