import { Component, OnInit } from "@angular/core";
import {Case} from '../../models/case';
import {CasesService} from "../../services/cases.service";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: "app-icons",
  templateUrl: "cases.component.html"
})
export class CasesComponent implements OnInit {
  constructor() {}

  ngOnInit() {

  }

}
