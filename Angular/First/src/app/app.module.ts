import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http'; 

import { AppComponent } from './app.component';
import { FirstNewComponent } from './first-new/first-new.component';
import { UserDetailsApiComponent } from './user-details-api/user-details-api.component';

@NgModule({
  declarations: [
    AppComponent,
    FirstNewComponent,
    UserDetailsApiComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
