import { Component, Input, Output, OnChanges, EventEmitter ,OnInit, SimpleChanges } from '@angular/core';
import { FirstServiceService } from '../first-service.service';

@Component({
  selector: 'app-first-new',
  templateUrl: './first-new.component.html',
  styleUrls: ['./first-new.component.css']
})
export class FirstNewComponent implements OnInit , OnChanges {

  info = "Hii This info is from NewComponent";

  @Output() dataEvent = new EventEmitter();

  @Input() data! : String;

  public _title !:string;

  @Input()
  public set title(title:string){
    this._title=title;
  }

  public get title(){
    return this._title;
  }

  ngOnInit(): void {
    console.log("hello")
    
  }

  ngOnChanges(changes: SimpleChanges): void {
    
  }

  constructor(public userService : FirstServiceService){

  }

  setDetailsOfUser():void{
    this.userService.setUserDetails(this.info);
  }

  firstButton(){
    this.dataEvent.emit(this.userService.getUserDetails())
  }
 
}


