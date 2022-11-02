import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ObjectTestModule} from '../object-test/object-test.module';
import {ObjectData} from '../model/object-data';
import {ObjectType} from '../model/object-type';

@Injectable({
  providedIn: 'root'
})
export class ObjectServiceService {
  private API_URL = '  http://localhost:3000/objectList';
  private API_URL_CUSTOMER_TYPE = '  http://localhost:3000/objectTypes';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<ObjectData[]> {
    return this.http.get<ObjectData[]>(this.API_URL);
  }

  getAllObjectDataType(): Observable<ObjectType[]> {
    return this.http.get<ObjectType[]>(this.API_URL_CUSTOMER_TYPE);
  }

  getObjectTypeById(id: number): Observable<ObjectType> {
    return this.http.get<ObjectType>(this.API_URL_CUSTOMER_TYPE + '/' + id);
  }

  findById(id: number): Observable<ObjectData> {
    return this.http.get<ObjectData>(this.API_URL + '/' + id);
  }

  saveObjectData(customer: ObjectData): Observable<ObjectData> {
    return this.http.post<ObjectData>(this.API_URL, customer);
  }

  updateObjectData(customer: ObjectData): Observable<ObjectData> {
    return this.http.patch<ObjectData>(this.API_URL + '/' + customer.id, customer);
  }

  deleteObjectData(id: number): Observable<void> {
    return this.http.delete<void>(this.API_URL + '/' + id);
  }

  searchCustomerByName(nameSearch: string, idSearch: string): Observable<ObjectData[]> {
    if (Number(idSearch) > 0) {
      return this.http.get<ObjectData[]>(this.API_URL + '?objectType.name_like=' + nameSearch + '&id=' + idSearch);
    } else {
      return this.http.get<ObjectData[]>(this.API_URL + '?objectType.name_like=' + nameSearch);
    }
  }
}
