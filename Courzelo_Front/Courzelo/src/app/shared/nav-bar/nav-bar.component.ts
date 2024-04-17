import { Component, OnInit } from '@angular/core';
import { NotificationService } from 'src/app/Services/ProjectServices/notification.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  notificationCount: number = 0;
notifications: string[] = []; // Array to hold notifications

  constructor(private notificationService: NotificationService) { }

  ngOnInit() {
    // Load notifications from localStorage on component initialization
    const storedNotificationsString = localStorage.getItem('notifications');
    if (storedNotificationsString) {
      try {
        this.notifications = JSON.parse(storedNotificationsString); // Assign stored notifications to notifications array
        this.notificationCount = this.notifications.length; // Update notification count
      } catch (error) {
        console.error('Error parsing stored notifications:', error);
      }
    }

    // Subscribe to new notifications
    this.notificationService.getNotifications().subscribe((notification: string) => {
      console.log('Notification Received:', notification);
      this.notifications.push(notification); // Add new notification to the array
      this.notificationCount = this.notifications.length; // Update notification count
    });
  }
 // Method to clear all notifications
 clearNotifications() {
  localStorage.removeItem('notifications'); // Remove notifications from localStorage
  this.notifications = []; // Clear notifications array
  this.notificationCount = 0; // Reset notification count
}
}
