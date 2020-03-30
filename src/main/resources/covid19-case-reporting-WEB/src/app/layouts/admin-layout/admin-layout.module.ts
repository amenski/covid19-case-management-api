import { NgModule } from "@angular/core";
import { HttpClientModule } from "@angular/common/http";
import { RouterModule } from "@angular/router";
import { CommonModule } from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

import { AdminLayoutRoutes } from "./admin-layout.routing";
import { DashboardComponent } from "../../pages/dashboard/dashboard.component";
import { CasesComponent } from "../../pages/cases/cases.component";
import { HealthFacilitiesComponent } from "../../pages/health-facilities/health-facilities.component";
import { NotificationsComponent } from "../../pages/notifications/notifications.component";
import { UserComponent } from "../../pages/user/user.component";
import { TablesComponent } from "../../pages/tables/tables.component";
import { TypographyComponent } from "../../pages/typography/typography.component";
// import { RtlComponent } from "../../pages/rtl/rtl.component";

import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import {CaseListComponent} from "../../pages/cases/case-list/case-list.component";
import {AddCasesComponent} from "../../pages/cases/add-cases/add-cases.component";
import {HealthFacilityListComponent} from "../../pages/health-facilities/health-facility-list/health-facility-list.component";
import {AddHealthFacilityComponent} from "../../pages/health-facilities/add-health-facility/add-health-facility.component";
import {LoginComponent} from "../../pages/login/login.component";

@NgModule({
    imports: [
        CommonModule,
        RouterModule.forChild(AdminLayoutRoutes),
        FormsModule,
        HttpClientModule,
        NgbModule,
        ReactiveFormsModule,
    ],
  declarations: [
    DashboardComponent,
    UserComponent,
    TablesComponent,
    CasesComponent,
    CaseListComponent,
    AddCasesComponent,
    TypographyComponent,
    NotificationsComponent,
    HealthFacilitiesComponent,
    HealthFacilityListComponent,
    AddHealthFacilityComponent
    // RtlComponent
  ]
})
export class AdminLayoutModule {}
