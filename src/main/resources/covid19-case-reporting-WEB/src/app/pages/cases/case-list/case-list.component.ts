import { Component, OnInit } from '@angular/core';
import {Case} from '../../../models/case';
import {CasesService} from "../../../services/cases.service";

@Component({
  selector: 'app-city-list',
  templateUrl: './case-list.component.html',
  styleUrls: ['./case-list.component.scss']
})
export class CaseListComponent implements OnInit {
  cases: Case[];
  constructor(private casesService: CasesService) {}

  ngOnInit() {
    this.casesService.getAllCases().subscribe(result=>{
      this.cases = result;
    })
  }

}
