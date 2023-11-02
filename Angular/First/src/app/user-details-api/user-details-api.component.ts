import { Component , Output , EventEmitter} from '@angular/core';
import { FirstServiceService } from '../first-service.service';
import { UserApiServiceService } from '../user-api-service.service';

@Component({
  selector: 'app-user-details-api',
  templateUrl: './user-details-api.component.html',
  styleUrls: ['./user-details-api.component.css']
})

export class UserDetailsApiComponent {

  userData !: object

  @Output() userDetailsEvent = new EventEmitter();

  constructor(public userService : FirstServiceService , public apiService : UserApiServiceService){}
  
  setUserdetails(){
    // this.userDetailsEvent.emit(this.userData);
     this.apiService.setApiUserDetails().subscribe((res) => this.userData = res);
    
  }

  // getUserDetails(){
  //   this.apiService.
  // }

}
