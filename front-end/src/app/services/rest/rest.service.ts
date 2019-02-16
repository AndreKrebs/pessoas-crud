import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';

const endpoint = 'http://localhost:8080/api/';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class RestService {

  constructor(private http: HttpClient) { }

  private extractData(res: Response) {
    debugger;
    let body = res;
    return body || {};
  }

  getRequest(uri: String): Observable <any>  {
    return this.http.get(endpoint+uri).pipe(map((response: Response) => {
      console.log(response);
      return response;
    }));
  }


}
