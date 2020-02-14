import { Student } from './../models/student';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentsService {

  private baseEndpoint = "http://localhost/students";
  private headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  public getAll(): Observable<Student[]> {
    return this.http.get<Student[]>(this.baseEndpoint);
  }

  public getAllPageable(page:string,size:string): Observable<any> {
    let params=new HttpParams();
    params=params.set('page',page)
    params=params.set('size',size);
    return this.http.get<any>(`${this.baseEndpoint}/page`,{params:params});
  }

  public getById(id: number): Observable<Student> {
    return this.http.get<Student>(`${this.baseEndpoint}/${id}`);
  }

}
