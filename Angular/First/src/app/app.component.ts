import { Component, OnInit } from '@angular/core';
import { FirstServiceService } from './first-service.service'; 

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit  {
  title = 'First';
  name!: string ;

  userDetails!: object;

  constructor(public firstService:FirstServiceService){

  }

  ngOnInit(): void {
    // this.firstService.setUserDetails("Ops Tech😥");
    console.log(this.firstService.getUserDetails())
  }

  getDetails(){
    console.log(this.firstService.getUserDetails())
  }

  printData(data:string){
    console.log(data);
  }

  printYohoho(data:string){
    console.log(`Vakari masta ${data}`)
  }

  setUserDetails(userDetails:object){
    this.userDetails = userDetails;
    console.log(`UserDetails : ${userDetails}`)
  }

}
