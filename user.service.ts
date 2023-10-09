import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseURL = "http://localhost:8080/FlightBooking.Com";

  constructor(private httpClient: HttpClient, private router:Router) {}

  signup(user:User):Observable<any>
  {
     const headers={'content-type':'application/json'};
     const body=JSON.stringify(user);
     return this.httpClient.post(`${this.baseURL}/signup`,body,{'headers':headers});
  }
  isUserLoggedIn() {
    let status = sessionStorage.getItem('loginStatus')
    console.log(status === null)
    return !(status === null)
  }
  logout() {
    sessionStorage.removeItem('loginStatus')
    sessionStorage.removeItem('email')
    sessionStorage.removeItem('userId')
    sessionStorage.removeItem('userRole')
    sessionStorage.removeItem('userName')
  }
}