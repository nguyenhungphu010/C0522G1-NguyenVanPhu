import { Injectable } from '@angular/core';
import {Category} from '../model/category';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  API_URL = 'http://localhost:3000/categorise';
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Category[]> {
    return this.http.get<Category[]>(this.API_URL);
  }

  saveCategory(category): Observable<Category> {
    return this.http.post<Category>(this.API_URL, category);
  }

  findById(id: number): Observable<Category> {
    return this.http.get<Category>(this.API_URL + '/' + id);
  }

  updateCategory(category: Category): Observable<Category> {
    return this.http.patch<Category>(this.API_URL + '/' + category.id, category);
  }

  deleteCategory(id: number): Observable<Category> {
    return this.http.delete<Category>(this.API_URL + '/' + id);
  }
}
