import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import {map} from 'rxjs/operators';
import {BASE_URL} from '../helpers/constants'
import { User } from '../models/user';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
  user: User;
  private currentUserSubject: BehaviorSubject<User>;
  public currentUser: Observable<User>;

  constructor(private http: HttpClient) {
    this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
    this.user = new User();
  }

  login(username: string, password: string): Observable<any> {
    this.user.email = username;
    this.user.password = password;
    return this.http.post<any>(BASE_URL+'/v1/authenticate', this.user )

      .pipe(map(res => {
        // login successful if there's a jwt token in the response
          this.user.token = res.jwtToken;
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem('currentUser', JSON.stringify(this.user));
          this.currentUserSubject.next(this.user);
        return this.user;
      }));
  }
  public get currentUserValue(): User {
    return this.currentUserSubject.value;
  }
  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }
}
