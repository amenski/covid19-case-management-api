import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {CasesService} from "../../../services/cases.service";

@Component({
  selector: 'app-add-cases',
  templateUrl: './add-cases.component.html',
  styleUrls: ['./add-cases.component.scss']
})
export class AddCasesComponent implements OnInit {
  form: FormGroup;
  cityName: string;
  country: string;
  constructor(public fb: FormBuilder, private casesService: CasesService) {
    this.form = this.fb.group({
      caseCode: '',
      firstName: '',
      lastName: ''
    })
  }

  ngOnInit() {
  }

  addCase() {
    console.log("Adding a new Case "+ this.form.get('caseCode').value);
    let formData: any = new FormData();
    formData.append("firstName", this.form.get('firstName').value);
    formData.append("lastName", this.form.get('lastName').value);
    this.casesService.createNewCase(formData).subscribe(result=>{
      alert(result);
    })

  }
}
