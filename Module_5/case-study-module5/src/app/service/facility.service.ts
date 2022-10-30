import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Facility} from "../model/facility/facility";
import {RentType} from "../model/facility/rent-type";
import {Customer} from "../model/customer/customer";
import {FacilityType} from "../model/facility/FacilityType";

@Injectable({
  providedIn: 'root'
})
export class FacilityService {

  private URL_API = 'http://localhost:3000/facilities';
  private URL_API_RENT_TYPE = 'http://localhost:3000/rentTypes';
  private URL_API_FACILITY_TYPE = 'http://localhost:3000/facilityTypes';

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Facility[]> {
    return this.httpClient.get<Facility[]>(this.URL_API);
  }

  getAllRentType(): Observable<RentType[]> {
    return this.httpClient.get<RentType[]>(this.URL_API_RENT_TYPE);
  }

  getAllFacilityType(): Observable<FacilityType[]> {
    return this.httpClient.get<FacilityType[]>(this.URL_API_FACILITY_TYPE);
  }

  findById(id: number): Observable<Facility> {
    return this.httpClient.get<Facility>(this.URL_API + '/' + id);
  }

  saveFacility(facility: Facility): Observable<Facility> {
    return this.httpClient.post<Facility>(this.URL_API, facility);
  }

  updateFacility(facility: Facility): Observable<Facility> {
    return this.httpClient.patch<Customer>(this.URL_API + '/' + facility.id, facility);
  }

  deleteFacility(id: number): Observable<void> {
    alert(this.URL_API + '/' + id);
    return this.httpClient.delete<void>(this.URL_API + '/' + id);
  }

}
