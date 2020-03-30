import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Case} from '../models/case';
import {BASE_URL} from "../helpers/constants";

@Injectable({
  providedIn: 'root'
})
export class CasesService {

  constructor(private http: HttpClient) { }

  getAllCases(): Observable<Case[]>{
    let casesUrl = BASE_URL+"/v1/cases";
    let headers = {
        'Access-Control-Allow-Origin': true
      };
    // @ts-ignore
    return this.http.get<Case[]>(casesUrl, headers);
  }

  createNewCase(formData: FormData): Observable<any>{
      const url = BASE_URL+'/v1/cases';
      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type':  'application/json',
        })
      };
      let puiCase = {};
      formData.forEach((value, key) => {
        puiCase[key] = value;

        console.log(key+" : "+value);
      });
      let json = JSON.stringify(puiCase);
      return this.http.post(url, puiCase, httpOptions);
  }

}
