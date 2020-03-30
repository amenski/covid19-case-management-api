import { Routes } from "@angular/router";

import { DashboardComponent } from "../../pages/dashboard/dashboard.component";
import { CasesComponent } from "../../pages/cases/cases.component";
import { HealthFacilitiesComponent } from "../../pages/health-facilities/health-facilities.component";
import { NotificationsComponent } from "../../pages/notifications/notifications.component";
import { UserComponent } from "../../pages/user/user.component";
import { TablesComponent } from "../../pages/tables/tables.component";
import { TypographyComponent } from "../../pages/typography/typography.component";
import {AuthGuard} from "../../helpers/auth.guard";
import {LoginComponent} from "../../pages/login/login.component";
// import { RtlComponent } from "../../pages/rtl/rtl.component";

export const AdminLayoutRoutes: Routes = [
  // { path: "login", component: LoginComponent},
  { path: "home", component: DashboardComponent, canActivate: [AuthGuard]},
  { path: "cases", component: CasesComponent, canActivate: [AuthGuard] },
  { path: "health-facilities", component: HealthFacilitiesComponent, canActivate: [AuthGuard] },
  { path: "follow-up", component: NotificationsComponent, canActivate: [AuthGuard] },
  { path: "questionnaire", component: UserComponent },
  { path: "user", component: TablesComponent },
  // { path: "typography", component: TypographyComponent },
];
