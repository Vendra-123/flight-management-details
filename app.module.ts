import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FlightListComponent } from './flight-list/flight-list.component';
import { CreateFlightComponent } from './create-flight/create-flight.component';
import { UpdateFlightComponent } from './update-flight/update-flight.component';
import { ViewFlightComponent } from './view-flight/view-flight.component';
//import { FlightComponent } from './flight.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';

import { AboutUsComponent } from './about-us/about-us.component';
import { LogoutComponent } from './logout/logout.component';

import { UpdateFlightCompanyComponent } from './update-flight-company/update-flight-company.component';
import { ViewFlightCompanyComponent } from './view-flight-company/view-flight-company.component';
import { CreateFlightCompanyComponent } from './create-flight-company/create-flight-company.component';
import { FlightCompanyListComponent } from './flight-company-list/flight-company-list.component';

import { CreateAirportComponent } from './create-airport/create-airport.component';
import { AirportListComponent } from './airport-list/airport-list.component';
import { UpdateAirportComponent } from './update-airport/update-airport.component';
import { ViewAirportComponent } from './view-airport/view-airport.component';

import { CreateFeedbackComponent } from './create-feedback/create-feedback.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { ContactUsComponent } from './contact-us/contact-us.component';


//@import{MatCardModule}from '@angular/material/card';


@NgModule({
  declarations: [
    AppComponent,
    FlightListComponent,
    CreateFlightComponent,
    UpdateFlightComponent,
    ViewFlightComponent,
    SignInComponent,
    SignUpComponent,
    
    AboutUsComponent,
    LogoutComponent,
  
    UpdateFlightCompanyComponent,
    ViewFlightCompanyComponent,
    CreateFlightCompanyComponent,
    FlightCompanyListComponent,
    
    CreateAirportComponent,
    AirportListComponent,
    UpdateAirportComponent,
    ViewAirportComponent,
  
    CreateFeedbackComponent,
       FeedbackComponent,
       ContactUsComponent,
       
   
   // FlightComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    //eactiveFormsModule,
   // HttpClientModule,
   // MatCardModule,
   // MatButtonModule,
   // MatIconModule,
   // MatFormFieldModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }