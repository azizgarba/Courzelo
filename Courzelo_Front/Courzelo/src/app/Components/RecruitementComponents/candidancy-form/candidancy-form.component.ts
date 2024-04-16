import { Component, Inject } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { MAT_DIALOG_DATA } from "@angular/material/dialog";
import { ActivatedRoute } from "@angular/router";
import { Candidacy } from "src/app/Models/RecruitementEntities/Candidacy";
import { CandidancyService } from "src/app/Services/RecruitementServices/candidancy.service";

@Component({
  selector: "app-candidancy-form",
  templateUrl: "./candidancy-form.component.html",
  styleUrls: ["./candidancy-form.component.css"],
})
export class CandidancyFormComponent {
  submitted = false;
  jobId: any;
  candidacyForm = new FormGroup({
    description: new FormControl("", Validators.required),
    skills: new FormControl("", Validators.required),
    experience: new FormControl("", Validators.required),
    resume: new FormControl("", Validators.required),
  });

  constructor(
    private candidacyService: CandidancyService,
    private route: ActivatedRoute
  ) {
    this.jobId = this.route.snapshot.paramMap.get("jobId");
  }

  ngOnInit() {}

  onSubmit() {
    if (this.candidacyForm.valid) {
      const candidacy = this.candidacyForm.value;
      this.candidacyService
        .createCandidancy(candidacy, this.jobId)
        .subscribe((response) => {
          console.log(response);
        });
    }
  }
}
