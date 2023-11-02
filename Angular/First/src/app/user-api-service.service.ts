import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class UserApiServiceService {
  data!: object;

  API_URL: string = 'http://localhost:8080/userList';

  constructor(private http: HttpClient) {}

  setApiUserDetails() {
    console.log('hii');
    return this.http.get(this.API_URL);
    // console.log(this.data)
  }

  getApiUserDetails() {
    console.log('hii');
    return this.data;
  }
}
