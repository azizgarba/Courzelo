import { Component, OnInit } from "@angular/core";
import { JobOfferService } from "src/app/Services/RecruitementServices/job-offer.service";

@Component({
  selector: "app-job-offer",
  templateUrl: "./job-offer.component.html",
  styleUrls: ["./job-offer.component.css"],
})
export class JobOfferComponent implements OnInit {
  jobOffers: any;
  title = "";
  currentJobOffer: any;
  currentIndex = -1;
  message = "";

  constructor(private jobofferService: JobOfferService) {}

  ngOnInit() {
    this.message = "";
    this.retrieveJobOffers();
  }
  retrieveJobOffers() {
    this.jobofferService.getAll().subscribe(
      (data) => {
        this.jobOffers = data;
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    );
  }
  searchTitle() {
    this.jobofferService.findbytitle(this.title).subscribe(
      (data) => {
        this.jobOffers = data;
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    );
  }
  setActiveJobOffer(jobOffer: any, index: any) {
    this.currentJobOffer = jobOffer;
    this.currentIndex = index;
  }
  deletejobOffer(id: any) {
    this.jobofferService.delete(id).subscribe(
      (response) => {
        console.log(response);
        this.retrieveJobOffers();
      },
      (error) => {
        console.log(error);
      }
    );
  }
  getJobOffer(id: any) {
    this.jobofferService.get(id).subscribe(
      (data) => {
        this.currentJobOffer = data;
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    );
  }
  updatejobOffer() {
    this.jobofferService
      .update(this.currentJobOffer.id, this.currentJobOffer)
      .subscribe(
        (response) => {
          console.log(response);
          this.message = "The job offer was updated successfully!";
          this.retrieveJobOffers();
        },
        (error) => {
          console.log(error);
        }
      );
  }
}
