import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NavbarComponent} from './navbar/navbar.component';
import {BodyComponent} from './body/body.component';
import {FooterComponent} from './footer/footer.component';
import {CustomerModule} from './customer/customer.module';
import {FacilityModule} from './facility/facility.module';
import {HttpClientModule} from "@angular/common/http";
import {NgxPaginationModule} from "ngx-pagination";


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    BodyComponent,
    FooterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CustomerModule,
    FacilityModule,
    HttpClientModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
