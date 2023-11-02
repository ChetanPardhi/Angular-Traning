import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FirstServiceService {

  constructor() { }

  detail! : string ;

  yoho !: string;

  getUserDetails(){
    return this.detail;
  }

  setUserDetails(vara:string) : void{
    this.detail = vara;
  }
  
  setYohoho(name:string):void{
    console.log(name);
    this.yoho = name;
  }

  getYohoho(){
    return this.yoho;
  }
}
