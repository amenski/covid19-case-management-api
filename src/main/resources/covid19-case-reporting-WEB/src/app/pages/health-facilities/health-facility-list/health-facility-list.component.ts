import { Component, OnInit } from '@angular/core';
import {HealthFacilitiesService} from "../../../services/health-facilities.service";
import {HealthFacilities} from "../../../models/health-facilities";

@Component({
  selector: 'app-health-facility-list',
  templateUrl: './health-facility-list.component.html',
  styleUrls: ['./health-facility-list.component.scss']
})
export class HealthFacilityListComponent implements OnInit {
  facilities: HealthFacilities[];
  constructor(private healthFacilitiesService: HealthFacilitiesService) { }

  ngOnInit() {
    this.healthFacilitiesService.getFacilities().subscribe(result=>{
      this.facilities = result;
    })

  }

}
