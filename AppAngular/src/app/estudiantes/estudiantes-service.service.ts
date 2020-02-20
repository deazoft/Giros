import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from './../../environments/environment';

@Injectable()
export class EstudiantesServiceService {

  constructor(private http: HttpClient) { }
  // Http Options
  httpOptions  = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  getDepartamentos(): Observable<any[]> {
    return this.http.get<any[]>(environment.baseUrl + 'estudiantes/get').pipe    (
      map( (response) => response as any[]));
  }
}
