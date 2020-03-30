import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {BASE_URL} from "../helpers/constants";
import {HealthFacilities} from "../models/health-facilities";

@Injectable({
  providedIn: 'root'
})
export class HealthFacilitiesService {

  constructor(private httpClient: HttpClient) { }

  getFacilities(): Observable<HealthFacilities[]>{
    let headers =
      {
        'Access-Control-Allow-Origin': true
      };
    let facilitiesUrl = BASE_URL+"/v1/health-facilities";
    // @ts-ignore
    return this.httpClient.get(facilitiesUrl, headers);
  }
}
