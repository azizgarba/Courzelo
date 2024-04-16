import { Component, OnInit } from "@angular/core";
import { JobOfferService } from "src/app/Services/RecruitementServices/job-offer.service";

@Component({
  selector: "app-addjob-offer",
  templateUrl: "./addjob-offer.component.html",
  styleUrls: ["./addjob-offer.component.css"],
})
export class AddjobOfferComponent implements OnInit {
  JobOffer = {
    title: "",
    description: "",
    skills: "",
    speciality: "",
    experience: "",
  };
  submitted = false;

  constructor(private jobOfferService: JobOfferService) {}

  ngOnInit() {}

  onSubmit() {
    console.log("Form Submitted!");
  }
  saveJobOffer() {
    const data = {
      title: this.JobOffer.title,
      description: this.JobOffer.description,
      skills: this.JobOffer.skills,
      speciality: this.JobOffer.speciality,
      experience: this.JobOffer.experience,
    };

    this.jobOfferService.create(data).subscribe(
      (response) => {
        console.log(response);
        this.submitted = true;
      },
      (error) => {
        console.log(error);
      }
    );
  }
  newJobOffer() {
    this.submitted = false;
    this.JobOffer = {
      title: "",
      description: "",
      skills: "",
      speciality: "",
      experience: "",
    };
  }
}
