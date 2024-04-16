import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { TypeFeedback } from "src/app/Models/FeedBackEntitie/Feedback";
import { FeedbackService } from "src/app/Services/FeedBackServices/feedback.service";

@Component({
  selector: "app-add-feedback-module",
  templateUrl: "./add-feedback-module.component.html",
  styleUrls: ["./add-feedback-module.component.css"],
})
export class AddFeedbackModuleComponent implements OnInit {
  contactForm!: FormGroup;
  modules: string[] = ["Module A", "Module B", "Module C"]; // Define your list of modules here
  constructor(
    private fb: FormBuilder,
    private feedbackService: FeedbackService
  ) {}

  ngOnInit() {
    this.contactForm = this.fb.group({
      description: ["", Validators.required],
      selectedModule: ["", Validators.required], // Add a form control for the selected module
    });
  }
  onSubmit() {
    if (this.contactForm.valid) {
      // Process form submission
      console.log(this.contactForm.value);
    } else {
      // Handle form validation errors
      alert("Please provide your feedback and select a module.");
    }
  }

  saveFeedback() {
    if (this.contactForm.valid) {
      // Initialize TypeFeedback entity with "Module"
      const feedbackData = {
        ...this.contactForm.value,
        type: TypeFeedback.Module,
      };

      // Save feedback to the database
      this.feedbackService.create(feedbackData).subscribe(
        (response) => {
          console.log(response);
          alert("Feedback submitted successfully!");
        },
        (error) => {
          console.log(error);
          alert("An error occurred while submitting your feedback.");
        }
      );
    } else {
      // Handle form validation errors
      alert("Please provide your feedback and select a module.");
    }
  }
}
