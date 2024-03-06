import { Component } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { AddjobOfferComponent } from "src/app/Components/RecruitementComponents/addjob-offer/addjob-offer.component";

@Component({
  selector: "app-nav-bar",
  templateUrl: "./nav-bar.component.html",
  styleUrls: ["./nav-bar.component.css"],
})
export class NavBarComponent {
  constructor(private dialog: MatDialog) {}
  opendialog(event: Event) {
    event.preventDefault();
    this.dialog.open(AddjobOfferComponent);
  }
}
