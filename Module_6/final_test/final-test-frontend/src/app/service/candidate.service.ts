import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {SearchResult} from '../model/search-result';
import {Candidate} from '../model/candidate';

@Injectable({
  providedIn: 'root'
})
export class CandidateService {
  private API_URL: string;
  constructor(private http: HttpClient) {
    this.API_URL = environment.api_url;
  }

  deleteCandidate(id: number): Observable<void> {
    return this.http.delete<void>(this.API_URL + '/candidate/delete/' + id);
  }

// tslint:disable-next-line:max-line-length
  paginate(page: number, limit: number, nameSearch: string, typeSearch: number): Observable<SearchResult<Candidate>> {
    console.log(nameSearch);
    return this.http.get<SearchResult<Candidate>>(this.API_URL + '/candidate/list?page='
      + (page - 1) + '&size=' + limit + '&nameSearch=' + nameSearch + '&idCard=' + typeSearch);
  }
}
