import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FlightListComponent } from './flight-list/flight-list.component';
import { CreateFlightComponent } from './create-flight/create-flight.component';
import { ViewFlightComponent } from './view-flight/view-flight.component';
import {UpdateFlightComponent} from'./update-flight/update-flight.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { AuthGaurdService } from './auth-gaurd.service';

import { AboutUsComponent } from './about-us/about-us.component';
import { LogoutComponent } from './logout/logout.component';
import { FlightCompanyListComponent } from './flight-company-list/flight-company-list.component';
import { ViewFlightCompanyComponent } from './view-flight-company/view-flight-company.component';
import { UpdateFlightCompanyComponent } from './update-flight-company/update-flight-company.component';

import { AirportListComponent } from './airport-list/airport-list.component';
import { UpdateAirportComponent } from './update-airport/update-airport.component';
import { ViewAirportComponent } from './view-airport/view-airport.component';
import { CreateAirportComponent } from './create-airport/create-airport.component';
import { CreateFlightCompanyComponent } from './create-flight-company/create-flight-company.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { ContactUsComponent } from './contact-us/contact-us.component';




  const routes: Routes = [
   
    {path: 'see-all-flights', component: FlightListComponent,canActivate: [AuthGaurdService]},
    {path: 'create-flight', component: CreateFlightComponent,canActivate: [AuthGaurdService]},
    {path: '', redirectTo: 'signup', pathMatch: 'full'},
    {path: 'update-flight/:id', component: UpdateFlightComponent,canActivate: [AuthGaurdService]},
    {path: 'view-flight-details/:id', component: ViewFlightComponent, canActivate: [AuthGaurdService]},
    {path:'sign-in', component: SignInComponent},
    {path:'sign-up', component: SignUpComponent},
    
    { path: 'about-us', component: AboutUsComponent },
    { path: 'logout',component:LogoutComponent},
    {path:'flight-company-list',component:FlightCompanyListComponent},
    {path: 'view-flight-company-details/:companyId', component: ViewFlightCompanyComponent, canActivate: [AuthGaurdService]},
    {path: 'update-flight-company-details/:companyId', component: UpdateFlightCompanyComponent,canActivate: [AuthGaurdService]},
    
    {path:'airport-list',component:AirportListComponent},
    {path:'update-airport/:airportId',component:UpdateAirportComponent,canActivate:[AuthGaurdService]},
    {path:'view-airport',component:ViewAirportComponent},
    {path: 'view-airport-details/:airportId', component: ViewAirportComponent, canActivate: [AuthGaurdService]},
    {path:'create-airport',component:CreateAirportComponent,canActivate: [AuthGaurdService]},
    {path:'create-flight-company',component:CreateFlightCompanyComponent,canActivate: [AuthGaurdService]},
    {path:'feedback',component:FeedbackComponent},
    {path:'contact-us',component:ContactUsComponent},
   
    

    

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }