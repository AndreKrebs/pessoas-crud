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
      return response;
    }));
  }

  postRequest(uri: String, obj: Object): Observable <any>  {
    
    return this.http.post<any>(endpoint + uri, JSON.stringify(obj), httpOptions).pipe(
      tap((data) => console.log("added id="+data.id)),
      map((response: Response) => {
        return response;
      }),
      catchError(this.handleError<any>('post request'))
    );
  }

  deleteRequest(uri: String) {
    return this.http.request('delete', endpoint+uri, {});
  }

  putRequest(uri: String, obj: Object): Observable <any>  {
    
    return this.http.put<any>(endpoint + uri, JSON.stringify(obj), httpOptions).pipe(
      tap((data) => console.log("added id="+data.id)),
      map((response: Response) => {
        return response;
      }),
      catchError(this.handleError<any>('post request'))
    );
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(error); // log to console instead

      console.log(`${operation} failed: ${error.message}`);

      return of(result as T);
    };
  }

}
