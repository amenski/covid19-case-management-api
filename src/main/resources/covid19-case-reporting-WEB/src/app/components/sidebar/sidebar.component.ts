import { Component, OnInit } from "@angular/core";

declare interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}
export const ROUTES: RouteInfo[] = [
  {
    path: "/home",
    title: "Dashboard",
    icon: "icon-chart-pie-36",
    class: ""
  },
  {
    path: "/cases",
    title: "Cases",
    icon: "icon-atom",
    class: ""
  },
  {
    path: "/follow-up",
    title: "PUI Follow Up",
    icon: "icon-pin",
    class: "" },
  {
    path: "/health-facilities",
    title: "Health Facilities",
    icon: "icon-bell-55",
    class: ""
  },
  {
    path: "/questionnaire",
    title: "Questionnaire",
    icon: "icon-puzzle-10",
    class: ""
  },

  {
    path: "/user",
    title: "User Profile",
    icon: "icon-single-02",
    class: ""
  }
];

@Component({
  selector: "app-sidebar",
  templateUrl: "./sidebar.component.html",
  styleUrls: ["./sidebar.component.css"]
})
export class SidebarComponent implements OnInit {
  menuItems: any[];

  constructor() {}

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }
  isMobileMenu() {
    if (window.innerWidth > 991) {
      return false;
    }
    return true;
  }
}
