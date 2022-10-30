import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../model/customer/customer";
import {CustomerType} from "../model/customer/customer-type";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private API_URL = 'http://localhost:3000/customers';
  private API_URL_CUSTOMER_TYPE = 'http://localhost:3000/customerTypes';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.API_URL);
  }

  getAllCustomerType(): Observable<CustomerType[]> {
    return this.http.get<CustomerType[]>(this.API_URL_CUSTOMER_TYPE);
  }

  findById(id: number): Observable<Customer> {
    return this.http.get<Customer>(this.API_URL + '/' + id);
  }

  saveCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(this.API_URL, customer);
  }

  updateCustomer(customer: Customer): Observable<Customer> {
    return this.http.patch<Customer>(this.API_URL + '/' + customer.id, customer);
  }

  deleteCustomer(id: number): Observable<void>{
    alert(this.API_URL + '/' + id);
    return this.http.delete<void>(this.API_URL + '/' + id);
  }
}
